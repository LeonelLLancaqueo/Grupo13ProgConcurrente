package LosToboganes;

public class Visitante extends Thread{
    private Tobogan tobogan;
    private int nro;

    public Visitante(Tobogan tobogan, int nro){
        this.tobogan = tobogan;
        this.nro = nro;
    }

    public void run(){
        //while(true){
            try {
                tobogan.accederEscalera();
                System.out.println("El visitante "+nro+" accedio a la escalera");
                System.out.println("El visitante "+nro+" contempla la naturaleza");
                Thread.sleep(5000);
                tobogan.solicitarTobogan();
                System.out.println("El visitante "+nro+" solicita el tobogan");
                tobogan.tomarTobogan();
                System.out.println("El visitante "+nro+" tomo un tobogan");
                Thread.sleep(1500);
                System.out.println("El visitante "+nro+" dejo el tobogan");
                tobogan.dejarTobogan();
                
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        //}
    }
}
