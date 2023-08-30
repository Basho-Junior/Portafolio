/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio7;

/**
 *
 * @author Junior
 */
public class MainBombillo {
    
    public static void main(String[] args) {
        Bombilla Bombillo1 = new Bombilla();
        Bombilla Bombillo2 = new Bombilla();
        
        Bombillo1.apagar();
        Bombillo2.encender();
        
        System.out.println("La Bombilla 1 esta: "+Bombillo1.mostrarestado()+" y la Bombilla 2 esta: "+Bombillo2.mostrarestado());
        
        Bombilla.pressinterruptor();
        System.out.println("OH NO! Los fusiles se han dañado, ahora la Bombilla 1 esta: "+Bombillo1.mostrarestado()+" y la Bombilla 2 esta: "+Bombillo2.mostrarestado());
        Bombillo1.encender();
        
        Bombilla.pressinterruptor();
        System.out.println("Los fusiles fueron arreglados, la electricidad ha regresado, ahora la Bombilla 1 esta: "+Bombillo1.mostrarestado()+" y la Bombilla 2 esta: "+Bombillo2.mostrarestado());
        
    }
    
}
