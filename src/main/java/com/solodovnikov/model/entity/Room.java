package com.solodovnikov.model.entity;

public class Room {
    private Integer id;

    private Integer maxPersons;

    private Integer pricePerNight;

    private Integer status;

    private Integer hotelId;

    public Room() {

    }

    public Room(Integer maxPersons, Integer pricePerNight, Integer status, Integer hotelId) {
        this(-1, maxPersons, pricePerNight, status, hotelId);
    }

    public Room(Integer id, Integer maxPersons, Integer pricePerNight, Integer status, Integer hotelId) {
        this.id = id;
        this.maxPersons = maxPersons;
        this.pricePerNight = pricePerNight;
        this.status = status;
        this.hotelId = hotelId;
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

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "\n======================\nid=" + id + ",\nmaxPersons=" + maxPersons + ",\npricePerNight=" + pricePerNight + ",\nstatus=" + status + ",\nhotelId=" + hotelId;
    }
}
