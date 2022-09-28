package AcrobaciaAerea;
import java.util.Random;

public class Persona extends Thread{
    private Salon salon;
    private int nro, primeraAct, segundaAct;
    private Random r;


    public Persona(Salon salon, int nro){
        this.nro = nro;
        this.salon= salon;
        r=new Random();
    }

    public void run(){
        try {
            salon.entrarSalon();
            System.out.println("La persona"+ nro + "entro en el salon");
            primeraAct=r.nextInt(3);
            primeraAct= salon.tomarCupo(primeraAct);
            System.out.println("La persona "+ nro + " tomo el cupo de la act: "+ primeraAct);
            salon.realizarActividad();
            System.out.println("La persona "+ nro + " empezo a realizar la act: "+ primeraAct);
            Thread.sleep(3000);
            salon.terminarActividad();
            segundaAct= primeraAct;
            while(segundaAct == primeraAct){ //realizamos este while para evitar que la persona elija a la primera act como segunda act
                segundaAct= r.nextInt(3);
            }
            segundaAct= salon.tomarCupo(segundaAct);
            System.out.println("La persona "+ nro + " tomo el cupo de la act: "+ primeraAct);
            salon.realizarActividad();
            System.out.println("La persona "+ nro + " empezo a realizar la act: "+ primeraAct);
            Thread.sleep(3000);
            salon.terminarActividad();
            salon.salirSalon();
            System.out.println("La persona "+ nro + " salio del salon");
            
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }


    }
}
