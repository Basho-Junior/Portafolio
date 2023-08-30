package logical;

public class Opuesto extends Jugadores {

	private int ataq;
	private int bloqueosEfectivos;
	private int bloqueosFalli2;

	public Opuesto(String nombre, int erroresCom, int puntosDirec, int totalServicio, int ataq, int bloqueosEfectivos, int bloqueosFalli2) {
		super(nombre, erroresCom, puntosDirec, totalServicio);
		this.ataq=ataq;
		this.bloqueosEfectivos= bloqueosEfectivos;
		this.bloqueosFalli2= bloqueosFalli2;
	}

	public int getataq() {
		return ataq;
	}

	public int getbloqueosFalli2() {
		return bloqueosFalli2;
	}

	public int getbloqueosEfectivos() {
		return bloqueosEfectivos;
	}

	public void setataq(int ataq) {
		ataq = ataq;
	}

	public void setbloqueosEfectivos(int bloqueosEfectivos) {
		bloqueosEfectivos = bloqueosEfectivos;
	}

	public void setbloqueosFalli2(int bloqueosFalli2) {
		bloqueosFalli2 = bloqueosFalli2;
	}


}
