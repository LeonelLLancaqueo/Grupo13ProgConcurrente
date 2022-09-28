package TrenTuristico;
import java.util.concurrent.CyclicBarrier;

public class Pasajero extends Thread{
    private trenMejorado tren;
    private int nroPasajero;

    public Pasajero(trenMejorado tren, int nroPasajero){
        this.tren = tren;
        this.nroPasajero = nroPasajero;
    }
    /* cuando llamar  a comer debemos contarlos */
    /* si hay menos cantidad de animales q permisos entonces  */
    /* si la cantidad de animales q ya comieron es igual a la cantidad o la cantidad de animales de la especie es igual a 0 cambiar turno */

    public void run(){
        try {
            //while(true){
                Thread.sleep((int)(Math.random() * 1000));
                tren.comprarTicket();
                System.out.println("El pasajero nro "+ nroPasajero + " entra a comprar un ticket");
                tren.tomarTicket();
                System.out.println("El pasajero nro "+ nroPasajero + " toma el ticket");
                tren.tomarTren();           
                System.out.println("El pasajero nro "+ nroPasajero + " tomo el tren");
                tren.bajarTren();
                System.out.println("El pasajero nro "+ nroPasajero + " se baja tren");
                
            //} 
        }   
        catch (Exception err) {
            System.out.println(err.getMessage());
        }   
    }
}
