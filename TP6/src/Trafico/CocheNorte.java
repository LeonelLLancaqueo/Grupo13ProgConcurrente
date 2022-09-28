package Trafico;

public class CocheNorte extends Thread{
    private Puente puente;
    private int nro;

    public CocheNorte(Puente puente, int nro){
        this.puente = puente;
        this.nro = nro;
    }

    public void run(){
        try {
            Thread.sleep((int)(Math.floor(Math.random()*(4000-2000+1)+2000)));
            puente.entrarCocheNorte();
            System.out.println("El conche "+nro+" entra al puente desde el lado norte");
            Thread.sleep((int)(Math.floor(Math.random()*(1200-500+1)+500)));
            System.out.println("El conche "+nro+" sale del puente desde el lado norte");
            puente.salirCocheDelNorte();

        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }

}
