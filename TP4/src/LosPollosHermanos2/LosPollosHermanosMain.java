package LosPollosHermanos2;

public class LosPollosHermanosMain {
    public static void main(String[] args) {
        Silla silla= new Silla();
        Moso moso= new Moso(silla);
        Cocinero cocinero= new Cocinero(silla);
        Empleado arr[]= new Empleado[5];
        EmpleadoComedor arrComedor[]= new EmpleadoComedor[5];
        EmpleadoTomador arrTomador[]= new EmpleadoTomador[5];
        for(int i=0; i <= 4; i++) {
            arr[i]= new Empleado(silla, i);
            arrComedor[i]= new EmpleadoComedor(silla, i+5);
            arrTomador[i]= new EmpleadoTomador(silla, i+10);
        }
        moso.start();
        cocinero.start();
        for(int i=0; i <= 4; i++) {
            arr[i].start();
            arrComedor[i].start();
            arrTomador[i].start();
        }

        try {
            for(int i=0; i <= 4; i++) {
                arr[i].join();
                arrComedor[i].join();
                arrTomador[i].join();
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }
        System.out.println("cant de empleados atendidos por el moso: " + moso.getCantEmpleadosAtendidos());

    }
}
