package Trafico;

import java.util.concurrent.Semaphore;

public class Puente {
    private Semaphore esperar , mutexPuenteEnUso, mutexAutosNorteEsperando, mutexAutosSurEsperando, mutexAutoNorte, mutexAutoSur, mutexTurnoNorte, mutexTurnoSur, mutexAutosNortePasando, mutexAutosSurPasando;
    private int autosNortePasando, autosSurPasando, autosNorteEsperando, autosSurEsperando, contAutosNorte, contAutosSur;
    private boolean turnoSur, turnoNorte, puenteEnUso;

    public Puente() {

        esperar = new Semaphore(0,true);
        mutexAutoNorte = new Semaphore(1,true);
        mutexAutoSur = new Semaphore(1,true);
        mutexPuenteEnUso = new Semaphore(1,true);
        mutexAutosNorteEsperando = new Semaphore(1,true);
        mutexAutosSurEsperando = new Semaphore(1,true);
        mutexAutosNortePasando = new Semaphore(1,true);
        mutexAutosSurPasando = new Semaphore(1,true);
        mutexTurnoSur = new Semaphore(1,true);
        mutexTurnoNorte = new Semaphore(1,true);

    }

    public void entrarCocheNorte() throws InterruptedException{
        boolean continuar= false;
        
        while(!continuar){
            mutexAutoNorte.acquire();

            mutexPuenteEnUso.acquire();
            if(!puenteEnUso){
                //mutexTurnoNorte.acquire();
                turnoNorte= true;
                //mutexTurnoNorte.release();

                puenteEnUso= true;
            }
            mutexPuenteEnUso.release();
            
            mutexTurnoNorte.acquire(); //TOME EL MUTEX DE TURNO
            if(!turnoNorte ){
                mutexTurnoNorte.release(); // LO LIBERA
                mutexAutosNorteEsperando.acquire();
                autosNorteEsperando++;
                System.out.println("autos norte esperando "+autosNorteEsperando);
                mutexAutosNorteEsperando.release();

                mutexAutoNorte.release();

                esperar.acquire();

                mutexAutoNorte.acquire();

                mutexAutosNorteEsperando.acquire();
                autosNorteEsperando--;
                mutexAutosNorteEsperando.release();
            }else{

                autosNortePasando++; //cambiar por autoNorte
                contAutosNorte++;
                if(contAutosNorte > 10 && autosSurEsperando>0){
                    
                    turnoNorte= false;

                }
                mutexTurnoNorte.release();
                continuar= true;
            }

            mutexAutoNorte.release();
        }

        
        
    }

    public void salirCocheDelNorte() throws InterruptedException{
        mutexAutoNorte.acquire();
        autosNortePasando--;
        
        System.out.println(autosNortePasando);
        if(autosNortePasando == 0){ //cambiar por autonorte
            contAutosNorte=0;

            mutexTurnoNorte.acquire();
            turnoNorte= false;
            mutexTurnoNorte.release();
        
            mutexPuenteEnUso.acquire();
            puenteEnUso= false;
            mutexPuenteEnUso.release();

            mutexAutosSurEsperando.acquire();
            esperar.release(autosSurEsperando);
            mutexAutosSurEsperando.release();
            
        }
        
        mutexAutoNorte.release();


    }
    public void entrarCocheSur() throws InterruptedException{
        boolean continuar= false;
        
        while(!continuar){
            mutexAutoSur.acquire();
            mutexPuenteEnUso.acquire();
            if(!puenteEnUso){
                mutexTurnoSur.acquire();
                turnoSur= true;
                mutexTurnoSur.release();

                puenteEnUso= true;
            }
            mutexPuenteEnUso.release();
            
            mutexTurnoSur.acquire(); //TOME EL MUTEX DE TURNO
            if(!turnoSur){
                mutexTurnoSur.release(); // LO LIBERA
                mutexAutosSurEsperando.acquire();
                autosSurEsperando++;
                System.out.println("autos sur esperando "+autosSurEsperando);
                mutexAutosSurEsperando.release();

                mutexAutoSur.release();
                esperar.acquire();

                mutexAutoSur.acquire();

                mutexAutosSurEsperando.acquire();
                autosSurEsperando--;
                mutexAutosSurEsperando.release();
            }else{

                autosSurPasando++; //cambiar por autoNorte
                contAutosSur++;
                mutexAutosNorteEsperando.acquire();
                if(contAutosSur > 10 && autosNorteEsperando>0){
                    
                    System.out.println("llega aca?");
                    turnoSur= false;
                    
                }
                mutexAutosNorteEsperando.release();

                mutexTurnoSur.release();
                continuar= true; // lo dejamos aca pq solo puede salir del bucle si es su turno
            }
            
            mutexAutoSur.release();
        }

        
        
    }

    public void salirCocheDelSur() throws InterruptedException{
        mutexAutoSur.acquire();
        autosSurPasando--;
        
        System.out.println(autosSurPasando);
        if(autosSurPasando == 0 ){ //cambiar por autonorte
            contAutosSur=0;
            mutexTurnoSur.acquire();

            turnoSur= false;
            mutexTurnoSur.release();
        
            mutexPuenteEnUso.acquire();

            puenteEnUso= false;
            mutexPuenteEnUso.release();

            mutexAutosNorteEsperando.acquire();

            esperar.release(autosNorteEsperando);
            mutexAutosNorteEsperando.release();
            
        }
        
        mutexAutoSur.release();


    }

    
}
