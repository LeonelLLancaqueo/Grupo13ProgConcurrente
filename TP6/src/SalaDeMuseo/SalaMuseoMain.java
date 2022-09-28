package SalaDeMuseo;

public class SalaMuseoMain {
    public static void main(String[] args){
        SalaMuseo sala= new SalaMuseo(23);
        Persona []arrPersonas= new Persona[125];
        PersonaJubilada []arrPersonasJub= new PersonaJubilada[25];
        
        /* inicializamos los hilos */
        for(int i=0; i<arrPersonas.length; i++){
            arrPersonas[i]= new Persona(sala);
        }
        for(int i=0; i<arrPersonasJub.length; i++){
            arrPersonasJub[i]= new PersonaJubilada(sala);
        }

        /* ejecutamos los hilos */
        for(int i=0; i<arrPersonas.length; i++){
            arrPersonas[i].start();
        }
        for(int i=0; i<arrPersonasJub.length; i++){
            arrPersonasJub[i].start();
        }

        ControlTemperatura cT= new ControlTemperatura(sala);
        cT.start();
        

    }
}
