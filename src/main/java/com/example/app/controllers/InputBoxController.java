package com.example.app.controllers;

import com.example.app.model.Parking;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class InputBoxController {
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
        String text = inputText.getText();
        if (!text.isBlank()){
            text = text.trim().toUpperCase();
            if (text.length() == 7) {
                switch (ParkingController.selectedOption){
                    case 0:
                        Parking.registrarEntrada(text);
                        if (Parking.buscarVehiculo(text) == null)
                            //ParkingController.launchMessageWindow();
                        break;
                    case 1:
                        Parking.registrarSalida(text);
                        System.out.println("Salida registrada con placa: " + text);
                        break;
                    case 2:
                        Parking.darAltaOficial(text);
                        System.out.println("Vehiculo registrado como oficial: " + text);
                        break;
                    case 3:
                        Parking.darAltaResidente(text);
                        System.out.println("Vehiculo registrado como residente: " + text);
                        break;
                    default:
                        System.out.println("no es una opcion valida");
                }
            }
        }



        try {
            ParkingController.closeInputWindow();
        }
        catch (IOException e){
            e.printStackTrace();;
        }
    }
}
