package com.solodovnikov.controller;

import com.solodovnikov.model.dao.HotelDao;
import com.solodovnikov.model.entity.Hotel;

import java.sql.SQLException;
import java.util.List;

public class HotelController implements AbstractController<Hotel>{
    private static final HotelDao dao = new HotelDao();

    public HotelController() {

    }


    @Override
    public List<Hotel> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Hotel find(Integer id) throws SQLException {
        return dao.find(id);
    }

    @Override
    public void create(Hotel hotel) throws SQLException {
        dao.create(hotel);
    }

    @Override
    public void update(Integer id, Hotel hotel) throws SQLException {
        dao.update(id, hotel);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}