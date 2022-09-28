package Carpinteria;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


public class carpinteria {
    private Lock  arrLock[], carpinteroA, carpinteroB, carpinteroC, ensamblador;
    private Condition  arrCondition[], esperarA, esperarB, esperarC, esperarE;
    private Boolean []seguir;
    private int piezasListas, piezasArmadas, piezasTotal, piezasPedidas[], mueblesSolicitados, mueblesArmados;
    

    public carpinteria(int mueblesPedidos){
        piezasPedidas= new int[]{mueblesPedidos, mueblesPedidos, mueblesPedidos};
        carpinteroA= new ReentrantLock(true);
        carpinteroB= new ReentrantLock(true);
        carpinteroC= new ReentrantLock(true);
        ensamblador= new ReentrantLock(true);
        arrLock= new Lock[]{carpinteroA, carpinteroB, carpinteroC};
        esperarA= carpinteroA.newCondition();
        esperarB= carpinteroB.newCondition();
        esperarC= carpinteroC.newCondition();
        esperarE= ensamblador.newCondition();
        arrCondition= new Condition[]{esperarA, esperarB, esperarC};
        seguir= new Boolean []{false, false ,false};

    }

    public void armarPieza(int i)throws InterruptedException{
        arrLock[i].lock();
        while(piezasPedidas[i] == 0){
            arrCondition[i].await();
        }

    }
    public void terminarPieza(int i)throws InterruptedException{
        piezasPedidas[i]--;
        piezasArmadas++;
        ensamblador.lock();
        esperarE.signal();
        ensamblador.unlock();
        while(!seguir[i]){
            arrCondition[i].await();
        }
        seguir[i]= false;
        arrLock[i].unlock();
    }
    public void armarMueble() throws InterruptedException{
        ensamblador.lock();
        while(piezasArmadas == 0){
            esperarE.await();
        }
        piezasArmadas--;
        piezasTotal++;
        if(piezasTotal == 3){
            System.out.println("Se ensamblo un mueble");
            mueblesArmados++;
            piezasTotal=0;
            despertarCarpinteros();
        }
        ensamblador.unlock();
    }
    public void despertarCarpinteros(){
        for(int i=0;i<arrLock.length;i++){
            seguir[i]= true;
            arrLock[i].lock();
            arrCondition[i].signalAll();
            arrLock[i].unlock();
        }
    }





}
