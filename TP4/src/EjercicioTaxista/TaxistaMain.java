package EjercicioTaxista;

public class TaxistaMain {
    
    public static void main(String[] args){
        Taxi taxi= new Taxi();
        ClienteTaxi [] arr= new ClienteTaxi[5];
        for(int i=0; i<= 4; i++) {
            arr[i]= new ClienteTaxi(taxi, i);
        }
        Taxista taxista= new Taxista(taxi, arr.length);

        taxista.start();
        for(int i=0; i<= 4; i++) {
            arr[i].start();
        }
        

    }
}
