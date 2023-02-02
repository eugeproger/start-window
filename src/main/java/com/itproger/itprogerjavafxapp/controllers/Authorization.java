package com.itproger.itprogerjavafxapp.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Authorization {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private Button sign_up_button;

    @FXML
    private Button sing_in_button;

    @FXML
    void initialize() {
        sing_in_button.setOnAction(event ->
        {
            System.out.println("You pressed button \"Sing in\"");
        });

    }

}
