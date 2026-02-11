
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
public class CalculatorSample {
    private double num1 = 0;
    private double num2 = 0;
    private String operator = "";
    public CalculatorSample(){
        JFrame fr = new JFrame("CalculatorSample");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 350);
        fr.setLayout(new BorderLayout());
        JTextField display = new JTextField();
        display.setSize(300, 50);
        fr.add(display, BorderLayout.NORTH);
        JPanel pn = new JPanel();
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        JButton bm = new JButton("X");
        JButton bmi = new JButton("-");
        JButton bp = new JButton("+");
        JButton bd = new JButton("/");
        JButton be = new JButton("=");
        JButton bc = new JButton("c");
        pn.setLayout(new GridLayout(4, 4));
        pn.add(b7);     pn.add(b8);     pn.add(b9);     pn.add(bp);
        pn.add(b4);     pn.add(b5);     pn.add(b6);     pn.add(bmi);
        pn.add(b1);     pn.add(b2);     pn.add(b3);     pn.add(bm);
        pn.add(b0);     pn.add(bc);     pn.add(be);     pn.add(bd);
        fr.add(pn, BorderLayout.CENTER);
        fr.setVisible(true);
        pn.setVisible(true);   
        
        ActionListener numberListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JButton btn = (JButton)e.getSource();
                display.setText(display.getText() + btn.getText());
            }
        };

        b0.addActionListener(numberListener);
        b1.addActionListener(numberListener);
        b2.addActionListener(numberListener);
        b3.addActionListener(numberListener);
        b4.addActionListener(numberListener);
        b5.addActionListener(numberListener);
        b6.addActionListener(numberListener);
        b7.addActionListener(numberListener);
        b8.addActionListener(numberListener);
        b9.addActionListener(numberListener);

        ActionListener operatorListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num1 = Double.parseDouble(display.getText());
                JButton btn = (JButton)e.getSource();
                operator = btn.getText();
                display.setText("");
            }
        };

        bp.addActionListener(operatorListener);
        bmi.addActionListener(operatorListener);
        bm.addActionListener(operatorListener);
        bd.addActionListener(operatorListener);

        be.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                num2 = Double.parseDouble(display.getText());
                double result = 0;

                if(operator.equals("+")){
                    result = num1 + num2;
                }
                else if(operator.equals("-")){
                    result = num1 - num2;
                }
                else if(operator.equals("X")){
                    result = num1 * num2;
                }
                else if(operator.equals("/")){
                    result = num1 / num2;
                }

                display.setText(String.valueOf(result));
            }
        });

        bc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                display.setText("");
                num1 = 0;
                num2 = 0;
                operator = "";
            }
        });

        fr.setVisible(true);
    }
    public static void main(String[] args) {
       CalculatorSample cs = new CalculatorSample();
    }
}
