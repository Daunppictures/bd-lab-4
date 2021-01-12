package com.solodovnikov.model.dao;

import com.solodovnikov.model.entity.Hotel;
import com.solodovnikov.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDao implements AbstractDao<Hotel> {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Hotel> findAll() throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            hotels = session.createQuery("from Hotel").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotels;
    }

    @Override
    public Hotel find(Integer id) throws SQLException {
        Hotel hotel = null;
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            hotel = session.get(Hotel.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotel;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            Hotel hotel = session.get(Hotel.class, id);
            if (hotel != null) {
                session.delete(hotel);
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Hotel hotel) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            session.save(hotel);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Hotel hotel) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            session.save(hotel);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}