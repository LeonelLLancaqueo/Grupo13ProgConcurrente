public class ImprimirMain {
    public static void main(String[] args) {
        Imprimir impresor = new Imprimir();
        hiloLetra hiloA= new hiloLetra("A", 1, impresor, 3, 1);
        hiloLetra hiloB= new hiloLetra("B", 2, impresor, 3, 2);
        hiloLetra hiloC= new hiloLetra("C", 3, impresor, 3, 3);

        // 3 semaforos el hilo a obtiene el paso
        // 
        hiloA.start();
        hiloB.start();
        hiloC.start();
    
        
    }
}
