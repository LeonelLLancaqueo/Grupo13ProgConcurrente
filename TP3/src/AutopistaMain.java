public class AutopistaMain {
    public static void main(String[] args) {
        EstacionServicio n = new EstacionServicio();
        Auto autoA= new Auto("001",3, 2, n);
        Auto autoB= new Auto("002",3, 2, n);
        Auto autoC= new Auto("003",3, 2, n);
        Auto autoD= new Auto("004",3, 2, n);
        Auto autoE= new Auto("005",3, 2, n);

        Thread hilo1= new Thread(autoA);
        Thread hilo2= new Thread(autoB);
        Thread hilo3= new Thread(autoC);
        Thread hilo4= new Thread(autoD);
        Thread hilo5= new Thread(autoE);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();

    }

}
