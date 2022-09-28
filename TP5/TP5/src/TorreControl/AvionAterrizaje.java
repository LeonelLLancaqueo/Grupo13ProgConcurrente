package TorreControl;

public class AvionAterrizaje extends Thread{
    private Pista pista;
    private int nro;

    public AvionAterrizaje(Pista pista, int nro){
        this.pista = pista;
        this.nro = nro;
    }

    public void run(){
        try {
            pista.solicitarAterrizar();
            pista.aterrizar();
            System.out.println("El avion "+ nro + " esta aterrizando");
            Thread.sleep(1250);
            System.out.println("El avion "+ nro + " termina de aterrizar");
            pista.terminarUsarPista();

        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
