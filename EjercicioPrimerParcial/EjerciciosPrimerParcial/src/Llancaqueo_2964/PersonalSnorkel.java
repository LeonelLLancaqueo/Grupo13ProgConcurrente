package Llancaqueo_2964;

public class PersonalSnorkel extends Thread{
    private ParqueAcuatico parqueAcuatico;

    public PersonalSnorkel(ParqueAcuatico parqueAcuatico){
        this.parqueAcuatico = parqueAcuatico;
    }
    public void run(){
        
        try {
            while(true){ // el personal itera infinitamente esperando a nuevos visitantes
                parqueAcuatico.entregarSnorkel();
            }
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
