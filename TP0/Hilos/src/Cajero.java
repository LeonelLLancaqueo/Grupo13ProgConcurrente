public class Cajero {
    private  String nombre;

    public Cajero(String nombre){
        this.nombre= nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void esperarXsegundos(int x){
        try{
            Thread.sleep(x*1000);
        }catch(InterruptedException e){

        }
    }
    public void procesarCompra(Clientes cliente, long timeStamp){
        System.out.println(" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE" + cliente.getNombre()+ "en el tiempo: " +
            (System.currentTimeMillis() - timeStamp) / 1000 + "seg"
        );
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
           this.esperarXsegundos(cliente.getCarroCompra()[i]);
        System.out.println("Procesado el producto " + (i + 1) + " ->Tiempo: " +
            (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        }
        System.out.println("La cajera " + this.nombre +
            " HA TERMINADO DE PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: " +
        (System.currentTimeMillis() - timeStamp) / 1000 +
        "seg");
    }

}
