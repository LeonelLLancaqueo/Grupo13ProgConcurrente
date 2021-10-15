package LosPollosHermanos;

public class LosPollosHermanosMain {
    public static void main(String[] args) {
        Comedor silla= new Comedor();
        Moso moso= new Moso(silla);
        Empleado arr[]= new Empleado[5];
        for(int i=0; i <= 4; i++) {
            arr[i]= new Empleado(silla, i);
        }
        moso.start();
        for(int i=0; i <= 4; i++) {
            arr[i].start();
        }
        try {
            for(int i=0; i <= 4; i++) {
                arr[i].join();
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }
        System.out.println("cant de empleados atendidos por el moso: " + moso.getCantEmpleadosAtendidos());

    }
}
