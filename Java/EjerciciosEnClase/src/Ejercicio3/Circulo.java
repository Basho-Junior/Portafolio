/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

/**
 *
 * @author Junior
 */
public class Circulo {
    double radio;
    double area;
    double perimetro;
    
    public Circulo(double radio)
    {
        this.radio = radio;
    }
    
    public double calc_area ()
    {
        //this.area = 3.14 * this.radio * this.radio;
        return Math.PI * Math.pow(radio, 2);
    }
    
    public double calc_perimetro ()
    {
        //this.perimetro = 2 * 3.14 * this.radio;
        return 2 * Math.PI * radio;
    }
    void imprimir ()
    {
        System.out.println("El radio es: "+radio+ " el area es: "+area+" el perimetro: "+perimetro);
    }
}
