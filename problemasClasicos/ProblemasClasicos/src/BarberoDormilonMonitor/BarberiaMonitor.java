package BarberoDormilonMonitor;

public class BarberiaMonitor {
    //private int sillasDisponibles;
    private boolean sillaOcupada, terminoCortar, salio;
    private int sillasDisponibles, cantSillas;
    public BarberiaMonitor(int sillasDisponibles){
        this.sillasDisponibles= sillasDisponibles;
        this.cantSillas= sillasDisponibles;
    }

    public synchronized void esperarCliente() throws InterruptedException {
        while(!sillaOcupada){ //si no hay nadie en la silla
            this.wait(); //bloqueamos al barbero
        }
    }
    //hacer un notifyall y que lo agarre el barbero nomas
    
    public synchronized boolean solicitarSillon() {
        boolean exito= false; 
        if(!sillaOcupada && sillasDisponibles == cantSillas){
            sillaOcupada= true;
            exito=true;
        }    
        return exito;
    }
    public synchronized void solicitarSilla() throws InterruptedException {
        while(this.sillasDisponibles <= 0){ //si ya no quedan sillas disponibles
            this.wait(); // bloqueamos al hilo
        }
        this.sillasDisponibles--; // si hay sillas disponibles ocupamos una
        System.out.println("Sillas disponibles: "+ this.sillasDisponibles);
        while(sillaOcupada){ //si la silla esta ocupada entonces 
            this.wait(); // bloqueamos al hilo
        }
        this.sillasDisponibles++;
        System.out.println("Sillas disponibles: "+ this.sillasDisponibles);
        sillaOcupada= true; //marcamos  a silla como ocupada  

    }

    public synchronized void solicitarCorte() throws InterruptedException{
        this.notifyAll();
    }

    public synchronized void terminarAtencion() throws InterruptedException{
        this.terminoCortar= true;
        this.notifyAll();
    }

    public synchronized void salir() throws InterruptedException{
        while(!terminoCortar){ //mientras no tenga exito la accion realiza un wait()
            this.wait();
        }
        this.sillaOcupada= false;
        this.salio= true;
        this.terminoCortar= false;
        notifyAll();
    }
    public synchronized void barrerPiso() throws InterruptedException{
        while(!salio){
            this.wait();
        }
        salio=false;
    }

}
