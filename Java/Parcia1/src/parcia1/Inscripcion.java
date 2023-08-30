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
public class Inscripcion {
    
    public void imprimirAsignaturasCursadasPorEstudiante(Estudiante est)
    {
        System.out.println("Las asignaturas cursadas por el estudiante " +est.nombre+ "son: " + est.getGrupo().getAsignatura().getNombre());
    }
    
    public void imprimirProfesoresDelEstudiante(Estudiante est)
    {
        System.out.println("Los profesores del estudiante " +est.nombre+ "han sido: " + est.getGrupo().getProfesor().getNombre());
    }
    
    
}
