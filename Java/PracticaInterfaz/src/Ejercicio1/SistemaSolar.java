/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

/**
 *
 * @author Junior
 */
public class SistemaSolar {
    private double masa;
    private double diametro;
    private double distancia;
    private double periodo_rotacion;
    private double periodo_traslacion;

    public SistemaSolar(double masa, double diametro, double distancia, double periodo_rotacion, double periodo_traslacion) {
        this.masa = masa;
        this.diametro = diametro;
        this.distancia = distancia;
        this.periodo_rotacion = periodo_rotacion;
        this.periodo_traslacion = periodo_traslacion;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPeriodo_rotacion() {
        return periodo_rotacion;
    }

    public void setPeriodo_rotacion(double periodo_rotacion) {
        this.periodo_rotacion = periodo_rotacion;
    }

    public double getPeriodo_traslacion() {
        return periodo_traslacion;
    }

    public void setPeriodo_traslacion(double periodo_traslacion) {
        this.periodo_traslacion = periodo_traslacion;
    }

    
    
}
