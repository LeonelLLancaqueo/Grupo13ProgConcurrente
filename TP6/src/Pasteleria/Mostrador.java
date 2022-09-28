package Pasteleria;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Mostrador {
    private Lock pasteleria= new ReentrantLock(true);
    private Condition horno= pasteleria.newCondition();
    private Condition robotEmpaquetador= pasteleria.newCondition();
    private Condition brazoMecanico= pasteleria.newCondition();
    private int []arrPastel;
    private int cantPasteles, pesoCajaMax, pesoCajaActual, cajasListas;
    
    private boolean reponer;

    public Mostrador(int pesoMax){
        arrPastel= new int[10];
        pesoCajaMax= pesoMax;
    }



    public  void reponerCaja() throws InterruptedException{
        pasteleria.lock();
        while(!reponer){
            brazoMecanico.await();
        }
        pesoCajaActual=0;
        reponer= false;
        robotEmpaquetador.signalAll(); //despertamos a los hilos empaquetadores
        cajasListas++; 
        pasteleria.unlock();    
    
    }

    public  int tomarPastel() throws InterruptedException{
        pasteleria.lock();
        
        while(cantPasteles <= 0){
            horno.signalAll();

            robotEmpaquetador.await();
        }
        int peso= arrPastel[cantPasteles-1]; 
        arrPastel[cantPasteles-1]= -1;
        cantPasteles--;


        pasteleria.unlock();
        return peso;
    }

    public  void soltarPastel(int peso) throws InterruptedException{
        pasteleria.lock();

        
        while(pesoCajaActual+peso > pesoCajaMax){ // si el peso total de la caja + el pastel que se quiere soltar en menos al pedo maximo de la caja
            /* preguntar si esta bien esto */
            reponer= true;
            brazoMecanico.signal(); //despertamos al brazo mecanico
            
            robotEmpaquetador.await(); //dormimos al empaquetador
        }
        pesoCajaActual+= peso; //sumamos el peso del pastel al pesoActual de la caja
        
        pasteleria.unlock();
    }

    public void hornearPastel(int pesoPastel) throws InterruptedException{
        /* entra uno de los 3 hornos */
        pasteleria.lock();
        while(cantPasteles+1 >= arrPastel.length){ //mientras el 
            horno.await();
        }
        arrPastel[cantPasteles]= pesoPastel; 
        cantPasteles++;
        robotEmpaquetador.signalAll();

        pasteleria.unlock();
    }

}
