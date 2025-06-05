package com.example.app.model.utils;

import com.example.app.model.vehicles.Residente;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GeneradorInformes{

    public void generarInformeResidentes(String fileName, ArrayList<Residente> residentes){
        String texto = generarTextoInforme(residentes);
        generarArchivoTexto(fileName, texto);
    }
    
    private String generarTextoInforme(ArrayList<Residente> residentes){
        String texto = "Matricula\t\tTiempo estacionado (min.)\t\tCantidad a pagar\n";
            for (Residente r : residentes){
                texto += r.generarInformacionPago()+"\n";
            }   
        return texto;
    }

    private void generarArchivoTexto(String fileName, String informe){
        try {
            FileWriter writer = new FileWriter(fileName + ".txt");
            writer.write(informe);
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
