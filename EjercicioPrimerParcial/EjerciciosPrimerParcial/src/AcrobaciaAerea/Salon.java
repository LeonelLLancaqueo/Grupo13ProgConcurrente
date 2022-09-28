package AcrobaciaAerea;
import java.util.concurrent.Semaphore;
public class Salon {
    private Semaphore persona, controladorAct, acroTelas, lyraAcrobatica, yogaEnAro, salon;
    private Semaphore[] actividades;
    private Semaphore mutexGenteSalon;


    public Salon(){
        mutexGenteSalon= new Semaphore(1, true);
        persona= new Semaphore(0, true);
        salon= new Semaphore(12, true);
        actividades= new Semaphore[3];
        actividades[0]= new Semaphore(4,true);
        actividades[1]= new Semaphore(4,true);
        actividades[2]= new Semaphore(4,true);
        controladorAct= new Semaphore(0,true);
        
    }
    public void entrarSalon() throws InterruptedException{
        salon.acquire(); // 
    }

    public int tomarCupo(int act) throws InterruptedException{ 
        while(!actividades[act].tryAcquire()){ // no se produc espera activa pq hay un permiso para cada persona
            act++;
            if(act > 2){
                act= 0;
            }
        }
        controladorAct.release();// avisamos que se tomo un cupo
        return act;
    }
    public void liberarPermisos() throws InterruptedException{
        controladorAct.acquire(12);// espera a que se tomen todos los cupos
        persona.release(12); //libera los permisos necesarios para q los hilos puedan terminar su act
    }
    public void liberarCupos() throws InterruptedException{
        controladorAct.acquire(12);// espera a que se tomen todos los cupos
        for(int i=0; i< actividades.length; i++){
            actividades[i].release(4);
        }
        persona.release(12); //libera los permisos necesarios para q los hilos puedan terminar su act
    }
    public void realizarActividad() throws InterruptedException{
        persona.acquire();
    }
    public void terminarActividad() throws InterruptedException{
        controladorAct.release();
        persona.acquire(); // bloqueamos a las personas para dejarlas salir cuando todas terminaron la act
                           // o seguir con la segunda act     
    }
    
    
    public void salirSalon() throws InterruptedException{
        salon.release();
    }

}


