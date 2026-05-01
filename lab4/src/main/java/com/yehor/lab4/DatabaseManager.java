package com.yehor.lab4;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {

    private Connection connection;

    public DatabaseManager(String configPath) {

        try {
            Properties props = new Properties();
            props.load(new FileInputStream(configPath));

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            connection = DriverManager.getConnection(url, user, password);

            System.out.println("DB connected!");

        } catch (Exception e) {
            System.out.println("DB connection error: " + e.getMessage());
        }
    }

    public void insertClothes(Clothes c, String type) {

        String sql = "INSERT INTO clothes(type, name, size, color, price, brand, quantity) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, type);
            ps.setString(2, c.getName());
            ps.setString(3, c.getSize().toString());
            ps.setString(4, c.getColor().toString());
            ps.setDouble(5, c.getPrice());
            ps.setString(6, c.getBrand());
            ps.setInt(7, c.getQuantity());

            ps.executeUpdate();

            System.out.println("Inserted into DB!");

        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }
    }

    // ✔ ДОБАВЛЕНО (щоб не було помилки в Main)
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing DB: " + e.getMessage());
        }
    }
}