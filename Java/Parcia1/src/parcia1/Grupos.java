/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcia1;

import java.util.Random;

/**
 *
 * @author Junior
 */
public class Grupos {
    public Asignaturas asignatura;
    public int numero_grupo;
    public Profesor profesor;
    public int calif_obte;
    
    public Grupos(Asignaturas asig, int num, Profesor profe)
    {
        this.asignatura = asig;
        this.numero_grupo = num;
        this.profesor = profe;
        this.calif_obte =  new Random().nextInt(5);
    }
    
    public Asignaturas getAsignatura()
    {
        return asignatura;
    }
    
    public Profesor getProfesor()
    {
        return profesor;
    }
    
    public int getCalif()
    {
        return calif_obte;
    }
    
}
