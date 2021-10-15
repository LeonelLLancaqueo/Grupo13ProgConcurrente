package LosPollosHermanos2;

public class Moso extends Thread {
    private int cantEmpleadosAtendidos;
    private Silla silla;
    public Moso(Silla silla){
        this.cantEmpleadosAtendidos= 0;
        this.silla = silla;
    }
    

    public int getCantEmpleadosAtendidos() {
        return cantEmpleadosAtendidos;
    }


    public void run() {
        try {
            while(true){
                silla.hacerPollo();
                System.out.println("El moso esta haciendo pollos nuevos");
                silla.prepararBebida(); 
                System.out.println("El mozo esta preparando la bebida: ");
                Thread.sleep((int)(Math.random()*1000));  
                System.out.println("El mozo esta sirviendo la bebida: ");
                silla.servirPedido();
                System.out.println("El moso esta saludando al Empleado: ");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
