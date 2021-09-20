
public class hiloLetra extends Thread {
    private String texto;
    private int turno;
    private Imprimir impresor;
    private int cantVeces;
    private int cantVecesLetra;

    public hiloLetra(String texto, int turno, Imprimir impresor, int cantVeces, int cantVecesLetra) {
        this.texto = texto;
        this.turno= turno;
        this.impresor= impresor;
        this.cantVeces = cantVeces;
        this.cantVecesLetra= cantVecesLetra;
    }

    public void run() {
        try {
            int i=0;
            int k=0;
            while(i < this.cantVeces ){
                    while(k < cantVecesLetra){
                        if(impresor.imprimirHilo(turno, texto)){
                            k++;
                        }else{
                            Thread.sleep(1000);
                        }
                    }
                    i++;
                    k=0;
                    impresor.cambiarTurno(1);
                        //                    
            }

        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
    
}
