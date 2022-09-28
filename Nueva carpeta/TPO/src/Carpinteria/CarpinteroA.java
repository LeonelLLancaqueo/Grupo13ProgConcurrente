package Carpinteria;

public class CarpinteroA extends Thread{
    private Carpinteria carpinteria;
    private int nro;

    public CarpinteroA(Carpinteria carpinteria, int nro){
        this.carpinteria = carpinteria;
        this.nro = nro;
    }

    public void run(){
        while(true){
            try {
                carpinteria.armarPiezaA();
                System.out.println("carpinteroA "+nro+ " esta armando una pieza");
                Thread.sleep(2000);
                System.out.println("carpinteroA "+nro+ " termino de armar una pieza");
                carpinteria.terminarArmarPiezaA();
                System.out.println("carpinteroA "+nro+ " esta entregando la pieza y espera");
                carpinteria.entregarPiezaA();
                System.out.println("carpinteroA "+nro+ " vuelve a seguir armando");
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }

        }
    }
}
