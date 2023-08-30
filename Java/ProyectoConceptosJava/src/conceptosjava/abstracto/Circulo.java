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
public class Circulo extends OtroFiguraGeometrica{

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }      
    
    @Override
    public double area() {
       return radio*radio*Math.PI;
    }

    @Override
    public double perimetro() {
        return radio*2*Math.PI;
    }
    
}
