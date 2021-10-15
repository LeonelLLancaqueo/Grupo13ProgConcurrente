package TiendaMascotas;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Rueda {
    private ReentrantLock rueda;
    public Rueda(){
        this.rueda = new ReentrantLock();
    }
    public boolean usarRueda(){
        boolean exito= false;
        try {
            exito= rueda.tryLock();
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally {
            if(exito){
                rueda.unlock();
            }
        }
        return exito;
    }

}
