package com.itproger.itprogerjavafxapp.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.itproger.itprogerjavafxapp.simple_data.User;
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
        sing_up_button.setOnAction(event -> {
            singUnNewUser();
        });
    }

    private void singUnNewUser() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        String firstName = name_field.getText();
        String lastName = surname_field.getText();
        String userName = login_field.getText();
        String password = password_field.getText();
        String location = country_field.getText();
        String gender;

        if(male_check_box.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }

        User user = new User(
                firstName,
                lastName,
                userName,
                password,
                location,
                gender
        );

        databaseHandler.singUpUser(user);
    }
}