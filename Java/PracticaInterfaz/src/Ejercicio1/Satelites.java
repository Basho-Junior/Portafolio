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
public class Satelites extends SistemaSolar implements ImplementacionSolar {
    
    public Satelites(double masa, double diametro, double distancia, double periodo_rotacion, double periodo_traslacion) {
        super(masa, diametro, distancia, periodo_rotacion, periodo_traslacion);
    }

    @Override
    public void mostrar_informacion() {
        System.out.println("Su masa: "+ this.getMasa() + 
        " Su diametro: " + this.getDiametro()+ " Su distancia: " + this.getDistancia()+
        " Su periodo de rotacion: " + this.getPeriodo_rotacion() +" Su periodo de traslacion: "+this.getPeriodo_traslacion());
    }
    
}
