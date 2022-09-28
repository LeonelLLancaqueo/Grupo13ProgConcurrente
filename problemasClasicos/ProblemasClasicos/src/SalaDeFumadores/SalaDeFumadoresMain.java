package SalaDeFumadores;

public class SalaDeFumadoresMain {
    public static void main(String[] args) {
        SalaDeFumadores sala = new SalaDeFumadores();
        Fumador f1 = new Fumador(1, sala);
        Fumador f2 = new Fumador(2, sala);
        Fumador f3 = new Fumador(3, sala);
        Agente ag = new Agente(sala);

        f1.start();
        f2.start();
        f3.start();
        ag.start();
        
    }//main
}
