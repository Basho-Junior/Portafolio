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
public class MainAbstracto {
    
    public static void main(String[] args) {
        Cuadrado cuadrado  =new Cuadrado(10);
        System.out.println("El cuadrado area: "+cuadrado.area());
        System.out.println("El cuadrado perimetro: "+cuadrado.perimetro());
        
        Circulo circulo  =new Circulo(3);
        System.out.println("El circulo area: "+circulo.area());
        System.out.println("El circulo perimetro: "+circulo.perimetro());
        
        //Cuando instancio una clase abstracta tengo que implementar
        //lo metodos abstractos..
        double baseMayor = 10;
        double baseMenor =2;
        double altura =4;
        FiguraGeometrica trapecio = new FiguraGeometrica() {           
            
            @Override
            public double area() {
                return ((baseMayor+baseMenor)*altura)/2;
            }

            @Override
            public double perimetro() {
                return 0;
            }
        };
        System.out.println("Area del trapecio: "+trapecio.area());
    }
}
