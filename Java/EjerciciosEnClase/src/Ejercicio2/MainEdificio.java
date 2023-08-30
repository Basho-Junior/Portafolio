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
public class MainEdificio {
    public static void main(String[] args) {
        Edificio ed1 = new Edificio(14, "Junior", 4);
        ed1.imprimir();
        ed1.cambiarpisos(12);
        ed1.cambiarnumeropuerta(3);
        ed1.cambiarnombre("Fulano");
        ed1.imprimir();
    }
}
