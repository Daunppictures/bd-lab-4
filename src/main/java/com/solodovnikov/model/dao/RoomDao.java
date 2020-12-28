package com.solodovnikov.model.dao;

import com.solodovnikov.Connector;
import com.solodovnikov.model.entity.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDao implements AbstractDao<Room> {
    public static final String TABLE = "solodovnikov.room";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE room_id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (max_persons, price_per_night, status, hotel_id) VALUES (?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET max_persons = ?, price_per_night = ?, status = ?, hotel_id = ? WHERE room_id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE room_id = ?;";

    @Override
    public List<Room> findAll() throws SQLException {
        List<Room> rooms = new ArrayList<>();

        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Room room = new Room(
                        resultSet.getInt("room_id"),
                        resultSet.getInt("max_persons"),
                        resultSet.getInt("price_per_night"),
                        resultSet.getInt("status"),
                        resultSet.getInt("hotel_id")
                );
                rooms.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public Room find(Integer id) throws SQLException {
        Room room = null;

        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                room = new Room(
                        resultSet.getInt("room_id"),
                        resultSet.getInt("max_persons"),
                        resultSet.getInt("price_per_night"),
                        resultSet.getInt("status"),
                        resultSet.getInt("hotel_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return room;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Room object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, object.getMaxPersons());
            statement.setInt(2, object.getPricePerNight());
            statement.setInt(3, object.getStatus());
            statement.setInt(4, object.getHotelId());
            statement.setInt(5, id);
            statement.executeUpdate();
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Room object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, object.getMaxPersons());
            statement.setInt(2, object.getPricePerNight());
            statement.setInt(3, object.getStatus());
            statement.setInt(4, object.getHotelId());
            statement.executeUpdate();
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
