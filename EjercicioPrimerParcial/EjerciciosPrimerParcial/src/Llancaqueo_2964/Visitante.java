package Llancaqueo_2964;

public class Visitante extends Thread{
    private ParqueAcuatico parqueAcuatico;
    private int nroVisitante;

    public Visitante(ParqueAcuatico parqueAcuatico, int nroVisistante){
        this.parqueAcuatico = parqueAcuatico;
        this.nroVisitante = nroVisistante;
    }
    public void run(){
        try {
            
            parqueAcuatico.pedirAntiparra();
            parqueAcuatico.tomarAntiparra();
            System.out.println("El visitante "+ nroVisitante +" tomo una antiparra");
                
            parqueAcuatico.pedirSnorkel();
            parqueAcuatico.tomarSnorkel();
            System.out.println("El visitante "+ nroVisitante +" tomo un snorkel");
               
            System.out.println("El visitante "+ nroVisitante +" esta buceando");
            Thread.sleep(1250);
            System.out.println("El visitante "+ nroVisitante +" termino de bucear");
            parqueAcuatico.devolverInstrumentos();

        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }


}
