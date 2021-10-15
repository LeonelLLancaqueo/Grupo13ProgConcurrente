package LosPollosHermanos2;

public class Cocinero extends Thread{
    private Silla silla;    

    public Cocinero(Silla silla) {
        this.silla = silla;
    }

    public void run() {
        try {
            while(true){
                silla.ordenarCocina();
                System.out.println("el cocinero esta ordenando la cocina");
                silla.prepararComida();
                System.out.println("El cocinero esta preparando la comida: ");
                Thread.sleep((int)(Math.random()*1000)); 
                System.out.println("El cocinero esta sirviendo la comida: ");
                silla.servirPedido();
                
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }

    }
}
