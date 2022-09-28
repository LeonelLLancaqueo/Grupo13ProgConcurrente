package PlantaEmbotelladora;

public class Empaquetador extends Thread{
    private PlantaEmbotelladora pEmbotelladora;

    public Empaquetador(PlantaEmbotelladora pEmbotelladora) {
        this.pEmbotelladora = pEmbotelladora;
    }
    public void run() {
        try {
            while(true){
                Thread.sleep(1250);
                pEmbotelladora.empaquetar();
                System.out.println("cambiando la caja....");
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

    }

}
