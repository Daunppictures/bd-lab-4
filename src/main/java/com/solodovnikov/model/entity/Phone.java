package com.solodovnikov.model.entity;
import javax.persistence.*;

@Table(name = "phone")
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "number")
    private String number;


    public Phone() {

    }

    public Phone(String number) {
        this(-1, number);
    }

    public Phone(Integer id, String number) {
        this.id = id;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return  "\n==========================" +
                "\nid=" + id + "\nnumber=" + number;
    }
}