package TrenTuristico;

public class VendedorTickets extends Thread {
    private trenMejorado tren;

    public VendedorTickets(trenMejorado tren){
        this.tren = tren;
    }

    public void run(){
        try {
            while(true){
                tren.venderTicket();
            }
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }


}
