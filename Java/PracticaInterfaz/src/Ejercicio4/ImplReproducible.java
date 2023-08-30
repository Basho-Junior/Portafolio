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
public class ImplReproducible {
    public static void main(String[] args) {
        Audio audio1 = new Audio();
        Video video1 = new Video();
        
        Reproducible reproducible1 = video1;
        Reproducible reproducible2 = audio1;
        
        reproducible1.avanzar();
        reproducible1.detener();
        
        reproducible2.grabar();
        reproducible2.ejecutar();
        reproducible2.rebobinar();
    }
}
