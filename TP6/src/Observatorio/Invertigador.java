package Observatorio;

public class Invertigador extends Thread{
    private Observatorio observatorio;
    private int nro;

    public Invertigador(Observatorio obs, int nro){
        this.observatorio = obs;
        this.nro = nro;
    }

    public void run() {
        try {
            observatorio.entrarInvestigador();
            System.out.println("el investigador " +nro+ " entro en el observatorio");
            Thread.sleep(1500);
            observatorio.salirInvestigador();
            System.out.println("el investigador " +nro+ " salio del observatorio");    

        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
