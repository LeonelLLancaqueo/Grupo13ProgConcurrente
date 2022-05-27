
import java.util.concurrent.Semaphore;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Aeropuerto {
    private Aerolinea colAerolinea[];
    private GuardiaSeguridad colGuardia[];
    private Terminal colTerminal [];
    private int hora, espEntrar; 
    private static final int horaCierre= 20;
    private Semaphore mutexHora, entrar, mutexEspEntrar, guardia, lugaresTren;
    private static final String nombreAerolinea[]= new String[]{"Aerolineas Argentinas", "AirBang", "Fly", "AliExpress", "Despegar"};
    private Random r;
    private CyclicBarrier tren;


    public Aeropuerto(int cantAerolinea) {
        hora= 5;
        r= new Random(); //utilizamos para hacer las reservas de manera aleatoria
        
        // Entrar Aeropuerto y Puesto de informe
        guardia= new Semaphore(0);
        entrar= new Semaphore(0);
        mutexEspEntrar= new Semaphore(1);
        espEntrar= 0;
        //tren
        lugaresTren= new Semaphore(10);

        //mutex
        mutexHora= new Semaphore(1);
        this.inicializarColAerolineaYGuardia(cantAerolinea);
    
        tren= new CyclicBarrier(10);
    }
    // METODO EJECUTADO POR EL RELOJ
    public void reloj() throws InterruptedException{
        mutexHora.acquire();
        hora++;
        System.out.println("El reloj marca las "+ hora+ " hs");
        if(hora == 6){ //SI ES LA HORA DE ABRIR
            guardia.release();  //EL RELOJ DESPIERTA AL GUARDIA
        }
        mutexHora.release();
    }

    //METODOS EJECUTADOS POR EL PASAJEROS
    public Aerolinea entrarPuestoInforme() throws InterruptedException{
        /* EN ESTE METODO LOS PASAJEROS INTENTA ENTRAR AL AEROPUERTO */
        mutexHora.acquire();
        if(hora < 6 || hora > 16){ // SI EL AEROPUERTO ESTA CERRADO LOS PASAJEROS QUEDAN BLOQUEADOS ESPERANDO A QUE VUELVA A ABRIR

            mutexEspEntrar.acquire();
            espEntrar++;
            mutexEspEntrar.release();
            
            mutexHora.release();
            entrar.acquire();
            mutexHora.acquire();
        }   
        mutexHora.release();

        return colAerolinea[r.nextInt(colAerolinea.length)];
    }
    public void abrirAeropuerto() throws InterruptedException{
        //En este metodo el guardia del aeropuerto abre la puerta a los pasajeros esperando a entrar al puesto de informe
        guardia.acquire();
        
        mutexEspEntrar.acquire();
        entrar.release(espEntrar);
        espEntrar=0;
        mutexEspEntrar.release();

    }
    // PARTE DEL TREN

    public void tomarTren() throws  BrokenBarrierException, InterruptedException {
        lugaresTren.acquire();
        tren.await();
    }

    public void bajarTren(){
    }

    // METODOS PROPIOS DE AEROPUERTO
    private void inicializarColAerolineaYGuardia(int n){
        colAerolinea= new Aerolinea [n];
        colGuardia= new GuardiaSeguridad [n];
        for(int i = 0; i < n; i++){
            colAerolinea[i]= new Aerolinea(nombreAerolinea[i]); 
            colGuardia[i]= new GuardiaSeguridad(colAerolinea[i]);
            colGuardia[i].start();
        }
    }

    private void inicializarTerminal(){
        colTerminal= new Terminal[3];
        for(int i=0; i<3; i++){
            colTerminal[i]= new Terminal();
        }
    } 
    

}
