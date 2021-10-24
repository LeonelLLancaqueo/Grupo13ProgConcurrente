package BarberoDormilonMonitor;
public class BarberiaMonitorMain {
    
    public static void main(String[] args){
        BarberiaMonitor barberia= new BarberiaMonitor(4);
        ClienteMonitor arr[]= new ClienteMonitor[10];
        int cantClientes= 10;
        for(int i=0; i < cantClientes; i++){
            arr[i]= new ClienteMonitor(barberia, i); 
        }
        BarberoMonitor barbero = new BarberoMonitor(barberia,"Juan Carlos"); 
        barbero.start();
        for(int i=0; i < cantClientes; i++){
            arr[i].start(); 
        }

        try {
            for(int i=0; i < cantClientes; i++){
                arr[i].join(); 
            }
            Thread.sleep(1000); // lo dormimos al main para q el barbero termine de hacer el conteo con el ultimo cliente q atendio
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }
        System.out.println("Total de clientes atendido por el barbero: "+ barbero.getClientesAtendidos());

    }
    
}
