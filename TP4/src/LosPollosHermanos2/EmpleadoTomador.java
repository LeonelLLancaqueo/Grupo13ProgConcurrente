package LosPollosHermanos2;

public class EmpleadoTomador extends Thread{
    private int numEmpleado;
    private Silla silla;

    public EmpleadoTomador(Silla silla, int numEmpleado) {
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
            silla.comer();
            System.out.println("El Empleado: "+ numEmpleado+ " esta bebiendo su bebida");
            Thread.sleep((int)(Math.random()*1000)); 
            System.out.println("El Empleado: "+ numEmpleado+ " esta dejando la silla");
            silla.dejarSilla();
            
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

    }    
}
