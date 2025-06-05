package com.example.app.controllers;

import com.example.app.model.*;
import com.example.app.model.interfaces.KeyEventListener;
import com.example.app.model.utils.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.util.function.UnaryOperator;

public class InputBoxController implements KeyEventListener {
    private MenuState menuState;
    private ParkingService parkingService;
    private SceneManager sceneManager;

    @FXML
    private Rectangle inputBackground;

    @FXML
    private TextField inputText;

    @FXML
    private Label labelPrompt;

    public void init() {
        inputText.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE)
                handleEscape();
            else if (event.getCode() == KeyCode.ENTER)
                handleEnter();
        });
        if (menuState.getOptionSelected() != 5) {
            UnaryOperator<TextFormatter.Change> filter = change -> {
                String newText = change.getControlNewText().toUpperCase();
                if (newText.length() <= AppConstants.PLATE_MAX_CHARS) {
                    change.setText(change.getText().toUpperCase());
                    return change;
                }
                return null;
            };

            inputText.setTextFormatter(new TextFormatter<>(filter));
        }
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
        if (menuState.getOptionSelected() == 5)
            parkingService.setFileName(inputText.getText().trim());
        else
            parkingService.setMatricula(inputText.getText().trim().toUpperCase());
        sceneManager.closePopUp();
    }

    public void changeLabelPrompt(String s){
        labelPrompt.setText(s);
    }

    public void handleEscape() {
        parkingService.setMatricula(null);
        parkingService.setFileName(null);
        sceneManager.closePopUp();
    }

    public void setSceneManager(SceneManager sceneManager){
        this.sceneManager = sceneManager;
    }

    public void setParkingService(ParkingService parkingService){
        this.parkingService = parkingService;
    }

    public void setMenuState(MenuState menuState){
        this.menuState = menuState;
    }
}
