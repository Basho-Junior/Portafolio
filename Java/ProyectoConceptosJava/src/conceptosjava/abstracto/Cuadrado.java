/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.abstracto;

/**
 *
 * @author vacax
 */
public class Cuadrado extends FiguraGeometrica{
    
    double lado;
    
    public Cuadrado(double lado){
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public double perimetro() {
        return 4 * lado;                
    }
    
}
