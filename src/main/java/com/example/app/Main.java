package com.example.app;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = 480;
    private static Stage primaryStage;
    // public static SharedData sharedData = new SharedData();

    @Override
    public void start(Stage primaryStage) throws IOException {
        Font.loadFont(getClass().getResourceAsStream("/fonts/VT323-Regular.ttf"), 21);
        /*
        sharedData.changeScene("/Parking.fxml", WINDOW_WIDTH, WINDOW_HEIGHT);

        SharedData.getCurrentWindow().setTitle("PARKING");
        SharedData.getCurrentWindow().initStyle(StageStyle.UNDECORATED);
        SharedData.getCurrentWindow().show();
        */

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Parking.fxml"));
        Parent root = loader.load();
        ParkingController controller = loader.getController();
        controller.linkToMain(this);
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        Main.primaryStage = primaryStage;
        primaryStage.setTitle("PARKING");
        primaryStage.setScene(scene);
        // primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();


        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case DOWN -> controller.handleDownPressed();
                case UP -> controller.handleUpPressed();
                case ENTER -> controller.handleEnterPressed();
            }
        });
    }

    public void launchInputWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Input.fxml"));
        Parent inputPopUp = loader.load();

        Stage popUpStage = new Stage();
        popUpStage.initOwner(primaryStage);
        popUpStage.initModality(Modality.WINDOW_MODAL);
        popUpStage.setScene(new Scene(inputPopUp, 426, 121));
        // popUpStage.initStyle(StageStyle.UNDECORATED);
        popUpStage.show();

    }

    public static void exitApp(){
        if (primaryStage != null){
            primaryStage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    // para pasar la referencia de primaryStage a SharedData.
    public static Stage getPrimaryStage(){
        return primaryStage;
    }
}

