import java.util.concurrent.Semaphore;

public class Imprimir {
    private int turno=1;
    private Semaphore s;
    
    public Imprimir(){
        s= new Semaphore(1);
    }

    public void imprimir(String texto) throws InterruptedException {
        System.out.print(texto);
    }
    public void cambiarTurno(int i){
        this.turno+=i;
        if(this.turno > 3){
            this.turno= 1;
        }
    }
    public boolean imprimirHilo(int t, String texto) throws InterruptedException{
        boolean exito= false;
        if(this.turno == t){
            s.acquire();
            this.imprimir(texto);
            exito= true;
            s.release();
        }
        return exito;
    }

}
