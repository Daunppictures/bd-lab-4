package com.solodovnikov;

import java.sql.*;

public class App {
    private static final String url = "jdbc:mysql://localhost:3306/solodovnikov?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String user = "root";
    private static final String password = "Idonotnubas2001";

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet rs = null;


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT COUNT(*) FROM hotel");

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.format("\ncount: %d\n", count);
            }
            //SELECT * FROM hotel
            rs = statement.executeQuery("SELECT * FROM hotel");
            System.out.format("\nTable hotel ----------------------------------------------------\n");
            System.out.format("%3s %-12s %-12s %20s\n", "hotel_id", "hotel_chain_id", "country_id", "name");
            while (rs.next()) {
                int hotel_id = rs.getInt("hotel_id");
                int hotel_chain_id = rs.getInt("hotel_chain_id");
                int country_id = rs.getInt("country_id");
                String name = rs.getString("name");
                System.out.format("%4d %12d %12d %30s\n", hotel_id, hotel_chain_id, country_id, name);
            }
        } catch (
                ClassNotFoundException e) {
            System.out.println("MySQL Driver is not loaded");
        } catch (
                SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            if (statement != null) try {
                statement.close();
            } catch (SQLException e) {
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }
}
