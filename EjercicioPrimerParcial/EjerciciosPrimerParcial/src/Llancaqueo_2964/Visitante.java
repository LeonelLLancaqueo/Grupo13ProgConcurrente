package Llancaqueo_2964;

public class Visitante extends Thread{
    private ParqueAcuatico parqueAcuatico;
    private boolean tomoSnorkel, tomoAntiparra;
    private int nroVisitante;

    public Visitante(ParqueAcuatico parqueAcuatico, int nroVisistante){
        this.parqueAcuatico = parqueAcuatico;
        this.nroVisitante = nroVisistante;
    }
    public void run(){
        try {
            while(!tomoAntiparra || !tomoSnorkel){      
                if(!tomoAntiparra){
                    this.parqueAcuatico.pedirAntiparra();
                    this.tomoAntiparra= parqueAcuatico.tomarAntiparra();
                    if(this.tomoAntiparra){
                        System.out.println("El visitante "+ nroVisitante +" tomo una antiparra");
                    }    
                }
                if(!tomoAntiparra){
                    System.out.println("El visitante "+ nroVisitante +" no puedo tomar una antiparra");
                    Thread.sleep(1250);
                }
                if(!tomoSnorkel){
                    this.parqueAcuatico.pedirSnorkel();
                    this.tomoSnorkel= parqueAcuatico.tomarSnorkel();
                    if(this.tomoSnorkel){
                        System.out.println("El visitante "+ nroVisitante +" tomo un snorkel");
                    }
                }
                if(!tomoSnorkel){
                    System.out.println("El visitante "+ nroVisitante +" no puedo tomar un snorkel");
                    Thread.sleep(1250);
                }
                if( tomoAntiparra && tomoSnorkel){
                    System.out.println("El visitante "+ nroVisitante +" esta buceando");
                    Thread.sleep(1250);
                    System.out.println("El visitante "+ nroVisitante +" termino de buceandar");
                    parqueAcuatico.devolverInstrumentos();
                }
               
            }
           
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }


}
