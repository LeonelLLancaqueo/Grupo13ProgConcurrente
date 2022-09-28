package CuartelSoldados;

public class Comedor {
    private int capacidad, abridores, soldadosEnComedor, mostradorAlmuerzo, mostradorPostre;

    public Comedor(int capacidad, int abridores, int mostradorAlmuerzo, int mostradorPostre){
        this.capacidad = capacidad;
        this.abridores = abridores;
        this.mostradorAlmuerzo = mostradorAlmuerzo;
        this.mostradorPostre = mostradorPostre;

    }
    public synchronized void solicitarEntrar() throws InterruptedException{
        while(soldadosEnComedor > capacidad){
            System.out.println("soldado esperando a poder entrar al comedor");
            this.wait();
        }
        soldadosEnComedor++;
    }

    public synchronized void solicitarBandeja() throws InterruptedException{
        while(mostradorAlmuerzo == 0){
            System.out.println("soldado esperando a que se desocupe un mostrador");
            this.wait();
        }
        mostradorAlmuerzo--;

        this.notifyAll(); //iria un notify aca?
        
    }

    public synchronized void tomarBandeja() throws InterruptedException{
        mostradorAlmuerzo++;
        this.notifyAll();
    }

    public synchronized void solicitarAbridor() throws InterruptedException{
        while(abridores == 0){
            System.out.println("soldado esperando a que se desocupe un abridor");
            this.wait();
        }
        abridores--;

    }

    public synchronized void terminarUsarAbridor(){
        abridores++;
        this.notifyAll();
    }

    public synchronized void solicitarPostre() throws InterruptedException{
        while(mostradorPostre == 0){
            System.out.println("soldado esperando a que se desocupe un mostrador de postres");
            this.wait();
        }
        mostradorPostre--;
        this.notifyAll();
    }


    public synchronized void tomarPostre() throws InterruptedException{
        mostradorPostre++;
        this.notifyAll();
    }

    public synchronized void comer(){
        
    }

    public synchronized void dejarBandeja(){
        soldadosEnComedor--;
        this.notifyAll();
    }


}
