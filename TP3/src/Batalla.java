public class Batalla {
    public static void main(String[] args) {
        Guerrero g= new Guerrero();
        Orco o= new Orco(g);
        Curandero c= new Curandero(g);

        Thread t= new Thread(o, "orco");
        Thread p= new Thread(c, "curandero");

        t.start();
        p.start();    
    }
}
