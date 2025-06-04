package com.example.app.model;

public class ParkingService{
    private int operation;
    private String matricula;
    private String fileName;
    Parking parking = new Parking();

    public Result executeQuery(){
        //TODO make this better. Could be more organized
        if (matricula == null && operation >=0 && operation <= 3)
            return null;
        Result r = switch (operation) {
            case 0 -> parking.registrarEntrada(matricula);
            case 1 -> parking.registrarSalida(matricula);
            case 2 -> parking.darAltaOficial(matricula);
            case 3 -> parking.darAltaResidente(matricula);
            case 4 -> {
                parking.comienzaMes();
                yield new Result(true, "Se ha reiniciado el mes");
            }
            case 5 -> {
                parking.generarInformeResidentes();
                yield new Result(true, "Se ha generado el informe");
            }
            default -> new Result(false, "Operacion no valida");
        };
        matricula = null;

        return r;
    }

    public int getOperation(){
        return operation;
    }
    public String getMatricula(){
        return matricula;
    }
    public void setOperation(int operation){
        this.operation = operation;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
