package com.itproger.itprogerjavafxapp.database;

import com.itproger.itprogerjavafxapp.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configuration {

    Connection databaseConnection;

    public Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + databaseHost + ":" + databasePort + "/" + databaseName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        databaseConnection = DriverManager.getConnection(connectionString, databaseUser, databasePassword);

        return databaseConnection;
    }

    public void singUpUser(User user) {

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
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getLocation());
            preparedStatement.setString(6, user.getGender());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}