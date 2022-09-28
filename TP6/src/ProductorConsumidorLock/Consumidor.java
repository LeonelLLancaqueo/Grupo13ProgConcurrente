package ProductorConsumidorLock;

public class Consumidor extends Thread {
    private Buffer buffer;

    public Consumidor(Buffer buffer){
        this.buffer = buffer;
    }
    public void run(){
        while(true){
            try {
                //Thread.sleep(1000);
                buffer.consumir();
                System.out.println("consumidor consumiendo.....");
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }

        }
    }

}
