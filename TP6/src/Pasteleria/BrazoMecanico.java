package Pasteleria;

public class BrazoMecanico  extends Thread{
    private Mostrador mostrador;

    public BrazoMecanico(Mostrador mostrador) {
        this.mostrador= mostrador;
        
    }
    public void run(){
        while(true){
            try {
                mostrador.reponerCaja();
                System.out.println("El brazo mecanico repuso la caja " );
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }
        }
    }
}
