/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.constructores;

/**
 *
 * @author vacax
 */
public class MainConstructores {
    
    public static void main(String[] args) {
        System.out.println("Prueba de Constructores");
        Estudiante e1 =new Estudiante();
        e1.matricula=20011136;
        e1.nombre="Carlos Camacho";
        e1.carrera="Telemático";
        
        Estudiante e2 = new Estudiante(20011136);
        Estudiante e3 = new Estudiante(20011136,"Carlos Camacho", "Telematico");
        
    }
}
