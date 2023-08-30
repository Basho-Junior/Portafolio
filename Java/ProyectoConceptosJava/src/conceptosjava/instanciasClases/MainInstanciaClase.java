/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.instanciasClases;

/**
 *
 * @author vacax
 */
public class MainInstanciaClase {
    
    public static void main(String[] args) {
        
        Estudiante est = new Estudiante(); //necesito instanciar antes de...
        est.matricula= 20011136;
        est.nombre="Carlos Camacho";
        est.prematricula();
        Estudiante.valor=1; // est.valor = 1; es lo mismo..
        //no tengo la instancia... de nullpoint.
        //Estudiante otro = null;
        //otro.prematricula();
        
        //
        Estudiante est2 = new Estudiante();
        est2.matricula= 20011137;
        est2.nombre="Pancho Grullon";
        est2.valor = 2;
        Estudiante.metodoClase(); //los mismo.. est2.metodoClase();
        
        Estudiante est3 = new Estudiante();
        est3.matricula= 20011136;
        est3.nombre="Domingo Jimenez";
        est3.valor = 3;
    }
}
