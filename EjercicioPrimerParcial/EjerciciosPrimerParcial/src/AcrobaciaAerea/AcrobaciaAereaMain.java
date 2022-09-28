package AcrobaciaAerea;


public class AcrobaciaAereaMain {
    
    public static void main(String[] args){
        Salon salon= new Salon();
        ControladorAct controladorAct= new ControladorAct(salon);
        Persona []persona= new Persona[12];
        for(int i=0; i < persona.length; i++){
            persona[i]= new Persona(salon,i);
        }
        controladorAct.start();
        for(int i=0; i < persona.length; i++){
            persona[i].start();
        }
    }

}
