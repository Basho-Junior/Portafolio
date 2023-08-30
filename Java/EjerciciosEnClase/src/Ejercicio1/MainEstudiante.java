/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

/**
 *
 * @author Junior
 */
public class MainEstudiante {
    public static void main(String[] args) {
        
        Estudiante estudiante1 = new Estudiante();
        Estudiante estudiante2 = new Estudiante();
        Estudiante estudiante3 = new Estudiante();
        Estudiante estudiante4 = new Estudiante();
        Estudiante estudiante5 = new Estudiante();
        
        estudiante1.ingreso_dato(20180995,"Fulano", "Martinez", "Telematico");
        estudiante2.ingreso_dato(20180996,"Fulana", "Cristal", "Medico");
        estudiante3.ingreso_dato(20180997,"Fulanito", "Fernandez", "Administracion");
        estudiante4.ingreso_dato(20180998,"Juan Patricio", "Lucresio", "Terapia Fisica");
        estudiante5.ingreso_dato(20180999,"Junior", "Hernandez", "Sistemas");
    }
}
