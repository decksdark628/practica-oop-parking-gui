package com.example.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.security.Key;

public class InputController {
    private Main mainReference;
    @FXML
    private Rectangle inputBackground;

    @FXML
    private TextField inputText;

    @FXML
    private Label labelPrompt;

    public void initialize(){
        inputText.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE)
                handleEscapePressed();
        });
    }

    public void handleEscapePressed(){
        // currently trying to implement this, but I doubt this is the best way to go about it
    }
}
