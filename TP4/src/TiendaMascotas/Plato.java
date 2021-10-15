package TiendaMascotas;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Plato {
    private ReentrantLock plato;

    public Plato(){
        this.plato = new ReentrantLock();
    }
    public boolean usarPlato(){
        boolean exito= false;
        try {
            exito= plato.tryLock();
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally {
            if(exito){
                plato.unlock();
            }
        }
        return exito;
    }
    
}
