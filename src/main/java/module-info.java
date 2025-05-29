module com.example.app {
    requires javafx.controls;
    requires org.slf4j;
    requires javafx.fxml;

    opens com.example.app to javafx.fxml;

    exports com.example.app;
}