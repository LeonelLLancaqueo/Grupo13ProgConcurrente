import java.util.logging.Logger;
import java.util.logging.Level;

public class Orco implements Runnable {
    private int ataque= 3;
    private Guerrero g;
    public Orco(Guerrero n){
        this.g= n;
    }
    public synchronized void atacar()throws InterruptedException{
        if(g.getVida() >= 0){
            System.out.println("Realizando ataque: ");           
            Thread.sleep(1500);                
            g.restarVida(this.ataque);
            System.out.println("Ataque realizado");  
            System.out.println("la vida de guerrero es: " + g.getVida());
        }else{
            System.out.println("el guerrero esta muerto "+ Thread.currentThread().getName());
            System.out.println("la vida de guerrero es: " + g.getVida());
            Thread.sleep(1000);    
        }
    }

    public void run() {
        for(int i=0; i <= 15; i++){
            try {
                this.atacar();
            } catch (InterruptedException e) {
                Logger.getLogger(VerificarCuenta.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
