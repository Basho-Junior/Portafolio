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
public class Empleado extends Persona implements Sueldo{
    
    private double sueldoFijo;
    private double horasExtras;
    private double preciosHorasExtras;

    public Empleado(String nombre, int num_empleado, String cedula, String direccion, String telefono, String fecha_naci, Date fecha_conta, String Puesto) {
        super(nombre, num_empleado, cedula, direccion, telefono, fecha_naci, fecha_conta, Puesto);
    }

    public Empleado(double sueldoFijo, double horasExtras, double preciosHorasExtras, String nombre, int num_empleado, String cedula, String direccion, String telefono, String fecha_naci, Date fecha_conta, String Puesto) {
        super(nombre, num_empleado, cedula, direccion, telefono, fecha_naci, fecha_conta, Puesto);
        this.sueldoFijo = sueldoFijo;
        this.horasExtras = horasExtras;
        this.preciosHorasExtras = preciosHorasExtras;
    }

   


    @Override
    public double calcularSueldo() {
        return (sueldoFijo + (preciosHorasExtras * horasExtras));
    }

    public double getSueldoFijo() {
        return sueldoFijo;
    }

    public void setSueldoFijo(double sueldoFijo) {
        this.sueldoFijo = sueldoFijo;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getPreciosHorasExtras() {
        return preciosHorasExtras;
    }

    public void setPreciosHorasExtras(double preciosHorasExtras) {
        this.preciosHorasExtras = preciosHorasExtras;
    }
}
