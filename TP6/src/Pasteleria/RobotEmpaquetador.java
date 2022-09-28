package Pasteleria;

public class RobotEmpaquetador extends Thread{
    private int nro; 
    private Mostrador mostrador;

    public RobotEmpaquetador(Mostrador mostrador, int nro) {
        this.mostrador= mostrador;
        this.nro= nro;
    }
    public void run(){
        int pesoPaquete;
        while(true){
            try {
                pesoPaquete= mostrador.tomarPastel();
                System.out.println("El robot empaquetador " +nro+ " esta tomando un pastel " );
                Thread.sleep(1500);
                mostrador.soltarPastel(pesoPaquete);
                System.out.println("El robot empaquetador " +nro+ " solo el pastel en la caja" );
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }
        }
    }
}
