/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizherencia;

import java.util.Random;

/**
 *
 * @author Junior
 */
public class Sensor extends Alarma{
    
    public Sensor(int min, int max) {
        super(min, max);
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        Sensor aux = new Sensor(0,25);
        while(true)
        {
            int i = -50 + (int)(Math.random()*((45-(-50)+1)));
            System.out.println(i);
            aux.chequeo(i);
        }   
    }
    
}
