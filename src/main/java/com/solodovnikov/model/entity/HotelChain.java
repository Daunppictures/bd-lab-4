package com.solodovnikov.model.entity;

public class HotelChain {
    private Integer id;

    private String name;

    public HotelChain() {

    }

    public HotelChain(String name) {
        this(-1, name);
    }

    public HotelChain(Integer id, String name) {
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n======================\nid=" + id + ",\nname=" + name;
    }
}
