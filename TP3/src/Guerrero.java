public class Guerrero {
   private int vida= 10;


    public synchronized int getVida() {
    return vida;
    }

    public void setVida(int vida) {
    this.vida = vida;
    }

    public synchronized void restarVida(int daño){
        vida -= daño;
        System.out.println("la vida de guerrero es: " + this.vida);
    }
    public synchronized void operar(int vida){
        this.vida += vida;
        System.out.println("la vida de guerrero es: " + this.vida);
    }
}
