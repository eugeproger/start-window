package com.itproger.itprogerjavafxapp.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.itproger.itprogerjavafxapp.animations.Shake;
import com.itproger.itprogerjavafxapp.database.DatabaseHandler;
import com.itproger.itprogerjavafxapp.simple_data.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

        sign_up_button.setOnAction(event -> {
            sign_up_button.getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(
                    "/com/itproger/itprogerjavafxapp/views/registration.fxml"
            ));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        sing_in_button.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();

            if (!loginText.equals("") && !loginPassword.equals("")) {
                loginUser(loginText, loginPassword);
            } else {
                System.out.println("Login or password is empty");
            }
        });

    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet resultSet = databaseHandler.getUser(user);

        int counter = 0;
        
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }

        if (counter >= 1) {
            System.out.println("Success!");
        } else {
            Shake userField = new Shake(login_field);
            Shake passwordField = new Shake(password_field);

            userField.playAnimation();
            passwordField.playAnimation();
        }
    }
}
