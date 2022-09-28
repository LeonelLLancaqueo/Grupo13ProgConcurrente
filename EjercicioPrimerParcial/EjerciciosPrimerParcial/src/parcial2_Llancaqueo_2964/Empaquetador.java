package parcial2_Llancaqueo_2964;

public class Empaquetador extends Thread{
    private Fabrica fabrica;

    public Empaquetador(Fabrica fabrica){
        this.fabrica = fabrica;
    }

    public void run(){
        while(true){
            try {
                fabrica.empaquetar();
                System.out.println("El empaquetador empaqueto una caja ");
                Thread.sleep(3000);
                fabrica.reponerCaja();
                System.out.println("El empaquetador repuso una caja");
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
    }
}
