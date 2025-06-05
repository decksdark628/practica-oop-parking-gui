package com.example.app.model.interfaces;

import javafx.scene.input.KeyEvent;

public interface KeyEventListener{
    boolean subscribesTo(KeyEvent event);
    void onKeyPressed(KeyEvent event);
}
