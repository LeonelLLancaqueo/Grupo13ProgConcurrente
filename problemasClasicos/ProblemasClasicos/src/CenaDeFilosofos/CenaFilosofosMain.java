package CenaDeFilosofos;

public class CenaFilosofosMain {
    public static void main(String[] args){
        Mesa mesa= new Mesa(5);
        Filosofo []arrFilosofo= new Filosofo[5];

        for(int i=0; i<arrFilosofo.length; i++){
            arrFilosofo[i]= new Filosofo(mesa, i);
        }
        for(int i=0; i<arrFilosofo.length; i++){
            arrFilosofo[i].start();
        }
    }
}
