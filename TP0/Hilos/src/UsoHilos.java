

public class UsoHilos {
    
    public static void main(String[] args){
        System.out.println("Hilo principal iniciando. ");

        //Primero, construye un objeto hiloRunneable
        hiloRunnable h1= new hiloRunnable("#1");
        //luego creamos un hilo con ese objeto
        Thread newHilo= new Thread(h1);

        newHilo.start();
        try{
            newHilo.join();
        }catch(InterruptedException e){
            System.out.println("error");
        }

        for(int i=0; i<50; i++){
            System.out.println(" .");
        }
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            System.out.println("Hilo principal interrumplido");
        }
        System.out.println("hilo principal terminado");
    }
}
