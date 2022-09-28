package SalaDeFumadores;

public class SalaDeFumadores {
    private boolean empezoFumar, ingA, ingB;
    private int ingredientesA, ingredientesB;

    public synchronized void entraFumar(int id) throws InterruptedException{
        
        while((!ingA || !ingB) || empezoFumar || (ingredientesA == id || ingredientesB == id)){ 
            //si los ingredientes aun no fueron puesto o ya hay alguien fumando
            // o si alguno de los ingredientes colocados por el agente es igual al del fumador
            this.wait(); //bloqueamos al hilo
        }
        empezoFumar= true;
        
    }
    public synchronized void colocar(int ingrediente) throws InterruptedException{
        // no debe ingresar dos ingredientes iguales

        while(ingA && ingB){
            this.wait();
        }
        if(!ingA){ //si el ingrediente a no esta puesto 
            ingredientesA= ingrediente; //ingrediente aleatorio
            ingA= true;
        }
        if(!ingB && (ingrediente != ingredientesA)){ //si el ingrediente b no esta puesto 
            ingredientesB= ingrediente; //ingrediente aleatorio
            ingB= true;
        }
        notifyAll();
    }
    public synchronized void terminarFumar(){
        empezoFumar= false;
        ingA= false;
        ingB= false;
        notifyAll();
    }
}
