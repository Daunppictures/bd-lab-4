package com.solodovnikov.controller;

import com.solodovnikov.model.dao.ReviewDao;
import com.solodovnikov.model.entity.Review;

import java.sql.SQLException;
import java.util.List;

public class ReviewController implements AbstractController<Review>{
    private static final ReviewDao dao = new ReviewDao();

    public ReviewController() {

    }


    @Override
    public List<Review> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Review find(Integer id) throws SQLException {
        return dao.find(id);
    }

    @Override
    public void create(Review entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Review entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
