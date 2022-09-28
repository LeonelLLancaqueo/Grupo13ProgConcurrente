package PlantaEmbotelladora;

public class Embotellador extends Thread{
    private PlantaEmbotelladora pEmbotelladora;

    public Embotellador(PlantaEmbotelladora pEmbotelladora) {
        this.pEmbotelladora = pEmbotelladora;
    }
    public void run() {
        try {
            while(true){
                Thread.sleep(1250);
                pEmbotelladora.embotellar();
                System.out.println("embotellando...");
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

    }
}
