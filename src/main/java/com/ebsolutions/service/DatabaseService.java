package com.ebsolutions.service;

import java.sql.*;

public class DatabaseService {
    private Connection connection = null;
    private Statement statement = null;

    public Statement getStatement() throws Exception {
        if (statement == null) {
            this.prepStatement();
        }

        return this.statement;
    }

    public PreparedStatement getPreparedStatement(String query) throws Exception {
        if (connection == null) {
            this.prepConnection();
        }

        return this.connection.prepareStatement(query);
    }

    private void prepConnection() throws Exception {
        // Setup the connection with the DB
        connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/Banking?user=root&password=honda1834");

    }

    private void prepStatement() throws Exception {
        if (connection == null) {
            this.prepConnection();
        }
        statement = connection.createStatement();
    }

    public void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            System.out.println("Result set may not have closed correctly.");
        }
    }

    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("Database connection may not have closed correctly.");
        }
    }
}