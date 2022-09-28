package Carpinteria;

public class CarpinteriaMain {
    public static void main(String[] args){
        Carpinteria carpinteria= new Carpinteria(10);

        CarpinteroA []arrCarpinteroA= new CarpinteroA[10];
        CarpinteroB []arrCarpinteroB= new CarpinteroB[10];
        CarpinteroC []arrCarpinteroC= new CarpinteroC[10];
        Ensamblador []arrEnsamblador= new Ensamblador[10];
        
        for(int i=0; i<arrCarpinteroA.length ;i++){
            arrCarpinteroA[i]= new CarpinteroA(carpinteria, i);
        }
        for(int i=0; i<arrCarpinteroB.length ;i++){
            arrCarpinteroB[i]= new CarpinteroB(carpinteria, i);
        }
        for(int i=0; i<arrCarpinteroC.length ;i++){
            arrCarpinteroC[i]= new CarpinteroC(carpinteria, i);
        }

        for(int i=0; i<arrEnsamblador.length ;i++){
            arrEnsamblador[i]= new Ensamblador(carpinteria, i);
        }


        for(int i=0; i<arrCarpinteroA.length ;i++){
            arrCarpinteroA[i].start();
        }
        for(int i=0; i<arrCarpinteroB.length ;i++){
            arrCarpinteroB[i].start();
        }
        for(int i=0; i<arrCarpinteroC.length ;i++){
            arrCarpinteroC[i].start();
        }

        for(int i=0; i<arrEnsamblador.length ;i++){
            arrEnsamblador[i].start();
        }

    }
}

