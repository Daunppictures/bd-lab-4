package com.solodovnikov.controller;

import com.solodovnikov.model.dao.RoomDao;
import com.solodovnikov.model.entity.Room;

import java.sql.SQLException;
import java.util.List;

public class RoomController implements AbstractController<Room>{
    private static final RoomDao dao = new RoomDao();

    public RoomController() {

    }

    @Override
    public List<Room> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Room find(Integer id) throws SQLException {
        return dao.find(id);
    }

    @Override
    public void create(Room entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Room entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
