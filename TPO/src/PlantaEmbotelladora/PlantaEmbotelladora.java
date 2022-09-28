package PlantaEmbotelladora;

public class PlantaEmbotelladora {
    private int topeBotellas, cantCajas, botellas;
    private boolean cajaLlena;

    public PlantaEmbotelladora(){
        this.topeBotellas= 10;

    }

    public synchronized void embotellar() throws InterruptedException{
        
        while(cajaLlena){ // si la caja esta llena
            this.wait(); //bloqueamos a el hilo que embotella
        }
        this.botellas++; //sino, embotella
        if(this.botellas == this.topeBotellas){ //cuando la cantidad de botellas embotelladas es igual al tope
            this.cajaLlena = true; //marcamos que la caja esta llena
            this.notifyAll(); 
        }
    } 
    public synchronized void empaquetar() throws InterruptedException{
        
        while(!cajaLlena){
            this.wait();
        }
        this.botellas= 0;
        this.cantCajas++;
        this.cajaLlena= false;
        this.notifyAll();
    } 

}
