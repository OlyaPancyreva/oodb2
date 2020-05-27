package ru.icmit.oodb.lab12.domain.classes;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    Long id;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private int stock;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
