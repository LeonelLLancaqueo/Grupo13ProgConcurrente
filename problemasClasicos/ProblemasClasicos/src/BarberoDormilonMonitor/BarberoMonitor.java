package BarberoDormilonMonitor;
public class BarberoMonitor extends Thread {
    
    private BarberiaMonitor barberia;
    private String nombre;
    private int clientesAtendidos;

    public BarberoMonitor(BarberiaMonitor barberia, String nombre){
        this.barberia= barberia; 
        this.nombre= nombre;
        this.clientesAtendidos= 0;
    }
    
    
    

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }

    public void setClientesAtendidos(int clientesAtendidos) {
        this.clientesAtendidos = clientesAtendidos;
    }



    public void run(){
        try {
            while(true){
                System.out.println("El barbero: "+ nombre + " esta esperando a un cliente");
                barberia.esperarCliente();
                System.out.println("El barbero: "+ nombre + " esta cortandole el pelo al cliente");
                Thread.sleep((int)(Math.random() * 1000));
                System.out.println("El barbero: "+ nombre + " termino de cortale el pelo al cliente");
                barberia.terminarAtencion();
                System.out.println("El barbero: "+ nombre + " esta barriendo el piso");
                barberia.barrerPiso();
                clientesAtendidos++;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
