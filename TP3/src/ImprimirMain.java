public class ImprimirMain {
    public static void main(String[] args) {
        Imprimir impresor = new Imprimir();
        hiloLetra hiloA= new hiloLetra("A", 1, impresor, 3);
        hiloLetra hiloB= new hiloLetra("BB", 2, impresor, 3);
        hiloLetra hiloC= new hiloLetra("CCC", 3, impresor, 3);


        hiloA.start();
        hiloB.start();
        hiloC.start();
    
        
    }
}
