/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio8;

/**
 *
 * @author Junior
 */
public class motor {

    private int la;
    private double cv;

    public motor(int cilindros_vehiculo) {
        this.cv = cilindros_vehiculo;
        this.la = 0;
    }

    public double getCilindros() {
        return cv;
    }

    public int getAceite() {
        return la;
    }

    public void setAceite(int aceite) {
        this.la = aceite;
    }

    public void setCilindros(int cilindros) {
        this.cv = cilindros;
    }

    public void Aceites(int litros_aceite) {
        la = litros_aceite;
    }
}
