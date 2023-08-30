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
public class Asignaturas {
    public String nombre;
    public String clave;
    public int cant_creditos;
    
    public Asignaturas(String Nombre, String Clave, int cant_cred)
    {
        this.nombre = Nombre;
        this.clave = Clave;
        this.cant_creditos = cant_cred;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
}
