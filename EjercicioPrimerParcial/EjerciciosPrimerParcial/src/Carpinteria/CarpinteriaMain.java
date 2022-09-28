package Carpinteria;

public class CarpinteriaMain {
    public static void main(String[] args){
        carpinteria carpinteria= new carpinteria(5);
        Ensamblador ensamblador= new Ensamblador(carpinteria);
        int carpPorPieza= 1;
        carpintero []arrCarpinteroA= new carpintero[carpPorPieza];
        carpintero []arrCarpinteroB= new carpintero[carpPorPieza];
        carpintero []arrCarpinteroC= new carpintero[carpPorPieza];
        ensamblador.start();
        for(int i=0; i< carpPorPieza ;i++){
            arrCarpinteroA[i] = new carpintero(carpinteria, 0, i);
            arrCarpinteroB[i] = new carpintero(carpinteria, 1, i);
            arrCarpinteroC[i] = new carpintero(carpinteria, 2, i);
        }
        for(int i=0; i< carpPorPieza ;i++){
            arrCarpinteroA[i].start();
            arrCarpinteroB[i].start();
            arrCarpinteroC[i].start();
        }

    }

}
