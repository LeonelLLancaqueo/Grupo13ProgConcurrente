package TiendaMascotas;
public class Hamster extends Thread {
    Actividades hilo;
    private String nombre;
    private boolean comio, corrio, descanso;
    public Hamster(Actividades hilo, String name) {
        this.hilo = hilo;
        this.nombre= name;
        comio= false;
        corrio= false;
        descanso= false;
    }
    public void run(){
        try {
            while(!comio || !corrio || !descanso){
                if(!comio){
                    comio= this.hilo.comer(this.nombre);
                }
                if(!corrio){
                    corrio =this.hilo.corriendo(this.nombre);
                }
                if(!descanso){
                    descanso= this.hilo.descansando(this.nombre);
                }
                
            }
            
            
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        
    }
}
