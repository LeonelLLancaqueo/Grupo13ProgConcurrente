package parcial2_Llancaqueo_2964;

public class RelojMadurador extends Thread{
    private Fabrica fabrica;
    
    public RelojMadurador(Fabrica fabrica){
        this.fabrica = fabrica;
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
                fabrica.actualizarHora();
                System.out.println("paso una hora en l fabrica");
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
        /*
        java.lang.ClassCastException: class parcial2_Llancaqueo_2964.Caja cannot be cast to 
        class parcial2_Llancaqueo_2964.CajaVino (parcial2_Llancaqueo_2964.Caja and parcial2_Llancaqueo_2964.CajaVino are in unnamed module of loader 'app')
        at parcial2_Llancaqueo_2964.Fabrica.madurarVino(Fabrica.java:155)
        at parcial2_Llancaqueo_2964.RelojMadurador.run(RelojMadurador.java:14)
        */
    }

}
