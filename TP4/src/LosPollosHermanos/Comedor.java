package LosPollosHermanos;

import java.util.concurrent.locks.ReentrantLock;
public class Comedor {
    // cambiar nombre
    public ReentrantLock silla, moso, empleado, plato;
    public int cantSillasDisponible;

    public Comedor(){
        silla= new ReentrantLock();
        moso= new ReentrantLock();
        plato= new ReentrantLock();
        cantSillasDisponible= 1;
    }
    /*
    public void sentarseSilla(){

    }*/
    public boolean sentarseSilla() throws InterruptedException{
        return silla.tryLock();
    }
    public void atender() throws InterruptedException {
        try {
            moso.lock();
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally{
            moso.unlock();
        }

    }
    public void pedirComida(){
        plato.lock();
    }
    public void servirPlato(){
        plato.release();
    }
    public void comer() throws InterruptedException{
        plato.acquire();
    }
    public void dejarSilla()  { 
        silla.unlock();
    }

    
}
