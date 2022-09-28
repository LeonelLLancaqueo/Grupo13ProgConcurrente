package Trafico;

public class CocheSur extends Thread{
    private Puente puente;
    private int nro;

    public CocheSur(Puente puente, int nro){
        this.puente = puente;
        this.nro = nro;
    }

    public void run(){
        try {
            Thread.sleep((int)(Math.floor(Math.random()*(4000-2000+1)+2000)));
            puente.entrarCocheSur();
            System.out.println("El conche "+nro+" entra al puente desde el lado Sur");
            Thread.sleep((int)(Math.floor(Math.random()*(100-500+1)+500)));
            System.out.println("El conche "+nro+" sale del puente desde el lado Sur");
            puente.salirCocheDelSur();

        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
