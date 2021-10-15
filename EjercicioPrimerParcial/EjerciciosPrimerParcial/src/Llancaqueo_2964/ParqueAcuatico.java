package Llancaqueo_2964;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
public class ParqueAcuatico {
    private int cantSnorkel, cantAntiparra, visitantes; //estas variables se utilizan para sabes cuantos snorkel/antiparras estan disponibles, visitantes se utiliza para hacer un conteo de la cantidad de visitantes q pasaron por el parque
    private Semaphore personalSnorkel, personalAntiparra, snorkel, antiparra; //estos semaforos se utilizan para comunicarse entre los empleados y los visitantes snorkel/antiparra se utilizan para comunicar al visitante si puede tomar uno de los mismos
    private ReentrantLock lockSnorkel, lockAntiparra;  // estos locks se utlizan para proteger la seccion critica de las variables de cantAntiparra y cantSnorkels a la hora de ser modificado por los distintos hilos

    public ParqueAcuatico(int cantSnorkel, int cantAntiparra){
        // inicializamos los semaforos de los personales en 0 para q puedan ser despertados por un visitante a la hora de pedirle el instrumento
        this.personalSnorkel = new Semaphore(0); 
        this.personalAntiparra = new Semaphore(0);
        //inicilizamos los semaforos de  snorkel/antiparra en 0 para q sean los personales los responsables de liberarlos si se encuentra alguno disponible
        this.snorkel = new Semaphore(0,true);
        this.antiparra = new Semaphore(0,true);
        this.cantSnorkel= cantSnorkel;
        this.cantAntiparra = cantAntiparra;
        this.lockAntiparra= new ReentrantLock();
        this.lockSnorkel= new ReentrantLock();
        
    }
    public int getVisitantes(){
        return this.visitantes;
    }

    public void pedirAntiparra(){ //metodo para comunicarle al personal q un visitante solicita una antiparra
        personalAntiparra.release();
    }
    public boolean entregarAntipara() throws InterruptedException{ //metodo utilizado por el personalAntiparra para tratar de entregar una antiparra al visitante si es que se encuentra disponible alguna
        boolean exito= false;
        personalAntiparra.acquire();
        try {
            lockAntiparra.lock();
            if(this.cantAntiparra>0){
                this.antiparra.release();
                exito= true;
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally{
            lockAntiparra.unlock();
        }
        return exito;

    }
    public boolean tomarAntiparra() throws InterruptedException{ // metodo utilizado para q el visitante tome una antiparra si es que el personal le libero el semaforo
        boolean exito= false;
        if(this.antiparra.tryAcquire()){
            try {
                lockAntiparra.lock();
                this.cantAntiparra--;
                exito= true;
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }finally{
                lockAntiparra.unlock();
            }
        }
        return exito;
    }
    public void pedirSnorkel(){ //metodo para comunicarle al personal q un visitante solicita una snorkel
        this.personalSnorkel.release();
    }


    public boolean entregarSnorkel() throws InterruptedException{  //metodo utilizado por el personalSnorkel para tratar de entregar una snorkel al visitante si es que se encuentra disponible alguna
        boolean exito= false;
        this.personalSnorkel.acquire();
        try {
            lockSnorkel.lock();
            if(this.cantSnorkel>0){
                exito= true;
                this.snorkel.release();
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally{
            lockSnorkel.unlock();
        }
        return exito;
    }
    public boolean tomarSnorkel() throws InterruptedException{ // metodo utilizado para q el visitante tome una snorkel si es que el personal le libero el semaforo
        boolean exito= false;

        if(this.snorkel.tryAcquire()){
            try {
                lockSnorkel.lock();
                this.cantSnorkel--;
                exito= true;
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }finally{
                lockSnorkel.unlock();
            }
        }
       
        return exito;
        
    }

    public void devolverInstrumentos(){ // metodo utilizado para q el visitante pueda devolver la antiparra/snorkel luego de terminar de bucear
        try {
            lockAntiparra.lock();
            this.cantAntiparra++;
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally{
            lockAntiparra.unlock();
        }
        try {
            lockSnorkel.lock();
            this.cantSnorkel++;
            this.visitantes++;
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally{
            lockSnorkel.unlock();
            
        }
        
        
    }


}
