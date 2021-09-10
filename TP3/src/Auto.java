public class Auto extends Vehiculo implements Runnable{
    
    public Auto(String patente, int kmsFaltante, int cantvueltas, EstacionServicio n){
        super( patente, kmsFaltante, cantvueltas, n);
    }
    public void run() {
        try {
            super.andar();
        } catch (Exception e) {
            System.out.println("Error");
        }
        
    }
}
