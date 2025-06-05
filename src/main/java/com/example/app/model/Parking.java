package com.example.app.model;

import com.example.app.model.interfaces.PagaAlSalir;
import com.example.app.model.interfaces.ReinicioMensual;
import com.example.app.model.vehicles.NoResidente;
import com.example.app.model.vehicles.Oficial;
import com.example.app.model.vehicles.Residente;
import com.example.app.model.vehicles.Vehiculo;
import com.example.app.model.utils.GeneradorInformes;
import com.example.app.model.utils.Result;

import java.util.HashMap;
import java.util.ArrayList;

public class Parking{
    public HashMap<String, Vehiculo> vehiculos = new HashMap<>();
    private GeneradorInformes genInf;

    public Parking(){}

    public Result registrarEntrada(String placa){
        Result r;
        if (validarPlaca(placa)) {
            Vehiculo v = buscarVehiculo(placa);
            if (v == null) {
                registrarVehiculo(placa);
                v = buscarVehiculo(placa);
            }
            if (v.getUltimoIngreso() == null) {
                v.registrarUltimoIngreso();
                r = new Result(true, "Entrada registrada");
            }
            else
                r = new Result(false, "El vehiculo aun no ha salido");
        }
        else
            r = new Result(false, "La placa no tiene un formato valido");
        return r;
    }
    
    public Result registrarSalida(String placa){
        Result r;
        Vehiculo v = buscarVehiculo(placa);
        if (v == null)
            r = new Result(false, "El vehiculo no existe");
        else if (v.getUltimoIngreso() != null) {
                v.registrarSalida();
                if (v instanceof PagaAlSalir)
                    r = new Result(true, "Total a pagar: " + ((PagaAlSalir) v).getPrecioAPagar());
                else
                    r = new Result(true, "Salida registrada");
            }
        else
            r = new Result(false, "El vehiculo aun no ha entrado");

        return r;
    }

    public Result darAltaOficial(String placa) {
        Result r;
        if (validarPlaca(placa)) {
            Vehiculo v = buscarVehiculo(placa);
            if (v != null) {
                if (!(v instanceof Oficial)) {
                    if (v.getUltimoIngreso() == null) {
                        Vehiculo oficial = new Oficial(placa);
                        Vehiculo confirmacion = vehiculos.replace(placa, oficial);
                        if (confirmacion != null)
                            r = new Result(true, "Vehiculo dado de alta como Oficial");
                        else
                            r = new Result(false, "Hubo un error");
                    }
                    else
                        r = new Result(false, "El vehiculo aun no ha salido");
                } else
                    r = new Result(false, "El vehiculo ya es Oficial");
            } else
                r = new Result(false, "El vehiculo no existe");
        } else
            r = new Result(false, "La placa no tiene un formato valido");
        return r;
    }
    
    public Result darAltaResidente(String placa){
        Result r;
        if (validarPlaca(placa)) {
            Vehiculo v = buscarVehiculo(placa);
            if (v != null) {
                if (!(v instanceof Residente)){
                    if (v.getUltimoIngreso() == null) {
                        Vehiculo residente = new Residente(placa);
                        Vehiculo confirmacion = vehiculos.replace(placa, residente);
                        if (confirmacion != null)
                            r = new Result(true, "Vehiculo dado de alta como Residente");
                        else
                            r = new Result(false, "Hubo un error");
                        }
                    else
                        r = new Result(false, "El vehiculo aun no ha salido");
                } else
                    r = new Result(false, "El vehiculo ya es Residente");
            } else
                r = new Result(false, "El vehiculo no existe");
        } else
            r = new Result(false, "La placa no tiene un formato valido");
        return r;
    }

    public void comienzaMes(){
        for (Vehiculo v : vehiculos.values()){
            if (v instanceof ReinicioMensual){
                ReinicioMensual rm = (ReinicioMensual)v;
                rm.comienzaMes();
            }
        }
    }

    public Result generarInformeResidentes(String fileName){
        ArrayList<Residente> lista = new ArrayList<>();
        for (Vehiculo v : vehiculos.values()){
            if (v instanceof Residente){
                Residente r = (Residente)v;
                lista.add(r);
            }
        }
        genInf = new GeneradorInformes();
        genInf.generarInformeResidentes(fileName, lista);
        return new Result(true, "Se ha generado el reporte");
    }

    public Vehiculo buscarVehiculo(String placa){
        return vehiculos.get(placa);
    }

    public void registrarVehiculo(String placa){
        NoResidente v = new NoResidente(placa);
        vehiculos.put(placa, v);
    }

    private boolean validarPlaca(String placa){
        if (placa.length() < 7)
            return false;
        else
            return true;
    }

    public HashMap<String, Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(HashMap<String, Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}