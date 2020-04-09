package Lab8.classes;

import Lab6.annotation.Column;
import Lab6.annotation.Entity;
import Lab7.annotation.Id;
import Lab7.annotation.ManyToOne;

import java.util.Comparator;

//  реализация сотрудников
@Entity
public class Worker {

    @Id
    Long id;
    @Column
    private String name;
    @Column
    private String number;
    @Column
    private char gender;
    @Column
    private double salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
