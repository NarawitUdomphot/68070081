/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;

public class Poring extends JFrame {

    private JLabel label;
    private JLabel lcount;
    private JFrame frame;
    private int count = 0;
    public Poring() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(300,300);
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon("poring1.jpg");
        label = new JLabel(icon);
        lcount = new JLabel("0");

        frame.add(label);
        frame.add(lcount);
        frame.setVisible(true);
        
    }
    public void counter(){
        count++;
        lcount.setText(String.valueOf(count));
    }
    
}
