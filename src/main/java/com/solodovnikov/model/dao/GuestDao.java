package com.solodovnikov.model.dao;

import com.solodovnikov.model.entity.Guest;
import com.solodovnikov.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestDao implements AbstractDao<Guest> {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Guest> findAll() throws SQLException {
        List<Guest> guests = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            guests = session.createQuery("from Guest").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return guests;
    }

    @Override
    public Guest find(Integer id) throws SQLException {
        Guest guest = null;
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            guest = session.get(Guest.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return guest;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            Guest guest = session.get(Guest.class, id);
            if (guest != null) {
                session.delete(guest);
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Guest guest) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            session.save(guest);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Guest guest) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(guest);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}