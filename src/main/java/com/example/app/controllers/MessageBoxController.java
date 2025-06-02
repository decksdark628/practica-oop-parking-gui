package com.example.app.controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;

public class MessageBoxController {
    @FXML
    private Label labelPrompt;

    public void setupKeyHandlers(){
        Scene scene = ParkingController.popUpStage.getScene();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case ESCAPE -> handleEscapePressed();
                case ENTER -> handleEnterPressed();
            }
        });
    }

    public void handleEscapePressed() {
        try {
            ParkingController.closeInputWindow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleEnterPressed(){
        try {
            ParkingController.closeInputWindow();
        }
        catch (IOException e){
            e.printStackTrace();;
        }
    }

    public Label getLabelPrompt(){
        return labelPrompt;
    }
}
