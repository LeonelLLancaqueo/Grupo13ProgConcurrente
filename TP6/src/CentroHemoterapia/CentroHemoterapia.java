package CentroHemoterapia;
import java.util.concurrent.Semaphore;



public class CentroHemoterapia {
    private Semaphore mutexDonante, mutexOrdLlegada;
    private Semaphore esperarParado, mutexEsperarParado, silla, revista;
    private int camillas, revistas, turno, ordenLlegada;
    private int esperarParadoCont;
    
    public CentroHemoterapia(){
        camillas= 4;
        
        revista= new Semaphore(9,true);
        silla = new Semaphore(5, true);
        esperarParado = new Semaphore(5, true);
        mutexEsperarParado = new Semaphore(1, true);
        mutexDonante = new Semaphore(1, true);
        mutexOrdLlegada = new Semaphore(1, true);

    }

    public int entrarCentro() throws InterruptedException{
        mutexOrdLlegada.acquire();
        
        int turnoDonante= ordenLlegada;
        ordenLlegada++; 
        
        mutexOrdLlegada.release();
        return turnoDonante;
    }

    public boolean donarSangre(int turnoDonante) throws InterruptedException{
        mutexDonante.acquire();
        boolean exito= false;
        if(turno == turnoDonante && camillas > 0){
            exito= true;
            camillas--;
            turno++; 
        } 
        mutexDonante.release();
        return exito;
    }

    public void terminarDonarSangre() throws InterruptedException{
        mutexDonante.acquire();
        /* tendria q despertar a todo el conjunto de espera */
            camillas++;
        mutexDonante.release();
    }



    public boolean tomarSilla() throws InterruptedException{   
        return silla.tryAcquire(); //el donante trata de tomar una silla
    }
    public void esperarParado() throws InterruptedException{
        
    }
    public boolean tomarRevista() throws InterruptedException{
        return revista.tryAcquire(); //
    }
    public void dejarRevista() throws InterruptedException{
        revista.release(); //
    }

    public void dejarSilla() throws InterruptedException{

    }
    
    /* SON ATENDIDOS POR ORDEN DE LLEGADA */

}
