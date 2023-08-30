/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Junior
 */
public class Estadio {

    Random rand = new Random();

    //rand.nextInt(1000)
    public void completarEstadisticas(ArrayList<Jugador> misEquipos) {
        
    }

    public void imprimirEstadisticas(ArrayList<Jugador> misEquipos) {
            Iterator iterador2= misEquipos.iterator();
            
		while (iterador2.hasNext()) {
			Jugador elemento = (Jugador) iterador2.next();
			System.out.print(elemento + " ");
		}
    }

    public static void main(String[] args) {
        ArrayList<Jugador> EquipoB = new ArrayList<>();
        Lanzadores L1 = new Lanzadores("Junior Castro", 157.4, "5´10", "Lanzador", 0, 0, 0);
        EquipoB.add(L1);
        Lanzadores B1 = new Lanzadores("Mario Milano", 144.5, "5´9", "Receptor", 0, 0, 0);
        EquipoB.add(B1);
        Lanzadores B2 = new Lanzadores("Juan Osoria", 160.7, "5´11", "Primera Base", 0, 0, 0);
        EquipoB.add(B2);
        Lanzadores B3 = new Lanzadores("Pedro Navao", 170.4, "5´10", "Segunda Base", 0, 0, 0);
        EquipoB.add(B3);
        Lanzadores B4 = new Lanzadores("Nicolas Cristal", 145.4, "5´9", "Tercera Base", 0, 0, 0);
        EquipoB.add(B4);
        Lanzadores B5 = new Lanzadores("Sergio Ramirez", 200.0, "5´11", "Campo Corto", 0, 0, 0);
        EquipoB.add(B5);
        Lanzadores B6 = new Lanzadores("Jariel Morel", 159.4, "5´10", "Jardinero Central", 0, 0, 0);
        EquipoB.add(B6);
        Lanzadores B7 = new Lanzadores("Saul Castro", 158.5, "5´10", "Jardinero Derecho", 0, 0, 0);
        EquipoB.add(B7);
        Lanzadores B8 = new Lanzadores("Junior Castro", 157.4, "5´10", "Jardinero Izquierdo", 0, 0, 0);
        EquipoB.add(B8);
        Estadio estadio = new Estadio();
        estadio.imprimirEstadisticas(EquipoB);
    }
}
