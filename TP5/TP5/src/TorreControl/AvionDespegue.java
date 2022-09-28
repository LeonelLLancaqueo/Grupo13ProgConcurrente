package TorreControl;

public class AvionDespegue extends Thread{
    private Pista pista;
    private int nro;
    
    public AvionDespegue(Pista pista, int nro){
        this.pista = pista;
        this.nro = nro;
    }

    public void run(){
        try {
            
            pista.solicitarDespegar();
            pista.despegar();
            System.out.println("El avion "+ nro + " despega");
            Thread.sleep(1250);
            System.out.println("El avion "+ nro + " termina de despega");
            pista.terminarUsarPista();

        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
