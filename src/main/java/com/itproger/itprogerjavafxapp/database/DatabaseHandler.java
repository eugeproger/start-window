package com.itproger.itprogerjavafxapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler extends Configuration {

    Connection databaseConnection;

    public Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + databaseHost + ":" + databasePort + "/" + databaseName;

        Class.forName("com.mysql.jdbc.Driver");

        databaseConnection = DriverManager.getConnection(connectionString, databaseUser, databasePassword);

        return databaseConnection;
    }
}
