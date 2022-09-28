package Observatorio;

public class VisitanteSillaRuedas extends Thread{
    private Observatorio observatorio;
    private int nro;

    public VisitanteSillaRuedas(Observatorio obs, int nro){
        this.observatorio = obs;
        this.nro = nro;
    }

    public void run() {
        try {
            observatorio.entrarVisitanteSillaRuedas();
            System.out.println("el visitante en silla de ruedas " +nro+ " entro en el observatorio");
            Thread.sleep(1500);
            observatorio.salirVisitanteSillaRuedas();
            System.out.println("el visitante en silla de ruedas " +nro+ " salio del observatorio");    

        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
