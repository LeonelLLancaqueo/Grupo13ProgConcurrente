public class BarberiaMain {
    
    public static void main(String[] args){
        Barberia barberia= new Barberia();
        Cliente arr[]= new Cliente[10];
        int cantClientes= 10;
        for(int i=0; i < cantClientes; i++){
            arr[i]= new Cliente(barberia, i); 
        }
        Barbero barbero = new Barbero(barberia,"Juan Carlos"); 
        barbero.start();
        for(int i=0; i < cantClientes; i++){
            arr[i].start(); 
        }

        try {
            for(int i=0; i < cantClientes; i++){
                arr[i].join(); 
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }
        System.out.println("Total de clientes atendido por el barbero: "+ barbero.getClientesAtendidos());

    }
    
}
