import java.util.concurrent.Semaphore;

public class Aerolinea {
    private String nombre;
    private Semaphore puesto, hallCenter, mutexOD, guardia, mutexTurno, mutexCE;
    private static final int capMax= 3;
    private int ordenLlegada, turno, cantEsperando;
    


    public Aerolinea(String nombre){
        this.nombre = nombre;
        mutexOD= new Semaphore(1); // mutex orden de llegada
        mutexCE= new Semaphore(1); // mutex cantidad de gente esperando en el hall center
        guardia= new Semaphore(0);
        puesto = new Semaphore(capMax); 
        hallCenter = new Semaphore(0); // lo dejo por las dudas
        ordenLlegada= 1;
        turno= 3; 
        cantEsperando=0;
        mutexTurno= new Semaphore(1);
    }

    public  int solicitarEntrar() throws InterruptedException{
        //En este metodo se le asigna al pasajero la orden de llegada al puesto
        mutexOD.acquire();
        int n= ordenLlegada;
        ordenLlegada++;
        mutexOD.release();
        return n;
    }
    public void entrar(int ordLlegada) throws InterruptedException{
        //en este metodo se retorna si el pasajero logro obtener un permiso para ser atendido en el puesto
        mutexTurno.acquire();
        while(ordLlegada > turno){//por cortocircuito si la primera condicion no se verifica el hilo entra en el bucle 
            mutexCE.acquire();
            cantEsperando++; // aumentamos el contador de personas esperando
            mutexCE.release();

            mutexTurno.release();// liberamos el mutex antes de quedar bloqueados esperando
            
            hallCenter.acquire(); // queda esperando en el hallCenter
            
            mutexTurno.acquire();

            mutexCE.acquire();
            cantEsperando--; // decrementamos el contador de personas esperando
            mutexCE.release();
        }
        
        mutexTurno.release();
        

    }

    public void despertarPasajero() throws InterruptedException{
        guardia.acquire();
        
        mutexCE.acquire();
        hallCenter.release(cantEsperando);
        mutexCE.release();
    } 

    public void hacerCheckIn() throws InterruptedException{ 
        puesto.acquire();
    }
    public void salirPuesto() throws InterruptedException{        
        mutexTurno.acquire();
        turno++; 
        mutexTurno.release();
        
        puesto.release();
        guardia.release();

    }

    //METODOS GET SET
    public String getNombre(){
        return nombre;
    }


}
