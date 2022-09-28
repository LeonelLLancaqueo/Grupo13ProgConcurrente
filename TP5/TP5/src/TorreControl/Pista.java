package TorreControl;
import java.util.concurrent.Semaphore;

public class Pista {
    private int cantAterrizajes, colaAterrizaje; //colaDespegue;
    private Semaphore despegar, aterrizar, pista, mutexColAterrizaje, solicitarPista; // mutexColDespegue;

    public Pista(){
        pista = new Semaphore(1,true);
        despegar = new Semaphore(0,true);
        aterrizar = new Semaphore(0,true);
        mutexColAterrizaje = new Semaphore(1,true);
        solicitarPista=  new Semaphore(1,true);
        //mutexColDespegue = new Semaphore(1,true);
    }


    public void solicitarDespegar() throws InterruptedException{
        //mutexColDespegue.acquire();
        //this.colaDespegue++; 
        //mutexColDespegue.release();
        if(!solicitarPista.tryAcquire()){
            this.despegar.acquire(); //lo agregamos a la cola de aviones que quieren despegar
        }

        //mutexColDespegue.acquire();
        //this.colaDespegue--;
        //mutexColDespegue.release();
    }
    public void despegar() throws InterruptedException{
        this.pista.acquire();
    }
    public void solicitarAterrizar() throws InterruptedException{
        mutexColAterrizaje.acquire();
        this.colaAterrizaje++; 
        mutexColAterrizaje.release();
        
        if(!solicitarPista.tryAcquire()){
            this.aterrizar.acquire(); //lo agregamos a la cola de aviones que quieren aterrizar
        }

        mutexColAterrizaje.acquire();
        this.colaAterrizaje--;
        mutexColAterrizaje.release();
    }
    public void aterrizar() throws InterruptedException{
        this.pista.acquire();
        this.cantAterrizajes++;
    }
    public void terminarUsarPista(){
        if(colaAterrizaje > 0 && (cantAterrizajes%2 != 0 || cantAterrizajes == 0 )){ 
            //si hay cola para aterrizar y no llevan mas de 10 aterrizajes seguidos
            
            this.aterrizar.release(); //habilitamos a un avion a aterrizar
        }else{
            //si no hay cola para aterrizar o llevan mas de 10 aterrizajes seguidos
            cantAterrizajes=0; //ESTA BIEN DEJARLA AHI???
            this.despegar.release(); //habilitamos a un avion a despegar
        }
        this.pista.release();

    }

}
