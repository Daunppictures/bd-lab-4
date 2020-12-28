package com.solodovnikov.model.dao;

import com.solodovnikov.Connector;
import com.solodovnikov.model.entity.Email;
import com.solodovnikov.model.entity.Guest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailDao implements AbstractDao<Email>{
    public static final String TABLE = "solodovnikov.email";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE email_id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (email, guest_id) VALUES (?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET email = ?, guest_id = ? WHERE email_id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE email_id = ?;";

    @Override
    public List<Email> findAll() throws SQLException {
        List<Email> emails = new ArrayList<>();
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Email email = new Email (
                        resultSet.getInt("email_id"),
                        resultSet.getString("email"),
                        resultSet.getInt("guest_id")
                );
                emails.add(email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emails;
    }

    @Override
    public Email find(Integer id) throws SQLException {
        Email email = null;
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                email = new Email (
                        resultSet.getInt("email_id"),
                        resultSet.getString("email"),
                        resultSet.getInt("guest_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
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
    public void update(Integer id, Email object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, object.getEmail());
            statement.setInt(2, object.getGuestId());
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Email object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, object.getEmail());
            statement.setInt(2, object.getGuestId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
