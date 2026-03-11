/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;

public class MyFrame1 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("My Timer");

        MyTimer timer = new MyTimer();

        Thread t = new Thread(timer);

        t.start();

        frame.add(timer);

        frame.setSize(350,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
