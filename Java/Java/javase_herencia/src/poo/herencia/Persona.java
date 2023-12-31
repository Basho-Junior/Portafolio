package poo.herencia;

import java.util.Date;
/**

 */
public abstract class Persona {
    private String nombre;
    private String puesto;
    private String direccion;
    private Date fecha_nacimiento;

    public Persona(String nombre, String puesto, String direccion, Date fecha_nacimiento) {
        super();
        this.nombre = nombre;
        this.puesto = puesto;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
