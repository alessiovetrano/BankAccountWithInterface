import javax.swing.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class BankAccount {

    static BankAccount[] contiCorrenti  = new BankAccount[10];
    private DecimalFormat df = new DecimalFormat("0.00");
    private double balance;
    private double totBalance;
    private int contaDepositi;
    private int contaPrelievi;
    private final double tassoDollaro = 0.97;
    private int numeroConto = 1000000000;

    private boolean dollaro = false;

    public void deposita(int indice, double valore){
        contaDepositi++;
        contiCorrenti[indice].balance += valore;
    }
    public void preleva(int indice, double valore){
        contaPrelievi++;
        contiCorrenti[indice].balance -= valore;
    }
    public void setContoCorrente(){
        for(int i=0;i<contiCorrenti.length;i++){
            contiCorrenti[i].numeroConto += i;
        }
    }

    public void checkBalance(){
        for(int i=0;i<contiCorrenti.length;i++){
            if(contiCorrenti[i].balance > 5000){
                contiCorrenti[i].balance = contiCorrenti[i].balance * 0.90;
            }
        }
    }
    public double convertiValuta(double valore){
        df.setRoundingMode(RoundingMode.UP);
        System.out.println("Il valore in dollari è uguale a " + df.format(valore*tassoDollaro) + "$");
        if(dollaro == false){
            dollaro = true;
            System.out.println("Da euro a dollaro");
            return valore*tassoDollaro;
        } else {
            dollaro = false;
            System.out.println("Da dollaro a euro");
            return valore/tassoDollaro;

        }
    }

    //GETTER
    public double getBalance(int indice){return contiCorrenti[indice].balance;}
    public double getAllBalance(){
        totBalance = 0;
        for(int i=0;i<contiCorrenti.length;i++){
            totBalance += contiCorrenti[i].balance;
        }
        return totBalance;
    }
    public int getNumeroDepositi(){return this.contaDepositi;}
    public int getNumeroPrelievi(){return this.contaPrelievi;}


    //Stampa della lista di tutti i conti
    public void printAllNumber(){
        System.out.println("---CONTI BANCARI DI TUTTA LA BANCA---");
        for(int i=0;i<contiCorrenti.length;i++){
            System.out.println("Numero conto: "+ contiCorrenti[i].numeroConto);
        }
    }

    //STAMPA DELLE INFORMAZIONI
    public void printAllBalance(){System.out.println("Totale bilancio: " + getAllBalance());}
    public void printSingleBalance(int indice){System.out.println("Bilancio: " + getBalance(indice));}
    public void printSingleNumber(int i){System.out.println("Numero conto: " + contiCorrenti[i].numeroConto);}
    public void printNumberDeposit(){System.out.println("Numero depositi: " + getNumeroDepositi());}
    public void printNumberPrelievi(){System.out.println("Numero prelievi: " + getNumeroPrelievi());};

    public static void creaAccount() {
        for(int i=0;i<contiCorrenti.length;i++){
            contiCorrenti[i] = new BankAccount();
        }
    }

}
