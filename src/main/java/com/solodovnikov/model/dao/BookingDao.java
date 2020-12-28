package com.solodovnikov.model.dao;

import com.solodovnikov.Connector;
import com.solodovnikov.model.entity.Booking;
import com.solodovnikov.model.entity.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDao implements AbstractDao<Booking> {
    public static final String TABLE = "solodovnikov.booking";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE booking_id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (start_date, end_date, guest_id, room_id) VALUES (?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET start_date = ?, end_date = ?, guest_id = ?, room_id = ? WHERE booking_id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE booking_id = ?;";

    @Override
    public List<Booking> findAll() throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Booking booking = new Booking (
                        resultSet.getInt("booking_id"),
                        resultSet.getString("start_date"),
                        resultSet.getString("end_date"),
                        resultSet.getInt("guest_id"),
                        resultSet.getInt("room_id")
                );
                bookings.add(booking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public Booking find(Integer id) throws SQLException {
        Booking booking = null;
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                booking = new Booking (
                        resultSet.getInt("booking_id"),
                        resultSet.getString("start_date"),
                        resultSet.getString("end_date"),
                        resultSet.getInt("guest_id"),
                        resultSet.getInt("room_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booking;
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
    public void update(Integer id, Booking object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, object.getStartDate());
            statement.setString(2, object.getEndDate());
            statement.setInt(3, object.getGuestId());
            statement.setInt(4, object.getRoomId());
            statement.setInt(5, id);
            statement.executeUpdate();
            System.out.println(statement);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Booking object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, object.getStartDate());
            statement.setString(2, object.getEndDate());
            statement.setInt(3, object.getGuestId());
            statement.setInt(4, object.getRoomId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
