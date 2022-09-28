package FabricaGaseosa;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Box {
    private final int capacidad= 10;
    private int contBotellas, tipoBebida;
    private ReentrantLock lockBox;
    private Condition embotellador;
    private boolean cajaLlena;

    public Box(int tipoBebida,ReentrantLock lockBox, Condition embotellador) {
        this.tipoBebida= tipoBebida;
        contBotellas = 0;      
        this.lockBox= lockBox;
        this.embotellador= embotellador;  
        this.cajaLlena= false;
    }

    public boolean put(){
        boolean exito= true;
        if(contBotellas == 10){ 
            exito= false;;
        }else{
            contBotellas++;
        }
        return exito;
    }
    public int getTipoBebida(){
        return tipoBebida;
    }

    public void despertarEmbotelladores(){
        lockBox.lock();
            embotellador.signal();
        lockBox.unlock();
    }
    public boolean getCajaLlena(){
        return cajaLlena;
    }
    

      


}
