package com.example.app;

import java.time.LocalDateTime;

public class Estancia{
    LocalDateTime entrada;
    LocalDateTime salida;

    public Estancia(LocalDateTime e, LocalDateTime s){
        entrada = e;
        salida = s;
    }
    
    public LocalDateTime getEntrada() {
        return this.entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSalida() {
        return this.salida;
    }

    public void setSalida(LocalDateTime salida) {
        this.salida = salida;
    }    
}
