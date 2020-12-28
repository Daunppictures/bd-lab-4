package com.solodovnikov.model.entity;

public class Country {
    private Integer id;

    private String country;

    public Country() {

    }

    public Country(String country) {
        this(-1, country);
    }

    public Country(Integer id, String country) {
        this.id = id;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "\n======================\nid=" + id + ",\ncountry=" + country;
    }
}
