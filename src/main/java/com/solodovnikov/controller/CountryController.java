package com.solodovnikov.controller;

import com.solodovnikov.model.dao.CountryDao;
import com.solodovnikov.model.entity.Country;

import java.sql.SQLException;
import java.util.List;

public class CountryController implements AbstractController<Country>{
    private static final CountryDao dao = new CountryDao();

    public CountryController() {

    }

    @Override
    public List<Country> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Country find(Integer id) throws SQLException {
        return dao.find(id);
    }

    @Override
    public void create(Country entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Country entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
