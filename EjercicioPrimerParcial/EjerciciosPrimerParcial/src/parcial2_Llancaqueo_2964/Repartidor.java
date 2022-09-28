package parcial2_Llancaqueo_2964;

import java.util.Random;
public class Repartidor extends Thread{
    private Fabrica fabrica;
    private Random r;

    public Repartidor(Fabrica fabrica){
        this.fabrica = fabrica;
        r= new Random();
    }

    public void run(){
        while(true){
            try {
                fabrica.repartir(); // elige una caja entre 1 y 2
                System.out.println("El repartidor salio a repartir cajas");
                Thread.sleep(5000);
                
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
        /*
        java.lang.ClassCastException: class parcial2_Llancaqueo_2964.Caja cannot be cast to class parcial2_Llancaqueo_2964.CajaVino (parcial2_Llancaqueo_2964.Caja and parcial2_Llancaqueo_2964.CajaVino are in unnamed module of loader 'app')
        at parcial2_Llancaqueo_2964.Fabrica.repartir(Fabrica.java:175)
        at parcial2_Llancaqueo_2964.Repartidor.run(Repartidor.java:16) */
    }
}
