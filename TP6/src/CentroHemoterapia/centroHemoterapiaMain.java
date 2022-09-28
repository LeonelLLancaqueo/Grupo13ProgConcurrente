package CentroHemoterapia;
import java.util.Random;
public class centroHemoterapiaMain {
    public static void main(String[] args){
        Random r = new Random();
        CentroHemoterapia2 centro= new CentroHemoterapia2();
        Donante []arrDonante= new Donante[15];

        for(int i=0; i< arrDonante.length; i++){
            
            arrDonante[i]= new Donante(centro, r.nextInt(2), i);
            
        }
        for(int i=0; i< arrDonante.length; i++){
            arrDonante[i].start();
            
        }

    }
}
