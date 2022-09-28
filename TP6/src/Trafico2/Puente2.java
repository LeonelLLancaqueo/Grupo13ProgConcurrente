package Trafico2;
import java.util.concurrent.Semaphore;

public class Puente2 {
    private Semaphore esperarCocheSur, esperarCocheNorte, esperarCoche, mutexPuente, esperarSalir;
    private int cocheLadoOpuestoEsperando, cocheSurEsperando, cocheNorteEsperando, cochesEsperando,tipoAutoCruzando, turnoSalidaPuente; 
    private int contCoches, contAutoSaliendo, autosEsperandoSalir;
    private boolean puenteEnUso;

    public Puente2(){
        esperarCocheNorte= new Semaphore(0, true);
        esperarCocheSur= new Semaphore(0, true);
        esperarCoche= new Semaphore(0, true);
        esperarSalir= new Semaphore(0, true);
        mutexPuente= new Semaphore(1, true);//
        turnoSalidaPuente= 1;
    }
    public int entrarCoche(int tipoAuto) throws InterruptedException{
        boolean puedeEntrar= false;
        int turnoSalidaPuente= -1;
        while(!puedeEntrar){// mientras no se den las condiciones para q el hilo pueda entrar al puente queda en el bucle es algun conjunto de espera
            mutexPuente.acquire();
            if(!puenteEnUso){ // si el puente 
                tipoAutoCruzando= tipoAuto; //pueden entrar los autos del mismo tipoAutoCruzando
                puenteEnUso= true;
            }
            if(tipoAuto == tipoAutoCruzando){ //si el tipoAutoCruzando del auto es igual al tipoAutoCruzando del puente //cambiarTipo
                
                if(contCoches < 10){
                    contCoches++;
                    System.out.println("cont Coches: "+ contCoches); 
                    turnoSalidaPuente = contCoches; // el orden en el que entran el auto
                    puedeEntrar= true;
                    mutexPuente.release();
                }else{
                    cochesEsperando++;
                    System.out.println("el coche con tipo de auto: "+ tipoAuto+ " esta esperando a cruzar el puente");
                    mutexPuente.release();
                    esperarCoche.acquire();
                    cochesEsperando--;
                }
            }else{
                cocheLadoOpuestoEsperando++;
                cochesEsperando++;
                System.out.println("el coche con tipo de auto: "+ tipoAuto+ " esta esperando a cruzar el puente");
                mutexPuente.release();
                esperarCoche.acquire();
                cocheLadoOpuestoEsperando--;
                cochesEsperando--;
            }
        
        }
        return turnoSalidaPuente;
    }

    public void salirCoche (int turnoCoche, int turnoSalida)throws InterruptedException{
        boolean puedeSalir= false; 
        while(!puedeSalir){
            mutexPuente.acquire(); 
            if(turnoSalida == turnoSalidaPuente){
                puedeSalir= true;
                mutexPuente.release(); 
            }else{
                autosEsperandoSalir++;
                mutexPuente.release(); 
                esperarSalir.acquire();
                autosEsperandoSalir--;
            }
            
        }
        mutexPuente.acquire(); 
        turnoSalidaPuente++;
        esperarSalir.release(autosEsperandoSalir);
        contAutoSaliendo++;
        if(contAutoSaliendo == contCoches){
            if(turnoCoche == 1){
                if(cocheLadoOpuestoEsperando > 0){
                    tipoAutoCruzando = 0;
                }else{
                    puenteEnUso= false;
                }
            }
            if(turnoCoche == 0){
                if(cocheLadoOpuestoEsperando > 0){
                    tipoAutoCruzando = 1;
                }else{
                    puenteEnUso= false;
                }
            }
            turnoSalidaPuente=1;
            contCoches=0;
            contAutoSaliendo= 0;
            cocheLadoOpuestoEsperando =0;
            esperarCoche.release(cochesEsperando);
        }
        
        mutexPuente.release();

    }
}
