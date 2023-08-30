/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.interfaz.coninterfaz;

/**
 *
 * @author vacax
 */
public interface ISoldado {
    
    //por definicion todas las propiedades
    // son public static final , si quiero lo agrego.
    String VALOR = "ES UNA CONSTANTE...";
    
    void pelear();
    void marchar();
    void entrenar();
    //no es necesario incluir public abstract 
    public abstract void metodo();
    
    /**
     * Desde Java 9, se permite la implementación
     * de metodos en interfaz
     */
    default void metodoImplementado(){
        System.out.println("Metodo implmentado en la Interfaz: "+getClass().getSimpleName());
    }
}
