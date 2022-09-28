package LosToboganes;

public class LosToboganesMain {
    public static void main(String[] args){
        Tobogan tobogan= new Tobogan(8); //PQ PASAN MAS DE 8
        Encargado encargado= new Encargado(tobogan);

        Visitante []arrVisitantes= new Visitante[15];

        for(int i=0; i<arrVisitantes.length; i++){
            arrVisitantes[i]=new Visitante(tobogan, i);
        }
        encargado.start();
        
        for(int i=0; i<arrVisitantes.length; i++){
            arrVisitantes[i].start();
        }
    }
}
