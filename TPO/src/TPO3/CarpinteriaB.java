package TPO3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class CarpinteriaB {

    private Lock parteA, parteB, parteC;
    private Condition carpinteroA, carpinteroB, carpinteroC; 
    private int cantMuebles, cantMueblesArmados, turnoCarpinteroA, turnoCarpinteroB, turnoCarpinteroC;
    private int pedidoPiezasA, pedidoPiezasB, pedidoPiezasC;
    private int piezasAArmadas, piezasBArmadas, piezasCArmadas;
    private boolean muebleEnsamblado;

    public CarpinteriaB(){
        parteA= new ReentrantLock(true);
        parteB= new ReentrantLock(true);
        parteC= new ReentrantLock(true);
        carpinteroA= parteA.newCondition();
        carpinteroB= parteB.newCondition();
        carpinteroC= parteC.newCondition();
    }
    public int armarPiezaA() throws InterruptedException{
        int turnoSalida;
        parteA.lock();
        while(pedidoPiezasA == 0){
            carpinteroA.await();
        }
        turnoSalida= turnoCarpinteroA;
        turnoCarpinteroA++;

        parteA.unlock();
        return turnoSalida;
    }
    public void seguirPorducionedoPiezaA() throws InterruptedException{
        
    }
    public void armarPiezaB() throws InterruptedException{
        
    }
    public void seguirPorducionedoPiezaB() throws InterruptedException{
        
    }
    public void armarPiezaC() throws InterruptedException{
        
    }
    public void seguirPorducionedoPiezaC() throws InterruptedException{
        
    }
    
}
