/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacionfinal.javafundamentos;

import java.util.Date;

/**
 *
 * @author junio
 */
public class Consultor extends Persona implements Sueldo{
    private double horaTrabajadas;
    private double precioHoras;

    public Consultor(String nombre, int num_empleado, String cedula, String direccion, String telefono, String fecha_naci, Date fecha_conta, String Puesto) {
        super(nombre, num_empleado, cedula, direccion, telefono, fecha_naci, fecha_conta, Puesto);
    }

   
    
  @Override
    public double calcularSueldo() {
    double nm = (horaTrabajadas * precioHoras);
    double mn = (nm *0.1);
    double pt = nm - mn;
       return pt;
    }

   
    public double getHoraTrabajadas() {
        return horaTrabajadas;
    }

    public void setHoraTrabajadas(double horaTrabajadas) {
        this.horaTrabajadas = horaTrabajadas;
    }

    public double getPrecioHoras() {
        return precioHoras;
    }

    public void setPrecioHoras(double precioHoras) {
        this.precioHoras = precioHoras;
    }
    
}
    