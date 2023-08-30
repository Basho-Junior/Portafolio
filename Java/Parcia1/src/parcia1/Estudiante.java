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
public class Estudiante {
    public int matricula;
    public String nombre;
    public String carrera;
    public Grupos grupo;
    
    public Estudiante(int matri, String nom, String Carre,Grupos grup)
    {
        this.matricula = matri;
        this.nombre =  nom;
        this.carrera = Carre;
        this.grupo = grup;
    } 
    
    public Grupos getGrupo()
    {
        return grupo;
    }
    public void setGrupo(Grupos g)
    {
        this.grupo = g;
    }
    
}
