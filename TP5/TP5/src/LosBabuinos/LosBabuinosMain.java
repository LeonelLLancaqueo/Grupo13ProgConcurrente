package LosBabuinos;

import java.util.Random;
public class LosBabuinosMain {
    public static void main(String[] args){
        Soga soga= new Soga(5,8); //r.nextInt(3)+1
        Random r= new Random();

        Babuino []arrBabuinos= new Babuino[25];

        for(int i=0; i<arrBabuinos.length; i++){
            arrBabuinos[i]= new Babuino(soga, r.nextInt(2));
        }

        for(int i=0; i<arrBabuinos.length; i++){
            arrBabuinos[i].start();
        }

    }
}
