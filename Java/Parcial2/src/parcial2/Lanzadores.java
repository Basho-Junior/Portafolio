/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

/**
 *
 * @author Junior
 */
public class Lanzadores extends Jugador implements ICorredorEmergente {
    
    public Lanzadores(String nombre, double peso, String tamano, String posicion, double promedioBateo, double efectividadLanzamientos, int errores) {
        super(nombre, peso, tamano, posicion, promedioBateo, efectividadLanzamientos, errores);
    }
    
    public void lanzarcurvas()
    {
        System.out.println("Lanzando una curva a 95 MPH");
    }
    
    @Override
    public void lanzarrectas()
    {
        System.out.println("Lanzando un recta a 95 MPH");
    }
    
    public void cambiovelocidad()
    {
        System.out.println("Cambiando velocidad");
    }

    @Override
    public void correrbases() {
        System.out.println("Corriendo a base");
    }

    @Override
    public void robarbase() {
        System.out.println("Robando base");
    }
    
}
