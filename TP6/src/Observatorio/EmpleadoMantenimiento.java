package Observatorio;

public class EmpleadoMantenimiento extends Thread{
    private Observatorio observatorio;
    private int nro;

    public EmpleadoMantenimiento(Observatorio obs, int nro){
        this.observatorio = obs;
        this.nro = nro;
    }

    public void run() {
        try {
            observatorio.entrarMantenimiento();
            System.out.println("el emplado de mantenimiento " +nro+ " entro en el observatorio");
            Thread.sleep(1500);
            observatorio.salirMantenimiento();
            System.out.println("el emplado de mantenimiento " +nro+ " salio del observatorio");    

        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
