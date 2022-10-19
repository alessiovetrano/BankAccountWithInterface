
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window {
    BankAccount conti = new BankAccount();
    final int ALTEZZA = 600;
    final int LARGHEZZA = 400;

    /*Gestione dell'interfaccia grafica*/
    public Window(){
        JFrame finestra = new JFrame("BANCOMAT EXCERCISE");

        finestra.setBounds(0,0,LARGHEZZA,ALTEZZA);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Chiudere finestra
        finestra.setResizable(false);
        // PANEL
        JPanel displayPanel = new JPanel();
        JPanel numericPanel = new JPanel();
        JPanel informationPanel = new JPanel();
        //displayPanel.setBounds(0,0,LARGHEZZA,ALTEZZA);
        finestra.setLayout(new BorderLayout());
        displayPanel.setBackground(new Color(23,75,120)); //RGB
        finestra.add(displayPanel,BorderLayout.NORTH);
        finestra.add(numericPanel, BorderLayout.CENTER);
        finestra.add(informationPanel,BorderLayout.SOUTH);
        numericPanel.setLayout(new GridLayout(4,3));
        numericPanel.setBackground(new Color(23,75,120)); //RGB
        informationPanel.setLayout(new GridLayout(4,1));
        informationPanel.setBackground(new Color(23,75,120)); //RGB

        ArrayList<String> choiseCount = new ArrayList<>();
        //Tasti da 0 a 9
        JButton [] buttons = new JButton[10];
        JButton cancelButton = new JButton("Cancel");
        JButton depositButton = new JButton("Deposita");
        JButton prelevaButton = new JButton("Preleva");
        JButton buttonCambioValuta = new JButton("Cambio valuta");
        JLabel schermataImporto = new JLabel();
        schermataImporto.setForeground(Color.WHITE);


        for(int i=0;i<=9;i++){
            choiseCount.add(String.valueOf(i));
            buttons[i] = new JButton(choiseCount.get(i));
            numericPanel.add(buttons[i]);
            final int tmp = i;
            buttons[i].addActionListener(e-> schermataImporto.setText(schermataImporto.getText() + String.valueOf(tmp)));
        }
        //Selezione del Conto Corrente
        JLabel sceltaConto = new JLabel("Conto numero: ");
        sceltaConto.setForeground(Color.WHITE);
        JComboBox boxList = new JComboBox(choiseCount.toArray());
        displayPanel.add(sceltaConto);
        displayPanel.add(boxList);

        /* Bottoni EXTRA */
        cancelButton.addActionListener(e-> schermataImporto.setText(""));
        numericPanel.add(buttonCambioValuta);
        numericPanel.add(depositButton);
        numericPanel.add(prelevaButton);
        numericPanel.add(cancelButton);
        numericPanel.add(cancelButton);
        displayPanel.add(schermataImporto);

        //Numero Prelievi


        JLabel bilancioConto = new JLabel("Bilancio : ");
        bilancioConto.setForeground(Color.WHITE);
        JLabel bilancioTotale = new JLabel("Bilancio Totale : ");
        bilancioTotale.setForeground(Color.WHITE);
        JLabel numeroDepositiLabel = new JLabel("Numero di depositi");
        numeroDepositiLabel.setForeground(Color.WHITE);
        JLabel numeroPrelieviLabel = new JLabel("Numero di prelievi");
        numeroPrelieviLabel.setForeground(Color.WHITE);


        informationPanel.add(bilancioConto);
        informationPanel.add(bilancioTotale);
        informationPanel.add(numeroDepositiLabel);
        informationPanel.add(numeroPrelieviLabel);

        buttonCambioValuta.addActionListener(e->{
            bilancioTotale.setText("Bilancio totale: "+ String.valueOf(conti.convertiValuta(conti.getAllBalance())) + "$");
            bilancioConto.setText("Bilancio : " + String.valueOf(conti.convertiValuta(conti.getBalance(boxList.getSelectedIndex()))) + "$");
        });

        depositButton.addActionListener(e ->
        {
            conti.deposita(boxList.getSelectedIndex(),Double.parseDouble(schermataImporto.getText()));
            numeroDepositiLabel.setText("Depositi: " + String.valueOf(conti.getNumeroDepositi()));
            bilancioConto.setText("Bilancio : " + String.valueOf(conti.getBalance(boxList.getSelectedIndex())));
            bilancioTotale.setText("Bilancio totale: "+ String.valueOf(conti.getAllBalance()));
            schermataImporto.setText("");


        });

        prelevaButton.addActionListener(e ->
        {
            conti.preleva(boxList.getSelectedIndex(),Double.parseDouble(schermataImporto.getText()));
            numeroPrelieviLabel.setText("Prelievi: " + String.valueOf(conti.getNumeroPrelievi()));
            bilancioConto.setText("Bilancio : " + String.valueOf(conti.getBalance(boxList.getSelectedIndex())));
            bilancioTotale.setText("Bilancio totale: "+ String.valueOf(conti.getAllBalance()));
            schermataImporto.setText("");
        });

        finestra.setVisible(true);

    }




}
