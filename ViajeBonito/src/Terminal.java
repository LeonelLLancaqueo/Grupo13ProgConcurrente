public class Terminal {
    private char id;
    private int embarque[];
    

    public Terminal(char id, int []embarque){
        this.id = id;
        this.embarque = embarque;
    }


    public char getId() {
        return id;
    }


    public void setId(char id) {
        this.id = id;
    }


    public int[] getEmbarque() {
        return embarque;
    }


    public void setEmbarque(int[] embarque) {
        this.embarque = embarque;
    }
    
}
