package CentroDeImpresion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
public class CentroCopiadoMain {
      /*  
    public static void cargaInicial(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Leonel LLancaqueo\\Desktop\\Materias\\Segundo Año\\Segundo Cuatrimestre\\ProgramacionConcurrente\\usuarioImpresion.txt"));
            String lineas;
            while((lineas = br.readLine())  != null){

            }
        } catch (IOException e) {
            //TODO: handle exception
        }
        
    }*/
    
    public static void main(String[] args){
        
        CentroDelCopiado cm= new CentroDelCopiado();

        cm.insertarImpresora('A');
        //cm.insertarImpresora('A');
        //cm.insertarImpresora('A');
        cm.insertarImpresora('B');
        cm.insertarImpresora('B');
        //cm.insertarImpresora('B');
        //cm.insertarImpresora('A');
        cm.insertarImpresora('A');

        usuarioImpresion usarioA= new usuarioImpresion("leonel",'A',cm);
        usuarioImpresion usarioB= new usuarioImpresion("Juan",'B',cm);
        usuarioImpresion usarioC= new usuarioImpresion("Pedro",'B',cm);
        usuarioImpresion usarioD= new usuarioImpresion("Diego",'A',cm);
        usuarioImpresion usarioE= new usuarioImpresion("Nemo",'B',cm);
        usuarioImpresion usarioF= new usuarioImpresion("Daniel",'A',cm);
        usuarioImpresion usarioG= new usuarioImpresion("Fernando",'A',cm);
        usuarioImpresion usarioH= new usuarioImpresion("Rodrigues",'A',cm);
        usuarioImpresion usarioI= new usuarioImpresion("Herrera",'A',cm);
        usuarioImpresion usarioJ= new usuarioImpresion("Pedro",'A',cm);
        usuarioImpresion usarioK= new usuarioImpresion("Palacios",'A',cm);
        usuarioImpresion usarioL= new usuarioImpresion("Eze",'A',cm);
        usuarioImpresion usarioM= new usuarioImpresion("Dario",'A',cm);
        usuarioImpresion usarioN= new usuarioImpresion("Brian",'A',cm);
        usuarioImpresion usarioO= new usuarioImpresion("Agustin",'A',cm);
        usuarioImpresion usarioP= new usuarioImpresion("lihue",'A',cm);

        
            usarioA.start();
            usarioB.start();
            usarioC.start();
            usarioD.start();
            usarioE.start();
            usarioF.start();
            usarioG.start();
            usarioH.start();
            usarioI.start();
            usarioJ.start();
            usarioK.start();
            usarioL.start();
            usarioM.start();
            usarioN.start();
            usarioO.start();
            usarioP.start();
       

    }    
}
