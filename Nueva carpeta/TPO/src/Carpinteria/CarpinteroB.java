package Carpinteria;

public class CarpinteroB extends Thread{
    private Carpinteria carpinteria;
    private int nro;

    public CarpinteroB(Carpinteria carpinteria, int nro){
        this.carpinteria = carpinteria;
        this.nro = nro;
    }

    public void run(){
        while(true){
            try {
                carpinteria.armarPiezaB();
                System.out.println("carpinteroB "+nro+ " esta armando una pieza");
                Thread.sleep(2000);
                System.out.println("carpinteroB "+nro+ " termino de armar una pieza");
                carpinteria.terminarArmarPiezaB();
                System.out.println("carpinteroB "+nro+ " esta entregando la pieza y espera");
                carpinteria.entregarPiezaB();
                System.out.println("carpinteroB "+nro+ " vuelve a seguir armando");
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }

        }
    }
}
