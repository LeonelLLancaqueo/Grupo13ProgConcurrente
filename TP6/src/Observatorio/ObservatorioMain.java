package Observatorio;

public class ObservatorioMain {
    public static void main(String[] args){
        Observatorio observatorio= new Observatorio(10);

        Visitante []arrVisitantes= new Visitante[25];
        VisitanteSillaRuedas []arrVisitantesSilla= new VisitanteSillaRuedas[5];
        EmpleadoMantenimiento []arrEmpleado= new EmpleadoMantenimiento[3];
        Invertigador []arrInvertigador= new Invertigador[2];

        for(int i=0; i< arrVisitantes.length; i++){
            arrVisitantes[i]= new Visitante(observatorio, i);
        }
        for(int i=0; i< arrVisitantesSilla.length; i++){
            arrVisitantesSilla[i]= new VisitanteSillaRuedas(observatorio, i);
        }
        for(int i=0; i< arrEmpleado.length; i++){
            arrEmpleado[i]= new EmpleadoMantenimiento(observatorio, i);
        }
        for(int i=0; i< arrInvertigador.length; i++){
            arrInvertigador[i]= new Invertigador(observatorio, i);
        }
        
        /* ejecutamos los hilos */

        for(int i=0; i< arrVisitantes.length; i++){
            arrVisitantes[i].start();
        }
        for(int i=0; i< arrVisitantesSilla.length; i++){
            arrVisitantesSilla[i].start();
        }
        for(int i=0; i< arrEmpleado.length; i++){
            arrEmpleado[i].start();
        }
        for(int i=0; i< arrInvertigador.length; i++){
            arrInvertigador[i].start();
        }
    
    }

    
}
