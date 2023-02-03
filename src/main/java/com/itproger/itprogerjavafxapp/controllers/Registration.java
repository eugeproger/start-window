package com.itproger.itprogerjavafxapp.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.itproger.itprogerjavafxapp.database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Registration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField country_field;

    @FXML
    private CheckBox female_check_box;

    @FXML
    private TextField login_field;

    @FXML
    private CheckBox male_check_box;

    @FXML
    private TextField name_field;

    @FXML
    private TextField password_field;

    @FXML
    private Button sing_up_button;

    @FXML
    private TextField surname_field;

    @FXML
    void initialize() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        sing_up_button.setOnAction(event -> {
            databaseHandler.singUpUser(
                    name_field.getText(),
                    surname_field.getText(),
                    login_field.getText(),
                    password_field.getText(),
                    country_field.getText(),
                    "Male");
        });
    }

}
