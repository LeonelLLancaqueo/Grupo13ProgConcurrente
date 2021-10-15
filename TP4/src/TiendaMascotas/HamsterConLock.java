package TiendaMascotas;

public class HamsterConLock extends Thread {
    private Hamaca hamaca;
    private Plato plato;
    private Rueda rueda;
    private int nro;
    private boolean comio, corrio, descanso;
    public HamsterConLock(int nro, Hamaca hamaca, Rueda rueda, Plato plato){
        this.nro= nro;
        this.plato= plato;
        this.hamaca= hamaca;
        this.rueda= rueda;
    }
    public void run(){
        try {
            while(!comio || !corrio || !descanso){
                if(!comio){
                    comio= this.plato.usarPlato();
                    if(comio){
                        System.out.println("El hamster "+ nro+" esta usando el plato");
                    }
                }
                if(!corrio){
                    corrio =this.rueda.usarRueda();
                    if(corrio){
                        System.out.println("El hamster "+ nro+" esta usando la rueda");
                    }                    
                }
                if(!descanso){
                    descanso= this.hamaca.usarHamaca();
                    if(descanso){
                        System.out.println("El hamster "+ nro+" esta usando la hamaca");
                    }
                }
                Thread.sleep(800);
            }
            
            
        } catch (InterruptedException e) {
           System.out.println("error");
        }
        
    }
}
