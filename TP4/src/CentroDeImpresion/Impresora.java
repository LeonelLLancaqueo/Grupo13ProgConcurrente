package CentroDeImpresion;
import java.util.concurrent.Semaphore;
public class Impresora {
    private char tipo;
    private Semaphore s;

    public Impresora(char tipo){
        this.tipo = tipo;
        s= new Semaphore(1);
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    public void imprimir(String trabajo) {
        System.out.println(trabajo);
        //Thread.sleep(2000);
    }
    public boolean imprimirTrabajo(char tipoTrabajo, String trabajo){
        boolean exito= false;
        if(this.tipo == tipoTrabajo){
            if(s.tryAcquire()){
                this.imprimir(trabajo);
                s.release();
                exito= true;
            }
        }
        return exito;
    }
    
}
