package com.example.ServerlessAws.encapsulaciones;

import java.util.List;

public class ListarLaboratoriosResponse {
    boolean error;
    String mensajeError;
    List<Laboratorio> laboratorios;

    public ListarLaboratoriosResponse() {
    }

    public ListarLaboratoriosResponse(boolean error, String mensajeError, List<Laboratorio> laboratorios) {
        this.error = error;
        this.mensajeError = mensajeError;
        this.laboratorios = laboratorios;
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

    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(List<Laboratorio> estudiantes) {
        this.laboratorios = estudiantes;
    }
}