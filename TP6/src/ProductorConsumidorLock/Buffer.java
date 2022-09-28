package ProductorConsumidorLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private int cantidad;
    private final int tamanio;
    private final Lock mutex;
    //para sincronizar los productores
    private final Condition productores;
    //para sincronizar los consumidores
    private final Condition consumidores;

    public Buffer(int tamanio){
        this.cantidad=0;
        this.tamanio = tamanio;
        mutex = new ReentrantLock();
        this.productores = mutex.newCondition();
        this.consumidores = mutex.newCondition();
    }
    public  void producir(){
        try {
            mutex.lock();
            while(cantidad == tamanio){
                System.out.println("buffer lleno");
                productores.await();
            }
            cantidad++;
            consumidores.signal();
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally{
            mutex.unlock();
        }
    }

    public  void consumir(){
        try {
            mutex.lock();
            while(cantidad == 0){    
                System.out.println("buffer vacio");
                consumidores.await();
            }
            cantidad--;
            productores.signal();

        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally{
            mutex.unlock();
        }
    }

}
