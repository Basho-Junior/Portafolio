/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colecciones;

/**
 *
 * @author junio
 */
public enum Frutas {
    MANGO("Mango es muy bueno") , NARANJA("La naranja es muy buena pero prefiero el zapote") , MELON("El melón es mi favorito.") , ZAPOTE("Zapote nose") , SANDIA("No me gusta la sandía");
    
    String descripcion;
    
    Frutas(String descripcion){
        this.descripcion=descripcion;
    }  
    public String getDescripcion(){
        return this.descripcion;
    }
    
}