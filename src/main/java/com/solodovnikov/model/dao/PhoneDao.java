package com.solodovnikov.model.dao;

import com.solodovnikov.Connector;
import com.solodovnikov.model.entity.Phone;
import com.solodovnikov.model.entity.Review;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao implements AbstractDao<Phone> {
    public static final String TABLE = "solodovnikov.phone";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE phone_id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (number, guest_id) VALUES (?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET number = ?, guest_id = ? WHERE phone_id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE phone_id = ?;";

    @Override
    public List<Phone> findAll() throws SQLException {
        List<Phone> phones = new ArrayList<>();

        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Phone phone = new Phone(
                        resultSet.getInt("phone_id"),
                        resultSet.getString("number"),
                        resultSet.getInt("guest_id")
                );
                phones.add(phone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phones;
    }

    @Override
    public Phone find(Integer id) throws SQLException {
        Phone phone = null;
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                phone = new Phone(
                        resultSet.getInt("phone_id"),
                        resultSet.getString("number"),
                        resultSet.getInt("guest_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phone;
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
    public void update(Integer id, Phone object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, object.getNumber());
            statement.setInt(2, object.getGuestId());
            statement.setInt(3, id);
            System.out.println(statement);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Phone object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, object.getNumber());
            statement.setInt(2, object.getGuestId());
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
