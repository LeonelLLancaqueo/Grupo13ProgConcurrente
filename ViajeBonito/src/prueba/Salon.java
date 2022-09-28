package prueba;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Salon {
    private LinkedBlockingQueue cola;
    private Semaphore control;

    public Salon(){
        cola = new LinkedBlockingQueue<Semaphore>();

    }
    public void entrarCola() throws InterruptedException{
        Semaphore sem= new Semaphore(0);
        cola.put(sem);
        sem.acquire();
        
    } 

    public void despertarHilo() throws InterruptedException{

       ((Semaphore)cola.poll()).release(); // recuperamos y liberamos el semaforo
    }



}
