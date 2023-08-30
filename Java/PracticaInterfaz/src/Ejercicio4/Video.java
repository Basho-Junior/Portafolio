/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

/**
 *
 * @author Junior
 */
public class Video implements Reproducible {

    @Override
    public void avanzar() {
        System.out.println("El video avanzó");
    }

    @Override
    public void detener() {
        System.out.println("El video se detuvo");
    }

    @Override
    public void grabar() {
        System.out.println("El video se grabó");
    }

    @Override
    public void rebobinar() {
        System.out.println("El video se rebobinó");
    }

    @Override
    public void ejecutar() {
        System.out.println("El video se ejecutó");
    }

}
