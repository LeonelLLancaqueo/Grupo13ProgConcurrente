package TPO3;

import java.util.concurrent.Semaphore;

public class Carpinteria {
    private Semaphore piezaA, piezaB, piezaC, ensamblador;
    private int cantMuebles, cantMueblesArmados, turnoCarpinteroA, turnoCarpinteroB, turnoCarpinteroC;
    private boolean muebleEnsamblado;

    public Carpinteria(int cantMuebles){
        this.cantMuebles = cantMuebles;
        piezaA= new Semaphore(1,true);
        piezaB= new Semaphore(1,true);
        piezaC= new Semaphore(1,true);
        ensamblador= new Semaphore(1,true);
    }
    public void ensamblar() throws InterruptedException{
        ensamblador.acquire();
            
        ensamblador.release();
    }
    public void armarPiezaA() throws InterruptedException{
        piezaA.acquire();

        piezaA.release();
    }
    public void armarPiezaB() throws InterruptedException{
        piezaB.acquire();
            
        piezaB.release();
    }
    public void armarPiezaC() throws InterruptedException{
        piezaC.acquire();
            
        piezaC.release();
    }
}
