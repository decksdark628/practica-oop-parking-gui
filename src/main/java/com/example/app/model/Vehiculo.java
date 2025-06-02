package com.example.app.model;

import java.time.LocalDateTime;

public abstract class Vehiculo{
    private String placa;
    private LocalDateTime ultimoIngreso;

    public Vehiculo(String placa){
        this.placa = placa;
    }

    public void registrarUltimoIngreso(){
        LocalDateTime time = LocalDateTime.now();
        ultimoIngreso = time;
    }

    public abstract void registrarSalida();

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getUltimoIngreso() {
        return this.ultimoIngreso;
    }

    public void setUltimaEntrada(LocalDateTime ultimoIngreso) {
        this.ultimoIngreso = ultimoIngreso;
    }

    public String toString() {
        return " Placa: " + getPlaca() +
            ", Ultimo ingreso: " + getUltimoIngreso();
    }

}