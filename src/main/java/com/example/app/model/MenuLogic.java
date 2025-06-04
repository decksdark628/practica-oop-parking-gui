package com.example.app.model;

public class MenuLogic{
    private MenuState menuState;

    public MenuLogic(MenuState menuState){
        this.menuState = menuState;
    }
    public void handleUp(){
        if (menuState.getOptionSelected() >= 1)
            menuState.decrementOptionSelected();
        else
            menuState.setOptionSelected(6);
    }

    public void handleDown(){
        if (menuState.getOptionSelected() <= 5)
            menuState.incrementOptionSelected();
        else
            menuState.setOptionSelected(0);
    }
}
