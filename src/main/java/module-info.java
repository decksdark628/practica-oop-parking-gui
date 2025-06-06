module com.example.app {
    requires javafx.controls;
    requires org.slf4j;
    requires javafx.fxml;

    opens com.example.app to javafx.fxml;

    exports com.example.app;
    exports com.example.app.controllers;
    opens com.example.app.controllers to javafx.fxml;
    exports com.example.app.model;
    opens com.example.app.model to javafx.fxml;
    exports com.example.app.model.utils;
    opens com.example.app.model.utils to javafx.fxml;
    exports com.example.app.model.vehicles;
    opens com.example.app.model.vehicles to javafx.fxml;
    exports com.example.app.model.interfaces;
    opens com.example.app.model.interfaces to javafx.fxml;
}