/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PoringConstructor extends JFrame 
        implements ActionListener, WindowListener {

    private JButton btnAdd;
    private Poring poring;

    public PoringConstructor() {

        setTitle("Controller");
        setSize(200,150);
        setLayout(new FlowLayout());

        btnAdd = new JButton("Add");

        add(btnAdd);

        btnAdd.addActionListener(this);

        addWindowListener(this);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        poring = new Poring();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnAdd){

            Thread t = new Thread(){
                public void run(){
                    poring.counter();
                }
            };

            t.start();
        }
    }

    public void windowClosing(WindowEvent e) {

        poring.dispose();
        dispose();
        System.exit(0);
    }

    public void windowOpened(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    
    public static void main(String[] args) {

        PoringConstructor c = new PoringConstructor();

    }
}