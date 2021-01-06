package com.solodovnikov.model.dao;

import com.solodovnikov.Connector;
import com.solodovnikov.model.entity.Review;
import com.solodovnikov.model.entity.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDao implements AbstractDao<Review> {
    public static final String TABLE = "solodovnikov.review";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE review_id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (text, date, hotel_id) VALUES (?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET text = ?, date = ?, hotel_id = ? WHERE review_id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE review_id = ?;";

    @Override
    public List<Review> findAll() throws SQLException {
        List<Review> reviews = new ArrayList<>();

        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Review review = new Review(
                        resultSet.getInt("review_id"),
                        resultSet.getString("text"),
                        resultSet.getString("date"),
                        resultSet.getInt("hotel_id")
                );
                reviews.add(review);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public Review find(Integer id) throws SQLException {
        Review review = null;
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                review = new Review(
                        resultSet.getInt("review_id"),
                        resultSet.getString("text"),
                        resultSet.getString("date"),
                        resultSet.getInt("hotel_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return review;
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
    public void update(Integer id, Review object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, object.getText());
            statement.setString(2, object.getDate());
            statement.setInt(3, object.getHotelId());
            statement.setInt(4, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Review object) throws SQLException {
        try (PreparedStatement statement = Connector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, object.getText());
            statement.setString(2, object.getDate());
            statement.setInt(3, object.getHotelId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
