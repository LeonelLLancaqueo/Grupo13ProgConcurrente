public class Hamster extends Thread {
    Actividades hilo;
    String nombre;
    public Hamster(Actividades hilo, String name) {
        this.hilo = hilo;
        this.nombre= name;
    }
    public void run(){
        try {
            this.hilo.comer(this.nombre);
            this.hilo.corriendo(this.nombre);
            this.hilo.descansando(this.nombre);
            
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        
    }
}
