package ru.icmit.oodb.lab12.domain.classes;

import javax.persistence.*;

//  реализация сотрудников
@Entity
public class Worker {

    @Id
    @GeneratedValue
    Long id;
    @Column
    private String name;
    @Column
    private String number;
    @Column
    private String gender;
    @Column
    private Double salary;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
