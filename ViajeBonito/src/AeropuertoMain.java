public class AeropuertoMain {
    public static void main(String[] args) {
        Aeropuerto aeropuerto= new Aeropuerto(3);
        Pasajero pasajero[]= new Pasajero[20]; 
        Reloj reloj= new Reloj(aeropuerto);
        GuardiaAeropuerto guardiaAeropuerto= new GuardiaAeropuerto(aeropuerto);
        for(int i=0; i<pasajero.length; i++) {
            pasajero[i]=new Pasajero(aeropuerto);
        }
        for(int i=0; i<pasajero.length; i++) {
            pasajero[i].start();
        }
        reloj.start();
        guardiaAeropuerto.start();


        

    }    
}
/*

*/