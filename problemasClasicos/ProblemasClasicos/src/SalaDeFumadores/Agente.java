package SalaDeFumadores;
import java.util.Random;
public class Agente extends Thread{
    private SalaDeFumadores sala;
    private Random r;
    public Agente(SalaDeFumadores sala){
        this.sala = sala;
        r= new Random();
    }
    public void run (){
        while(true){
            try {
                sala.colocar(r.nextInt(3)+1);
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }
            
        }//while
    }// run
}
