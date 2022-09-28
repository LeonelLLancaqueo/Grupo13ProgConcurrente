package SalaDeFumadores;

public class Fumador extends Thread{
    private int id;
    private SalaDeFumadores sala;
    public Fumador(int id, SalaDeFumadores sala){
        this.id = id;
        this.sala = sala;
    }//constructor

    public void run(){
        while(true){
            try {
                sala.entraFumar(id);
                System.out.println("entra a fumar el fumador: " + id);
                Thread.sleep(1250);
                sala.terminarFumar();
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }
    }
}
