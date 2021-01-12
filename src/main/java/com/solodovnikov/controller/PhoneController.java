package com.solodovnikov.controller;

import com.solodovnikov.model.dao.PhoneDao;
import com.solodovnikov.model.entity.Phone;

import java.sql.SQLException;
import java.util.List;

public class PhoneController implements AbstractController<Phone>{
    private static final PhoneDao dao = new PhoneDao();

    public PhoneController() {

    }

    @Override
    public List<Phone> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Phone find(Integer id) throws SQLException {
        return dao.find(id);
    }

    @Override
    public void create(Phone entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Phone entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}