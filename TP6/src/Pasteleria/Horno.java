package Pasteleria;

public class Horno extends Thread{
    private int pesoPastel, nro;
    private Mostrador mostrador;

    public Horno(Mostrador mostrador, int pesoPastel, int nro) {
        this.pesoPastel = pesoPastel;
        this.mostrador= mostrador;
        this.nro= nro;
        
    }
    public void run(){
        while(true){
            try {
                mostrador.hornearPastel(pesoPastel);
                System.out.println("El horno " +nro+ " esta horneado un pastel" );
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }
        }
    }

}
