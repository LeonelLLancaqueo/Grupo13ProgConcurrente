package ProductorConsumidorLock;

public class ProductorConsumidorMain {
    public static void main(String[] args){
        Buffer buffer = new Buffer(10);
        Productor productor = new Productor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        consumidor.start();
        productor.start();
        
    }
}
