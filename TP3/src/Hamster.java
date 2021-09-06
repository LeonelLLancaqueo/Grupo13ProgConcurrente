public class Hamster extends Thread {
    Actividades hilo;
    String nombre;
    //boolean comio, corrio, descanso;
    public Hamster(Actividades hilo, String name) {
        this.hilo = hilo;
        this.nombre= name;
    }
    public void run(){
        try {
            /*while(!comio || !corrio || !descanso)
            if(){

            }*/
            this.hilo.comer();
            this.hilo.corriendo();
            this.hilo.descansando();
            
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        
    }
}
