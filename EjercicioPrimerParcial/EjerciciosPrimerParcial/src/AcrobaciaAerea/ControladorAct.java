package AcrobaciaAerea;

public class ControladorAct extends Thread{
    private Salon salon;
    private int nro, primeraAct, segundaAct;


    public ControladorAct(Salon salon){
        this.salon= salon;
    }

    public void run(){
        while(true){
            try {
                salon.liberarPermisos();
                salon.liberarCupos();
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
    }
}
