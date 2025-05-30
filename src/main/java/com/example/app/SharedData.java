package com.example.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SharedData {
    private static Parent currentRoot;
    private static Scene currentScene;
    private static Stage currentWindow = Main.getPrimaryStage();

    public void changeScene (String fxmlPath, int width, int height) throws IOException {
        FXMLLoader newLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent newRoot = newLoader.load();
        Scene newScene = new Scene(newRoot, width, height);
        currentWindow.setScene(newScene);
        currentScene = currentWindow.getScene();
        currentRoot = currentScene.getRoot();
    }

    public static Parent getCurrentRoot() {
        return currentRoot;
    }

    public static Scene getCurrentScene() {
        return currentScene;
    }

    public static Stage getCurrentWindow() {
        return currentWindow;
    }
}
