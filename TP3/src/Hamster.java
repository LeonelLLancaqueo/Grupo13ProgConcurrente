public class Hamster extends Thread {
    Actividades hilo;
    private String nombre;
    private boolean comio, corriendo, descansando;
    public Hamster(Actividades hilo, String name) {
        this.hilo = hilo;
        this.nombre= name;
    }
    public void run(){
        try {
            while(true){
                this.hilo.comer(this.nombre);
                this.hilo.corriendo(this.nombre);
                this.hilo.descansando(this.nombre);
            }
            
            
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        
    }
}
