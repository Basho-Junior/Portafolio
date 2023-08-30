package com.example.ServerlessAws.encapsulaciones;

public class LaboratorioResponse {
    boolean error;
    String mensajeError;
    Laboratorio laboratorio;

    public LaboratorioResponse(){

    }

    public LaboratorioResponse(boolean error, String mensajeError, Laboratorio laboratorio) {
        this.error = error;
        this.mensajeError = mensajeError;
        this.laboratorio = laboratorio;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
}
