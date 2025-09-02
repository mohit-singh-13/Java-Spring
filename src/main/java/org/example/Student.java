package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Student {
    @Id // this is mentioning that rollNo is the primary key
    private int rollNo;
    private String sName;
    private int sAge;
    @OneToMany(mappedBy = "student")    // we are explicitly telling the Student table to not create a third table because Laptop is keeping the track with "student" field
    private List<Laptop> laptops;

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

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                ", laptop=" + laptops +
                '}';
    }
}
