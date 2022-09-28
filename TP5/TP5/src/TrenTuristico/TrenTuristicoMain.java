package TrenTuristico;

public class TrenTuristicoMain {

    public static void main(String[] args){
        trenMejorado tren= new trenMejorado(15);
        VendedorTickets vendedorTicket= new VendedorTickets(tren);
        ControlTren controlTren= new ControlTren(tren);
        Pasajero arrPasajero[]= new Pasajero[90];

        for(int i=0; i < arrPasajero.length; i++){
            arrPasajero[i]= new Pasajero(tren, i);
        }
        vendedorTicket.start();
        controlTren.start();
        for(int i=0; i < arrPasajero.length; i++){
            arrPasajero[i].start();
        }
        


    }

}
