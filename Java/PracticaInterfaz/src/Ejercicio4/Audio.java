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
public class Audio implements Reproducible {

    @Override
    public void avanzar() {
        System.out.println("El audio avanzó");
    }

    @Override
    public void detener() {
        System.out.println("El audio se detuvo");
    }

    @Override
    public void grabar() {
        System.out.println("El audio se grabó");
    }

    @Override
    public void rebobinar() {
        System.out.println("El audio se rebobinó");
    }

    @Override
    public void ejecutar() {
        System.out.println("El audio se ejecutó");
    }
    
}
