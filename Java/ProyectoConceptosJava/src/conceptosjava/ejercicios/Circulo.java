/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.ejercicios;

/**
 *
 * @author vacax
 */
public class Circulo {
    
    private double radio;
    
    public Circulo(double radio){
        this.radio = radio;
    }
    
    public double getArea(){
        return Math.PI * Math.pow(radio, 2); //radio*radio*3.1416....
    }
    
    public double getPerimetro(){
        return 2 * Math.PI * radio;
    }
    
    public static void main(String[] args) {
        Circulo c1 = new Circulo(100);
        System.out.println("El area: "+c1.getArea());
        System.out.println("El perimetro: "+c1.getPerimetro());
    }
}
