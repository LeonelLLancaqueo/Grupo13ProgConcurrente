
class Actividades   {
    private Object comer = new Object();
    private Object corriendo = new Object();
    private Object descansando = new Object();

    public void comer(String nombreHamster) throws InterruptedException{
        synchronized (comer){
            System.out.println("Hamster "+ nombreHamster  +" comiendo.....");
            System.out.println("Hamster "+ nombreHamster  +" termino de comer.");
        }
        
    }
    public  void corriendo(String nombreHamste) throws InterruptedException{
        synchronized(corriendo){
            System.out.println("Hamster "+ nombreHamste  +" corriendo.....");
            System.out.println("Hamster "+ nombreHamste  +" termino de correr");
        }
        

    }
    public  void descansando(String nombreHamste) throws InterruptedException{

        synchronized (descansando){
            System.out.println("Hamster "+ nombreHamste  +" descansando.....");
            System.out.println("Hamster "+ nombreHamste  +" termino de descansar.");
        }

    }
}






