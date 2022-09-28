package SociedadProtectoraAnimales;

public class Perro extends Thread{
    private int nroEspecieAnimal, nroAnimal;
    private boolean comio;
    private Comedero comedor;

    public Perro(int nroEspecieAnimal, Comedero comedor, int nroAnimal){
        this.nroEspecieAnimal=  nroEspecieAnimal;
        this.comedor= comedor;
        this.nroAnimal= nroAnimal;
    }
    public void run() {
        
        while(!comio){
            try {
                Thread.sleep((int)(Math.floor(Math.random()*(2000-1000+1)+1000)));
                comio= comedor.comer(this.nroEspecieAnimal);
                if(comio){
                    System.out.println("El perro"+ nroAnimal  +" entro a comer");
                }else{
                    System.out.println("El perro"+ nroAnimal  +" espera");
                    this.comedor.esperar();
                }
                if(comio){
                    Thread.sleep(1250);
                    System.out.println("El perro"+ nroAnimal  +" termino de comer");
                    comedor.terminarComer();
                }             
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
            
        
    }

}
