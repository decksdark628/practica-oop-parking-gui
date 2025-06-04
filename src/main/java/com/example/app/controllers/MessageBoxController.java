package com.example.app.controllers;

import com.example.app.model.KeyEventListener;
import com.example.app.model.KeyHandler;
import com.example.app.model.ParkingService;
import com.example.app.model.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class MessageBoxController implements KeyEventListener {
    private KeyHandler keyHandler;
    private ParkingService parkingService;
    private SceneManager sceneManager;

    @FXML
    private Label labelPrompt;

    public boolean subscribesTo(KeyEvent event){
        return switch (event.getCode()){
            case ENTER, ESCAPE -> true;
            default -> false;
        };
    }

    public void onKeyPressed(KeyEvent event){
        switch (event.getCode()){
            case ENTER, ESCAPE -> handleEscape();
        }
    }

    public void handleEscape() {
        sceneManager.closePopUp();
    }

    public void changeText(String text){
        labelPrompt.setText(text);
    }

    public void setSceneManager(SceneManager sceneManager){
        this.sceneManager = sceneManager;
    }

    public void setParkingService(ParkingService parkingService){
        this.parkingService = parkingService;
    }

    public void setKeyHandler(KeyHandler keyHandler){
        this.keyHandler = keyHandler;
    }
}
