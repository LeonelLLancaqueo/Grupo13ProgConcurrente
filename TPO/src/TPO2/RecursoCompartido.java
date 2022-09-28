package TPO2;
import java.util.concurrent.Semaphore;
public class RecursoCompartido {
    private int a, b ,c, w, x, y, z;
    private Semaphore permiso1, permiso2, permiso3;

    public RecursoCompartido(int x ,int y ,int z){
         this.x = x;
         this.y = y;
         this.z = z;
         permiso1 = new Semaphore(1);
         permiso2 = new Semaphore(0,true);
         permiso3 = new Semaphore(0,true);

    }

    public void s1() throws InterruptedException{
        permiso1.acquire();
        a= x+y;
        System.out.println("total a: "+ a);
        permiso1.release();
        permiso2.release();
    }
    public void s2() throws InterruptedException{
        permiso1.acquire();
        b= z-1;
        System.out.println("total b: "+ b);
        permiso1.release();
        permiso2.release();
    }
    public void s3() throws InterruptedException{
        permiso2.acquire(2);
        c= a-b;
        System.out.println("total c: "+ c);
        permiso2.release(2);
        permiso3.release();
    }
    public void s4() throws InterruptedException{
        permiso3.acquire();
        w= c+1;
        System.out.println("total w: "+ w);
        permiso3.release();
    }

}
