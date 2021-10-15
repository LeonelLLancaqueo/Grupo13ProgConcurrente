package TiendaMascotas;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Hamaca {
    private ReentrantLock hamaca;

    public Hamaca(){
        this.hamaca = new ReentrantLock();    
    }
    public boolean usarHamaca(){
        boolean exito= false;
        try {
            exito= hamaca.tryLock();
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally {
            if(exito){
                hamaca.unlock();
            }
        }
        
        return exito;
    }
    
}
