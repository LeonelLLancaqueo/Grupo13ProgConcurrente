package SociedadProtectoraAnimales;
import java.util.concurrent.Semaphore;

public class Comedero {
    /* COMO CONTROLAR CUANDO FALTAN ANIMALES COMER PARA COMPLETAR EL TOTAL Y YA NO HAY HILOS */
    private Semaphore platos,  esperar, mutexCont, mutexEspecieComiendo; 
    private Semaphore mutexTerminaronComer, mutexLlegoAlgunaE, mutexComedor;
    private int cont, especieComiendo, terminaronDeComer, animalesEsperando; 
    private boolean llegoAlgunaEspecie;

    public Comedero(int cantPlantos){
        especieComiendo= -1;
        platos= new Semaphore(cantPlantos, true);
        esperar= new Semaphore(0, true);
        mutexCont= new Semaphore(1,true);
        mutexLlegoAlgunaE= new Semaphore(1,true);
        mutexEspecieComiendo= new Semaphore(1,true);
        mutexTerminaronComer= new Semaphore(1,true);
        mutexComedor= new Semaphore(1,true);


        //this.cantEspecies= cantEspecies;
        
        //this.maxPorEspecie= maxPorEspecie;
    }

    public boolean comer(int tipoEspecie) throws InterruptedException{
        boolean exito= false;
        mutexComedor.acquire();
        //REVISAR SI SIRVE PARA ALGO MAS GENERICO O 
        if(!llegoAlgunaEspecie){ //´preguntamos si ya llego alguna especien al comedero 
            this.especieComiendo= tipoEspecie; //sino asignamos el id de la espcie como tipoEspecie comiendo
            llegoAlgunaEspecie= true; //marcamos que ya llego una tipoEspecie a comer
        }
        
        if(tipoEspecie == this.especieComiendo  ){ // consulta si pertenece a la tipoEspecie que esta comiendo, y si no supera el limite
            
            if(this.cont < 8){ //preguntar si esta bien
                this.cont++;    
                platos.acquire();  
                exito= true;   
            }
        }else{
            this.animalesEsperando++;      
        }
        mutexComedor.release();
        return exito;
    }
    public void esperar() throws InterruptedException {
        this.esperar.acquire(); 
    }
    public void terminarComer() throws InterruptedException{

        this.platos.release(); // liberamos el plato

        mutexTerminaronComer.acquire();
        this.terminaronDeComer++; //aumentamos la variable de animales q terminaron de comer
        mutexTerminaronComer.release();
        
        if(this.terminaronDeComer == this.cont){ //si la cantidad de animales que terminron de comer es igual a la la cantidad de animales q entrarona  comer entonces
            
            mutexEspecieComiendo.acquire();
            this.especieComiendo++; //cambiamos de turno
            mutexEspecieComiendo.release();

            this.terminaronDeComer=0; // reseteamos las variables contadoras

            mutexCont.acquire();
            this.cont=0;    
            mutexCont.release();

            /*
            mutexCont.acquire();
            if(this.especieComiendo > 1){ // PREGUNTAR SI ESTA BIEN POR QUE TENDRIA Q MODIFICARSE CADA VEZ QUE SE AGREGASE UN tipoEspecie
                this.especieComiendo= 0;
            }
            mutexCont.release();
            */
            llegoAlgunaEspecie= false;

            this.esperar.release(this.animalesEsperando);
        }
        

        
    }
    
}
