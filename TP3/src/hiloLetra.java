public class hiloLetra extends Thread {
    private String texto;
    private int turno;
    private Imprimir impresor;
    private int cantVeces;

    public hiloLetra(String texto, int turno, Imprimir impresor, int cantVeces) {
        this.texto = texto;
        this.turno= turno;
        this.impresor= impresor;
        this.cantVeces = cantVeces;
    }

    public void run() {
        try {
            int i=0;
            while( i < this.cantVeces ){
                if(impresor.imprimirHilo(turno, texto)){
                    i++;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
    
}
