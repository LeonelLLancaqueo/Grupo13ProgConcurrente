public class Imprimir {
    private int turno=1;

    
    public void imprimir(String texto) throws InterruptedException {
        System.out.print(texto);
    }

    public  synchronized boolean imprimirHilo(int t, String texto) throws InterruptedException{
        boolean exito= false;
        if(this.turno == t){
            this.imprimir(texto);    
            exito= true;
            this.turno++;
            if(this.turno > 3){
                this.turno= 1;
            }
        }
        return exito;
    }

}
