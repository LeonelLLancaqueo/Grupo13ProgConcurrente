public class SynchronizedObjectCounter extends Thread{
    private int c = 0 ;
    public void increment( ){
        synchronized ((Integer)c) { 
            c++;
            System.out.println("c= "+ this.value());
        }   // Este elemento debe ser casteado a Integer
    }
    public void decrement( ) {
        synchronized (this) { 
            c--;
            System.out.println("c= "+ this.value());
        }
    }
    public int value( ) { return c ;}
    
    public void run(){
        for(int i=0; i <5 ; i++){
            this.increment();
        }
        
    }

}
