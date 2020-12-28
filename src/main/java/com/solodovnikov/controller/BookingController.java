package com.solodovnikov.controller;

import com.solodovnikov.model.dao.BookingDao;
import com.solodovnikov.model.entity.Booking;

import java.sql.SQLException;
import java.util.List;

public class BookingController implements AbstractController<Booking> {
    private static final BookingDao dao = new BookingDao();

    public BookingController() {

    }

    @Override
    public List<Booking> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Booking find(Integer id) throws SQLException {
        return dao.find(id);
    }

    @Override
    public void create(Booking entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Booking entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
