package com.solodovnikov.model.entity;

public class Email {
    private Integer id;

    private String email;

    private Integer guestId;

    public Email() {

    }

    public Email(String email, Integer guestId) {
        this(-1, email, guestId);
    }

    public Email(Integer id, String email, Integer guestId) {
        this.id = id;
        this.email = email;
        this.guestId = guestId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    @Override
    public String toString() {
        return "\n======================\nid=" + id + ",\nemail=" + email + ",\nguestId=" + guestId;
    }
}
