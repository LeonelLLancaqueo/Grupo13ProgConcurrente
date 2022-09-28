package Trafico3;

import java.util.concurrent.Semaphore;

public class Puente3 {
    private Semaphore cocheNorte, concheSur, controladorNorte, controladorSur , mutexContAutoNorte, mutexContAutoSur, mutexPuente;
    private int autosNortePasando, autosSurPasando, turno;
    private boolean turnoNorte, turnoSur, puenteEnUso;

    public Puente3(){
        
    }

    public void solicitarEntrarCocheNorte() throws InterruptedException{
        cocheNorte.acquire();
        controladorNorte.release();
    }

    public void solicitarEntrarCocheSur() throws InterruptedException{}

    public void controladorCocheNorte() throws InterruptedException{
        controladorNorte.acquire();
        
        if(!puenteEnUso){
            turno= 1;
            puenteEnUso= true;
        }
        if(turno == 1){
            
        }
    }
   
    
    public void controladorCocheSur() throws InterruptedException{}
    
    public void entrarCocheNorte() throws InterruptedException{}

    public void entrarCocheSur() throws InterruptedException{}
}
