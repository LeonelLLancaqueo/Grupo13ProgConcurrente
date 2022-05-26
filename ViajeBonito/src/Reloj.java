public class Reloj extends Thread{
    private Aeropuerto aeropuerto;
    
    public Reloj(Aeropuerto aeropuerto){
        this.aeropuerto = aeropuerto;
    }
    public void run() {
        while(true){
            try {
                Thread.sleep(10000);
                aeropuerto.reloj();
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }
        }
       
        
    }
}
