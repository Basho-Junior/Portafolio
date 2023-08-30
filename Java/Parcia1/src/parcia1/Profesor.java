/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcia1;

/**
 *
 * @author Junior
 */
public class Profesor {
    public String nombre;
    public int cedula;
    
    public Profesor(String nom, int ced)
    {
        this.nombre = nom;
        this.cedula = ced;
    }
    
    public String getNombre()
    {
        return nombre;
    }
}
