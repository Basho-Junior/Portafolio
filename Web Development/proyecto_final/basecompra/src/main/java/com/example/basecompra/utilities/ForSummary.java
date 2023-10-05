package com.example.basecompra.utilities;

import com.example.basecompra.models.Servicio;

public class ForSummary {
    private Servicio servicio;
    private String fecha;

    public ForSummary(Servicio servicio, String fecha) {
        this.servicio = servicio;
        this.fecha = fecha;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
