package Parcial2.encapsulaciones;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Historial implements Serializable {

    @Id
    private int idEstudiante;

    private String Usuario;

    private float latitud;

    private float longitud;

    public Historial(int idEstudiante, String usuario, float latitud, float longitud) {
        this.idEstudiante = idEstudiante;
        Usuario = usuario;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Historial() {

    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }
}
