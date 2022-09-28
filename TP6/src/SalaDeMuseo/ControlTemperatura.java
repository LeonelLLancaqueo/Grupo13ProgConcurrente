package SalaDeMuseo;
import java.util.Random;

public class ControlTemperatura extends Thread{
    private SalaMuseo sala;
    private Random r;

    public ControlTemperatura(SalaMuseo sala){
        this.sala = sala;
        this.r = new Random();
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(550);
                sala.notificarTemperatura(r.nextInt(80)+1);
                System.out.println("El controlador de temparatura notifica la temperatura");
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
        
    }

}
