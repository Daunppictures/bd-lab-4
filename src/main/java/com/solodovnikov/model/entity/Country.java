package com.solodovnikov.model.entity;
import javax.persistence.*;

@Table(name = "country")
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Country() {

    }

    public Country(String country) {
        this(-1, country);
    }

    public Country(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String country) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "\n==========================" +
                "\nid=" + id + "\nname=" + name;
    }
}