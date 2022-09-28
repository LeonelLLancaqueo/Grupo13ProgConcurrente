package TPO2;

public class t2 extends Thread{
    private RecursoCompartido rc;
    public t2(RecursoCompartido rc) {
        this.rc = rc;
    }
    public void run(){
        try {
            rc.s2();
            rc.s4();
        }
        catch (InterruptedException err) {
            System.out.println(err.getMessage());
        }
    }
}
