package parcial2_Llancaqueo_2964;

public class mainFabrica {
    public static void main(String[] args){
        Fabrica fabrica= new Fabrica();
        int vino=0, agua=1;
        
        Embotellador []arrEmbVino= new Embotellador[2];
        Embotellador []arrEmbAgua= new Embotellador[2];
        Empaquetador empaquetador= new Empaquetador(fabrica);
        Repartidor repartidor = new Repartidor(fabrica);
        RelojMadurador relojMadurador= new RelojMadurador(fabrica);
        for(int i=0; i<arrEmbVino.length; i++){
            arrEmbVino[i]= new Embotellador(fabrica, i, agua);
        }
        for(int i=0; i<arrEmbAgua.length; i++){
            arrEmbAgua[i]= new Embotellador(fabrica, i, vino);
        }

        empaquetador.start();
        repartidor.start();
        relojMadurador.start();
        for(int i=0; i<arrEmbVino.length; i++){
            arrEmbVino[i].start();
        }
        for(int i=0; i<arrEmbAgua.length; i++){
            arrEmbAgua[i].start();
        }

    }
}
