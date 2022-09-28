package LosBabuinos;

import java.util.concurrent.Semaphore;
    
    public class Soga {
    
        private int lugarDisponible, contBabuinos, babuinosCruzaron, topeBabuinos, turno, babuinoEsperandoTurno, babuinoEsperabdoSoga, babuinosPasaronTotal;
        private boolean  sogaEnUso;
        private Semaphore mutexBabuino, esperar, esperarSoga;
        
        public Soga(int lugarDisponible, int topeBabuinos){
            this.lugarDisponible = lugarDisponible;
            this.topeBabuinos= topeBabuinos;
            turno= -1;
            esperarSoga = new Semaphore(0, true);
            esperar = new Semaphore(0, true);
            mutexBabuino = new Semaphore(1, true);

        }

        /* SOLUCION UTILIZANDO SEMAFOROS BINARIOS */
        public void tomarSoga(int nroTurno) throws InterruptedException{
            mutexBabuino.acquire(); //mutex utilizado para q un solo babuino pueda ejecutar el metodo a la vez
            boolean continuar= false;
        
            
            while(!continuar){ //mientras no se den las condiciones para que el babuino pase seguira en el bucle

                if(!sogaEnUso){ // UTILIZO ESTE IF PARA LA PRIMERA VEZ Q ENTRA UN BABUINO
                    sogaEnUso= true; //MARCO EN TRUE PARA SABER Q YA HAY BABUINOS CRUZANDO
                    turno= nroTurno; // LE ASIGNO SU TURNO AL TURNO DE LA SOGA
                }
                   
                 //
                 
                if( nroTurno == turno && contBabuinos < topeBabuinos){ // el babuino consulta si no se supero la cantidad de babuinos que podian cruzar y  si es su turno 
                    contBabuinos++; // cuento la cantidad de babuinos que solicitan la soga
                    boolean tomarSoga= false; //boolean utilizado para indicar si el babuino puede tomar la soga
                    while(!tomarSoga){ //si el babuino tiene la posibilidad de tomar la soga pero aun no estan dadas las condiciones para que suceda se quedara en bucle

                        if(lugarDisponible > 0){ //si quedan lugares en la soga 
                            lugarDisponible--; //toma un lugar en la soga
                            tomarSoga= true; //marcamos en true para que pueda salir del bucle
                        }else{

                            babuinoEsperabdoSoga++; //sino aumentamos el contador de babuinos esperando la soga
 
                            
                            mutexBabuino.release(); //liberamos el semaforo antes de que se bloque al babuino
                            
                            esperarSoga.acquire(); //queda esperando a q se libere un lugar en la soga
                            
                            mutexBabuino.acquire(); //tomamos de nuevo el mutex para seguir 
                            
                            babuinoEsperabdoSoga--; //retamos la cantidad de babuinos esperando la soga
                        }
                    }
                    continuar= true; //EL BABUINO PUEDE CRUZAR EL ACANTILADO y marcamos en true para que puedan salir del bucle
                    
                }else{
                    
                    babuinoEsperandoTurno++; //marcamos al babuino
                    mutexBabuino.release();

                    esperar.acquire(); //si no es su turno entonces espera
                    
                    mutexBabuino.acquire();
                    babuinoEsperandoTurno--;
                }
        
                
            }
            mutexBabuino.release();
                
            

        }

        public void soltarSoga() throws InterruptedException{
            mutexBabuino.acquire();
            lugarDisponible++; //liberamos un lugar en la soga
            System.out.println(" lugares disponibles "+ lugarDisponible);
            babuinosCruzaron++;
            System.out.println("babuinos cruzaron "+ babuinosCruzaron );
            babuinosPasaronTotal++;
            System.out.println("babuinos pasaron en total "+ babuinosPasaronTotal);
            
            if(babuinoEsperabdoSoga > 0){ //consultamos si todavia hay babuinos del mismo turno esperando por tomar la soga 
                esperarSoga.release();
            }else{
                if(babuinosCruzaron == contBabuinos){ //cuando terminaron de pasar todos lo babuinos por la soga
                    babuinosCruzaron=0;
                    contBabuinos=0;
                    turno= -1;
                    sogaEnUso= false;
                    esperar.release(babuinoEsperandoTurno);
                }

            }        
            mutexBabuino.release();
        }

}
