package LosPollosHermanos;

public class Empleado extends Thread{
    private int numEmpleado;
    private Comedor silla;

    public Empleado(Comedor silla, int numEmpleado) {
        this.silla = silla;
        this.numEmpleado = numEmpleado;
    }

    public void run() {
        try {
            Thread.sleep((int)(Math.random()*1000));  
            if(silla.sentarseSilla()){
                System.out.println("El Empleado: "+ numEmpleado+ " esta sentado en la silla");
                silla.pedirComida();
                System.out.println("El Empleado: "+ numEmpleado+ " esta pidiendo comida");
                silla.comer();
                System.out.println("El Empleado: "+ numEmpleado+ " esta comiendo");
                Thread.sleep((int)(Math.random()*1000)); 
                System.out.println("El Empleado: "+ numEmpleado+ " esta dejando la silla");
                silla.dejarSilla();
            }
            
            
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }

    }
}
