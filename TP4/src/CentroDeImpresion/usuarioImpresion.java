package CentroDeImpresion;
public class usuarioImpresion  extends Thread{
    private String trabajo;
    private char tipoTrabajo;
    private CentroDelCopiado c;

    public usuarioImpresion(String trabajo, char tipoTrabajo, CentroDelCopiado c) {
        this.trabajo = trabajo;
        this.tipoTrabajo = tipoTrabajo;
        this.c= c;
    }
    public void run(){
        boolean trabajoImprimido= false;
        while(!trabajoImprimido){
            trabajoImprimido= c.realizarImpresion(trabajo, tipoTrabajo);
        }        
    }
}
