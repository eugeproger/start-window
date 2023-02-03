package com.itproger.itprogerjavafxapp.database;

import com.itproger.itprogerjavafxapp.simple_data.User;

import java.sql.*;

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

    public ResultSet getUser(User user) {
        ResultSet resultSet = null;

        String select = "SELECT * FROM " +
                Constant.USERS_TABLE +
                " WHERE " +
                Constant.USER_USER_NAME +
                "=? AND " +
                Constant.USER_PASSWORD + "=?";

        try {
            PreparedStatement preparedStatement = getDatabaseConnection().prepareStatement(select);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());

            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }
}