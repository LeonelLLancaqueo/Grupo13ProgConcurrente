package CarreraRelevos;

import java.util.concurrent.Semaphore;
public class Equipo {
    
        public Semaphore testigo;
        
        public Equipo(){
            this.testigo = new Semaphore(1);

        }

        public void tomarTestigo(String nameThread) throws  InterruptedException{
            testigo.acquire();
            System.out.println("El hilo "+ nameThread+ " tomo el testigo" );
            
        }
        public void cederRelevo(String nameThread)throws  InterruptedException{
            System.out.println("El hilo "+ nameThread+ " cedio el testigo" );
            testigo.release(); 

        }
        /*
        public void run(){
            corredorDerecha.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
            corredorIzq.start();
        }
        */
}
