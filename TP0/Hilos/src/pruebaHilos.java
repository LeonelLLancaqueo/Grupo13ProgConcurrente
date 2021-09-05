public class pruebaHilos extends Thread{
    private String cadena; //mensje que se va a escribir
    private int delay; //tiempo entre escritura
    public pruebaHilos(String cadena, int time) {
        this.cadena= cadena;
        this.delay=time;
    }
    public void run(){
        for (int i = 1; i< delay ; i++){
                System.out.print(this.cadena + " ");
            try { 
                Thread.sleep(delay*1000);}
            catch(InterruptedException e){
            
            }
        }        
    }
}
