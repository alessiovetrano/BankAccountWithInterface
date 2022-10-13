
import javax.swing.*;
import java.awt.*;

public class Window {
    BankAccount conti = new BankAccount();
    int ALTEZZA = 600;
    int LARGHEZZA = 400;
    /*Gestione dell'interfaccia grafica*/
    public Window(){
        JFrame finestra = new JFrame("BANCOMAT ATM");

        finestra.setBounds(0,0,LARGHEZZA,ALTEZZA);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Chiudere finestra
        finestra.setLayout(new BorderLayout());
        // PANEL
        JPanel displayPanel = new JPanel();
        displayPanel.setBounds(0,0,LARGHEZZA,ALTEZZA);
        displayPanel.setBackground(new Color(23,75,120)); //RGB
        finestra.add(displayPanel);
        //LABEL

        displayPanel.setLayout(new GridLayout(5,2));

        //displayPanel.setLayout(null);
        //TEXT FIELD
        JTextField importo = new JTextField("Importo");
        importo.setSize(50,50);
        displayPanel.add(importo);
        JTextField numero_conto = new JTextField("Numero Conto");
        importo.setSize(50,50);
        displayPanel.add(numero_conto);

        //Button
        JButton buttonTextField = new JButton("Deposita");
        buttonTextField.setForeground(new Color(0,95,182));
        JButton buttonTextField2 = new JButton("Preleva");
        buttonTextField2.setForeground(new Color(0,95,182));
        JButton buttonTextField3 = new JButton("Visualizza tutto il bilancio della banca");
        buttonTextField3.setForeground(new Color(0,95,182));
        JButton buttonTextField4 = new JButton("Visualizza bilancio del conto");
        buttonTextField4.setForeground(new Color(0,95,182));
        JButton buttonTextField5 = new JButton("Visualizza numero depositi");
        buttonTextField5.setForeground(new Color(0,95,182));
        JButton buttonTextField6 = new JButton("Visualizza numero prelievi");
        buttonTextField6.setForeground(new Color(0,95,182));

        //Numero Prelievi
        JLabel bilancioConto = new JLabel("Bilancio : ");
        bilancioConto.setForeground(Color.WHITE);
        JLabel bilancioTotale = new JLabel("Bilancio Totale : ");
        bilancioTotale.setForeground(Color.WHITE);
        JLabel numeroDepositiLabel = new JLabel("Numero di depositi");
        numeroDepositiLabel.setForeground(Color.WHITE);
        JLabel numeroPrelieviLabel = new JLabel("Numero di prelievi");
        numeroPrelieviLabel.setForeground(Color.WHITE);


        buttonTextField.addActionListener(e ->
        {
            conti.deposita(Integer.parseInt(numero_conto.getText()),Double.parseDouble(importo.getText()));

        });

        buttonTextField2.addActionListener(e ->
        {
            conti.preleva(Integer.parseInt(numero_conto.getText()),Double.parseDouble(importo.getText()));
        });
        buttonTextField3.addActionListener(e -> {
                    conti.printAllBalance();
                    bilancioTotale.setText("Bilancio totale: " + String.valueOf(conti.getAllBalance()));

                }
        );
        buttonTextField4.addActionListener(e ->
                {
                    conti.printSingleBalance(Integer.parseInt(numero_conto.getText()));
                    bilancioConto.setText("Bilancio : " + String.valueOf(conti.getBalance(Integer.parseInt(numero_conto.getText()))));

                }
        );
        buttonTextField5.addActionListener(e -> {
            conti.printNumberDeposit();
            numeroDepositiLabel.setText("Depositi: " + String.valueOf(conti.getNumeroDepositi()));
        }
        );
        buttonTextField6.addActionListener(e -> {
                    conti.printNumberPrelievi();
                    numeroPrelieviLabel.setText("Prelievi: " + String.valueOf(conti.getNumeroPrelievi()));

                }
        );
        displayPanel.add(buttonTextField);
        displayPanel.add(buttonTextField2);
        displayPanel.add(buttonTextField3);
        displayPanel.add(buttonTextField4);
        displayPanel.add(buttonTextField5);
        displayPanel.add(buttonTextField6);
        displayPanel.add(bilancioConto);
        displayPanel.add(bilancioTotale);
        displayPanel.add(numeroDepositiLabel);
        displayPanel.add(numeroPrelieviLabel);
        finestra.setVisible(true);

    }




}
