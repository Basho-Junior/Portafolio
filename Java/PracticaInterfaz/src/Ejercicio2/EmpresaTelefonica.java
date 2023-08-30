/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author Junior
 */
public class EmpresaTelefonica {
    public static void main(String[] args) {
        LlamadaLocal Llamada1 = new LlamadaLocal("8093990212","8095705156",20);
        LlamadaProvincial Llamada2 = new LlamadaProvincial("8095642345","8299862826",3,1);
        LlamadaProvincial Llamada3 = new LlamadaProvincial("8495642345","8499862826",4,2);
        Central central=new Central();
        
        central.registraLlamada(Llamada1);
        central.registraLlamada(Llamada2);
        central.registraLlamada(Llamada3);
        
        central.printInforme();
        
    }
}
