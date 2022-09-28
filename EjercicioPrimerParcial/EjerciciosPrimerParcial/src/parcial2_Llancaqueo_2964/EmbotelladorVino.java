package parcial2_Llancaqueo_2964;



public class EmbotelladorVino extends Thread{
    private Fabrica fabrica;
    private int nro;

    public EmbotelladorVino(Fabrica fabrica, int nro){
        this.fabrica = fabrica;
        this.nro = nro;
    }


    public void run(){
        while(true){
            try {
                //fabrica.embotellarVino();
                Thread.sleep(3000);
                System.out.println("El embotellador "+ nro +" de Vino embotello una botella de vino");
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
    }
}
