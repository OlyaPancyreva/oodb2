package Lab7.classes;

import Lab6.annotation.Entity;
import Lab7.annotation.Column;
import Lab7.annotation.Id;
import Lab7.annotation.ManyToOne;
import Lab7.annotation.OneToMany;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
public class Shop {
    @Id
    Long id;
    @Column
    private String name;
}


