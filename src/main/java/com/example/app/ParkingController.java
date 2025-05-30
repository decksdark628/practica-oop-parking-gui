package com.example.app;

import javafx.css.PseudoClass;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.io.IOException;


public class ParkingController{
    PseudoClass active = PseudoClass.getPseudoClass("active");
    private Main mainReference;
    private int selectedOption = 0;
    private boolean justEntered = true;

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

    public void initialize(){
        if (justEntered) {
            lblRegistrarEntrada.pseudoClassStateChanged(active, true);
            justEntered = false;
        }
    }

    public void handleEnterPressed(){
        switch (selectedOption){
            case 0:
                tryToLaunchInputWindow();
                break;
            case 1:
                tryToLaunchInputWindow();
                break;
            case 2:
                tryToLaunchInputWindow();
                break;
            case 3:
                tryToLaunchInputWindow();
                break;
            case 6:
                Main.exitApp();
                break;
        }
    }

    private void tryToLaunchInputWindow(){
        try {
            mainReference.launchInputWindow();
        }
        catch (IOException e){
            e.printStackTrace();;
        }
    }

    public void linkToMain(Main m){
        mainReference = m;
    }

    public void handleDownPressed(){
        if (selectedOption <= 5)
            selectedOption++;
        else
            selectedOption = 0;
        updateMenuSelection();
    }

    public void handleUpPressed(){
        if (selectedOption >= 1)
            selectedOption--;
        else
            selectedOption = 6;
        updateMenuSelection();
    }

    public void updateMenuSelection(){
        resetMenuHighlights();
        switch (selectedOption) {
            case 0:
                squareRegistrarEntrada.setVisible(true);
                lblRegistrarEntrada.pseudoClassStateChanged(active, true);
                break;
            case 1:
                squareRegistrarSalida.setVisible(true);
                lblRegistrarSalida.pseudoClassStateChanged(active, true);
                break;
            case 2:
                squareAltaOficial.setVisible(true);
                lblAltaOficial.pseudoClassStateChanged(active, true);
                break;
            case 3:
                squareAltaResidente.setVisible(true);
                lblAltaResidente.pseudoClassStateChanged(active, true);
                break;
            case 4:
                squareComienzaMes.setVisible(true);
                lblComienzaMes.pseudoClassStateChanged(active, true);
                break;
            case 5:
                squareGenReporte.setVisible(true);
                lblGenerarReporte.pseudoClassStateChanged(active, true);
                break;
            case 6:
                squareSalir.setVisible(true);
                lblSalir.pseudoClassStateChanged(active, true);
                break;
            default:
                System.out.println("Something broke");
        }
    }
    private void resetMenuHighlights(){
        squareRegistrarEntrada.setVisible(false);
        squareRegistrarSalida.setVisible(false);
        squareAltaOficial.setVisible(false);
        squareAltaResidente.setVisible(false);
        squareComienzaMes.setVisible(false);
        squareGenReporte.setVisible(false);
        squareSalir.setVisible(false);

        lblRegistrarEntrada.pseudoClassStateChanged(active, false);
        lblRegistrarSalida.pseudoClassStateChanged(active, false);
        lblAltaOficial.pseudoClassStateChanged(active, false);
        lblAltaResidente.pseudoClassStateChanged(active, false);
        lblComienzaMes.pseudoClassStateChanged(active, false);
        lblGenerarReporte.pseudoClassStateChanged(active, false);
        lblSalir.pseudoClassStateChanged(active, false);
    }
}
