public class Clientes {
    private String nombre;
    private int[] carroCompra;
    public Clientes(String nombre, int[] arr){
        this.nombre = nombre;
        this.carroCompra= arr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getCarroCompra() {
        return carroCompra;
    }

}
