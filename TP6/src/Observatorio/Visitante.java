package Observatorio;

public class Visitante extends Thread {
    private Observatorio observatorio;
    private int nro;

    public Visitante(Observatorio obs, int nro){
        this.observatorio = obs;
        this.nro = nro;
    }

    public void run() {
        try {
            observatorio.entrarVisitante();
            System.out.println("el visitante " +nro+ " entro en el observatorio");
            Thread.sleep(1500);
            observatorio.salirVisitante();
            System.out.println("el visitante " +nro+ " salio del observatorio");    

        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
