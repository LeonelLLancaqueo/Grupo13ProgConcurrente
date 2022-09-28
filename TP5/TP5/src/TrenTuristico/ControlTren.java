package TrenTuristico;

public class ControlTren extends Thread {
    private trenMejorado tren;
    public ControlTren(trenMejorado tren) {
        this.tren = tren;
    }

    public void run() {
        try {
            while (true) {
                tren.habilitarTren();
                Thread.sleep((int)(Math.random() * 1000));
                tren.terminarRecorrido();
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}
