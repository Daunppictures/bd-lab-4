package com.solodovnikov.model.entity;
import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id", referencedColumnName = "id", nullable = false)
    private Review review;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country country;

    public Hotel() {

    }

    public Hotel(String name, Review review, Country country) {
        this(-1, name, review, country);
    }

    public Hotel(Integer id, String name, Review review, Country country) {
        this.id = id;
        this.name = name;
        this.review = review;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "\n==========================" +
                "\nid=" + id + "\nname=" + name + "\nreviewId=" + review + "\ncountryId=" + country;
    }
}