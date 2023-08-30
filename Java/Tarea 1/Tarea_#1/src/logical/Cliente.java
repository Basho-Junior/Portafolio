package logical;

public class Cliente {
   private String cedula;
   private String nombrecompleto;
   private String direccion;
   private String telefono;
   private Cuenta[] misCuentas;
   private int cantRealCuentas;
   

   public Cliente(String cedula, String nombrecompleto, String direccion, String telefono, Cuenta[] misCuentas,
		int cantRealCuentas) {
	super();
	this.cedula = cedula;
	this.nombrecompleto = nombrecompleto;
	this.direccion = direccion;
	this.telefono = telefono;
	this.misCuentas = new Cuenta[10];
	this.cantRealCuentas = 0;
	Cuenta aux = new Cuenta();
    misCuentas[0]=aux;
	this.cantRealCuentas++;
	
}
public String getCedula() {
	return cedula;
}
public void setCedula(String cedula) {
	this.cedula = cedula;
}
public String getNombrecompleto() {
	return nombrecompleto;
}
public void setNombrecompleto(String nombrecompleto) {
	this.nombrecompleto = nombrecompleto;
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
public Cuenta[] getMisCuentas() {
	return misCuentas;
}
public void setMisCuentas(Cuenta[] misCuentas) {
	this.misCuentas = misCuentas;
}
public int getCantRealCuentas() {
	return cantRealCuentas;
}
public void setCantRealCuentas(int cantRealCuentas) {
	this.cantRealCuentas = cantRealCuentas;
}

   
   
}
