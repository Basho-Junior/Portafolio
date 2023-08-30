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
public class MainUniversidad {
    
    public static void main(String[] args) {
        Asignaturas asig1 = new Asignaturas("Matematica","MAT-211", 5);
        Asignaturas asig2 = new Asignaturas("Ingles II","ILE-211", 4);
        Asignaturas asig3 = new Asignaturas("Lab-Fisica","FIS-211", 1);
        
        Profesor prof1 = new Profesor("Mirabal",102354365);
        Profesor prof2 = new Profesor("Maria Lozano",102355365);
        Profesor prof3 = new Profesor("Remigia",102354375);
        
        Grupos grupo1 = new Grupos(asig1,3,prof1);
        Grupos grupo2 = new Grupos(asig2,4,prof2);
        Grupos grupo3 = new Grupos(asig3,5,prof3);
        
        Estudiante est1 = new Estudiante(20180999,"Junior","Sistema",grupo1);
        est1.setGrupo(grupo3);
        Estudiante est2 = new Estudiante(20180910,"Jeremy","Telematica",grupo2);
        est1.setGrupo(grupo3);
        
        Inscripcion Ins = new Inscripcion();
        
        Ins.imprimirAsignaturasCursadasPorEstudiante(est1);
        Ins.imprimirAsignaturasCursadasPorEstudiante(est2);
        
        Ins.imprimirProfesoresDelEstudiante(est1);
        Ins.imprimirProfesoresDelEstudiante(est2);
    }
    
}
