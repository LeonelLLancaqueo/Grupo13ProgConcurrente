package EjercicioTaxista;
public class ClienteTaxi extends Thread {
    private Taxi taxi;
    private int nroCliente;

    public ClienteTaxi(Taxi taxi, int nroCliente) {
        this.taxi= taxi;
        this.nroCliente= nroCliente;
    }


    public void run(){
        try {
            Thread.sleep((int)(Math.random() * 1000));
            taxi.tomarTaxi(nroCliente);
            Thread.sleep((int)(Math.random() * 1000));
            taxi.bajarDelTaxi(nroCliente);

        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        

    }
}
