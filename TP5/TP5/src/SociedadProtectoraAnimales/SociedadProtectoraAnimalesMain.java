package SociedadProtectoraAnimales;

public class SociedadProtectoraAnimalesMain {
    public static void main(String[] args) {
        Comedero comederoAnimales = new Comedero(4);
        Perro []arrPerro= new Perro[10];
        Gato []arrGato= new Gato[10];

        for(int i=0; i< arrPerro.length; i++){
            arrPerro[i]= new Perro(0, comederoAnimales, i);
        }
        for(int i=0; i< arrGato.length; i++){
            arrGato[i]= new Gato(1, comederoAnimales, i);
        }

        for(int i=0; i< arrPerro.length; i++){
            arrPerro[i].start();
        }
        for(int i=0; i< arrGato.length; i++){
            arrGato[i].start();
        }


        try {
            for(int i=0; i< arrPerro.length; i++){
                arrPerro[i].join();
            }
            for(int i=0; i< arrPerro.length; i++){
                arrGato[i].join();
            }
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
