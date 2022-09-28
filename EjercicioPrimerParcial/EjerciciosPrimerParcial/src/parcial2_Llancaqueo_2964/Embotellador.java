package parcial2_Llancaqueo_2964;

public class Embotellador extends Thread{
    private Fabrica fabrica;
    private int nro, tipoBebida;


    public Embotellador(Fabrica fabrica, int nro, int tipoBebida){
        this.fabrica = fabrica;
        this.nro = nro;
        this.tipoBebida= tipoBebida;
    }


    public void run(){
        while(true){
            try {
                fabrica.embotellar(tipoBebida);
                Thread.sleep(3000);
                System.out.println("El embotellador"+ nro +" de Agua embotello una botella de "+ tipoBebida);
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
    }
}
