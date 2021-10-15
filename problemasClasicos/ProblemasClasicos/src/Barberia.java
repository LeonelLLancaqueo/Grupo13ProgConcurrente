import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
public class Barberia {
    private Semaphore sillon, barbero, cliente;
    private int lugarDisponible;
    private ReentrantLock lock;

    //private int ultimoLugarLibre;

    public Barberia(){
        this.lugarDisponible= 0;
        this.sillon = new Semaphore(1, true);
        this.barbero = new Semaphore(0, true);
        this.cliente = new Semaphore(0, true);
        this.lock= new ReentrantLock();
    }

    public void esperarCliente() throws InterruptedException {
        barbero.acquire();
    }
    /*public boolean entrar(){
        
    }*/

    
    public boolean solicitarSillon() throws InterruptedException{
        return sillon.tryAcquire();
    }
    public boolean sentarseEnSillaEspera() throws InterruptedException{
        boolean exito= false;
        try {
            lock.lock();
            if(this.lugarDisponible < 4){
                lugarDisponible++;
                exito= true;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            lock.unlock();
        }
        return exito;
    } 
    public void tomarSillon() throws InterruptedException{
        sillon.acquire();
        try {
            lock.lock();
            lugarDisponible--;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            lock.unlock();
        }

    }
    public void solicitarCorte() throws InterruptedException{
        barbero.release();
    }

    public void terminarAtencion() throws InterruptedException{
        cliente.release();
    }

    public void salir() throws InterruptedException{
        cliente.acquire();
        sillon.release();
    }

}
