package com.example.app.model;

public class MenuState {
    private int optionSelected = 0;

    public void decrementOptionSelected(){
        optionSelected--;
    }
    public void incrementOptionSelected(){
        optionSelected++;
    }

    public int getOptionSelected(){
        return optionSelected;
    }
    public void setOptionSelected(int n){
        optionSelected = n;
    }
}
