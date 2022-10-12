import java.awt.*;


public class Main {
    public static void main(String[] args) {

        BankAccount.creaAccount();
        BankAccount conti = new BankAccount();
        Window window = new Window();

        conti.setContoCorrente();

       /* conti.deposita(1, 100);
        conti.deposita(3, 100);
        conti.deposita(2, 100);
        conti.deposita(3, 100);
        conti.preleva(3,20);
        conti.preleva(1,20);
        conti.preleva(2,20);
        conti.preleva(4,20);
        conti.printAllBalance();
        conti.checkBalance();
        conti.printNumberDeposit();
        conti.printNumberPrelievi();
        conti.printSingleBalance(3);
        conti.printAllNumber();
        conti.convertiValuta(conti.getBalance(3));
        */

    }
}