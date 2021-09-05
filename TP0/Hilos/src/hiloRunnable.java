public class hiloRunnable implements Runnable {
    String nombreHilo;
    public hiloRunnable(String name){
        this.nombreHilo = name;
    }
    public void run() {
        System.out.println("comenzando " + this.nombreHilo);
        try{
            for (int contar=0; contar < 10; contar++) {
                Thread.sleep(400);
                System.out.println("En "+nombreHilo+" ; el recuento " + contar);
           }
        }catch(InterruptedException exc){
            System.out.println(nombreHilo + "interrumpido");
        }
        System.out.println("terminado: "+ nombreHilo);
    }
}
