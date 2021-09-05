public class Guerrero {
   private int vida= 10;


    public int getVida() {
    return vida;
}

    public void setVida(int vida) {
    this.vida = vida;
}

    public void restarVida(int daño){
        vida -= daño;
    }
    public void operar(int vida){
        this.vida += vida;
    }
}
