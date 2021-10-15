package LosPollosHermanos;

public class Moso extends Thread {
    private int cantEmpleadosAtendidos;
    private Comedor silla;
    public Moso(Comedor silla){
        this.cantEmpleadosAtendidos= 0;
        this.silla = silla;
    }
    

    public int getCantEmpleadosAtendidos() {
        return cantEmpleadosAtendidos;
    }


    public void run() {
        try {
            while(true){
                silla.atender();
                System.out.println("El mozo esta atendiendo: ");
                Thread.sleep((int)(Math.random()*1000));  
                System.out.println("El mozo esta sirviendo el plato: ");
                Thread.sleep((int)(Math.random()*1000));  
                silla.servirPlato();
                System.out.println("El moso esta saludando al Empleado: ");
                this.cantEmpleadosAtendidos++;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
