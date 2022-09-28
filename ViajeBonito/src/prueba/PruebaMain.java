package prueba;

public class PruebaMain {
    public static void main(String[] args) {
        Salon salon = new Salon();
        Despertador despertador = new Despertador(salon);
        Hilo arrHilo[] = new Hilo[5];
        for (int i = 0; i < arrHilo.length; i++){
            arrHilo[i] = new Hilo(salon);
            arrHilo[i].start();
        }
        despertador.start();
    }

}
