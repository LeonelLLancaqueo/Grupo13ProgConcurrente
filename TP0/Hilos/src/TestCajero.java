public class TestCajero {
    public static void main(String[] args) {
        Clientes cliente1 = new Clientes("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Clientes cliente2 = new Clientes("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
        Cajero cajera1 = new Cajero("Cajera 1");
        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        cajera1.procesarCompra(cliente1, initialTime);
        cajera1.procesarCompra(cliente2, initialTime);
    }
}
