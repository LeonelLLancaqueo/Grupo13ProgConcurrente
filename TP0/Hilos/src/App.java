public class App {
    public static void main(String[] args){       
        // 2 objetos definen los métodos run
        pruebaHilos o1=new pruebaHilos("PING",10);
        pruebaHilos o2= new pruebaHilos("PONG",11);
        // Se crean los hilos
        Thread t1 = new Thread (o1);
        Thread t2 = new Thread (o2);
        // se activan los hilos
        t1.start();
        t2.start();                   
    }
}
