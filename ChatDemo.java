/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
public class ChatDemo {
    private JTextArea txta;
    private final String FILE_NAME = "ChatDemo.dat";
    public ChatDemo(){
        JFrame fr = new JFrame("ChatDemo");
        fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        fr.setLayout(new BorderLayout());
        JButton Submit = new JButton("Submit");
        JButton Reset = new JButton("Reset");
        txta = new JTextArea();
        txta.setLineWrap(true);
        txta.setWrapStyleWord(true);
        txta.setSize(45,20);
        txta.setEditable(false);
        loadFile();
        JTextField txtf = new JTextField();
        txtf.setSize(45,0);
        JPanel pnl = new JPanel();
        pnl.setLayout(new FlowLayout());
        pnl.add(Submit);
        pnl.add(Reset);
        JPanel pnsr = new JPanel();
        pnsr.setLayout(new BorderLayout());
        pnsr.add(txta, BorderLayout.CENTER);
        pnsr.add(txtf, BorderLayout.SOUTH);
        fr.add(pnsr, BorderLayout.CENTER);
        fr.add(pnl, BorderLayout.SOUTH);
        fr.setVisible(true);
        pnl.setVisible(true);
        Submit.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                 txta.append(dtf.format(LocalDateTime.now()) + " : " + txtf.getText() + "\n");
                 txtf.setText("");
             }
        });
        Reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txta.setText("");
            }
        });
        fr.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveFile();
                System.exit(0);
            }
        });
        fr.setVisible(true);
        
    }
    private void loadFile() {

        File file = new File(FILE_NAME);

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    txta.append(line + "\n");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    private void saveFile() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bw.write(txta.getText());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
       ChatDemo cs = new ChatDemo();
    }
}
