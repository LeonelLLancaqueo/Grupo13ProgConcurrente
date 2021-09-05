public class CajeraThread extends Thread {
    private String nombre;
    private Clientes cliente;
    private long initialTime;
     
    public CajeraThread(String nombre, Clientes cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public void esperarXsegundos(int x){
        try{
            Thread.sleep(x*1000);
        }catch(InterruptedException e){

        }
    }
    
    public void run() {
        System.out.println("La cajera " + this.nombre +
            " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
            + this.cliente.getNombre() + " EN EL TIEMPO: "
            + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " del cliente " +
            this.cliente.getNombre() + "->Tiempo: " +
            (System.currentTimeMillis() - this.initialTime) / 1000 +
            "seg");
        }
        System.out.println("La cajera" + this.nombre + "HA TERMINADO DE PROCESAR"+ this.cliente.getNombre() + " EN EL TIEMPO: " +
            (System.currentTimeMillis() - this.initialTime) / 1000 +
            "seg");
    }       
}
