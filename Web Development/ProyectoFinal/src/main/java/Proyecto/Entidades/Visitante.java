package Proyecto.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Visitante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ipaddress;

    private String navegador;

    private String sistemaO;

    private Date fecha = new Date();

    public Visitante(int id, String ipaddress, String navegador, String sistema, Date fecha) {
        this.id = id;
        this.ipaddress = ipaddress;
        this.navegador = navegador;
        this.sistemaO = sistema;
        this.fecha = fecha;
    }

    public Visitante() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String getSistema() {
        return sistemaO;
    }

    public void setSistema(String sistema) {
        sistemaO = sistema;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFechaFormat() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        String date = dateFormat.format(fecha);
        return date;
    }
}
