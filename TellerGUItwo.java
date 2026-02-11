/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Narawit
 */
public class TellerGUItwo {
    private Account acc;
    public TellerGUItwo() {
        acc = new Account(6000);
        JFrame frame = new JFrame("Teller GUI");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        JLabel lblBalance = new JLabel("Balance");
        JTextField txtBalance = new JTextField("6000");

        JLabel lblAmount = new JLabel("Amount");
        JTextField txtAmount = new JTextField();

        JButton btnDeposit = new JButton("Deposit");
        JButton btnWithdraw = new JButton("Withdraw");
        JButton btnExit = new JButton("Exit");
        JPanel pn1 = new JPanel();
        pn1.setLayout(new GridLayout(2,2));
        pn1.add(lblBalance);    pn1.add(txtBalance);
        pn1.add(lblAmount);     pn1.add(txtAmount);
        frame.add(pn1, BorderLayout.NORTH);
        JPanel pn2 = new JPanel();
        pn2.setLayout(new GridLayout(1,3));
        pn2.add(btnDeposit);    pn2.add(btnWithdraw);   pn2.add(btnExit);
        frame.add(pn2, BorderLayout.SOUTH);
        pn1.setVisible(true);
        pn2.setVisible(true);
        frame.setVisible(true);
        
        btnDeposit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                double amount = Double.parseDouble(txtAmount.getText());
                acc.deposit(amount);
                txtBalance.setText(String.valueOf(acc.getBalance()));
                txtAmount.setText("");
            }
        });

        
        btnWithdraw.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                double amount = Double.parseDouble(txtAmount.getText());
                acc.withdraw(amount);
                txtBalance.setText(String.valueOf(acc.getBalance()));
                txtAmount.setText("");
            }
        });

        btnExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        TellerGUItwo Tlg = new TellerGUItwo();
    }
}
