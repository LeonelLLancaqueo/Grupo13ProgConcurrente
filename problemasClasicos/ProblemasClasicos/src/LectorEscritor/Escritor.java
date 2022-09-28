package LectorEscritor;

public class Escritor extends Thread{
    private Libro libro;

    public Escritor(Libro libro){
        this.libro = libro;
    }

    public void run(){
        while(true){
            try {
                Thread.sleep((int)(Math.floor(Math.random()*(2000-1000+1)+1000)));
                libro.empezarEscribir();
                System.out.println("Escritor escribiendo....");
                Thread.sleep(1200);
                System.out.println("Escritor termino de escribir.");                
                libro.terminarEscribir();
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
    }


}
