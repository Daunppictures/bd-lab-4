package com.solodovnikov.model.dao;

import com.solodovnikov.Connector;
import com.solodovnikov.model.entity.Country;
import com.solodovnikov.model.entity.Guest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDao implements AbstractDao<Country> {
    public static final String TABLE = "solodovnikov.country";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE country_id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (country) VALUES (?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET country = ? WHERE country_id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE country_id = ?;";

    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<>();
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Country country = new Country (
                        resultSet.getInt("country_id"),
                        resultSet.getString("country")
                );
                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public Country find(Integer id) throws SQLException {
        Country country = null;
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                country = new Country (
                        resultSet.getInt("country_id"),
                        resultSet.getString("country")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
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
    public void update(Integer id, Country object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, object.getCountry());
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Country object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, object.getCountry());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
