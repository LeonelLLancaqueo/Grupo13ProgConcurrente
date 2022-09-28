package CentroHemoterapia;

public class Donante extends Thread{
    private CentroHemoterapia2 centro;
    private int preferenciaEspera, nro;

    public Donante(CentroHemoterapia2 centro, int preferenciaEspera, int nro){
        this.centro = centro;
        this.nro= nro;
    }

    public void run(){
        try {
            centro.donarSangre(preferenciaEspera);
            System.out.println("el donante "+nro+" esta donando sangre...");
            Thread.sleep(5000);
            System.out.println("el donante "+nro+" esta termino de sangre...");
            Thread.sleep(1000);
            centro.salirCentro();
            System.out.println("el donante "+nro+" salio del centro...");
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

    }

}
