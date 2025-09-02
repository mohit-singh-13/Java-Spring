package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id // this is mentioning that rollNo is the primary key
    private int rollNo;
    private String sName;
    private int sAge;
    private Laptop laptop;

    public int getRollNo() {
        return this.rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getsName() {
        return this.sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return this.sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                ", laptop=" + laptop +
                '}';
    }
}
