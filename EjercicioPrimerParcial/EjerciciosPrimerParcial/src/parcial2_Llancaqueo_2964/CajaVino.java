package parcial2_Llancaqueo_2964;

public class CajaVino extends Caja{
    private int horaEmpaquetado;
    public CajaVino(int tipo){
        super(tipo);
    }

    public boolean listaRetirar(int horaActual){
        return (horaActual - horaEmpaquetado) < 10;
    }

}
