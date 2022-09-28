
import java.util.LinkedList;

//clase utilizada para modelar los vuelos dentro del aeropuerto

public class Vuelo {
    private int id, horaSalida, embarque;
    private final static int CANT_LUGARES=10;
    private char terminal;
    private String aerolinea;
    private LinkedList<Pasaje> colPasaje;
    private boolean realizado, stockPasajes, permitidoVender;

    


    public Vuelo(int id, int horaSalida,String aerolinea, int embarque, char terminal){
        this.id = id;
        this.aerolinea= aerolinea;
        this.horaSalida = horaSalida;
        this.terminal = terminal;
        this.embarque = embarque;
        this.inicializarColPasajes();
        colPasaje= new LinkedList<Pasaje>();
        this.stockPasajes = true;
        this.permitidoVender= true;
    }

    private void inicializarColPasajes(){ 
        for(int i=0; i<CANT_LUGARES; i++){
            colPasaje.add(new Pasaje(id, terminal, embarque, horaSalida));
        }
    }
    public Pasaje venderPasaje(){
        // este metodo retorna un pasajae
        Pasaje pasajeAux= colPasaje.poll();
        if(colPasaje.isEmpty()){
            stockPasajes= false;
        } 
        
        return pasajeAux; 
    }


    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getEmbarque() {
        return embarque;
    }

    public void setEmbarque(int embarque) {
        this.embarque = embarque;
    }

    public char getTerminal() {
        return terminal;
    }

    public void setTerminal(char terminal) {
        this.terminal = terminal;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public boolean isStockPasajes() {
        return stockPasajes;
    }
    
    public void setStockPasajes(boolean stockPasajes) {
        this.stockPasajes = stockPasajes;
    }


    public boolean isPermitidoVender() {
        //permite marcar a el avion si esta permitido vender pasajes
        return permitidoVender;
    }

    public void setPermitidoVender(boolean permitidoVender) {
        this.permitidoVender = permitidoVender;
    }

    @Override
    public String toString() {
        return "Vuelo [aerolinea=" + aerolinea + ", embarque=" + embarque + ", horaSalida=" + horaSalida + ", id=" + id
                + ", realizado=" + realizado + ", stockPasajes=" + stockPasajes + ", terminal=" + terminal + "]";
    }
    
}
