package com.example.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class ParkingController{
    private int selectedOption = 0;

    @FXML
    private Label lblAltaOficial;

    @FXML
    private Label lblAltaResidente;

    @FXML
    private Label lblComienzaMes;

    @FXML
    private Label lblGenerarReporte;

    @FXML
    private Label lblRegistrarEntrada;

    @FXML
    private Label lblRegistrarSalida;

    @FXML
    private Label lblSalir;

    @FXML
    private Rectangle squareAltaOficial;

    @FXML
    private Rectangle squareAltaResidente;

    @FXML
    private Rectangle squareComienzaMes;

    @FXML
    private Rectangle squareGenReporte;

    @FXML
    private Rectangle squareRegistrarEntrada;

    @FXML
    private Rectangle squareRegistrarSalida;

    @FXML
    private Rectangle squareSalir;

    public void handleDownPressed(KeyEvent event){
        if (selectedOption <= 5)
            selectedOption++;
        else
            selectedOption = 0;
        updateMenuSelection();
    }

    public void handleUpPressed(KeyEvent event){
        if (selectedOption >= 0)
            selectedOption--;
        else
            selectedOption = 6;
        updateMenuSelection();
    }

    public void updateMenuSelection(){
        switch (selectedOption) {
            case 0:
                squareSalir.setVisible(false);
                squareRegistrarEntrada.setVisible(true);
                squareRegistrarSalida.setVisible(false);
                break;
            case 1:
                squareRegistrarEntrada.setVisible(false);
                squareRegistrarSalida.setVisible(true);
                squareAltaOficial.setVisible(false);
                break;
            case 2:
                squareRegistrarSalida.setVisible(false);
                squareAltaOficial.setVisible(true);
                squareAltaResidente.setVisible(false);
                break;
            case 3:
                squareAltaOficial.setVisible(false);
                squareAltaResidente.setVisible(true);
                squareComienzaMes.setVisible(false);
                break;
            case 4:
                squareAltaResidente.setVisible(false);
                squareComienzaMes.setVisible(true);
                squareGenReporte.setVisible(false);
                break;
            case 5:
                squareComienzaMes.setVisible(false);
                squareGenReporte.setVisible(true);
                squareSalir.setVisible(false);
                break;
            case 6:
                squareGenReporte.setVisible(false);
                squareSalir.setVisible(true);
                squareRegistrarEntrada.setVisible(false);
                break;
            default:
                System.out.println("Something broke");
        }
    }

}
