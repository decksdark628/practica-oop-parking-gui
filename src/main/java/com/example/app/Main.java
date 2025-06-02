package com.example.app;

import com.example.app.controllers.ParkingController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = 480;
    private static Stage primaryStage;
    private static ParkingController controller;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Font.loadFont(getClass().getResourceAsStream("/fonts/VT323-Regular.ttf"), 21);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Parking.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        Main.primaryStage = primaryStage;
        primaryStage.setTitle("PARKING");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

        controller = loader.getController();
        controller.setupKeyHandlers();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void exitApp(){
        if (primaryStage != null){
            primaryStage.close();
        }
    }

    public static Stage getPrimaryStage(){
        return primaryStage;
    }

    public ParkingController getController(){
        return controller;
    }
}

