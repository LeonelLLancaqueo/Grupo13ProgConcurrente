package BarberoDormilonMonitor;
public class ClienteMonitor extends Thread{
    private BarberiaMonitor barberia;
    private int numCliente;

    public ClienteMonitor(BarberiaMonitor barberia, int numCliente){
        this.barberia = barberia;
        this.numCliente = numCliente;
    }

    public void run(){
        try {
            System.out.println("El cliente numero:" + numCliente+ " esta caminando hacia la barberia");
            Thread.sleep((int)(Math.random() * 1000));
            if(barberia.solicitarSillon()){
                System.out.println("El cliente numero:" + numCliente+ " solicita un corte de pelo al barbero");
                barberia.solicitarCorte();
                Thread.sleep((int)(Math.random() * 1000));
                System.out.println("El cliente numero:" + numCliente+ " sale de la barberia");
                barberia.salir();
            }else{
                System.out.println("El cliente numero:" + numCliente+ " solicita una silla en la barberia");
                barberia.solicitarSilla();
                System.out.println("El cliente numero:" + numCliente+ " solicita un corte de pelo al barbero");
                barberia.solicitarCorte();
                Thread.sleep((int)(Math.random() * 1000));
                System.out.println("El cliente numero:" + numCliente+ " sale de la barberia");
                barberia.salir();
            }
            
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}   
