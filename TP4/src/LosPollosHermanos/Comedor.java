package LosPollosHermanos;

import java.util.concurrent.locks.ReentrantLock;
public class Comedor {
    // cambiar nombre
    private ReentrantLock silla, moso, platoServido, lockSillaOcupada, pedirComidaLock;
    private boolean sillaOcupada, pedirComida, comidaServida;


    public Comedor(){
        silla= new ReentrantLock(true);
        moso= new ReentrantLock(true);
        platoServido= new ReentrantLock(true);

        pedirComidaLock= new ReentrantLock(true);
        lockSillaOcupada= new ReentrantLock(true);

    }
    /*
    public void sentarseSilla(){

    }*/
    public void sentarseSilla() throws InterruptedException{
        silla.lock();
        try {
            lockSillaOcupada.lock();
            sillaOcupada= true;
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally{
            lockSillaOcupada.unlock();
        }

    }
    public void atender() throws InterruptedException {
        boolean continuar= false;
        while(!continuar){
            try {
                lockSillaOcupada.lock();
                continuar= sillaOcupada;
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }finally{
                lockSillaOcupada.unlock();
            }
            Thread.sleep(1000);
        }
    }
    public void pedirComida(){
        try {
            pedirComidaLock.lock();
            pedirComida= true;
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally{
            pedirComidaLock.unlock();
        }
        
        
    }
    public void servirPlato() throws InterruptedException{
        boolean continuar= false;
        while(!continuar){
            try {
                pedirComidaLock.lock();
                continuar= pedirComida;
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }finally{
                pedirComidaLock.unlock();
            }
            Thread.sleep(1000);
        }

        try {
            platoServido.lock();
            comidaServida= true;
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally{
            platoServido.unlock();
        
            moso.unlock(); //liberamos el lcok mosos
        }
        
        
        
    }
    public void comer() throws InterruptedException{
        boolean continuar= false;
        while(continuar){
            try {
                platoServido.lock();
                continuar= comidaServida;
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }finally{
                platoServido.unlock();
            }
            Thread.sleep(1000);
        }
    }
    public void dejarSilla(){
        try {
            lockSillaOcupada.lock();
            sillaOcupada= false;
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally{
            lockSillaOcupada.unlock();
            
            silla.unlock();
        }
         
    }

    
}
