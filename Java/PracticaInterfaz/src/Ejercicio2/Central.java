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
public class Central {

    private int numLlamadas;
    private double costoTotal;

    public Central() {
        numLlamadas = 0;
        costoTotal = 0;
    }

    public int getNumLlamadas() {
        return numLlamadas;
    }

    public double getCostoLlamadas() {
        return costoTotal;
    }

    public void registraLlamada(Llamada llamada) {
        numLlamadas++;
        costoTotal += llamada.costoLlamada();
    }

    public void printInforme() {
        System.out.println("El numero total de llamadas es: " + numLlamadas + " y el costo total es: " + costoTotal);
    }
}
