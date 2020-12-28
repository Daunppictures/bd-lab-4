package com.solodovnikov.model.dao;

import com.solodovnikov.Connector;
import com.solodovnikov.model.entity.HotelChain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelChainDao implements AbstractDao<HotelChain> {
    public static final String TABLE = "solodovnikov.hotel_chain";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE hotel_chain_id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (name) VALUES (?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET name = ? WHERE hotel_chain_id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE hotel_chain_id = ?;";

    @Override
    public List<HotelChain> findAll() throws SQLException {
        List<HotelChain> hotelChains = new ArrayList<>();

        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                HotelChain hotelChain = new HotelChain(
                        resultSet.getInt("hotel_chain_id"),
                        resultSet.getString("name")
                );
                hotelChains.add(hotelChain);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotelChains;
    }

    @Override
    public HotelChain find(Integer id) throws SQLException {
        HotelChain hotelChain = null;
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                hotelChain = new HotelChain(
                        resultSet.getInt("hotel_chain_id"),
                        resultSet.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotelChain;
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
    public void update(Integer id, HotelChain object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, object.getName());
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(HotelChain object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, object.getName());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
