package LosToboganes;

public class Encargado  extends Thread{
    private Tobogan tobogan;

    public Encargado(Tobogan tobogan){
        this.tobogan = tobogan;
    }

    public void run(){
        while(true){
            try {
                tobogan.habitilarTobogan();
                System.out.println("El encargado habilito un tobogan");
            }
            catch (Exception err) {
                System.out.println(err.getMessage());
            }
        }
    }
}
