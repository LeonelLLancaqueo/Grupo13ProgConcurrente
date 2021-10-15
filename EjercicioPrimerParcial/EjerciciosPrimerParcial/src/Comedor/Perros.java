package Comedor;

public class Perros extends Thread{
    private Comedor comedor;
    private boolean comio;
    private int numPerro, animal;
    public Perros(Comedor comedor, int num, int animal){
        this.comedor= comedor;
        this.numPerro = num;
        this.animal = animal;
    }
    public void run() {
        try {
            while(!comio){
                System.out.println("El perro num: "+numPerro+" esta caminando hacia el comedor");
                Thread.sleep(1250);
                if(comedor.entrarComedor(animal)){
                    if(comedor.solicitarPlato()){
                        comio= comedor.terminarComer();
                    }
                }
                
                if(comio){
                    System.out.println("El perro num: "+numPerro+" comio");
                }
            }
            
        
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
