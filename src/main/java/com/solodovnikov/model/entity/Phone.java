package com.solodovnikov.model.entity;

public class Phone {
    private Integer id;

    private String number;

    private Integer guestId;

    public Phone() {

    }

    public Phone(String number, Integer guestId) {
        this(-1, number, guestId);
    }

    public Phone(Integer id, String number, Integer guestId) {
        this.id = id;
        this.number = number;
        this.guestId = guestId;
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

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    @Override
    public String toString() {
        return "\n======================\nid=" + id + ",\nnumber=" + number + ",\nguestId=" + guestId;
    }
}
