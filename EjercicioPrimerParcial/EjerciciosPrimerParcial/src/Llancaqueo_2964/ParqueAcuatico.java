package Llancaqueo_2964;

import java.util.concurrent.Semaphore;
//import java.util.concurrent.locks.ReentrantLock;


/*
Usa semaforos para rendez vous y locks para modificar los contadores (no corresponde). 
Los visitantes liberan permisos para avisar al empleado, pero asi se transforman en semaforos generales. 
Usa tryacquire, entonces genera una pequeña espera activa. 
Tendria que considerar alguna forma de controlar que la liberación del semaforo para el empleado se haga de a 1 por vez. 
*/
public class ParqueAcuatico {
    private int cantSnorkel, cantAntiparra, visitantes; //estas variables se utilizan para sabes cuantos snorkel/antiparras estan disponibles, visitantes se utiliza para hacer un conteo de la cantidad de visitantes q pasaron por el parque
    private Semaphore personalSnorkel, personalAntiparra, snorkel, antiparra, pedirAntiparra, pedirSnorkel, mutexSnorkel, mutexAntiparra; //estos semaforos se utilizan para comunicarse entre los empleados y los visitantes snorkel/antiparra se utilizan para comunicar al visitante si puede tomar uno de los mismos
    private Semaphore esperarSnorkel, esperarAntiparra; //semaforo utilizado para esperar entregar un instrumento  
    

    public ParqueAcuatico(int cantSnorkel, int cantAntiparra){
        // inicializamos los semaforos de los personales en 0 para q puedan ser despertados por un visitante a la hora de pedirle el instrumento
        this.personalSnorkel = new Semaphore(0); 
        this.personalAntiparra = new Semaphore(0);
        //inicilizamos los semaforos de  snorkel/antiparra en 0 para q sean los personales los responsables de liberarlos si se encuentra alguno disponible
        this.snorkel = new Semaphore(0,true);
        this.antiparra = new Semaphore(0,true);
        this.cantSnorkel= cantSnorkel;
        this.cantAntiparra = cantAntiparra;

        this.pedirAntiparra= new Semaphore(1, true);
        this.pedirSnorkel= new Semaphore(1, true);

        this.esperarAntiparra= new Semaphore(0, true);
        this.esperarSnorkel= new Semaphore(0, true);

        this.mutexSnorkel = new Semaphore(1,true);
        this.mutexAntiparra = new Semaphore(1,true);


        
    }
    public int getVisitantes(){
        return this.visitantes;
    }

    public void pedirAntiparra() throws InterruptedException{ //metodo para comunicarle al personal q un visitante solicita una antiparra
        pedirAntiparra.acquire(); //AGREGE UN SEMAFORO PARA Q SOLO UN VISITANTE PUEDA PEDIR A LA VEZ UNA ANTIPARRA
        personalAntiparra.release();
    }
    public void entregarAntipara() throws InterruptedException{ //metodo utilizado por el personalAntiparra para tratar de entregar una antiparra al visitante si es que se encuentra disponible alguna
        
        personalAntiparra.acquire();

        mutexAntiparra.acquire();
        if(this.cantAntiparra>0){
            mutexAntiparra.release();

            this.antiparra.release(); //liberamos un permiso para que un visitante pueda tomar una antiparra
        
        }else{
            mutexAntiparra.release(); //liberamos en ambos bloques para q al entrar en esperarAntiparra no lleve el permiso

            esperarAntiparra.acquire(); //bloqueamos al hilo hasta q devuelvan una antiparra;
            this.antiparra.release(); //liberamos un permiso para que un visitante pueda tomar una antiparra

        }
        

    }
    public void tomarAntiparra() throws InterruptedException{ // metodo utilizado para q el visitante tome una antiparra si es que el personal le libero el semaforo
        
        this.antiparra.acquire(); // tomamos el permiso liberado por el hilo que entrega las antiparras sino queda bloqueado

        mutexAntiparra.acquire();
        this.cantAntiparra--;
        mutexAntiparra.release();
        
        pedirAntiparra.release();   //liberamos el permiso de pedir antiparras para q otro hilo pueda pedir antiparras
        
    }
    public void pedirSnorkel() throws InterruptedException{ //metodo para comunicarle al personal q un visitante solicita una snorkel
        pedirSnorkel.acquire(); //AGREGE UN SEMAFORO PARA Q SOLO UN VISITANTE PUEDA PEDIR A LA VEZ UN SNORKEL
        this.personalSnorkel.release();
    }


    public void entregarSnorkel() throws InterruptedException{  //metodo utilizado por el personalSnorkel para tratar de entregar una snorkel al visitante si es que se encuentra disponible alguna

        this.personalSnorkel.acquire();

        mutexSnorkel.acquire();
        if(this.cantSnorkel>0){
            mutexSnorkel.release();
            this.snorkel.release();
        }else{
            mutexSnorkel.release();
            
            esperarSnorkel.acquire();
            this.snorkel.release();    
        }
        

    }
    public void tomarSnorkel() throws InterruptedException{ // metodo utilizado para q el visitante tome una snorkel si es que el personal le libero el semaforo

        this.snorkel.acquire();
        
        mutexSnorkel.acquire();
        this.cantSnorkel--;    
        mutexSnorkel.release();
        
        pedirSnorkel.release();
        
        
    }

    public void devolverInstrumentos() throws InterruptedException{ // metodo utilizado para q el visitante pueda devolver la antiparra/snorkel luego de terminar de bucear

        mutexAntiparra.acquire();
        this.cantAntiparra++;
        if(cantAntiparra == 1){
            esperarAntiparra.release();
        }
        mutexAntiparra.release();

        mutexSnorkel.acquire();
        this.cantSnorkel++;
        if(cantSnorkel == 1){
            esperarSnorkel.release();
        }
        mutexSnorkel.release();
        this.visitantes++;

        
        
    }


}
