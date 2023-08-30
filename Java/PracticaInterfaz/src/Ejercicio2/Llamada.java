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
public abstract class Llamada implements ICostodelallamada {

    private final String nomOrigen;
    private final String nomDestino;
    private final int duracion;

    public Llamada(String nori, String nodest, int dur) {
        nomOrigen = nori;
        nomDestino = nodest;
        duracion = dur;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public abstract double costoLlamada();
}
