package com.example.app.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.function.Consumer;

public class SceneManager{
    private Stage primaryStage;
    private Stage popUpStage;

    public <T> void switchScene(String fxmlPath, Consumer<T> initController){
        try{
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlPath));
            Parent root = loader.load();

            primaryStage.setScene(new Scene(root, AppConstants.MAIN_WINDOW_WIDTH, AppConstants.MAIN_WINDOW_HEIGHT));
            initController.accept(loader.getController());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    // TODO make Enum
    public <T> void launchPopUpWindow(int type, Consumer<T> initController){
        String fxmlPath = null;

        if (type == 1)
            fxmlPath = "/InputBox.fxml";
        else if (type == 2)
            fxmlPath = "/MessageBox.fxml";

        if (popUpStage == null){
            try{
                FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlPath));
                Parent root = loader.load();

//                T controller = loader.getController();
//                initController.accept(loader.getController());

                popUpStage = new Stage();
                popUpStage.initOwner(primaryStage);
                popUpStage.initModality(Modality.WINDOW_MODAL);
                popUpStage.setScene(new Scene(root, AppConstants.POPUP_WIDTH, AppConstants.POPUP_HEIGHT));
                popUpStage.initStyle(StageStyle.UNDECORATED);


                initController.accept(loader.getController());
                popUpStage.showAndWait();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void setStage(Stage stage){
        primaryStage = stage;
    }

    public Stage getPopUpStage(){
        return popUpStage;
    }

    public void closePopUp(){
        if (popUpStage != null){
            popUpStage.close();
            popUpStage = null;
        }
    }

    public void closeApp(){
        if (primaryStage != null)
            primaryStage.close();
    }
}
