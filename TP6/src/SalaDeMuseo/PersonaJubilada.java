package SalaDeMuseo;

public class PersonaJubilada extends Thread{
    private SalaMuseo sala;

    public PersonaJubilada(SalaMuseo sala){
        this.sala = sala;
    }

    public void run(){
        try {
            Thread.sleep((int)(Math.floor(Math.random()*(2000-1000+1)+1000)));
            sala.entrarSalaJubilado();
            System.out.println("la persona jubilada entra de la sala");
            Thread.sleep(1450);
            sala.salirSala();
            System.out.println("la persona jubilada sale de la sala");
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}

