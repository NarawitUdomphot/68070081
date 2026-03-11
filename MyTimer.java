/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;

public class MyTimer extends JLabel implements Runnable {

    int sec = 0;
    int min = 0;
    int hour = 0;

    public void run() {

        while(true) {

            sec++;

            if(sec == 60){
                sec = 0;
                min++;
            }

            if(min == 60){
                min = 0;
                hour++;
            }

            setFont(new Font("Arial", Font.BOLD, 60));

            String time = String.format("%02d:%02d:%02d", hour, min, sec);

            setText(time);

            try{
                Thread.sleep(1000);
            }catch(Exception e){}

        }

    }

}
