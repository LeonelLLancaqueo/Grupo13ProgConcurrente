package Pasteleria;

public class PasteleriaMain {
    public static void main(String[] args){
        Mostrador mostrador= new Mostrador(10);
        BrazoMecanico brazoMecanico= new BrazoMecanico(mostrador);
        RobotEmpaquetador []arrRobotEmpaquetador= new RobotEmpaquetador[2];
        Horno []arrHorno= new Horno[3];
        
        for(int i=0; i<arrRobotEmpaquetador.length; i++){
            arrRobotEmpaquetador[i]= new RobotEmpaquetador(mostrador, i);
        }
        for(int i=0; i<arrHorno.length; i++){
            arrHorno[i]= new Horno(mostrador, i, i); //el peso va a ser el i
        }
        brazoMecanico.start();
        for(int i=0; i<arrRobotEmpaquetador.length; i++){
            arrRobotEmpaquetador[i].start();
        }
        for(int i=0; i<arrHorno.length; i++){
            arrHorno[i].start();
        }

    }
}
