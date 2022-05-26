public class GuardiaSeguridad extends Thread {
    private static int idGuardia=0;
    private Aerolinea aerolinea;
    private int id; 


    public GuardiaSeguridad(Aerolinea aerolinea){
        this.aerolinea= aerolinea;
        this.id= inicializarId();
    }

    public static int inicializarId(){
        int id= idGuardia;
        idGuardia++;
        return id;
    }
    public void run(){
        while(true){
            try {
                aerolinea.despertarPasajero();
                System.out.println("El guardia "+ id+" despierta a los pasajeros ");
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
    }

}
