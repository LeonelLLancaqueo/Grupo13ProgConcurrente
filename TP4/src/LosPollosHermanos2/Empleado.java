package LosPollosHermanos2;

public class Empleado extends Thread{
    private int numEmpleado;
    private Silla silla;

    public Empleado(Silla silla, int numEmpleado) {
        this.silla = silla;
        this.numEmpleado = numEmpleado;
    }

    public void run() {
        try {
            Thread.sleep((int)(Math.random()*1000));  
            silla.sentarseSilla();
            System.out.println("El Empleado: "+ numEmpleado+ " esta sentado en la silla");
            silla.pedirBebida();
            System.out.println("El Empleado: "+ numEmpleado+ " esta pidiendo bebida");
            silla.pedirComida();
            System.out.println("El Empleado: "+ numEmpleado+ " esta pidiendo comida");
            silla.comer();
            System.out.println("El Empleado: "+ numEmpleado+ " esta comiendo");
            Thread.sleep((int)(Math.random()*1000)); 
            System.out.println("El Empleado: "+ numEmpleado+ " esta dejando la silla");
            silla.dejarSilla();
            
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

    }
}
