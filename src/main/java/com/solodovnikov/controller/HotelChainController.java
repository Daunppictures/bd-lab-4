package com.solodovnikov.controller;

import com.solodovnikov.model.dao.HotelChainDao;
import com.solodovnikov.model.entity.HotelChain;

import java.sql.SQLException;
import java.util.List;

public class HotelChainController implements AbstractController<HotelChain>{
    private static final HotelChainDao dao = new HotelChainDao();

    public HotelChainController() {

    }

    @Override
    public List<HotelChain> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public HotelChain find(Integer id) throws SQLException {
        return dao.find(id);
    }

    @Override
    public void create(HotelChain entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, HotelChain entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
