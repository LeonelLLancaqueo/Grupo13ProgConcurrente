package CuartelSoldados;

public class SoldadoA extends Thread{
    private Comedor comedor;
    private int nro;

    public SoldadoA(Comedor comedor, int nro){
        this.comedor = comedor;
        this.nro = nro;
    }

    public void run() {
        
        //while(true){
            try {
                comedor.solicitarEntrar();
                System.out.println("el soldado "+ nro+" entra en el comedor");
                comedor.solicitarBandeja();
                comedor.tomarBandeja();
                System.out.println("el soldado "+ nro+" toma la bandeja");
                comedor.comer();
                Thread.sleep((int)(Math.floor(Math.random()*(2000-1000+1)+1000)));
                comedor.dejarBandeja();
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }

        //}   
    }
}
