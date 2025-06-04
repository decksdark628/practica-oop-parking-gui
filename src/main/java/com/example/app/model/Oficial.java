package com.example.app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Oficial extends Vehiculo implements ReinicioMensual{
    private ArrayList<Estancia> estancias = new ArrayList<>();
    
    public Oficial(String placa){
        super(placa);
    }

    public void registrarSalida(){
        LocalDateTime ingreso = super.getUltimoIngreso();
        LocalDateTime salida = LocalDateTime.now();
        Estancia estancia = new Estancia(ingreso, salida);
        estancias.add(estancia);
        super.setUltimaEntrada(null);
    }

    public void comienzaMes(){
        estancias.clear();
    }

    public ArrayList<Estancia> getEstancias() {
        return this.estancias;
    }

    public void setEstancias(ArrayList<Estancia> estancias) {
        this.estancias = estancias;
    }
}
