package com.example.app;

import java.time.LocalDateTime;
import java.time.Duration;

public class Residente extends Vehiculo implements ReinicioMensual{
    public static final double PRECIO_POR_MINUTO = 0.002;
    private int tiempoAcumulado;

    public Residente(String placa){
        super(placa);
    }

	public void registrarSalida(){
		LocalDateTime ingreso = super.getUltimoIngreso();
        LocalDateTime salida = LocalDateTime.now();

        long minutosTranscurridos = Duration.between(ingreso, salida).toMinutes();

        tiempoAcumulado += (int)minutosTranscurridos;
	}

    public String generarInformacionPago(){
        return super.getPlaca() + "\t\t\t" + tiempoAcumulado + "\t\t\t" + tiempoAcumulado * PRECIO_POR_MINUTO;
    }

    
    public void comienzaMes(){
        tiempoAcumulado = 0;
    }

    public int getTiempoAcumulado() {
        return this.tiempoAcumulado;
    }

    public void setTiempoAcumulado(int tiempoAcumulado) {
        this.tiempoAcumulado = tiempoAcumulado;
    }

    public String toString(){
        return super.toString() + ", Precio por minuto: " + PRECIO_POR_MINUTO + " euros";
    }
}
