package LectorEscritor;

public class LectorEscritorMain {
    public static void main(String[] args){
        Libro libro= new Libro(10);
        
        Lector []arrLector= new Lector[5];
        Escritor []arrEscritor= new Escritor[2];

        for(int i=0; i< arrLector.length; i++){
            arrLector[i]= new Lector(libro);
        }
        for(int i=0; i< arrEscritor.length; i++){
            arrEscritor[i]= new Escritor(libro);
        }

        for(int i=0; i< arrLector.length; i++){
            arrLector[i].start();
        }
        for(int i=0; i< arrEscritor.length; i++){
            arrEscritor[i].start();
        }
    }
}
