package com.solodovnikov.model.dao;

import com.solodovnikov.Connector;
import com.solodovnikov.model.entity.Passport;
import com.solodovnikov.model.entity.Phone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassportDao implements AbstractDao<Passport> {
    public static final String TABLE = "solodovnikov.passport";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE passport_id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (code, guest_id) VALUES (?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET code = ?, guest_id = ? WHERE passport_id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE passport_id = ?;";

    @Override
    public List<Passport> findAll() throws SQLException {
        List<Passport> passports = new ArrayList<>();

        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Passport passport = new Passport(
                        resultSet.getInt("passport_id"),
                        resultSet.getInt("code"),
                        resultSet.getInt("guest_id")
                );
                passports.add(passport);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passports;
    }

    @Override
    public Passport find(Integer id) throws SQLException {
        Passport passport = null;
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                passport = new Passport(
                        resultSet.getInt("passport_id"),
                        resultSet.getInt("code"),
                        resultSet.getInt("guest_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passport;
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
    public void update(Integer id, Passport object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, object.getCode());
            statement.setInt(2, object.getGuestId());
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Passport object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, object.getCode());
            statement.setInt(2, object.getGuestId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
