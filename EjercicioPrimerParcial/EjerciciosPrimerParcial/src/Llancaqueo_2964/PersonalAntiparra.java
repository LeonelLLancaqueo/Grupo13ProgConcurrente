package Llancaqueo_2964;

public class PersonalAntiparra extends Thread{
    private ParqueAcuatico parqueAcuatico;

    public PersonalAntiparra(ParqueAcuatico parqueAcuatico){
        this.parqueAcuatico = parqueAcuatico;
    }
    public void run(){
        
        try {
            while(true){// el personal itera infinitamente esperando a nuevos visitantes
                System.out.println("El personal de antiparra puedo entregar la antiparra " + parqueAcuatico.entregarAntipara());
            }
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }

}
