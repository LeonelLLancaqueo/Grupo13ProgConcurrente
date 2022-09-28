package TPO2;

public class t1 extends Thread{
    private RecursoCompartido rc;
    public t1(RecursoCompartido rc) {
        this.rc = rc;
    }
    public void run(){
        try {
            rc.s1();
            rc.s3();
            
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }

}
