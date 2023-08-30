/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.tarea.bombillo;

/**
 *
 * @author vacax
 */
public class Bombillo {
    
    private boolean estado;
    public static boolean fusible = true;
    
    public Bombillo(boolean estado){
        this.estado = estado;
    }
    
    
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    
    public boolean getEstado(){
        return estado && Bombillo.fusible;
    }
    
    public static void setFusible(boolean estado){
        fusible = estado;
    }
}
