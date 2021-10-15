public class Barbero extends Thread {
    
    private Barberia barberia;
    private String nombre;
    private int clientesAtendidos;

    public Barbero(Barberia barberia, String nombre){
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
                clientesAtendidos++;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
