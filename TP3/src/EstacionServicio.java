public class EstacionServicio {
    

    public synchronized int recargar() throws InterruptedException{
        System.out.println("vehiculo "+ Thread.currentThread().getName()+" recargando....");
        Thread.sleep(2000);
        System.out.println("vehiculo "+ Thread.currentThread().getName()+" termino de cargar");
        return 10;
    }
}

