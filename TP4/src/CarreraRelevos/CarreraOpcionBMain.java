package CarreraRelevos;
public class CarreraOpcionBMain {
    public static void main(String[] args) {
        CarreraOpcionB carrera = new CarreraOpcionB();
        CompetidorCarreraB []competidores= new CompetidorCarreraB[7];


        for(int i=0; i< 7; i++){
            competidores[i]= new CompetidorCarreraB(i+1, carrera, i);
        }
        for(int i=0; i< 7; i++){
            competidores[i].start();
        }

        try {
            for(int i=0; i< 7; i++){
                competidores[i].join();
            }

        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
        System.out.println("termino la carrera: "+System.currentTimeMillis());

    }
}
