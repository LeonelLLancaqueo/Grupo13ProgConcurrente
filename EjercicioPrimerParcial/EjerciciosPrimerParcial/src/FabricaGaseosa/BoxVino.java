package FabricaGaseosa;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class BoxVino extends Box{
    private boolean madurado;


    public BoxVino(int tipoBebida, ReentrantLock lockBox, Condition embotellador){
        super(tipoBebida, lockBox, embotellador);
        madurado= false;
        
    }

    public void madurarVino(){ //este metodo lo llamad el reloj madurador
        madurado= true;
    }
    


}
