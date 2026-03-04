/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class StudentView extends JFrame 
        implements ActionListener, WindowListener {

    private JTextField txtID, txtName, txtMoney;
    private JButton btnDeposit, btnWithdraw;

    private Student student;
    private final String FILE_NAME = "StudentM.dat";

    public StudentView() {

        setTitle("StudentProfile");
        setSize(300,200);
        setLayout(new GridLayout(4,2));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);

        add(new JLabel("ID:"));
        txtID = new JTextField();
        add(txtID);

        add(new JLabel("Name:"));
        txtName = new JTextField();
        add(txtName);

        add(new JLabel("Money:"));
        txtMoney = new JTextField("0");
        txtMoney.setEditable(false);
        add(txtMoney);

        btnDeposit = new JButton("Deposit");
        btnWithdraw = new JButton("Withdraw");

        add(btnDeposit);
        add(btnWithdraw);

        btnDeposit.addActionListener(this);
        btnWithdraw.addActionListener(this);

        loadFile();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (student == null) {
            student = new Student(
                    txtName.getText(),
                    Integer.parseInt(txtID.getText()),
                    Integer.parseInt(txtMoney.getText())
            );
        }

        if (e.getSource() == btnDeposit) {
            student.setMoney(student.getMoney() + 100);
            txtMoney.setText(String.valueOf(student.getMoney()));
        }

        if (e.getSource() == btnWithdraw) {
            student.setMoney(student.getMoney() - 100);
            txtMoney.setText(String.valueOf(student.getMoney()));
        }
    }

    private void saveFile() {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            if (student != null) {
                oos.writeObject(student);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadFile() {

        File file = new File(FILE_NAME);

        if (file.exists()) {

            try (ObjectInputStream ois =
                         new ObjectInputStream(
                                 new FileInputStream(file))) {

                student = (Student) ois.readObject();

                txtID.setText(String.valueOf(student.getID()));
                txtName.setText(student.getName());
                txtMoney.setText(String.valueOf(student.getMoney()));

            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        saveFile();
        System.exit(0);
    }

    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    
    public static void main(String[] args) {
        StudentView c = new StudentView();
    }

}
