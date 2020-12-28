package com.solodovnikov.model.entity;

public class Hotel {
    private Integer id;

    private Integer hotelChainId;

    private Integer countryId;

    private String name;

    public Hotel() {

    }

    public Hotel(Integer hotelChainId, Integer countryId, String name) {
        this(-1, hotelChainId, countryId, name);
    }

    public Hotel(Integer id, Integer hotelChainId, Integer countryId, String name) {
        this.id = id;
        this.hotelChainId = hotelChainId;
        this.countryId = countryId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotelChainId() {
        return hotelChainId;
    }

    public void setHotelChainId(Integer hotelChainId) {
        this.hotelChainId = hotelChainId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n======================\nid=" + id + ",\nhotelChainId=" + hotelChainId + ",\ncountryId=" + countryId + ",\nname=" + name;
    }
}
