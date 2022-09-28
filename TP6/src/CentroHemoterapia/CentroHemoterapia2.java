package CentroHemoterapia;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CentroHemoterapia2 {
    private Lock centroHemoterapia;
    private Condition revista, televisor;
    private int camillas, sillas,revistas, ordenLlegada, turnoActual, cantDonantes;


    public CentroHemoterapia2(){
        camillas= 4;
        revistas= 9;
        centroHemoterapia= new ReentrantLock();
        revista= centroHemoterapia.newCondition();
        televisor= centroHemoterapia.newCondition();
    }
    
    public  void donarSangre(int preferenciaEspera) throws InterruptedException{
        centroHemoterapia.lock();
        boolean usoRevista= false;
        boolean usoSilla= false;
        int turnoDonante= ordenLlegada;
        ordenLlegada++; 
        while(camillas == 0 || turnoActual != turnoDonante){  
            //tambien fuciona para cuando se libere una revista y se despierten a todos los que no tienen una
            //entonces los que no pudieron conseguir una revista  

            if(preferenciaEspera == 1 && sillas > 0){ // el donante prefiere esperar sentado
                usoSilla= true;
                sillas--;
                System.out.println("el donante con el turno "+ turnoDonante+ " esta esperando sentado");
            }

            while(revistas <= 0 && turnoActual != turnoDonante){ //mientras no haya revitas o no sea el turno del donante
                System.out.println("el donante con el turno "+ turnoDonante+ " espera mirando el televisor");
                televisor.await(); // lo bloqueamos en el televisor
            }
            while(camillas == 0 || turnoActual != turnoDonante){
                //mientras no hayan camillas diponibles o no sea el turno del donante el hilo lee una revista
                usoRevista= true;
                revistas--;
                System.out.println("el donante con el turno "+ turnoDonante+ " agarro una revista y espera leyendo......");
                revista.await();
            }
            

        }
        if(usoRevista){
            /* si el hilo estaba utilizando una revista entonces liberamos una */
            revistas++;
            televisor.signalAll(); // despertamos a los hilos que estan mirando el televisor
        }
        if(usoSilla){
            sillas++;    
        }
        turnoActual++;
        System.out.println("turno actual : "+turnoActual);
        televisor.signalAll();//depertamos por si quedan camillas libres
        revista.signalAll();

        camillas--;
        centroHemoterapia.unlock();
        
    }
    
    public  void salirCentro() throws InterruptedException{
        centroHemoterapia.lock();
        camillas++;
        cantDonantes++;
        System.out.println("cantidad de donantes: "+ cantDonantes);

        
        televisor.signalAll();//se desocupo una camilla entonces despertamos a los hilos
        revista.signalAll();
        centroHemoterapia.unlock();
    }
    

}
