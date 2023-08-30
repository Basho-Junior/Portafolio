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
public class Bateadores extends Jugador implements ICorredorEmergente {

    public Bateadores(String nombre, double peso, String tamano, String posicion, double promedioBateo, double efectividadLanzamientos, int errores) {
        super(nombre, peso, tamano, posicion, promedioBateo, efectividadLanzamientos, errores);
    }
    
    @Override
    public void tocar()
    {
        System.out.println("Tocando");
    }
    
    @Override
    public void conectarhit()
    {
        System.out.println("Conectando un hit con mucha potencia");
    }
    
    public void conectardobles()
    {
        System.out.println("Conectando un doble con mucha potencia");
    }
    
    public void conectartriples()
    {
        System.out.println("Conectando un triple con mucha potencia");
    }
    public void homerun()
    {
        System.out.println("Haciendo un home run");
    }

    @Override
    public void correrbases() {
        System.out.println("Corriendo a base");
    }

    @Override
    public void robarbase() {
        System.out.println("Robando bases");
    }
}
