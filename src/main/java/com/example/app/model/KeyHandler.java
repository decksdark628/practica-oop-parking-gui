package com.example.app.model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class KeyHandler{
    private final List<KeyEventListener> listeners = new ArrayList<>();

    public void registerScene(Scene scene){
        scene.setOnKeyPressed(this::handleKeyPressed);
    }

    private void handleKeyPressed(KeyEvent event){
        for (KeyEventListener listener : listeners){
            if (listener.subscribesTo(event)){
                listener.onKeyPressed(event);
            }
        }
    }

    public void addListener(KeyEventListener listener){
        listeners.add(listener);
    }
    public void removeListener(KeyEventListener listener){
        listeners.remove(listener);
    }
}
