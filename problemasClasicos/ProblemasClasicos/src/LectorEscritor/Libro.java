package LectorEscritor;

public class Libro {
    
    private int cantLectores, cantPaginas, totalPaginas;
    private boolean hayEscritor, libroLleno; 

    public Libro(int totalPaginas){
        this.totalPaginas = totalPaginas;
    }
    public synchronized void empezarLeer() throws InterruptedException{
        while(hayEscritor || cantPaginas <= 0){
            this.wait();
        }
        cantLectores++;
        this.notifyAll();
    }

    public synchronized void terminarLeer(){
        cantLectores--;
        this.notifyAll();
    }

    public synchronized void empezarEscribir() throws InterruptedException{
        while(cantLectores > 0 || libroLleno || hayEscritor){
            this.wait();
        }
        hayEscritor= true;
    }

    public synchronized void terminarEscribir(){
        cantPaginas++;
        if(cantPaginas == totalPaginas){
            libroLleno= true;
            System.out.println("Libro lleno");
        }
        hayEscritor= false;
        this.notifyAll();
    }



}
