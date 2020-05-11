package com.ebsolutions.service;

import java.sql.*;

public class DatabaseService {
    private final PreparedStatement preparedStatement = null;
    private Connection connect = null;
    private Statement statement = null;

    public Statement getStatement() throws Exception {
        this.prepStatement();

        return this.statement;
    }

    private void prepStatement() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/Banking?"
                            + "user=root&password=honda1834");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
        } catch (Exception e) {
            throw e;
        }
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

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            System.out.println("Database connection may not have closed correctly.");
        }
    }
}