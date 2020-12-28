package com.solodovnikov.controller;

import com.solodovnikov.model.dao.PassportDao;
import com.solodovnikov.model.entity.Passport;

import java.sql.SQLException;
import java.util.List;

public class PassportController implements AbstractController<Passport>{
    private static final PassportDao dao = new PassportDao();

    public PassportController() {

    }

    @Override
    public List<Passport> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Passport find(Integer id) throws SQLException {
        return dao.find(id);
    }

    @Override
    public void create(Passport entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Passport entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
