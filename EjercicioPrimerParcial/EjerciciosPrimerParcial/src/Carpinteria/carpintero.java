package Carpinteria;

public class carpintero extends Thread{
    private carpinteria carpinteria;
    private int nro, tipoPieza;

    public carpintero(carpinteria carpinteria, int tipoPieza, int nro) {
        this.carpinteria= carpinteria;
        this.nro= nro;
        this.tipoPieza= tipoPieza;
    }
    public void run() {
        while (true) {
            try {
                carpinteria.armarPieza(tipoPieza);
                System.out.println("El carpintero "+nro+" esta armando una pieza tipo "+tipoPieza);
                Thread.sleep(3000);
                System.out.println("El carpintero "+nro+" termino de armar una pieza tipo "+tipoPieza);
                carpinteria.terminarPieza(tipoPieza);
                
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
    }

}
