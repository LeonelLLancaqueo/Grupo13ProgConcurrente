package CuartelSoldados;

public class CuartelSoldadosMain {
    public static void main(String[] args){
        Comedor comedor= new Comedor(100, 8, 5, 3);
        SoldadoA []arrSoldadoA= new SoldadoA[25];
        SoldadoB []arrSoldadoB= new SoldadoB[25];
        SoldadoC []arrSoldadoC= new SoldadoC[25];
        SoldadoD []arrSoldadoD= new SoldadoD[25];
        

        for(int i=0; i< arrSoldadoA.length; i++) {
            arrSoldadoA[i]= new SoldadoA(comedor, i); 
        }
        for(int i=0; i< arrSoldadoB.length; i++) {
            arrSoldadoB[i]= new SoldadoB(comedor, i+25); 
        }
        for(int i=0; i< arrSoldadoC.length; i++) {
            arrSoldadoC[i]= new SoldadoC(comedor, i+50); 
        }
        for(int i=0; i< arrSoldadoD.length; i++) {
            arrSoldadoD[i]= new SoldadoD(comedor, i+75); 
        }
        

        /* EJECUTAMOS LOS HILOS */

        /* SOLDADOS */
        for(int i=0; i< arrSoldadoA.length; i++) {
            arrSoldadoA[i].start(); 
        }
        for(int i=0; i< arrSoldadoB.length; i++) {
            arrSoldadoB[i].start(); 
        }
        for(int i=0; i< arrSoldadoC.length; i++) {
            arrSoldadoC[i].start(); 
        }
        for(int i=0; i< arrSoldadoD.length; i++) {
            arrSoldadoD[i].start(); 
        }


    }
    

}
