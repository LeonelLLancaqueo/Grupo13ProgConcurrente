public class SynchronizedCounter extends Thread{
    private int c = 0 ;
    public synchronized void increment( ) { 
        c++;
        System.out.println("c= "+ this.value());
    }
    public void decrement( ) { 
        c--;    // no esta protegida la seccion critica de este metodo
        System.out.println("c= "+ this.value());
    }
    public synchronized int value( ) { return c ;}
    
    public void run(){
        for(int i=0; i <5 ; i++){
            this.decrement();
        }
    }

}
