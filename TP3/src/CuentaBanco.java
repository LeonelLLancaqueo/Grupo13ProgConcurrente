public class CuentaBanco {
   private int balance= 50;


public int getBalance() {
    return balance;
}

public void setBalance(int balance) {
    this.balance = balance;
}
   
    public  void retiroBancario(int retiro)  {
        balance -= retiro;
    }

}
