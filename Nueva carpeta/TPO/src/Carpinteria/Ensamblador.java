package Carpinteria;

public class Ensamblador extends Thread{
    private Carpinteria carpinteria;
    private int nro;

    public Ensamblador(Carpinteria carpinteria, int nro){
        this.carpinteria = carpinteria;
        this.nro = nro;
    }

    public void run(){
        while(true){
            try {
                carpinteria.tomarPiezas();
                System.out.println("Ensamblador "+nro+ " tomo piezas");
                carpinteria.ensamblarMueble();
                System.out.println("Entro ensamblador "+nro+ " a ensamblar mueble");
                Thread.sleep(2000);
                System.out.println("termino ensamblador "+nro+ " de ensamblar mueble");
                carpinteria.terminarMueble();
                
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }

        }
    }
}
