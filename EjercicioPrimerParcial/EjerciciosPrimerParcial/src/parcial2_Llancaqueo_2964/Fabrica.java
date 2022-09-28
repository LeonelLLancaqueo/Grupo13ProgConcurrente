package parcial2_Llancaqueo_2964;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.TreeMap;
import java.util.LinkedList;

public class Fabrica {
    private int cajaEnAlmacen, horaActual;
    private int cajasParaEmpaquetar, cantCajaEmpaquetada, vinoEmpaquetado;

    private Lock lockCajaAgua, lockCajaVino, lockEmpaquetar, lockCajaRepartir, lockHoraActual; 
    private Condition esperarEmbotelladorVino, esperarEmbotelladorAgua, esperarEmpaquetador, esperarRepartidor, esperarReloj, esperarEmpaquetadorAlmacenLleno ;
    private static final int Vino=0, AguaSaborizada= 1, Empaquetador= 3, Repartidor = 4, Reloj= 5,capacidadAlmacen=3;
    private TreeMap <Integer,Lock> lock;
    private TreeMap <Integer, Caja>caja; 
    private TreeMap <Integer, Condition>conjuntoEspera;
    private Caja cajaAgua, cajaEmpaquetada;
    private CajaVino cajaVino;
    private LinkedList<Caja> colCajaRepartir;
    

    public Fabrica(){
        cajaEnAlmacen =0;
        lock= new TreeMap();
        caja= new TreeMap();
        conjuntoEspera= new TreeMap();
        /* locks */
        lockEmpaquetar= new ReentrantLock(true);
        lockCajaAgua= new ReentrantLock(true);
        lockCajaVino= new ReentrantLock(true);
        lockCajaRepartir= new ReentrantLock(true);
        lockHoraActual= new ReentrantLock(true);
        
        /* conjunto de espera */
        esperarEmbotelladorVino= lockCajaVino.newCondition();
        esperarEmbotelladorAgua= lockCajaAgua.newCondition();
        esperarEmpaquetador= lockEmpaquetar.newCondition();
        esperarEmpaquetadorAlmacenLleno= lockCajaRepartir.newCondition();
        esperarRepartidor= lockCajaRepartir.newCondition();
        esperarReloj= lockCajaRepartir.newCondition();


        
        /* caja */
        cajaVino= new CajaVino(Vino);
        cajaAgua= new Caja(AguaSaborizada);
         
        
        caja.put(Vino, cajaVino);
        caja.put(AguaSaborizada, cajaAgua);
        //lock= new TreeMap <Integer,Lock>({Vino, lockCajaVino},{AguaSaborizada, lockCajaAgua},  );
        lock.put(Vino, lockCajaVino);
        lock.put(AguaSaborizada, lockCajaAgua);
        lock.put(Empaquetador, lockEmpaquetar);
        
        conjuntoEspera.put(Vino, esperarEmbotelladorVino);
        conjuntoEspera.put(AguaSaborizada, esperarEmbotelladorAgua);
        conjuntoEspera.put(Empaquetador, esperarEmpaquetador);

        colCajaRepartir= new LinkedList<Caja>();
        cajasParaEmpaquetar=0; ////cuenta cuantas cajas hay listas para empaquetar de vino o agua
        vinoEmpaquetado= 0; //variable de condicion para el hilo que madura el vino

        horaActual=0;
    }

    /******************** EMBOTELLADORES  ***********************/
    public void embotellar(int bebida) throws InterruptedException{
        lock.get(bebida).lock(); // accedemos al lock de la caja a llenar
        while( caja.get(bebida).getCajaLlena() ){
            conjuntoEspera.get(bebida).await(); //dormimos al hilo en su respectivo conjunto de espera
        }
        caja.get(bebida).agregarBotella(); //agregamos una botella a la caja
        if(caja.get(bebida).getCajaLlena()){ //preguntamos si la caja se se lleno
            cajasParaEmpaquetar++; //aumentamos la cantidad de cajas a empaquetar

            lock.get(Empaquetador).lock(); //tomamos el lock del empaquetador
            (conjuntoEspera.get(Empaquetador)).signal(); //lo despertamos
            lock.get(Empaquetador).unlock(); //dejamos el lock
        }
        lock.get(bebida).unlock();
    }

    

    /******************** EMPAQUETADOR  ***********************/

    public void empaquetar() throws InterruptedException{
        lock.get(Empaquetador).lock();
        while(cajasParaEmpaquetar == 0){
            conjuntoEspera.get(Empaquetador).await();
        }       
        cajasParaEmpaquetar--;
        if(caja.get(AguaSaborizada).getCajaLlena()){
            caja.get(AguaSaborizada).vaciarCaja();/* "reponemos la caja" */
            cajaEmpaquetada= cajaAgua; //agregamos una caja a la colCajasRepartir
        }else{
            caja.get(Vino).vaciarCaja();/* "reponemos la caja" */   
            cajaEmpaquetada= cajaVino; //agregamos una caja a la colCajasRepartir
        }
        lock.get(Empaquetador).unlock();
    }
    
    public void reponerCaja() throws InterruptedException{
        lockCajaRepartir.lock();
        while(cajaEnAlmacen == capacidadAlmacen){
            esperarEmpaquetadorAlmacenLleno.await();
        }
        //preguntamos que caja hay que reponer
        
        cajaEmpaquetada.empaquetado(horaActual);// asignamos la hora actual a la hora de empaquetado de la caja

        if(cajaEmpaquetada.getTipo() == Vino){
            lock.get(Vino).lock(); //tomamos el lock de el embotellador de Vino
            conjuntoEspera.get(Vino).signalAll(); //despetamos a los embotelladores
            lock.get(Vino).unlock(); //liberamos el lock
            
            colCajaRepartir.add(cajaEmpaquetada.clone());
            vinoEmpaquetado++;
            esperarReloj.signal(); 
        }else{
            lock.get(AguaSaborizada).lock(); //tomamos el lock de el embotellador de agua
            conjuntoEspera.get(AguaSaborizada).signalAll(); //despetamos a los embotelladores
            lock.get(AguaSaborizada).unlock(); //liberamos el lock
            colCajaRepartir.add(cajaEmpaquetada.clone());
        }
        cajaEmpaquetada.vaciarCaja(); //vaciamos la caja;

        cajaEnAlmacen++;
        System.out.println("cajas en almacen luego de empaquetar"+ cajaEnAlmacen);
        if(cajaEnAlmacen == capacidadAlmacen){
            esperarRepartidor.signal();
        }
        lockCajaRepartir.unlock();
    }
    
    

    public void actualizarHora() throws InterruptedException{
        lockHoraActual.lock();
        this.horaActual++; // aumentamos la horaActual de la empresa
        lockHoraActual.unlock();
    }

    /*********** REPARTIDOR  ************/
    public void repartir() throws InterruptedException{
        lockCajaRepartir.lock();
        while(cajaEnAlmacen != capacidadAlmacen){
            esperarRepartidor.await();
            
        }
        Caja cajaAux;
        for(int i=0; i< colCajaRepartir.size(); i++){
            cajaAux = colCajaRepartir.get(i);
            if(cajaAux.listaRetirar(horaActual)){
                System.out.println("Se saco una caja de "+ cajaAux.getTipo()+" del almacen");
                colCajaRepartir.remove(i);
                cajaEnAlmacen--;
            }
        }
        System.out.println("cajas en almacen luego de repartir: " + cajaEnAlmacen);
        esperarEmpaquetadorAlmacenLleno.signal();
        lockCajaRepartir.unlock();

    }

}
