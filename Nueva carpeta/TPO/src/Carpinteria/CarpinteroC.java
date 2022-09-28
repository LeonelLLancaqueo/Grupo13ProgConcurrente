package Carpinteria;

public class CarpinteroC extends Thread{
    private Carpinteria carpinteria;
    private int nro;

    public CarpinteroC(Carpinteria carpinteria, int nro){
        this.carpinteria = carpinteria;
        this.nro = nro;
    }

    public void run(){
        while(true){
            try {
                carpinteria.armarPiezaC();
                System.out.println("carpinteroC "+nro+ " esta armando una pieza");
                Thread.sleep(2000);
                System.out.println("carpinteroC "+nro+ " termino de armar una pieza");
                carpinteria.terminarArmarPiezaC();
                System.out.println("carpinteroC "+nro+ " esta entregando la pieza y espera");
                carpinteria.entregarPiezaC();
                System.out.println("carpinteroC "+nro+ " vuelve a seguir armando");
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }

        }
    }
}
