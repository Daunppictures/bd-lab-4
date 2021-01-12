package com.solodovnikov.model.dao;

import com.solodovnikov.model.entity.Review;
import com.solodovnikov.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDao implements AbstractDao<Review> {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Review> findAll() throws SQLException {
        List<Review> reviews = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            reviews = session.createQuery("from Review").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public Review find(Integer id) throws SQLException {
        Review review = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            review = session.get(Review.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return review;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            Review review = session.get(Review.class, id);
            if (review != null) {
                session.delete(review);
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Review review) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            session.save(review);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Review review) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            session.save(review);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}