package com.solodovnikov.model.dao;

import com.solodovnikov.model.entity.Phone;
import com.solodovnikov.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao implements AbstractDao<Phone> {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Phone> findAll() throws SQLException {
        List<Phone> phones = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            phones = session.createQuery("from Phone").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return phones;
    }

    @Override
    public Phone find(Integer id) throws SQLException {
        Phone phone = null;
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            phone = session.get(Phone.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return phone;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            Phone phone = session.get(Phone.class, id);
            if (phone != null) {
                session.delete(phone);
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Phone phone) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            session.save(phone);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Phone phone) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            session.save(phone);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}