package com.example.projectpattern;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Seisagatova20082020^^";

    // Private constructor to prevent instantiation
    private DatabaseConnection() {
        // Logic to establish database connection
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get the database connection instance
    public static Connection getConnection() {
        if (connection == null) {
            new DatabaseConnection(); // Create a new instance if it doesn't exist
        }
        return connection;
    }
}
