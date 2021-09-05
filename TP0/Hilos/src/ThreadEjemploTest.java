public class ThreadEjemploTest {
    public static void main(String[] args){
        new ThreadEjemplo("maria Jose").start();
        new ThreadEjemplo("jose maria").start();
        System.out.println("termina thread main");
    }
}
