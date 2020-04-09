package Lab7.classes;

import Lab6.annotation.Entity;
import Lab7.annotation.Column;
import Lab7.annotation.Id;
import Lab7.annotation.ManyToOne;

@Entity
public class City{

    @Id
    Long id;
    @Column
    String city;
    @Column
    String address;
    @Column
    String hours;
}
