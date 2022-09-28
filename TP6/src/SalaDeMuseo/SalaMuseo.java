package SalaDeMuseo;

public class SalaMuseo {
    private int personasEnSala, jubEsperando, personasPermitidas, temperaturaActual;


    public SalaMuseo(int temp){    
        this.temperaturaActual= temp;
        this.recalcularPersonasPermitidas();
    }
    /*
        CONSULTAS: 
        la temperatura como se regula
        cada cuanto el hilo controTemperatura notifica
        cual es la funcion del parametro int temperatura viene del hilo ?
        

    */
    private synchronized void recalcularPersonasPermitidas(){
        if(temperaturaActual > 30){
            personasPermitidas= 35;
        }else{
            personasPermitidas= 50;
        }
    }   
    
    public synchronized void entrarSala() throws InterruptedException{
        while(personasEnSala >= personasPermitidas && jubEsperando > 0){
            this.wait();
        }
        personasEnSala++;
        this.notifyAll();
    }

    public synchronized void entrarSalaJubilado() throws InterruptedException{
        jubEsperando++;
        while(personasEnSala >= personasPermitidas){ 
            this.wait();
        }
        if(jubEsperando > 0){
            jubEsperando--;
        }
        personasEnSala++;
        this.notifyAll();
    }

    public synchronized void notificarTemperatura(int temperatura) throws InterruptedException{
        // control temperatura hace un random y lo asigna
        temperaturaActual= temperatura;
        recalcularPersonasPermitidas();
        this.notifyAll();
    }

    public synchronized void salirSala() throws InterruptedException{
        personasEnSala--;
        this.notifyAll();
    }

}
