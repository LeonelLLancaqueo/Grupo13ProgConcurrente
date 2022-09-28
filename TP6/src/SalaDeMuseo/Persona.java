package SalaDeMuseo;

public class Persona extends Thread{
    private SalaMuseo sala;

    public Persona(SalaMuseo sala){
        this.sala = sala;
    }

    public void run(){
        try {
            Thread.sleep((int)(Math.floor(Math.random()*(2000-1000+1)+1000)));//Math.floor(Math.random()*(N-M+1)+M);  /
            sala.entrarSala();
            System.out.println("la persona entra a la sala");
            Thread.sleep(1450);
            sala.salirSala();
            System.out.println("la persona sale de la sala");
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
