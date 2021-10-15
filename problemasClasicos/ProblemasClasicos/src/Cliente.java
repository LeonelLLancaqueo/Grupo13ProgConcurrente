public class Cliente extends Thread{
    private Barberia barberia;
    private int numCliente;

    public Cliente(Barberia barberia, int numCliente){
        this.barberia = barberia;
        this.numCliente = numCliente;
    }

    public void run(){
        try {
            System.out.println("El cliente numero:" + numCliente+ " esta caminando hacia la barberia");
            Thread.sleep((int)(Math.random() * 1000));
            if(barberia.solicitarSillon()){
                System.out.println("El cliente numero:" + numCliente+ " solicita un corte de pelo al barbero");
                barberia.solicitarCorte();
                Thread.sleep((int)(Math.random() * 1000));
                System.out.println("El cliente numero:" + numCliente+ " sale de la barberia");
                barberia.salir();
            }else{
                if(barberia.sentarseEnSillaEspera()){
                    System.out.println("El cliente numero:" + numCliente + " se sienta en la silla de espera");
                    barberia.tomarSillon();
                    System.out.println("El cliente numero:" + numCliente+ " solicita un corte de pelo al barbero");
                    barberia.solicitarCorte();
                    Thread.sleep((int)(Math.random() * 1000));
                    System.out.println("El cliente numero:" + numCliente+ " sale de la barberia");
                    barberia.salir();
                }else{
                    System.out.println("El cliente numero:" + numCliente+ " se va pq no hay asiento disponible");
                }
                
            }
            
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}   
