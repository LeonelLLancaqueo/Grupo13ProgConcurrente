package CentroDeImpresion;
public class CentroDelCopiado {
    private Impresora[] colImpresora;
    private int cantImpresoras;

    public CentroDelCopiado() {
        colImpresora = new Impresora[10];
        cantImpresoras = 0;
    }
    public Impresora[] getColImpresora() {
        return colImpresora;
    }
    public boolean insertarImpresora(char tipoImp){
        boolean exito= false;
        if(cantImpresoras < colImpresora.length){
            colImpresora[cantImpresoras] = new Impresora(tipoImp);
            cantImpresoras++;
        }
        return exito;
    }
    public boolean realizarImpresion(String trabajo, char tipo){
        boolean exito= false;
        int i=0;
        while(!exito && i < cantImpresoras){
            exito= colImpresora[i].imprimirTrabajo(tipo, trabajo);
            i++;
        }
        return exito;
    }

}
