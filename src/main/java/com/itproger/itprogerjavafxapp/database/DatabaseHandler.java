package com.itproger.itprogerjavafxapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configuration {

    Connection databaseConnection;

    public Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + databaseHost + ":" + databasePort + "/" + databaseName;

        Class.forName("com.mysql.jdbc.Driver");

        databaseConnection = DriverManager.getConnection(connectionString, databaseUser, databasePassword);

        return databaseConnection;
    }

    public void singUpUser(
            String firstName,
            String lastName,
            String userName,
            String password,
            String location,
            String gender
    ) {
        String insert = "INSERT INTO " +
                Constant.USERS_TABLE +
                "(" +
                Constant.USER_FIRST_NAME + ", " +
                Constant.USER_LAST_NAME + ", " +
                Constant.USER_USER_NAME + ", " +
                Constant.USER_PASSWORD + ", " +
                Constant.USER_LOCATION + ", " +
                Constant.USERS_GENDER +
                ")" +
                "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDatabaseConnection().prepareStatement(insert);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, location);
            preparedStatement.setString(6, gender);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
