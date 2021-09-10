public class HiloSumarArreglo extends Thread{ 
    private int desde, hasta;
    private int[]arr;
    private int suma;
    public HiloSumarArreglo(int[] arr, int desde, int hasta){
        this.arr = arr;
        this.desde = desde;
        this.hasta = hasta;
    }

    public int getSuma(){
        return this.suma;
    }

    public void sumar(int[] nums, int desde, int hasta){
        for (int i=desde; i< hasta;i++){
            this.suma+= nums[i];
            /*
            System.out.println("Total acumulado de "+Thread.currentThread().getName()+ "es "+sum);
            try {
                Thread.sleep(10);//permitir el cambio de tarea
            }catch (InterruptedException exc){
                System.out.println("Hilo interrumpido");
            }
            */
        }
        System.out.println("Total acumulado de "+Thread.currentThread().getName()+"es "+suma);
        /*
        try {
            Thread.sleep(10);//permitir el cambio de tarea
        }catch (InterruptedException exc){
            System.out.println("Hilo interrumpido");    
        }*/

        }
    
    public void run(){
            this.sumar(arr, desde, hasta);
    }
}
