/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.ejercicios;

/**
 *
 * @author vacax
 */
public class MainEstudiante {
    
    public static void main(String[] args) {
        
        Estudiante estudiante = new Estudiante();
        estudiante.setMatricula(20011136);
        System.out.println("Matricula Actual: "+estudiante.getMatricula());
        estudiante.setMatricula(-10);
        System.out.println("Matricula Actual: "+estudiante.getMatricula());        
        //estudiante.matricula = -12;
        System.out.println("Matricula Actual: "+estudiante.getMatricula());
    }
    
}
