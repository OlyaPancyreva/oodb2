package Lab7.classes;

import Lab6.annotation.Column;
import Lab6.annotation.Entity;
import Lab7.annotation.Id;
import Lab7.annotation.ManyToOne;

import java.util.Comparator;

@Entity
public class Product {

    @Id
    Long id;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private int stock;

}
