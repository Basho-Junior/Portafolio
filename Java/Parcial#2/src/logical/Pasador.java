package logical;

public class Pasador extends Jugadores {

	private int pases;
	private int fintas;

	public Pasador(String nombre, int erroresCom, int puntosDirec, int totalServicio, int pases, int fintas) {
		super(nombre, erroresCom, puntosDirec, totalServicio);
		this.pases=pases;
		this.fintas=fintas;

	}

	public int getpases() {
		return pases;
	}

	public int getfintas() {
		return fintas;
	}

	public void setpases(int pases) {
		pases = pases;
	}

	public void setfintas(int fintas) {
		fintas = fintas;
	}

}
