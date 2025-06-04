package com.example.app;

import com.example.app.controllers.ParkingController;
import com.example.app.model.*;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Font.loadFont(getClass().getResourceAsStream("/fonts/VT323-Regular.ttf"), 21);

        SceneManager sceneManager = new SceneManager();
        KeyHandler keyhandler = new KeyHandler();
        MenuState menuState = new MenuState();
        MenuLogic menuLogic = new MenuLogic(menuState);
        ParkingService parkingService = new ParkingService();

        sceneManager.setStage(primaryStage);
        sceneManager.switchScene("/Parking.fxml", (ParkingController controller) -> {
            controller.setMenuState(menuState);
            controller.setMenuLogic(menuLogic);
            controller.setSceneManager(sceneManager);
            controller.setParkingService(parkingService);
            keyhandler.addListener(controller);
            keyhandler.registerScene(primaryStage.getScene());
        });

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

