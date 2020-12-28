package com.solodovnikov.model.entity;

public class Review {
    private Integer id;

    private String text;

    private String date;

    private Integer hotelId;

    public Review() {

    }

    public Review(String text, String date, Integer hotelId) {
        this(-1, text, date, hotelId);
    }

    public Review(Integer id, String text, String date, Integer hotelId) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.hotelId = hotelId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "\n======================\nid=" + id + ",\ntext=" + text + ",\ndate=" + date + ",\nhotelId=" + hotelId;
    }
}
