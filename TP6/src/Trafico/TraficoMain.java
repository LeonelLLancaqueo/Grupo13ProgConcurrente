package Trafico;

public class TraficoMain {
    public static void main(String[] args) {
        Puente puente= new Puente();
        CocheNorte []arrCocheNorte= new CocheNorte[30];
        CocheSur []arrCocheSur= new CocheSur[30];

        for (int i=0; i<arrCocheNorte.length; i++){
            arrCocheNorte[i]=new CocheNorte(puente, i);
        }
        for (int i=0; i<arrCocheSur.length; i++){
            arrCocheSur[i]=new CocheSur(puente, i);
        }
        /*
        for (int i=0; i<arrCocheNorte.length; i++){
            arrCocheNorte[i].start();
        }*/
        for (int i=0; i<arrCocheSur.length; i++){
            arrCocheSur[i].start();
        }
        /*
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
        */
        
        arrCocheNorte[1].start();
    }
}
