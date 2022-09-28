package CenaDeFilosofos;

public class Mesa {
    private int cantTenedores;

    public Mesa(int cantTenedores) {
        this.cantTenedores = cantTenedores;
    }
    public synchronized void tomarTenedores( int nro) throws InterruptedException{
        while(cantTenedores - 2 < 0){
            System.out.println("El filosofo "+nro+" esta pensando ");
            this.wait();
        }
        cantTenedores= cantTenedores-2; 
        
    }
    public synchronized void cenar() throws InterruptedException{

    }

    public synchronized void dejarTenedores() throws InterruptedException{
        cantTenedores= cantTenedores + 2; 
        this.notifyAll();
    }
}
