package ProductorConsumidorLock;

public class Productor extends Thread{
    private Buffer buffer;

    public Productor(Buffer buffer){
        this.buffer = buffer;
    }
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
                buffer.producir();
                System.out.println("productor produciendo.....");
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }

        }
    }
}
