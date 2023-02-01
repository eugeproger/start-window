module com.itproger.itprogerjavafxapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.itproger.itprogerjavafxapp to javafx.fxml;
    exports com.itproger.itprogerjavafxapp;
}