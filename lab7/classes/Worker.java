package Lab7.classes;

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
}
