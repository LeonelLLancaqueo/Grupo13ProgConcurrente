package Trafico2;

public class CocheGeneral extends Thread{
    private Puente2 puente;
    private int nroCoche, turno, turnoCoche;

    public CocheGeneral(Puente2 puente, int nroCoche, int turnoCoche) {
        this.puente = puente;
        this.nroCoche = nroCoche; 
        this.turnoCoche = turnoCoche; //si es coche norte o sur
    }

    public void run() {
        try {
            turno= puente.entrarCoche(turnoCoche);
            System.out.println("El coche nro "+nroCoche+" con el turno "+turno+" entro en el puente");
            Thread.sleep(5000);
            puente.salirCoche(turnoCoche, turno);
            System.out.println("El coche "+nroCoche+" con el turno "+turno+" salio del puente");
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
