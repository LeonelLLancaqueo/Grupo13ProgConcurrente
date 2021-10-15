package TiendaMascotas;

import java.util.concurrent.Semaphore;

class Actividades   {
    /*
    private Object comer = new Object();
    private Object corriendo = new Object();
    private Object descansando = new Object();*/
    public Semaphore comerS, corriendoS, descansandoS ;
    
    public Actividades(){
        comerS= new Semaphore(1);
        corriendoS= new Semaphore(1);
        descansandoS= new Semaphore(1); 
    }
    
    /*public boolean getComer(){
        syn
        return 
    }*/
    
    public boolean comer(String nombreHamster) throws InterruptedException{
        boolean comio= false;
        if(comerS.tryAcquire()){
            System.out.println("Hamster "+ nombreHamster  +" comiendo.....");
            System.out.println("Hamster "+ nombreHamster  +" termino de comer.");
            comio= true;
            comerS.release();
        }

        return comio;
    }

    public  boolean  corriendo(String nombreHamste) throws InterruptedException{
        boolean corrio= false;
            if(corriendoS.tryAcquire()){
                System.out.println("Hamster "+ nombreHamste  +" corriendo.....");
                Thread.sleep(2000);
                System.out.println("Hamster "+ nombreHamste  +" termino de correr");
                corrio= true;
                corriendoS.release();
            }
        //}}
        return corrio;
        
    }

    public  boolean descansando(String nombreHamste) throws InterruptedException{
        boolean descansando= false;
            if(descansandoS.tryAcquire()){
            System.out.println("Hamster "+ nombreHamste  +" descansando.....");
            Thread.sleep(3000);   
            System.out.println("Hamster "+ nombreHamste  +" termino de descansar.");
            descansando= true;
            descansandoS.release();
        }

        return descansando;
    }
}






