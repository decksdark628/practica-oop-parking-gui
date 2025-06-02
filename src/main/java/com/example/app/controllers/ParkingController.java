package com.example.app.controllers;

import com.example.app.Main;
import com.example.app.model.Parking;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ParkingController{
    public static Stage popUpStage;
    private PseudoClass active = PseudoClass.getPseudoClass("active");
    public static int selectedOption = 0;
    private boolean justEntered = true;
    private static String placa;

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

    public void resolveQuery(){
        switch (selectedOption){
            case 0:
        }
    }

    public void setupKeyHandlers(){
        Scene scene = Main.getPrimaryStage().getScene();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case DOWN -> handleDownPressed();
                case UP -> handleUpPressed();
                case ENTER -> handleEnterPressed();
            }
        });
    }

    public void handleEnterPressed(){
        if (selectedOption == 6)
            Main.exitApp();
        else if (selectedOption >= 0 && selectedOption <= 3)
            tryToLaunchInputWindow();
        else
            Parking.imprimirHashmap();
    }

    private void tryToLaunchInputWindow(){
        try {
            launchInputWindow();
        }
        catch (IOException e){
            e.printStackTrace();;
        }
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

    public void launchInputWindow() throws IOException {
        if (popUpStage == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/InputBox.fxml"));
            Parent inputPopUp = loader.load();

            InputBoxController inputController = loader.getController();

            popUpStage = new Stage();
            popUpStage.initOwner(Main.getPrimaryStage());
            popUpStage.initModality(Modality.WINDOW_MODAL);
            popUpStage.setScene(new Scene(inputPopUp, 426, 121));
            popUpStage.initStyle(StageStyle.UNDECORATED);

            Scene scene = ParkingController.popUpStage.getScene();

            scene.setOnKeyPressed(event -> {
                switch (event.getCode()){
                    case ESCAPE -> inputController.handleEscapePressed();
                    case ENTER -> inputController.handleEnterPressed();
                }
            });

            popUpStage.show();
        }
    }

    public void launchMessageWindow() throws IOException {
        if (popUpStage == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MessageBox.fxml"));
            Parent inputPopUp = loader.load();

            InputBoxController inputController = loader.getController();

            popUpStage = new Stage();
            popUpStage.initOwner(Main.getPrimaryStage());
            popUpStage.initModality(Modality.WINDOW_MODAL);
            popUpStage.setScene(new Scene(inputPopUp, 426, 121));
            popUpStage.initStyle(StageStyle.UNDECORATED);

            Scene scene = ParkingController.popUpStage.getScene();

            scene.setOnKeyPressed(event -> {
                switch (event.getCode()){
                    case ESCAPE -> inputController.handleEscapePressed();
                    case ENTER -> inputController.handleEnterPressed();
                }
            });

            popUpStage.show();

        }
    }
    public static void closeInputWindow() throws IOException {
        if (popUpStage != null) {
            popUpStage.close();
            popUpStage = null;
        }
    }

    public static String getPlaca(){
        return placa;
    }

    public static void setPlaca(String placa){
        placa = placa;
    }
}
