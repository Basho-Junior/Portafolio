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
public class Pasante extends Persona implements Sueldo{
    
    
    private double pasaje;
    private double dieta;

    public Pasante(String nombre, int num_empleado, String cedula, String direccion, String telefono, String fecha_naci, Date fecha_conta, String Puesto) {
        super(nombre, num_empleado, cedula, direccion, telefono, fecha_naci, fecha_conta, Puesto);
    }
    
    
    @Override
    public double calcularSueldo() {
        return (pasaje + dieta);
    }

    public Pasante(double pasaje, double dieta, String nombre, int num_empleado, String cedula, String direccion, String telefono, String fecha_naci, Date fecha_conta, String Puesto) {
        super(nombre, num_empleado, cedula, direccion, telefono, fecha_naci, fecha_conta, Puesto);
        this.pasaje = pasaje;
        this.dieta = dieta;
    }


    

    public double getPasaje() {
        return pasaje;
    }

    public void setPasaje(double pasaje) {
        this.pasaje = pasaje;
    }

    public double getDieta() {
        return dieta;
    }

    public void setDieta(double dieta) {
        this.dieta = dieta;
    }
    


    
}
