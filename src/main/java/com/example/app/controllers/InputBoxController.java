package com.example.app.controllers;

import com.example.app.model.AppConstants;
import com.example.app.model.KeyEventListener;
import com.example.app.model.ParkingService;
import com.example.app.model.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.util.function.UnaryOperator;

public class InputBoxController implements KeyEventListener{
    private ParkingService parkingService;
    private SceneManager sceneManager;

    @FXML
    private Rectangle inputBackground;

    @FXML
    private TextField inputText;

    @FXML
    private Label labelPrompt;

    public void initialize() {
        inputText.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE)
                handleEscape();
            else if (event.getCode() == KeyCode.ENTER)
                handleEnter();
        });

        UnaryOperator<TextFormatter.Change> filter = change ->{
            String newText = change.getControlNewText().toUpperCase();
            if (newText.length() <= AppConstants.PLATE_MAX_CHARS){
                change.setText(change.getText().toUpperCase());
                return change;
            }
            return null;
        };

        inputText.setTextFormatter(new TextFormatter<>(filter));
    }

    public boolean subscribesTo(KeyEvent event){
        return switch (event.getCode()){
            case ENTER, ESCAPE -> true;
            default -> false;
        };
    }

    public void onKeyPressed(KeyEvent event){
        switch (event.getCode()){
            case ENTER -> handleEnter();
            case ESCAPE -> handleEscape();
        }
    }

    public void handleEnter(){
        parkingService.setMatricula(inputText.getText().trim().toUpperCase());
        sceneManager.closePopUp();
    }

    public void handleEscape() {
        parkingService.setMatricula(null);
        sceneManager.closePopUp();
    }

    public void setSceneManager(SceneManager sceneManager){
        this.sceneManager = sceneManager;
    }

    public void setParkingService(ParkingService parkingService){
        this.parkingService = parkingService;
    }
}
