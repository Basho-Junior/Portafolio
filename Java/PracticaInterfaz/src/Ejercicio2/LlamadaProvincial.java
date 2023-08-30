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
public class LlamadaProvincial extends Llamada {

    private double costo = 0;
    private int horario;

    public LlamadaProvincial(String nori, String nodest, int dur, int hora) {
        super(nori, nodest, dur);
        horario = hora;
        switch (horario) {
            case 1:
                costo = 20;
                break;
            case 2:
                costo = 1.25;
                break;
            case 3:
                costo = 30;
                break;
            default:
                break;
        }
    }

    @Override
    public double costoLlamada() {
        double costetotal = costo * this.getDuracion();
        return costetotal;
    }
}
