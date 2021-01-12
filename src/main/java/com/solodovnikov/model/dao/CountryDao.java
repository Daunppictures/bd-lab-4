package com.solodovnikov.model.dao;

import com.solodovnikov.model.entity.Country;
import com.solodovnikov.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDao implements AbstractDao<Country> {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            countries = session.createQuery("from Country ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public Country find(Integer id) throws SQLException {
        Country country = null;
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            country = session.get(Country.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            Country country = session.get(Country.class, id);
            if (country != null) {
                session.delete(country);
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Country country) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Country country) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}