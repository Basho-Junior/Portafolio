package logical;

public class Cuenta {
	private String codCuenta;
	private String tipoCuenta;
	private int openDate;
	private int diaCorte;
	private int puntos;
	private double saldo;
	private boolean estado;
	
	
	public Cuenta(String codCuenta, String tipoCuenta, int openDate, int diaCorte, int puntos, double saldo,
			boolean estado) {
		super();
		this.codCuenta = codCuenta;
		this.tipoCuenta = tipoCuenta;
		this.openDate = openDate;
		this.diaCorte = diaCorte;
		this.puntos = puntos;
		this.saldo = saldo;
		this.estado = estado;
	}
	public String getCodCuenta() {
		return codCuenta;
	}
	public void setCodCuenta(String codCuenta) {
		this.codCuenta = codCuenta;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public int getOpenDate() {
		return openDate;
	}
	public void setOpenDate(int openDate) {
		this.openDate = openDate;
	}
	public int getDiaCorte() {
		return diaCorte;
	}
	public void setDiaCorte(int diaCorte) {
		this.diaCorte = diaCorte;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	

     
}
