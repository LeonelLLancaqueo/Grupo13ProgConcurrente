public class TiendaMascotaMain {
    public static void main(String[] args) {
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
    }
    
    

}
