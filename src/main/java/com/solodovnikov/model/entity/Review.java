package com.solodovnikov.model.entity;
import javax.persistence.*;

@Table(name = "review")
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private String date;


    public Review() {

    }

    public Review(String text, String date) {
        this(-1, text, date);
    }

    public Review(Integer id, String text, String date) {
        this.id = id;
        this.text = text;
        this.date = date;
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

    @Override
    public String toString() {
        return  "\n==========================" +
                "\nid=" + id + "\ntext=" + text + "\ndate=" + date;
    }
}