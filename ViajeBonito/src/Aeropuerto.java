
import java.util.concurrent.Semaphore;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Aeropuerto {
    private PuestoAerolinea colAerolinea[];
    private GuardiaSeguridad colGuardia[];
    private Terminal colTerminal [];
    private int hora, espEntrar, personasEnTren; 
    private final int CANT_LUGARES_TREN= 10; 
    private static final int horaCierre= 20;
    private Semaphore  entrar, guardia, lugaresTren, esperarBajar, guardiaTren;
    private Semaphore mutexHora, mutexEspEntrar, mutexPEN;
    //datos para inicializar a los demas objetos pasivos del aeropuerto
    private static final String nombreAerolinea[]= new String[]{"Aerolineas Argentinas", "AirBang", "Fly", "AliExpress", "Despegar"};
    private char idTerminal[]= new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
    private int colEmbarque[][]= new int[][]{ {0,1,2,3,4,5},{6,7,8,9,10,11},{12,13,14,15,16,17},{18,19,20,21,22,23},{24,25,26,27,28,29}};  
    private Random r;
    private CyclicBarrier tren; //variable utilizada para bloquear a los pasajeros hasta que se llene el tren
    private Terminal paradaTren; 
    private TablaVuelo tablaVuelo;


    public Aeropuerto(int cantAerolinea) throws InterruptedException{
        hora= 5;
        r= new Random(); //utilizamos para hacer las reservas de manera aleatoria
        paradaTren= null;

        // Entrar Aeropuerto y Puesto de informe
        guardia= new Semaphore(0);
        entrar= new Semaphore(0);
        mutexEspEntrar= new Semaphore(1);
        espEntrar= 0;
        //tren
        lugaresTren= new Semaphore(CANT_LUGARES_TREN);
        mutexPEN= new Semaphore(1);
        guardiaTren= new Semaphore(0);

        //mutex
        mutexHora= new Semaphore(1);
        this.inicializarColAerolineaYGuardia(cantAerolinea);
    
        tren= new CyclicBarrier(CANT_LUGARES_TREN);
        tablaVuelo= new TablaVuelo(colAerolinea, colEmbarque, idTerminal, nombreAerolinea);

        System.out.println(tablaVuelo.mostrarVuelos());
    }
    // METODO EJECUTADO POR EL RELOJ
    public void reloj() throws InterruptedException{
        mutexHora.acquire();
        hora++;
        System.out.println("El reloj marca las "+ hora+ " hs");
        if(hora == 6){ //SI ES LA HORA DE ABRIR
            guardia.release();  //EL RELOJ DESPIERTA AL GUARDIA
        }
        mutexHora.release();
    }
    //METODO EJECUTADO POR EL GAURDIA SEGURIDAD AEROPUERTO
    public void abrirAeropuerto() throws InterruptedException{
        //En este metodo el guardia del aeropuerto abre la puerta a los pasajeros esperando a entrar al puesto de informe
        guardia.acquire();
        
        mutexEspEntrar.acquire();  
        entrar.release(espEntrar); // dejamos entrar a la gente al aeropuerto
        espEntrar=0;
        mutexEspEntrar.release();

    }

    //METODOS EJECUTADOS POR EL PASAJEROS
    public PuestoAerolinea entrarPuestoInforme() throws InterruptedException{
        /* EN ESTE METODO LOS PASAJEROS INTENTA ENTRAR AL AEROPUERTO */
        mutexHora.acquire();
        if(hora < 6 || hora > 16){ // SI EL AEROPUERTO ESTA CERRADO LOS PASAJEROS QUEDAN BLOQUEADOS ESPERANDO A QUE VUELVA A ABRIR

            mutexEspEntrar.acquire();
            espEntrar++;
            mutexEspEntrar.release();
            
            mutexHora.release(); //liberamos el semaforo
            
            entrar.acquire();
            
            mutexHora.acquire(); //lo volvemos a agarrar 
        }   
        
        mutexHora.release();

        return colAerolinea[r.nextInt(colAerolinea.length)];
        
    }
    
    // PARTE DEL TREN

    public void tomarTren() throws  BrokenBarrierException, InterruptedException {
        lugaresTren.acquire();
        mutexPEN.acquire();
        personasEnTren++;
        if(personasEnTren == CANT_LUGARES_TREN){
            
        }
        mutexPEN.acquire();
        tren.await();
    }

    public Terminal bajarTren(char idTerminal) throws InterruptedException{
        esperarBajar.acquire(); // lo utilizamos para que queden bloqueados hasta llegar a la primera parada
        while(paradaTren.getId() != idTerminal){
            esperarBajar.acquire();
        }
        mutexPEN.acquire();
        personasEnTren--;
        mutexPEN.acquire();
        return paradaTren; 
    } 

    public void empezarRecorrido() throws InterruptedException{
        //EL RECORRIDO SE SIMULA RECORRIENDO LA COLECCION DE TERMINALES Y 

        for(int i=0; i<colTerminal.length; i++){
            Thread.sleep(5000); // simulamos el viaje en tren
            paradaTren = colTerminal[i]; // asignamos la terminal en la que para el tren
            esperarBajar.release(personasEnTren); //despertamos a todos los pasajeros para que se bajen los que coinicidan la parada del tren con su terminal de pasaje
            Thread.sleep(5000); // aguardamos a que terminen de bajar los pasajeros
        }
        
    }
    public void terminarRecorrido(){
        System.out.println("Cantidad de personas en tren " + personasEnTren);
        tren.reset(); //reiniciamos el contador de pasajeros de tren
        lugaresTren.release(CANT_LUGARES_TREN);
    }

    // METODOS PROPIOS DE AEROPUERTO
    private void inicializarColAerolineaYGuardia(int n){
        colAerolinea= new PuestoAerolinea [n];
        colGuardia= new GuardiaSeguridad [n];
        for(int i = 0; i < n; i++){
            colAerolinea[i]= new PuestoAerolinea(nombreAerolinea[i]); 
            colGuardia[i]= new GuardiaSeguridad(colAerolinea[i]);
            colGuardia[i].start();
        }
    }

    private void inicializarTerminal(){
        
        colTerminal= new Terminal[3];
        for(int i=0; i<3; i++){
            colTerminal[i]= new Terminal(idTerminal[i], colEmbarque[i]);
        }
    } 
    
    

}
