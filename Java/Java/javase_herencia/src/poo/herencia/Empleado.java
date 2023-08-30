package poo.herencia;

import java.util.Date;

public class Empleado extends Persona implements Sueldo{
    private double sueldoFijo;
    private double horasExtras;
    private double preciosHorasExtras;
    
    
    
    public Empleado(String nombre, String puesto, String direccion, Date fecha_nacimiento) {
        super(nombre, puesto, direccion, fecha_nacimiento);
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
