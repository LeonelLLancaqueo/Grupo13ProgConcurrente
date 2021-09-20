import java.util.concurrent.Semaphore;

class Actividades   {
    /*
    private Object comer = new Object();
    private Object corriendo = new Object();
    private Object descansando = new Object();*/
    private Semaphore actividades;
    public Actividades(){
        actividades= new Semaphore(1); 
    }
    public void comer(String nombreHamster) throws InterruptedException{
        
        actividades.acquire();
        System.out.println("Hamster "+ nombreHamster  +" comiendo.....");
        System.out.println("Hamster "+ nombreHamster  +" termino de comer.");
        actividades.release();
    }

    public  void corriendo(String nombreHamste) throws InterruptedException{
        actividades.acquire();    
        System.out.println("Hamster "+ nombreHamste  +" corriendo.....");
        System.out.println("Hamster "+ nombreHamste  +" termino de correr");
        actividades.release();
    }

    public  void descansando(String nombreHamste) throws InterruptedException{
        actividades.acquire();
        System.out.println("Hamster "+ nombreHamste  +" descansando.....");
        System.out.println("Hamster "+ nombreHamste  +" termino de descansar.");
        actividades.release();
    }
}






