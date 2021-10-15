package EjercicioTaxista;
import java.util.concurrent.Semaphore;

public class Taxi {
    public Semaphore tomarTaxi, realizarViaje, avisarTerminoViaje, BajarTaxi;
    //AL HACER LA SINCRONIZACION EN EL RECURSO COMPARTIDO NOS FACILITA CAMBIAR LA HERRAMIENTA DE SINCRONIZACION
    public Taxi(){
        tomarTaxi = new Semaphore(1);
        realizarViaje = new Semaphore(0);
        BajarTaxi = new Semaphore(0);
        avisarTerminoViaje= new Semaphore(0);
    }
    /* HACER LOS PRINT EN LOS HILOS */
    public void tomarTaxi(int nroCliente) throws InterruptedException{
        tomarTaxi.acquire();
        System.out.println("El cliente: "+ nroCliente + " se subio al taxi");
        realizarViaje.release();
    }
    public void realizarViaje() throws InterruptedException{

            realizarViaje.acquire();
            System.out.println("El taxista empieza el viaje");
            avisarTerminoViaje.release();
              
    }
    public void avisarTerminoViaje() throws InterruptedException{
        avisarTerminoViaje.acquire();
        System.out.println("El taxista avisa que llego al destino");
        BajarTaxi.release();
    }
    public void bajarDelTaxi(int nroCliente) throws InterruptedException{
        BajarTaxi.acquire();
        System.out.println("El cliente: "+ nroCliente+ " se vaja del taxi");
        tomarTaxi.release();
    }
    
    

}
