/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica;

/**
 *
 * @author Junior
 */
public class Metodos {
    double frecuencia;
    
    public Metodos(double frecuencia)
    {
        this.frecuencia = frecuencia;
    }

    public Metodos() {
        
    }

    
    public void Down()
    {
        this.frecuencia = this.frecuencia  + 0.5;
        if(this.frecuencia > 108)
        {
            this.frecuencia = 80; 
        }
    }
    
    public void Up()
    {
        this.frecuencia = this.frecuencia  - 0.5;
        if(this.frecuencia < 80)
        {
            this.frecuencia = 108; 
        }
    }
    
    double imprimirfrecuencia() 
    {
        return frecuencia;
    }
}
