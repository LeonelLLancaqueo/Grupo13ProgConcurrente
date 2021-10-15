package CarreraRelevos;
import java.util.concurrent.Semaphore;

public class Carrera {
    public Semaphore testigo;
    protected int turnoEquipo;
    
    public Carrera(){
        this.testigo= new Semaphore(1);
        this.turnoEquipo= 0;
        //correrIzq = new Semaphore(2);
        
    }
    public void cambiarTurno(){
        this.turnoEquipo++;
        if(this.turnoEquipo == 2){
            this.turnoEquipo-= 2;
        }
        System.out.println("ultimo turno: "+ turnoEquipo);
    }
    public int getTurno(){
        return this.turnoEquipo;
    }

    public void correr(int nroCompetidor) throws  InterruptedException{
        System.out.println("el competidor: ");
        System.out.println("el hilo: "+ nroCompetidor + " esta corriendo");            
    }
    
    public boolean tomarTestigo(int nroCompetidor, int turno) throws  InterruptedException{
        boolean tomoTestigo= false;
        if(turnoEquipo == turno){
            if(testigo.tryAcquire()) {
                tomoTestigo= true;
                System.out.println("El hilo "+ nroCompetidor+ " tomo el testigo" );
            }  
        }
        return tomoTestigo;	
    }
    public boolean cederRelevo(int nroCompetidor)throws  InterruptedException{
        System.out.println("El hilo "+ nroCompetidor+ " cedio el testigo" );
        this.cambiarTurno();
        testigo.release(); 
        return true;
    }
    /*
    public void correrIzq(String nameThread)throws  InterruptedException{
        correrIzq.acquire();
        System.out.println("el hilo: "+ nameThread + " esta corriendo hacia la derecha");
        correrIzq.release();
    }*/

    /*
    public void cederRelevo(String nameThread)throws  InterruptedException{
        testigoA.acquire(); 
        
        System.out.println("El hilo "+ nameThread );
        
        
    }*/


}
