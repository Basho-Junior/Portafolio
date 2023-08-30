/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clonewhatsapp.Clases;

import java.util.Date;
import javax.swing.JList;

/**
 * Clase para encapsular la información del mensaje.
 * @author Marie y Junior
 */
public class Mensaje {

    String enviadoPor;
    Date fecha;
    String mensaje;
    public String enviadoA;

    public String getEnviadoA() {
        return enviadoA;
    }

    public void setEnviadoA(String enviadoA) {
        this.enviadoA = enviadoA;
    }

    public Mensaje(String usuario,String usuario2, String mensaje, Date fecha) {
        this.enviadoPor = usuario;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.enviadoA = usuario2;
    }

    public String getUsuario() {
        return enviadoPor;
    }

    public void setUsuario(String usuario) {
        this.enviadoPor = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

