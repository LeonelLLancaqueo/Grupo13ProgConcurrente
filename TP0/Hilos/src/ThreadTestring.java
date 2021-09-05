public class ThreadTestring {
    public static void main(String[] args){
        Thread miHilo= new MiEjecucion();
        miHilo.start();
        System.out.println("en el main");
    }
}
