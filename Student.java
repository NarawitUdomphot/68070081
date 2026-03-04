/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private int ID;
    private int money;

    public Student() {
    }

    public Student(String name, int ID, int money) {
        this.name = name;
        this.ID = ID;
        this.money = money;
    }

    // ===== Getter =====
    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getMoney() {
        return money;
    }

    // ===== Setter =====
    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
