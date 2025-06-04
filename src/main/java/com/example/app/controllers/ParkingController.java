package com.example.app.controllers;

import com.example.app.model.*;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ParkingController implements KeyEventListener {
    private Stage popUpStage;
    private KeyHandler keyHandler = new KeyHandler();
    private ParkingService parkingService;
    private SceneManager sceneManager;
    private MenuState menuState;
    private MenuLogic menuLogic;

    private PseudoClass active = PseudoClass.getPseudoClass("active");

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

    @FXML
    private void initialize() {
        lblRegistrarEntrada.pseudoClassStateChanged(active, true);
    }

    public boolean subscribesTo(KeyEvent event) {
        return switch (event.getCode()) {
            case UP, DOWN, ENTER -> true;
            default -> false;
        };
    }

    public void onKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case UP -> handleUp();
            case DOWN -> handleDown();
            case ENTER -> handleEnter();
        }
    }

    private void handleUp() {
        menuLogic.handleUp();
        updateMenuSelection();
    }

    private void handleDown() {
        menuLogic.handleDown();
        updateMenuSelection();
    }

    public void setMenuState(MenuState menuState) {
        this.menuState = menuState;
    }

    public void handleEnter() {
        int selection = menuState.getOptionSelected();
        parkingService.setOperation(selection);

        if (selection >= 0 && selection <= 5){
            if (selection <= 3)
                askPlate();

            Result r = parkingService.executeQuery();
            if (r != null)
                showMessage(r.getMessage());
        } else if (selection == 6)
            sceneManager.closeApp();
    }

    private void askPlate(){
        sceneManager.launchPopUpWindow(1, (InputBoxController controller) -> {
            controller.setParkingService(parkingService);
            controller.setSceneManager(sceneManager);
        });
    }
    private void showMessage(String msg){
        sceneManager.launchPopUpWindow(2, (MessageBoxController controller) -> {
            controller.setParkingService(parkingService);
            controller.setSceneManager(sceneManager);
            controller.changeText(msg);
            popUpStage = sceneManager.getPopUpStage();
            keyHandler.registerScene(popUpStage.getScene());
            keyHandler.addListener(controller);
        });
    }

    public void updateMenuSelection() {
        resetMenuHighlights();
        switch (menuState.getOptionSelected()) {
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

    private void resetMenuHighlights() {
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

    public void setMenuLogic(MenuLogic menuLogic) {
        this.menuLogic = menuLogic;
    }

    public void setSceneManager(SceneManager sceneManager){
        this.sceneManager = sceneManager;
    }

    public void setParkingService(ParkingService parkingService){
        this.parkingService = parkingService;
    }

    public void setPopUpStage(Stage popUpStage){
        this.popUpStage = popUpStage;
    }
}
