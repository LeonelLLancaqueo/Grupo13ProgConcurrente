package Trafico2;

public class CocheNorte2 extends Thread{
    private Puente2 puente;
    private int nroCoche, turno;
    private final int turnoAuto= 1;

    public CocheNorte2(Puente2 puente, int nroCoche) {
        this.puente = puente;
        this.nroCoche = nroCoche;
    }

    public void run() {
        try {
            turno= puente.entrarCoche(turnoAuto);
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
