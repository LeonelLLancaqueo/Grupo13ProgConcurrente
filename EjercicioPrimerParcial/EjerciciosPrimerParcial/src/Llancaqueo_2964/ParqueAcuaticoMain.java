package Llancaqueo_2964;

public class ParqueAcuaticoMain {
    public static void main(String[] args){
        ParqueAcuatico parqueAcuatico = new ParqueAcuatico(3,3);
        PersonalSnorkel personalSnorkel = new PersonalSnorkel(parqueAcuatico);
        PersonalAntiparra personalAntiparra = new PersonalAntiparra(parqueAcuatico);
        Visitante []colVisitante= new Visitante[5];
        
        int cantVisitante= colVisitante.length;
        
        personalSnorkel.start();
        personalAntiparra.start();
        
        for(int i=0; i<cantVisitante; i++){
            colVisitante[i]= new Visitante(parqueAcuatico, i);
        }
        
        for(int i=0; i<cantVisitante; i++){
            colVisitante[i].start();
        }
        
        try {
            for(int i=0; i<cantVisitante; i++){
                colVisitante[i].join();
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }
        
        System.out.println("cant visitantes en el parque: " + parqueAcuatico.getVisitantes());

    }
}
