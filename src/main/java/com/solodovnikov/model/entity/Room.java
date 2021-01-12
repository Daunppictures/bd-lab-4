package com.solodovnikov.model.entity;
import javax.persistence.*;

@Table(name = "room")
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "max_persons")
    private Integer maxPersons;

    @Column(name = "price_per_night")
    private Integer pricePerNight;

    @Column(name = "status")
    private Integer status;

    public Room() {

    }

    public Room(Integer maxPersons, Integer pricePerNight, Integer status) {
        this(-1, maxPersons, pricePerNight, status);
    }

    public Room(Integer id, Integer maxPersons, Integer pricePerNight, Integer status) {
        this.id = id;
        this.maxPersons = maxPersons;
        this.pricePerNight = pricePerNight;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxPersons() {
        return maxPersons;
    }

    public void setMaxPersons(Integer maxPersons) {
        this.maxPersons = maxPersons;
    }

    public Integer getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Integer pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return  "\n==========================" +
                "\nid=" + id + "\nmaxPersons=" + maxPersons + "\npricePerNight=" + pricePerNight + "\nstatus=" + status;
    }
}