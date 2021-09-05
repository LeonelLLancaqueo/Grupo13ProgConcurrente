public class TestCajeraThread {
    public static void main(String[] args) {
        Clientes cliente1 = new Clientes("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Clientes cliente2 = new Clientes("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
        
        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        CajeraThread cajera1 = new CajeraThread("Cajera 1", cliente1, initialTime);
        CajeraThread cajera2 = new CajeraThread("Cajera 1", cliente2, initialTime);
        cajera1.start();
        cajera2.start();


    }
}
