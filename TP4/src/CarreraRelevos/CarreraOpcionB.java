package CarreraRelevos;
import java.util.concurrent.Semaphore;

public class CarreraOpcionB  {
    public Semaphore testigo;
    protected int turnoEquipo;
    
    public CarreraOpcionB(){
        this.testigo= new Semaphore(1);
        this.turnoEquipo= 0;
        //correrIzq = new Semaphore(2);
        
    }
    public void cambiarTurno(){
        this.turnoEquipo++;

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
}
