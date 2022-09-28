import java.util.HashMap;
import java.util.Random;

/*  EN ESTA CLASE SE GUARDARA LA INFORMACION SOBRE LOS VUELOS QUE SE DEBEN REALIZAR DURANTE EL DIA */
public class TablaVuelo {
    private HashMap tabla;    
    private int hora[]= {10,13,15,18}; //{8,9,10,11,12,13,14,15,16,17,18};
    private Random r;
    private PuestoAerolinea colAerolinea[];

    private char idTerminal[];
    private int colEmbarque[][];  
    private String nombreAerolinea[]; 

    public TablaVuelo(PuestoAerolinea[] puestoAerolinea, int[][] colEmbarque, char [] idTerminal, String [] nombreAerolinea ) throws InterruptedException{
        tabla= new HashMap<Integer, Vuelo>();
        colAerolinea= puestoAerolinea;
        this.colEmbarque= colEmbarque;
        this.idTerminal= idTerminal;
        this.nombreAerolinea= nombreAerolinea;
        this.generarVuelos();
    }
    private void generarVuelos() throws InterruptedException{
        /*En este metodo se crean los vuelos que se van a realizar en el aeropuerto durante el dia */
        /*Es ejecutado por el hilo GeneradorVuelo */
        
        Vuelo vueloAux;

        for(int i=0; i<hora.length; i++){ 
            //creamso un vuelo en cada aerolinea para cada hora
            for(int k=0; i<colAerolinea.length; i++){
                vueloAux= new Vuelo(i, hora[i], nombreAerolinea[i], colEmbarque[k][k], idTerminal[i]);
                tabla.put(hora[i], vueloAux); // lo agregamos a la tabla de vuelos general del aeropuerto
                colAerolinea[k].agregarVuelo(vueloAux); // lo agregamos a la lista de vuelos de la aerolinea
            }

        }
    }
    public String mostrarVuelos(){
        return tabla.values().toString(); // to string de la tabla

        
    }
}
