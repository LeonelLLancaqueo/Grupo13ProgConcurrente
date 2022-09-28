package TrenTuristico;
 
import java.util.concurrent.Semaphore;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class trenMejorado {
    //Seguir
    private Semaphore controlTren, asientos, vendedorTicket, pasajero, mutexTickets, mutexAsientos, bajarTren, tomarTicket;
    private int asientosTotal, asientosOcupados;
    private CyclicBarrier ocuparAsiento, empezarTren;
    
    public trenMejorado(int cantAsientos) {
        this.controlTren = new Semaphore(0,true);
        this.asientos = new Semaphore(cantAsientos,true);
        this.vendedorTicket= new Semaphore(0,true);
        this.pasajero = new Semaphore(1,true);
        this.asientosTotal= cantAsientos;
        this.asientosOcupados=0;
        this.mutexTickets= new Semaphore(1,true);
        this.mutexAsientos= new Semaphore(1,true);
        this.bajarTren= new Semaphore(0,true);
        this.tomarTicket = new Semaphore(0, true);
        ocuparAsiento= new CyclicBarrier(cantAsientos+1);
    }

    public void comprarTicket() throws InterruptedException{    
        this.pasajero.acquire(); 
        this.vendedorTicket.release();
    }
    public void venderTicket() throws InterruptedException{
        this.vendedorTicket.acquire();  
        this.tomarTicket.release();

    }
    public void tomarTicket() throws InterruptedException{
        this.tomarTicket.acquire();
        this.pasajero.release();

        //return this.ticket.tryAcquire();
    }

    public void tomarTren()throws InterruptedException, BrokenBarrierException {
        ocuparAsiento.await();
        
              
    }
    public void habilitarTren() throws InterruptedException, BrokenBarrierException {
        this.ocuparAsiento.await(); //esperamos  que todos los pasajeros hayan subido al tren
        System.out.println("el viaje se inicia");
    }

    public void terminarRecorrido(){
        this.bajarTren.release(this.asientosTotal); // se termina el viaje y se les permite a todos los pasajeros bajar
    }
    public void bajarTren() throws InterruptedException{
        this.bajarTren.acquire();  //el pasajero pide permiso para dejar su asiento
        mutexAsientos.acquire();
        this.asientosOcupados--;        
        mutexAsientos.release();     
        mutexTickets.acquire();
        if(this.asientosOcupados == 0){
            System.out.println("entra aca");
            asientos.release(asientosTotal);
            ocuparAsiento.reset(); // aca 
        }
        mutexTickets.release();  
    }

}


