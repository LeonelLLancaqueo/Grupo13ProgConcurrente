import java.util.concurrent.BrokenBarrierException;

public class Pasajero extends Thread {
    private Aeropuerto aeropuerto;
    private PuestoAerolinea aerolinea;
    private static int idPasajero=0;
    private int id;
    private Pasaje pasaje;
    private Terminal terminal; // donde el pasajero


    public Pasajero(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
        this.id = Pasajero.inicializarId();
        this.pasaje= null;
        
    }
    private static int inicializarId(){        
        int id= idPasajero;
        idPasajero++;        
        return id;
    }

    public void run() {
        int ordLlegada=-1;
        try {


            //Puesto informe entrada del aeropuerto
            aerolinea= aeropuerto.entrarPuestoInforme();
            System.out.println("El pasajero "+id+" entro al aeropuerto y se le asigno la aerolinea "+ aerolinea.getNombre());
            //Puesto de la aerolinea
            ordLlegada= aerolinea.solicitarEntrar();
            if(ordLlegada != -1){
                System.out.println("El pasajero "+id+" tiene el turno "+ ordLlegada);

                aerolinea.entrar(ordLlegada);
                System.out.println("El pasajero "+id+" entro al puesto de atencion");
                
                this.pasaje= aerolinea.comprarPasaje(); // el pasajero pudo entrar y compra un pasaje
                System.out.println("El pasajero "+id+" compro su pasaje de avion");

                aerolinea.hacerCheckIn();
                Thread.sleep(5000);
                System.out.println("El pasajero "+id+" sale del puesto de atencion");
                aerolinea.salirPuesto();
                try {
                    aeropuerto.tomarTren();
                    System.out.println("El pasajero "+id+" consiguio lugar en el tren");
                
                }
                catch (BrokenBarrierException err) {
                    System.out.println(err.getMessage());
                }
                terminal= aeropuerto.bajarTren(pasaje.getIdTerminal()); 
                System.out.println("El pasajero se bajo en la terminal "+ terminal.getId());

                
                

            }else{
                System.out.println("El pasajero "+id+" no consiguio pasaje y se va del aeropuerto");
            }
            
            
        
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }

    }

}
