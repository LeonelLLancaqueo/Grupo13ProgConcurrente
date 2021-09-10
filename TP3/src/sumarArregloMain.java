public class sumarArregloMain {
    public static int[] crearArreglo() {
        int[]arr= new int[50000];
        for(int i=0; i<50000; i++) {
            arr[i]= (int)(Math.random()*10);
        }
        return arr;
    }
    
    public static void main(String[] args) {
        int[] arr= crearArreglo();

        HiloSumarArreglo hiloA= new HiloSumarArreglo(arr, 0, 10000);
        HiloSumarArreglo hiloB= new HiloSumarArreglo(arr, 10000, 20000);
        HiloSumarArreglo hiloC= new HiloSumarArreglo(arr, 20000, 30000);
        HiloSumarArreglo hiloD= new HiloSumarArreglo(arr, 30000, 40000);
        HiloSumarArreglo hiloE= new HiloSumarArreglo(arr, 40000, 50000);
        hiloA.start();
        hiloB.start();
        hiloC.start();
        hiloD.start();
        hiloE.start();
        try {
            hiloA.join();
            hiloB.join();
            hiloC.join();
            hiloD.join();
            hiloE.join();    
        } catch (Exception e) {
            System.out.println("error");
        }
        int sumaTotal= hiloA.getSuma() + hiloB.getSuma()+ hiloC.getSuma() +hiloD.getSuma() +hiloE.getSuma();
        System.out.println("Resultado final de la suma de los hilos: " + sumaTotal );
    }
}
