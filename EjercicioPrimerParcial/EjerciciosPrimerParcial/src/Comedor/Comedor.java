package Comedor;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

public class Comedor {
    private int comedoresDisponibles, animalesPasaronComedor,  especieComiendo;
    private ReentrantLock lock, terminarComer;
    private boolean puedePasar;
    private Semaphore[] plato;
    public Comedor(){
        this.lock = new ReentrantLock(); 
        this.terminarComer = new ReentrantLock();
        this.puedePasar = true;
    }

    public synchronized boolean entrarComedor(int animal){ //El metodo esta sincronizado
        boolean exito= false;
        if(animal == especieComiendo && puedePasar ){ // verificamos que este comiendo la especie de la cual es el animal
            
            if(this.animalesPasaronComedor < 4){ //preguntamos si no se sobrepaso la cantidad de animales q podian comer
                this.animalesPasaronComedor++;
                exito= true;
            }else{
                this.animalesPasaronComedor=0;
                puedePasar= false;
                this.especieComiendo++;
                if(this.especieComiendo > 1){
                    this.especieComiendo = 0;
                }

            }
        }
        return exito;
    }
    public boolean solicitarPlato(){
        boolean exito= false;
            try {
                lock.lock();
                if(this.comedoresDisponibles > 0){
                    this.comedoresDisponibles--;
                    exito= true;
                }
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }finally{
                lock.unlock();
            }
        return exito;
    }/*
    public void comer(){
        try {
            comer.lock();
            this.animalesComieron++;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            comer.unlock();
        }
    }*/
    public boolean terminarComer(){
        boolean exito= false;
        try{
            terminarComer.lock();
            exito= true;
            comedoresDisponibles++;

        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }finally{
            terminarComer.unlock();
        }
        return exito;
    }
    
}
