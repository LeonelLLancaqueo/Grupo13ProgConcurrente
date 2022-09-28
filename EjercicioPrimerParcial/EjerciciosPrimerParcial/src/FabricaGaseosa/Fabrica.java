package FabricaGaseosa;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Fabrica {
    private Box cajaVino, mostrador[];
    private int cajasParaEmpaquetar, cajasEmpaquetadas,  indiceMostrador;
    private final int capacidadAlmacen= 100;
    private Lock seccionEmbotellamientoVino, seccionAlmacenamiento; 
    private Condition embotelladorVino, embotelladorAgua, empaquetador, repartidor, reloj;
    private static final int vino=0, aguaSaborizada= 1;

    public Fabrica() {
        seccionEmbotellamientoVino= new ReentrantLock(true);
        embotelladorAgua= seccionEmbotellamientoVino.newCondition();
        embotelladorVino= seccionEmbotellamientoVino.newCondition();
        empaquetador= seccionEmbotellamientoVino.newCondition();
        //repartidor= seccionAlmacenamiento.newCondition();
        
        cajasParaEmpaquetar=0; ////cuenta cuantas cajas hay listas para empaquetar de vino o agua
    }

    /******************** EMBOTELLADORES  ***********************/
    public void embotellarVino() throws InterruptedException{
        seccionEmbotellamientoVino.lock();
        boolean exito= false;
        while( !(exito= cajaVino.put())){ //Resolver 
            embotelladorVino.await();
        }
        if(exito){
            mostrador[indiceMostrador]= cajaVino; // colocamos la caja en el ultimo lugar del mostrador
            empaquetador.signal(); // despertamos al empaquetador
        }

        seccionEmbotellamientoVino.unlock();
    }
}

   

    /******************** EMPAQUETADOR  ***********************/
/*
    public void empaquetar() throws InterruptedException{
        fabrica.lock();
        while(cajasParaEmpaquetar == 0){
            empaquetador.await();
        }       
        
        cajasListas++;
        cajasParaEmpaquetar--;
        /* puede pasar que ambas cajas se llenen a la vez pero como el empaquetador empaqueta y repone de a una 
        if(botellasEnCajaVino == 10){ //si la caja a empaquetar es la de vino
            contCajasVino++;
            cajaEmpaquetada= vino;
        }else{
            contCajasAgua++; //sino es la de agua la caja a empaquetar
            cajaEmpaquetada= aguaSaborizada;
        }
        
        if(cajasListas  == 10){
            repartidor.signal(); //despertamos al repartidor 
        }

        fabrica.unlock();
    }

    public void reponerCaja() throws InterruptedException{
        boxVino= new BoxVino();
    }

   */