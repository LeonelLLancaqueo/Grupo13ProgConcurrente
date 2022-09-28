package Trafico2;

public class Trafico2Main {
    public static void main(String[] args) {
        Puente2  puente = new Puente2();
        CocheGeneral []arrCocheGeneral= new CocheGeneral[30];
        for(int i=0; i<arrCocheGeneral.length; i++) {
            if(i%2 == 0){
                arrCocheGeneral[i]= new CocheGeneral(puente, i, 0);
            }else{
                arrCocheGeneral[i]= new CocheGeneral(puente, i, 1);
            }
        } 
        for(int i=0; i<arrCocheGeneral.length; i++) {
            arrCocheGeneral[i].start();
        }  
    }
}
