package com.solodovnikov.model.dao;

import com.solodovnikov.Connector;
import com.solodovnikov.model.entity.Hotel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDao implements AbstractDao<Hotel> {
    public static final String TABLE = "solodovnikov.hotel";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE hotel_id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (hotel_chain_id, country_id, name) VALUES (?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET hotel_chain_id = ?, country_id = ?, name = ? WHERE hotel_id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE hotel_id = ?;";

    @Override
    public List<Hotel> findAll() throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Hotel hotel = new Hotel (
                        resultSet.getInt("hotel_id"),
                        resultSet.getInt("hotel_chain_id"),
                        resultSet.getInt("country_id"),
                        resultSet.getString("name")
                );
                hotels.add(hotel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotels;
    }

    @Override
    public Hotel find(Integer id) throws SQLException {
        Hotel hotel = null;
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                hotel = new Hotel (
                        resultSet.getInt("hotel_id"),
                        resultSet.getInt("hotel_chain_id"),
                        resultSet.getInt("country_id"),
                        resultSet.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotel;
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
    public void update(Integer id, Hotel object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, object.getHotelChainId());
            statement.setInt(2, object.getCountryId());
            statement.setString(3, object.getName());
            statement.setInt(4, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Hotel object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, object.getHotelChainId());
            statement.setInt(2, object.getCountryId());
            statement.setString(3, object.getName());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
