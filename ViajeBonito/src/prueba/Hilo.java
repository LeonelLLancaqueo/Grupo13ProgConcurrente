package prueba;

public class Hilo extends Thread {
    private Salon recurso;

    public Hilo(Salon salon) {
        this.recurso = salon;
    }

    public void run(){
        try {
            System.out.println("El hilo entro en la cola");
            recurso.entrarCola();
            System.out.println("El hilo salio de la cola");
            
        }   
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
