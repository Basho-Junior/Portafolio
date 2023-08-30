/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author Junior
 */
public class LlamadaLocal extends Llamada {

    private final double coste;

    public LlamadaLocal(String nor, String ndes, int dur) {
        super(nor, ndes, dur);
        coste = 0.15;
    }

    @Override
    public double costoLlamada() {
        double costetotal = coste * this.getDuracion();
        return costetotal;
    }
}
