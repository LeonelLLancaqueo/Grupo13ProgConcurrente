package LosPollosHermanos2;

import java.util.concurrent.Semaphore;
public class Silla {
    // cambiar nombre
    public Semaphore silla, moso, empleado, pedido, cocinero;

    public Silla(){
        silla= new Semaphore(2);
        moso= new Semaphore(0);
        pedido= new Semaphore(0);
        cocinero= new Semaphore(0);
    }
    /*
    public void sentarseSilla(){

    }*/
    public void hacerPollo() throws InterruptedException{
        moso.acquire();
    }   
    public void ordenarCocina() throws InterruptedException{
        cocinero.acquire();
    }

    public void sentarseSilla() throws InterruptedException{
        silla.acquire();
        moso.release();
    }
    public void prepararBebida() throws InterruptedException { // el moso espera atender a un cliente
        moso.acquire();
    }
    public void pedirBebida()  { // el empleado libera al moso para q le traiga una bebida
        moso.release();
    }
    public void pedirComida()  { // el empleado libera al cocinero para q le traiga una comida
        cocinero.release();
    }
    
    public void prepararComida() throws InterruptedException{ // el cocinero espera atender a un cliente
        cocinero.acquire();
    }
    public void servirPedido(){// utilizado por moso y cocinero
        pedido.release();
    }
    public void comer() throws InterruptedException{
        pedido.acquire();
    }

    public void dejarSilla()  { 
        silla.release();
    }

    
}
