package logical;

public class Libero extends Jugadores {

	private int recibosEfectivoss;
	private int fallos;

	public Libero(String nombre, int fallos, int puntosDirec, int totalServicio, int recibosEfectivoss, int fallos) {
		super(nombre, fallos, puntosDirec, totalServicio);
		this.recibosEfectivoss= recibosEfectivoss;
		this.fallos=fallos;

	}

	public int getrecibosEfectivoss() {
		return recibosEfectivoss;
	}

	public void setrecibosEfectivoss(int recibosEfectivoss) {
		recibosEfectivoss = recibosEfectivoss;
	}

	public int getfallos() {
		return fallos;
	}

	public void setfallos(int fallos) {
		fallos = fallos;
	}

}
