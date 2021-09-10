public class Vehiculo {
    private int kmsFaltante, cantvueltasRestantes;
    private String patente;
    private EstacionServicio estacion;
    

    public Vehiculo(String patente, int kmsFaltante, int cantvueltas, EstacionServicio estacion) {
        this.patente = patente;
        this.kmsFaltante = kmsFaltante;
        this.cantvueltasRestantes = cantvueltas;
        this.estacion= estacion;
    }

    public void andar() throws InterruptedException{
        
        while(this.cantvueltasRestantes > 0){
            this.cantvueltasRestantes--;
            System.out.println("vehiculo "+ this.patente + "dando vuelta: " + this.cantvueltasRestantes);
            while(kmsFaltante >= 0){
                System.out.println("vehiculo "+ this.patente+" andando....");
                kmsFaltante--;
            }
            this.kmsFaltante= estacion.recargar();
        }
    }
}
