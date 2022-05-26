public class GuardiaAeropuerto extends Thread{
    private Aeropuerto aeropuerto;

    public GuardiaAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }
    public void run(){
        while(true){
            try {
                aeropuerto.abrirAeropuerto();
                System.out.println("El guardia del aeropuerto abre el aeropuerto");
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }
        }
    }

}
