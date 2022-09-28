package Carpinteria;

public class Ensamblador extends Thread{
    private carpinteria carpinteria;


    public Ensamblador(carpinteria carpinteria) {
        this.carpinteria= carpinteria;
        
    }
    public void run() {
        while (true) {
            try {
                carpinteria.armarMueble();
                System.out.println("El ensamblador tomo una pieza");
                Thread.sleep(3000);
                
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
    }
}
