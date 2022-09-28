package Observatorio;



public class Observatorio {

    private int visEnObs, mantEnObs, invEnObs, capacidadMax ;
    private int visEnSillaRuedasEnObs;

    public Observatorio(int capacidadMax ){
        this.capacidadMax = capacidadMax;
    }
    /* METODOS PARA ENTRAR AL OBSERVATORIO */
    public synchronized void entrarVisitante() throws InterruptedException{
        while(visEnObs >= capacidadMax || mantEnObs > 0 || invEnObs > 0){
            // si se sobrepasa la capMax o si hay alguna persona de mantenimiento o investigacion 
            this.wait();
        }
        visEnObs++;
        this.notifyAll();
    }
    
    public synchronized void entrarVisitanteSillaRuedas() throws InterruptedException{
        while(visEnObs >= capacidadMax || mantEnObs > 0 || invEnObs > 0){
            // si se sobrepasa la capMax o si hay alguna persona de mantenimiento o investigacion 
            this.wait();
        }
        visEnSillaRuedasEnObs++;
        capacidadMax= 5;
        visEnObs++;
        this.notifyAll();
    }
    
    public synchronized void entrarMantenimiento() throws InterruptedException{
        while(visEnObs > 0 || invEnObs > 0){
            this.wait();
        }
        mantEnObs++;
        this.notifyAll();
    }
    
    public synchronized void entrarInvestigador() throws InterruptedException{
        while(visEnObs > 0 || invEnObs > 0 || visEnObs > 0){
            this.wait(); 
        }
        invEnObs++;
    }

    /*  METODOS PARA SALIR DEL OBSERVATORIO */
    public synchronized void salirVisitante(){
        visEnObs--;
        this.notifyAll();
    }
    
    public synchronized void salirVisitanteSillaRuedas(){
        visEnSillaRuedasEnObs--;
        if(visEnSillaRuedasEnObs == 0){
            capacidadMax= 50;
        }
        visEnObs--;
        this.notifyAll();
    }

    public synchronized void salirMantenimiento(){
        mantEnObs--;
        this.notifyAll();
    }

    

    public synchronized void salirInvestigador(){
        invEnObs--;
        this.notifyAll();
    }
    

    

}
