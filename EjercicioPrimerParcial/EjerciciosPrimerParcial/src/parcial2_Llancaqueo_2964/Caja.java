package parcial2_Llancaqueo_2964;

/*
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition; */

public class Caja {
    //private Lock lock;
    //private Condition embotellador;
    private int botellasEnCaja, horaEmpaquetado;
    private boolean cajaLlena;
    private int tipo;
    private boolean listaRetirar;

    public Caja(int tipo){
        //lock= new ReentrantLock(true);
        //embotellador= lock.newCondition();
        botellasEnCaja=0;
        cajaLlena= false;
        this.tipo= tipo;
        listaRetirar= false;
        horaEmpaquetado=0;

    }
    public void agregarBotella() throws InterruptedException{
        //lock.lock();
        if(botellasEnCaja < 6){
            botellasEnCaja++;
        }else{
            cajaLlena = true;
        }
        //lock.unlock();
    }
    public void vaciarCaja() throws InterruptedException{
        botellasEnCaja=0;
        cajaLlena= false;
    }
    public boolean getCajaLlena(){
        return cajaLlena;
    }
    public int getTipo(){
        return tipo;
    }
    public int getBotellasEnCaja() {
        return botellasEnCaja;
    }
    
    public void setBotellasEnCaja(int botellasEnCaja) {
        this.botellasEnCaja = botellasEnCaja;
    }

    public void setCajaLlena(boolean cajaLlena) {
        this.cajaLlena = cajaLlena;
    }
    public Caja clone(){
        Caja unacaja= new Caja(tipo);
        if(botellasEnCaja > 0){
            unacaja.botellasEnCaja= this.botellasEnCaja;       
            unacaja.cajaLlena= this.cajaLlena;
            unacaja.horaEmpaquetado= this.horaEmpaquetado;

        }
        return unacaja;
    }
    public void empaquetado(int horaEmpaquetado){
        this.horaEmpaquetado= horaEmpaquetado;
    }
    public boolean listaRetirar(int horaActual){
        return true;
    }
    
    


}
