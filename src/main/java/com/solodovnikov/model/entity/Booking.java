package com.solodovnikov.model.entity;

public class Booking {
    private Integer id;

    private String startDate;

    private String endDate;

    private Integer guestId;

    private Integer roomId;

    public Booking() {

    }

    public Booking(String startDate, String endDate, Integer guestId, Integer roomId) {
        this(-1, startDate, endDate, guestId, roomId);
    }

    public Booking(Integer id, String startDate, String endDate, Integer guestId, Integer roomId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guestId = guestId;
        this.roomId = roomId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getStartDate() {

        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "\n======================\nid=" + id + ",\nstartDate=" + startDate + ",\nendDate=" + endDate + ",\nguestId=" + guestId + ",\nroomId=" + roomId;
    }
}
