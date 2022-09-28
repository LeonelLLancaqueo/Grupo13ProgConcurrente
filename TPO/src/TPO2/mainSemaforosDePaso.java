package TPO2;

public class mainSemaforosDePaso {
 
    public static void main(String[] args){
        RecursoCompartido rc= new RecursoCompartido(1,2,3);
        t1 t1= new t1(rc);
        t2 t2= new t2(rc);
        
        t2.start();
        t1.start();


    }

}
