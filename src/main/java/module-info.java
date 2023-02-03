module com.itproger.itprogerjavafxapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.itproger.itprogerjavafxapp to javafx.fxml;
    exports com.itproger.itprogerjavafxapp;
    exports com.itproger.itprogerjavafxapp.controllers;
    opens com.itproger.itprogerjavafxapp.controllers to javafx.fxml;
    exports com.itproger.itprogerjavafxapp.database;
    opens com.itproger.itprogerjavafxapp.database to javafx.fxml;
    exports com.itproger.itprogerjavafxapp.simple_data;
    opens com.itproger.itprogerjavafxapp.simple_data to javafx.fxml;
}