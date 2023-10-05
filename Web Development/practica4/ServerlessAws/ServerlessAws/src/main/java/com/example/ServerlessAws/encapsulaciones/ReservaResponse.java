package com.example.ServerlessAws.encapsulaciones;

public class ReservaResponse {
    boolean error;
    String mensajeError;
    Reserva reserva;

    public ReservaResponse(){

    }

    public ReservaResponse(boolean error, String mensajeError, Reserva reserva) {
        this.error = error;
        this.mensajeError = mensajeError;
        this.reserva = reserva;
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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
