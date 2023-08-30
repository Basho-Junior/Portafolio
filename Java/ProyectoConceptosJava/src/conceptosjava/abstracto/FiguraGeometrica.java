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
public abstract class FiguraGeometrica {
    
    String nombre;
    
    public abstract double area();
    
    public abstract double perimetro();
    
    public void otroMetodo(){
        System.out.println("No es abstracto tengo la información");
    }
}
