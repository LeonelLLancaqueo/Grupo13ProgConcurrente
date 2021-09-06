
class Actividades   {
    private boolean comerEnUso=false;
    private boolean corriendoEnUso=false;
    private boolean descansandoEnUso= false;

    

    public boolean getComerEnUso() {
        return comerEnUso;
    }

    public void setComerEnUso(boolean comerEnUso) {
        this.comerEnUso = comerEnUso;
    }

    public boolean getCorriendoEnUso() {
        return corriendoEnUso;
    }

    public void setCorriendoEnUso(boolean corriendoEnUso) {
        this.corriendoEnUso = corriendoEnUso;
    }

    public boolean getDescansandoEnUso() {
        return descansandoEnUso;
    }

    public void setDescansandoEnUso(boolean descansandoEnUso) {
        this.descansandoEnUso = descansandoEnUso;
    }
    
    public  void comer() throws InterruptedException{
        comerEnUso=true;
        System.out.println("Hamster "+ Thread.currentThread().getName()  +" comiendo.....");
        Thread.sleep(2000);
        System.out.println("Hamster"+ Thread.currentThread().getName()  +" termino de comer.");
        comerEnUso=false;
    }
    public  void corriendo() throws InterruptedException{
        corriendoEnUso=true;
        System.out.println("Hamster "+ Thread.currentThread().getName()  +" corriendo.....");
        Thread.sleep(2000);
        System.out.println("Hamster"+ Thread.currentThread().getName()  +" termino de comer.");
        corriendoEnUso=false;
    }
    public  void descansando() throws InterruptedException{
        descansandoEnUso=true;
        System.out.println("Hamster "+ Thread.currentThread().getName()  +" comiendo.....");
        Thread.sleep(2000);
        System.out.println("Hamster"+ Thread.currentThread().getName()  +" termino de descansar.");
        descansandoEnUso=false;
    }
}






