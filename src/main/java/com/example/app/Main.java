package com.example.app;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Font.loadFont(getClass().getResourceAsStream("/fonts/VT323-Regular.ttf"), 21);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Parking.fxml"));
        Parent root = loader.load();
        ParkingController controller = loader.getController();
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        primaryStage.setTitle("PARKING");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case DOWN -> controller.handleDownPressed(event);
                case UP -> controller.handleUpPressed(event);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

