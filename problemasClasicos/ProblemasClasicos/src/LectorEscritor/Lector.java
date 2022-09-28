package LectorEscritor;

public class Lector extends Thread{
    private Libro libro;

    public Lector(Libro libro){
        this.libro = libro;
    }

    public void run(){
        while(true){
            try {

                Thread.sleep((int)(Math.floor(Math.random()*(2000-1000+1)+1000)));
                libro.empezarLeer();
                System.out.println("Lector empezo a leer....");
                Thread.sleep(1200);
                System.out.println("Lector termino de leer");
                libro.terminarLeer();
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
    }
}
