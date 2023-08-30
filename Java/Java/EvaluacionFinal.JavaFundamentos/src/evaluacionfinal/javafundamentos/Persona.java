package evaluacionfinal.javafundamentos;
import java.util.Date;

/**

 */
public abstract class Persona {
    private String nombre;
    private int num_empleado;
    private String cedula;
    private String direccion;
    private String telefono;
    private String fecha_naci;
    private Date fecha_conta;
    private String Puesto;

    public Persona(String nombre, int num_empleado, String cedula, String direccion, String telefono, String fecha_naci, Date fecha_conta, String Puesto) {
        this.nombre = nombre;
        this.num_empleado = num_empleado;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_naci = fecha_naci;
        this.fecha_conta = fecha_conta;
        this.Puesto = Puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum_empleado() {
        return num_empleado;
    }

    public void setNum_empleado(int num_empleado) {
        this.num_empleado = num_empleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_naci() {
        return fecha_naci;
    }

    public void setFecha_naci(String fecha_naci) {
        this.fecha_naci = fecha_naci;
    }

    public Date getFecha_conta() {
        return fecha_conta;
    }

    public void setFecha_conta(Date fecha_conta) {
        this.fecha_conta = fecha_conta;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }
   
    
    

}