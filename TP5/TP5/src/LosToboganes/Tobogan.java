package LosToboganes;
import java.util.concurrent.Semaphore;

public class Tobogan {
    private int toboganes, esperandoTobogan;
    private Semaphore escalera, mutexEsperandoTobogan, mutexTobogan, tobogan, mutexVisitante, mutexEncargado, esperarTobogan;


    public Tobogan(int lugaresEscalera){
        toboganes= 2;
        escalera= new Semaphore(lugaresEscalera,true);
        mutexTobogan= new Semaphore(1,true);
        mutexEsperandoTobogan= new Semaphore(1,true);

        tobogan= new Semaphore(0,true);
        mutexVisitante= new Semaphore(1,true);
        mutexEncargado= new Semaphore(0,true);
        esperarTobogan= new Semaphore(0,true);
    }

    public void accederEscalera() throws InterruptedException {
        escalera.acquire();
    }

    public void solicitarTobogan() throws InterruptedException {
        mutexVisitante.acquire();
        mutexEncargado.release();
    }

    public void habitilarTobogan() throws InterruptedException {
        mutexEncargado.acquire();
        boolean entregarTobogan= false;
        while(!entregarTobogan){
            mutexTobogan.acquire();
            if(toboganes>0){              
                toboganes--;
                mutexTobogan.release();

                entregarTobogan= true;
            }else{
                mutexTobogan.release();

                mutexEsperandoTobogan.acquire();
                esperandoTobogan++;
                mutexEsperandoTobogan.release();

                esperarTobogan.acquire();
                
                mutexEsperandoTobogan.acquire();
                esperandoTobogan--;
                mutexEsperandoTobogan.release();
            }
        }
        tobogan.release();
    }

    public void tomarTobogan() throws InterruptedException {
        escalera.release();
        mutexVisitante.release();
        tobogan.acquire();
    }

    public void dejarTobogan() throws InterruptedException {
        toboganes++;
        mutexEsperandoTobogan.acquire();
        if(esperandoTobogan > 0){
            esperarTobogan.release();
        }
        mutexEsperandoTobogan.release();
    }

    
}
