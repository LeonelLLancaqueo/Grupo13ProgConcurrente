import java.util.logging.Logger;
import java.util.logging.Level;

public class Curandero implements Runnable {
    private int curacion= 3;
    private Guerrero g;
    
    public Curandero(Guerrero n){
        this.g= n;
    }
    public synchronized void curar() throws InterruptedException{
        if(g.getVida()<10 ){
            System.out.println("Realizando curacion: ");
            Thread.sleep(3000);
            g.operar(this.curacion);
            System.out.println("Curacion realizadada");  
            System.out.println("la vida de guerrero es: " + g.getVida());
        }else{
            System.out.println("No se pudo realizar la curacion " + Thread.currentThread().getName());
            System.out.println("Vida del guerrero: "+ g.getVida());
            Thread.sleep(1500);
        }
    }

    public void run(){
        for(int i=0; i <= 12; i++){
            try {
                this.curar();
            } catch (InterruptedException e) {
                Logger.getLogger(VerificarCuenta.class.getName()).log(Level.SEVERE, null, e);
            }          
        }
    }
}
