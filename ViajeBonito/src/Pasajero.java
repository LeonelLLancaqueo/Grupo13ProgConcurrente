public class Pasajero extends Thread {
    private Aeropuerto aeropuerto;
    private Aerolinea aerolinea;
    private static int idPasajero=0;
    private int id;

    public Pasajero(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
        this.id = Pasajero.inicializarId();
    
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
            System.out.println("El pasajero "+id+" tiene el turno "+ ordLlegada);

            aerolinea.entrar(ordLlegada);
            System.out.println("El pasajero "+id+" entro al puesto de atencion");

            aerolinea.hacerCheckIn();
            Thread.sleep(5000);
            System.out.println("El pasajero "+id+" sale del puesto de atencion");
            aerolinea.salirPuesto();
            
        
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }

    }

}
