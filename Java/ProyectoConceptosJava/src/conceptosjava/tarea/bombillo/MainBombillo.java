/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.tarea.bombillo;

/**
 *
 * @author vacax
 */
public class MainBombillo {
    public static void main(String[] args) {
        Bombillo b1 = new Bombillo(true);
        Bombillo b2 = new Bombillo(true);
        System.out.println("Bombillo  b1: "+b1.getEstado());
        System.out.println("Bombillo  b2: "+b2.getEstado());
        b2.setEstado(false);
        Bombillo.setFusible(false);
        System.out.println("Bombillo  b1: "+b1.getEstado());
        System.out.println("Bombillo  b2: "+b2.getEstado());
        Bombillo.setFusible(true);
        System.out.println("Bombillo  b1: "+b1.getEstado());
        System.out.println("Bombillo  b2: "+b2.getEstado());
    }
}
