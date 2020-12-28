package com.solodovnikov.model.entity;

public class Passport {
    private Integer id;

    private Integer code;

    private Integer guestId;

    public Passport() {

    }

    public Passport(Integer code, Integer guestId) {
        this(-1, code, guestId);
    }

    public Passport(Integer id, Integer code, Integer guestId) {
        this.id = id;
        this.code = code;
        this.guestId = guestId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    @Override
    public String toString() {
        return "\n======================\nid=" + id + ",\ncode=" + code + ",\nguestId=" + guestId;
    }
}
