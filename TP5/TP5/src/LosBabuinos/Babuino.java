package LosBabuinos;

public class Babuino extends Thread{
    private Soga soga;
    private int lado;

    public Babuino(Soga soga, int lado){
        /* COMO SIMULO QUE UNO ENTRA DE UN LADO Y OTRO DEL OTRO */
        this.soga = soga;
        this.lado = lado;
    }
    public void run(){
        try {
            Thread.sleep((int)(Math.floor(Math.random()*(1000-2000+1)+1000)));
            System.out.println("el babuino del lado "+lado+" esta solicitando la soga");
            soga.tomarSoga(lado);
            System.out.println("el babuino del lado "+lado+" esta cruzando el acantilado");
            Thread.sleep(1500);
            System.out.println("el babuino del lado "+lado+" esta dejando la soga");
            soga.soltarSoga();
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }

}
