
package EjercicioTaxista;
public class Taxista extends Thread {
    private Taxi taxi;
    private int cantClientes; 

    public Taxista(Taxi taxi, int cantClientes){
        this.taxi= taxi; 
        this.cantClientes= cantClientes;
    }

    public void run(){
    try {
        // A MENOS DE QUE ESTE EXPLICITO EN EL ENUNCIADO 
        int i=1;
        while(i <= cantClientes){
            taxi.realizarViaje();
            Thread.sleep((int)(Math.random()*1000));        
            taxi.avisarTerminoViaje();
            i++;
        }
            
    }catch (InterruptedException e) {
        System.out.println(e.getMessage());
        }
    }
}



