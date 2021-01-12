package com.solodovnikov.model.dao;

import com.solodovnikov.model.entity.Room;
import com.solodovnikov.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDao implements AbstractDao<Room> {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Room> findAll() throws SQLException {
        List<Room> rooms = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            rooms = session.createQuery("from Room").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public Room find(Integer id) throws SQLException {
        Room room = null;

        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            room = session.get(Room.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return room;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            Room room = session.get(Room.class, id);
            if (room != null) {
                session.delete(room);
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Room room) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            session.save(room);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Room room) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            session.save(room);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}