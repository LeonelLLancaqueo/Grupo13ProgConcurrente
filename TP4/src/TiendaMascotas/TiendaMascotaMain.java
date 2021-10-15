package TiendaMascotas;

public class TiendaMascotaMain {
    public static void main(String[] args) {
        // TIENDA DE MASCOTA CON SEMAFOROS
        /*
        Actividades hilo = new Actividades();

        Hamster hamsterA= new Hamster(hilo, "hamsterA" );
        Hamster hamsterB= new Hamster(hilo, "hamsterB" );
        Hamster hamsterC= new Hamster(hilo, "hamsterC" );
        Hamster hamsterD= new Hamster(hilo, "hamsterD" );
        Hamster hamsterE= new Hamster(hilo, "hamsterE" );
        
        hamsterA.start();
        hamsterB.start(); 
        hamsterC.start(); 
        hamsterD.start(); 
        hamsterE.start();  
        */
        // TIENDA DE MASCOTA CON LOCKS

        Rueda rueda = new Rueda();
        Hamaca hamaca= new Hamaca();
        Plato plato= new Plato();
        HamsterConLock arrHamster[]= new HamsterConLock[5];
        int cantidadDeHamsters= arrHamster.length;

        for(int i=0; i < cantidadDeHamsters; i++){
            arrHamster[i]= new HamsterConLock(i, hamaca, rueda, plato);
        }
        for(int i=0; i < cantidadDeHamsters; i++){
            arrHamster[i].start();
        }
        
        

    }
    
    

}
