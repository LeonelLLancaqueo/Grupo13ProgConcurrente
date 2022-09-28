package CenaDeFilosofos;

public class Filosofo extends Thread{
    private Mesa mesa;
    private int nro;

    public Filosofo(Mesa mesa, int nro){
        this.mesa = mesa;
        this.nro = nro;
    }

    public void run(){
        while(true){
            try {
                mesa.tomarTenedores(nro);
                mesa.cenar();
                System.out.println("El filosofo "+nro+" esta cenando");
                Thread.sleep(5000); //(int)(Math.floor(Math.random()*(2000-1000+1)+1000))
                System.out.println("El filosofo "+nro+" termino de cenar deja los tenedores");
                mesa.dejarTenedores();
            }
            catch (InterruptedException err) {
                System.out.println(err.getMessage());
            }
        }

    }


}
