/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaaula;

/**
 *
 * @author junio
 */
public enum Entrada {
    Balcon(1000) , Platea(1500) , VIP(2500) , FSP(3000);
    
    double precio;
    
    Entrada(double precio){
        this.precio=precio;
    }  
    public double getPrecio(){
        return this.precio;
    }
    
}