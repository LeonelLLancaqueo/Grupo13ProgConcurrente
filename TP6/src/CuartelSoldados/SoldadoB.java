package CuartelSoldados;

public class SoldadoB extends Thread{
    private Comedor comedor;
    private int nro;

    public SoldadoB(Comedor comedor, int nro){
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
                comedor.solicitarAbridor();
                System.out.println("el soldado "+ nro+" toma el abridor de botellas");
                Thread.sleep((int)(Math.floor(Math.random()*(500-0+1)+0)));
                comedor.terminarUsarAbridor();
                System.out.println("el soldado "+ nro+" termina de usar el abridor de botellas");
                comedor.comer();
                Thread.sleep((int)(Math.floor(Math.random()*(2000-1000+1)+1000)));
                System.out.println("el soldado "+ nro+" deja la bandeja");
                comedor.dejarBandeja();
                
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }

        //}   
    }
}
