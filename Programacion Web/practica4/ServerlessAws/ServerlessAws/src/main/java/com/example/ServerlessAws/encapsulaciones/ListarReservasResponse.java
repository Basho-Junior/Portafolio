package com.example.ServerlessAws.encapsulaciones;

import java.util.ArrayList;
import java.util.List;

public class ListarReservasResponse {
    boolean error;
    String mensajeError;
    List<Reserva> reservas;

    public ListarReservasResponse() {
    }

    public ListarReservasResponse(boolean error, String mensajeError, List<Reserva> reservas) {
        this.error = error;
        this.mensajeError = mensajeError;
        this.reservas = reservas;
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

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> estudiantes) {
        this.reservas = estudiantes;
    }
}
