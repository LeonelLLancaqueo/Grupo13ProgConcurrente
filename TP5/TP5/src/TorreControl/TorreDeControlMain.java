package TorreControl;

public class TorreDeControlMain {
    public static void main(String[] args) {
        Pista pista= new Pista();
        AvionDespegue []arrAvionDespegue= new AvionDespegue[10];
        AvionAterrizaje []arrAvionAterrizaje= new AvionAterrizaje[5];

        for(int i=0; i<arrAvionDespegue.length; i++){
            arrAvionDespegue[i]= new AvionDespegue(pista, i);
        }
        for(int i=0; i<arrAvionAterrizaje.length; i++){
            arrAvionAterrizaje[i]= new AvionAterrizaje(pista, i);
        }
        for(int i=0; i<arrAvionDespegue.length; i++){
            arrAvionDespegue[i].start();
        }
        for(int i=0; i<arrAvionAterrizaje.length; i++){
            arrAvionAterrizaje[i].start();
        }


    }

}
