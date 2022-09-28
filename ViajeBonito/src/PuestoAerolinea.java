import java.util.concurrent.Semaphore;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;


public class PuestoAerolinea {
    private String nombre;
    private Semaphore puesto, hallCenter, mutexOD, guardia, mutexTurno, mutexCE, mutexPasaje, mutexStock;
    private static final int capMax= 3;
    private int ordenLlegada, turno, cantEsperando, stockPasajes, clientes;
    private LinkedList<Vuelo> vuelos; 

    
    

    public PuestoAerolinea(String nombre){
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
        mutexPasaje= new Semaphore(1);
        vuelos = new LinkedList<Vuelo>(); 

    }
   
    
    // METODO EJECUTADO POR EL GENERADOR DE VUELOS
    public void agregarVuelo(Vuelo nVuelo) throws InterruptedException{
        //no sincronizamos pq el hilo no comparte el punto critico con otro objeto ademas de que se realiza como una precarga 
        mutexStock.acquire();
        vuelos.add(nVuelo);
        stockPasajes+= 10;
        mutexStock.acquire();

    }
    
    public  int solicitarEntrar() throws InterruptedException{
        //En este metodo se le asigna al pasajero la orden de llegada al puesto
        
        mutexStock.acquire();

        int n= ordenLlegada;
        if(ordenLlegada <= stockPasajes){// mientras todavia haya pasajes para vender
            ordenLlegada++;
        }else{
            n= -1; // significa que no puedo entrar 
        }
        mutexStock.release();
        
        return n;
    }
    public void entrar(int ordLlegada) throws InterruptedException{
        //en este metodo el pasajero trata de entrar a al puesto de atencion cuando haya lugar y sea su turno 
        
        mutexTurno.acquire();
        while(ordLlegada > turno){
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
        
        puesto.acquire();
        
    }
    public Pasaje comprarPasaje() throws InterruptedException{
        // En este metodo el pasajero compra un pasaje con el cual podra hacer el resto del recorrido en el aeropuerto 
        mutexPasaje.acquire();
        Pasaje aux= vuelos.peek().venderPasaje();
        if(!vuelos.peek().isStockPasajes()){ //si el avion se quedo sin pasajes para vender
            vuelos.remove(); // lo removemos de la col de vuelos
        }  
        mutexPasaje.release();
        return aux;
    }

    public void despertarPasajero() throws InterruptedException{
        guardia.acquire();
        
        mutexCE.acquire();
        hallCenter.release(cantEsperando);
        mutexCE.release();
    } 

    public void hacerCheckIn() throws InterruptedException{ 
        
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
