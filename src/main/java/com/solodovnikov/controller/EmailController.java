package com.solodovnikov.controller;

import com.solodovnikov.model.dao.EmailDao;
import com.solodovnikov.model.entity.Email;

import java.sql.SQLException;
import java.util.List;

public class EmailController implements AbstractController<Email>{
    private static final EmailDao dao = new EmailDao();

    public EmailController() {

    }

    @Override
    public List<Email> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Email find(Integer id) throws SQLException {
        return dao.find(id);
    }

    @Override
    public void create(Email entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Email entity) throws SQLException {
        if (dao.find(id) == null) {
            System.out.println("Adress does not exist");
        } else {
            dao.update(id, entity);
        }

    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
