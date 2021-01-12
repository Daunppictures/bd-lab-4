package com.solodovnikov.controller;

import com.solodovnikov.model.dao.GuestDao;
import com.solodovnikov.model.entity.Guest;

import java.sql.SQLException;
import java.util.List;

public class GuestController implements AbstractController<Guest>{
    private static final GuestDao dao = new GuestDao();

    public GuestController() {

    }

    @Override
    public List<Guest> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Guest find(Integer id) throws SQLException {
        return dao.find(id);
    }

    @Override
    public void create(Guest entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Guest entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}