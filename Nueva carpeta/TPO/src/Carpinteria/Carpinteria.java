package Carpinteria;

import java.util.concurrent.Semaphore;

public class Carpinteria {
    private Semaphore mutexCarpinteroA, mutexCarpinteroB, mutexCarpinteroC, mutexEnsamblador;
    private Semaphore esperarCarpinteroA, esperarCarpinteroB, esperarCarpinteroC, esperarEnsamblador;
    private Semaphore esperarMuebleA, esperarMuebleB, esperarMuebleC;
    private Semaphore tomarPiezaA, tomarPiezaB, tomarPiezaC;
    private int piezasAArmadas, piezasBArmadas, piezasCArmadas;
    private int mueblesSolicitados, mueblesEnsamblados;

    

    public Carpinteria(int mueblesSolicitados){
        this.mueblesSolicitados = mueblesSolicitados;
        mutexCarpinteroA= new Semaphore(1, true);
        mutexCarpinteroB= new Semaphore(1, true);
        mutexCarpinteroC= new Semaphore(1, true);
        mutexEnsamblador= new Semaphore(1, true);

        esperarCarpinteroA= new Semaphore(0, true);
        esperarCarpinteroB= new Semaphore(0, true);
        esperarCarpinteroC= new Semaphore(0, true);
        esperarEnsamblador= new Semaphore(0, true);

        tomarPiezaA= new Semaphore(0, true);
        tomarPiezaB= new Semaphore(0, true);
        tomarPiezaC= new Semaphore(0, true);
    
        esperarMuebleA= new Semaphore(0, true);
        esperarMuebleB= new Semaphore(0, true);
        esperarMuebleC= new Semaphore(0, true);

    }
    public int getMueblesSolicitados(){
        return this.mueblesSolicitados;
    }


    /********* CARPINTERO A **********/
    public void armarPiezaA() throws InterruptedException{
        mutexCarpinteroA.acquire();       
            while(piezasAArmadas == mueblesSolicitados){
                esperarCarpinteroA.acquire(); //bloqueamos al carpintero y bloqueamos al metodo
            } 
    }

    public void terminarArmarPiezaA(){
        piezasAArmadas++;
        mutexCarpinteroA.release();  
    }
    public void entregarPiezaA() throws InterruptedException{
        tomarPiezaA.release();
        esperarMuebleA.acquire();

    }

    /********* CARPINTERO B **********/
    public void armarPiezaB() throws InterruptedException{
        mutexCarpinteroB.acquire();       
            while(piezasBArmadas == mueblesSolicitados){
                esperarCarpinteroB.acquire(); //bloqueamos al carpintero y bloqueamos al metodo
            } 
    }

    public void terminarArmarPiezaB(){
        piezasBArmadas++;
        mutexCarpinteroB.release();  
    }
    public void entregarPiezaB() throws InterruptedException{
        tomarPiezaB.release();
        esperarMuebleB.acquire();

    }

    /********* CARPINTERO C **********/
    public void armarPiezaC() throws InterruptedException{
        mutexCarpinteroC.acquire();       
            while(piezasCArmadas == mueblesSolicitados){
                esperarCarpinteroC.acquire(); //bloqueamos al carpintero y bloqueamos al metodo
            } 
    }

    public void terminarArmarPiezaC(){
        piezasCArmadas++;
        mutexCarpinteroC.release();  
    }
    public void entregarPiezaC() throws InterruptedException{
        tomarPiezaC.release();
        esperarMuebleC.acquire();

    }


    /******************Ensamblador**********************/

    public void tomarPiezas() throws InterruptedException{  
        //cuando ya no haya muebles q armar no se vana producir mas piezas y el ensamblador va a quedar bloqueado
        /* tomamos una pieza de cada parte */
        tomarPiezaA.acquire(); 
        tomarPiezaB.acquire();
        tomarPiezaC.acquire();
    }
    public void ensamblarMueble() throws InterruptedException{
        mutexEnsamblador.acquire();
            System.out.println("Comienzo de etapa fabriacion de mueble");
        

    }
    public void terminarMueble() throws InterruptedException{
        
        mueblesEnsamblados++;
        System.out.println("total de muebles armados: "+ mueblesEnsamblados);
        /* liberamos a un carpintero que fabrico la pieza */
        esperarMuebleA.release();
        esperarMuebleB.release();
        esperarMuebleC.release();
        System.out.println("fin de etapa fabriacion de mueble");
        mutexEnsamblador.release();

    }

}
