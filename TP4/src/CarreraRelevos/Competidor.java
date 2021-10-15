package CarreraRelevos;
public class Competidor extends Thread{
    private int nroCompetidor;
    private Carrera carrera;
    private int equipo;
    private boolean terminoLaCarrera;
    
    public Competidor(int nroComp, Carrera carrera, int equipo){
        this.nroCompetidor = nroComp;
        this.carrera = carrera;
        this.equipo = equipo;
        this.terminoLaCarrera= false;
    }    
    public String getName(String name){
        return name;
    }
   
    public void run(){
        try {
            Thread.sleep(1000);
            while(!terminoLaCarrera){
                if(carrera.tomarTestigo(nroCompetidor, equipo)){
                    carrera.correr(this.nroCompetidor);
                    int valor= (int)(Math.random()*1000);
                    System.out.println("tiempo dormido: " + valor);
                    Thread.sleep(valor);
                    terminoLaCarrera= carrera.cederRelevo(nroCompetidor);
                    System.out.println(System.currentTimeMillis());
                }
                Thread.sleep(1000);

            }
            
        }
        catch (InterruptedException e) {
            System.out.println("Error");
        }
        
    }

}
