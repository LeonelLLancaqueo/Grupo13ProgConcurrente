package parcial2_Llancaqueo_2964;

public class EmbotelladorAgua extends Thread{
    private Fabrica fabrica;
    private int nro;

    public EmbotelladorAgua(Fabrica fabrica, int nro){
        this.fabrica = fabrica;
        this.nro = nro;
    }


    public void run(){
        while(true){
            try {
                //fabrica.embotellar();
                Thread.sleep(3000);
                System.out.println("El embotellador"+ nro +" de Agua embotello una botella de agua");
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
    }
}
