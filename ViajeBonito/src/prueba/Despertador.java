package prueba;

public class Despertador extends Thread{
    private Salon recurso;

    public Despertador(Salon salon) {
        this.recurso = salon;
    }

    public void run(){
        try {
            for(int i=0; i<5; i++){
                Thread.sleep(5000);
                recurso.despertarHilo();
                System.out.println("El hilo desperador desperto un hilo");

            }
            
            
        }   
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
