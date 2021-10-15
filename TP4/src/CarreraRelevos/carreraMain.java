package CarreraRelevos;
public class carreraMain {
    
    public static void main(String[] args){
        Carrera carrera = new Carrera();
        Competidor [] competidoresLadoIzq= new Competidor[5];
        Competidor [] competidoresLadoDer= new Competidor[5];
        for(int i=0; i <= 4; i++){
            competidoresLadoDer[i]= new Competidor(i, carrera, 0);
            competidoresLadoIzq[i]= new Competidor(i+5, carrera, 1);
        }
        for(int i=0; i <= 4; i++){
            competidoresLadoIzq[i].start();
            competidoresLadoDer[i].start();
        }
        
        try {
            Thread.sleep(100);
        }
        catch (Exception err) {
            System.out.println("error");
        }        
        
        try {
            for(int i=0; i <= 4; i++){
                competidoresLadoIzq[i].join();
                competidoresLadoDer[i].join();
            }
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Termino la carrera, tiempo: "+System.currentTimeMillis());
    }

}
