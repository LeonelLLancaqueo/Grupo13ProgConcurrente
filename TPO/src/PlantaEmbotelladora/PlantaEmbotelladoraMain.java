package PlantaEmbotelladora;

public class PlantaEmbotelladoraMain {
    public static void main(String[] args){
        PlantaEmbotelladora pEmbotelladora= new PlantaEmbotelladora();
        Empaquetador empaquetador= new Empaquetador(pEmbotelladora);
        Embotellador embotellador= new Embotellador(pEmbotelladora);

        embotellador.start();
        empaquetador.start();
    }



}
