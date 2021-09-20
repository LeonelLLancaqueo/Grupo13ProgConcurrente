public class CounterMain {
    public static void main(String[] args) {
        
        
        //***********    PRUEBA CLASS SynchronizedCounter  ***************
        /*
        SynchronizedCounter n = new SynchronizedCounter(); 

        n.start();
        for(int i=0; i <5 ; i++){
            n.increment();
        }
        try {
            n.join();    
        } catch (Exception e) {
            System.out.println("error");
        }
        
        System.out.println("Resultado: "+ n.value());
        */
        
        SynchronizedObjectCounter n= new SynchronizedObjectCounter();
        n.start();

        for(int i=0; i <5 ; i++){
            n.decrement();
        }
        try {
            n.join();    
        } catch (Exception e) {
            System.out.println("error");
        }
        
        System.out.println("Resultado: "+ n.value());
        
    }
}
