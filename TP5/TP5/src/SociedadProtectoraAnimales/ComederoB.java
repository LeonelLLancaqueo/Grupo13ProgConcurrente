package SociedadProtectoraAnimales;
import java.util.concurrent.Semaphore;

public class ComederoB {
    /* COMO CONTROLAR CUANDO FALTAN ANIMALES COMER PARA COMPLETAR EL TOTAL Y YA NO HAY HILOS */
    private Semaphore platos,  esperar, mutexCont, mutexEspecieComiendo, mutexTerminaronComer, mutexLlegoAlgunaE;
    private int cont, especieComiendo, terminaronDeComer, animalesEsperando;
    private static final int turnoPerro= 0, turnoGato=1, cantMaxPorTurno= 5; 
    private boolean llegoAlgunaEspecie;

    public ComederoB(int cantPlantos){
        this.especieComiendo= -1;
        this.platos= new Semaphore(cantPlantos, true);
        this.esperar= new Semaphore(0, true);
        this.mutexCont= new Semaphore(1,true);
        this.mutexLlegoAlgunaE= new Semaphore(1,true);
        this.mutexEspecieComiendo= new Semaphore(1,true);
        this.mutexTerminaronComer= new Semaphore(1,true);


        //this.cantEspecies= cantEspecies;
        
        //this.maxPorEspecie= maxPorEspecie;
    }

    public boolean comer(int especie) throws InterruptedException{
        boolean exito= false;
        mutexLlegoAlgunaE.acquire();
        //REVISAR SI SIRVE PARA ALGO MAS GENERICO O 
        if(!llegoAlgunaEspecie && especie != this.especieComiendo){ //´preguntamos si ya llego alguna especien al comedero 
            this.especieComiendo= especie; //sino asignamos el id de la espcie como especie comiendo
            llegoAlgunaEspecie= true; //marcamos que ya llego una especie a comer
        }
        mutexLlegoAlgunaE.release();
        if(especie == this.especieComiendo  ){ // consulta si pertenece a la especie que esta comiendo, y si no supera el limite

            if(this.cont < cantMaxPorTurno){ //todavia pueden seguir comiendo 
                this.cont++;
                platos.acquire();  
                exito= true;   
            }
        }else{
            this.animalesEsperando++;      
        }
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
            if(this.especieComiendo > 1){ // PREGUNTAR SI ESTA BIEN POR QUE TENDRIA Q MODIFICARSE CADA VEZ QUE SE AGREGASE UN ESPECIE
                this.especieComiendo= 0;
            }
            mutexCont.release();
            */
            llegoAlgunaEspecie= false;

            this.esperar.release(this.animalesEsperando);
        }
        

        
    }
}
