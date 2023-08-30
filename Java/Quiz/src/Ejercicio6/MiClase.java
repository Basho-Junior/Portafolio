/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio6;

/**
 *
 * @author Junior
 */
public class MiClase {
    public static int valorClase = 0;
    int valorInstancia;
    
    public MiClase(int valorinstancia) {
        valorClase++;
        this.valorInstancia++;
    }
    
    public static int getClase() {
        return valorClase;
    }
    
    public int getInstancia() {
        return valorInstancia;
    }
    
    public void setInstancia(int valorinstancia) {
        this.valorInstancia = valorinstancia;
    }
    
}
