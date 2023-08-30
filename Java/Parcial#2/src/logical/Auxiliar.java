package logical;

public class Auxiliar extends Jugadores {

	private int ataq;
	private int bloqueoFalli2;
	private int bloqueosEfectivos;


	public Auxiliar(String nombre, int erroresCom, int puntosDirec, int totalServicio, int ataq, int bloqueosEfectivos, int bloqueoFalli2 ) {
		super(nombre, erroresCom, puntosDirec, totalServicio);
		this.ataq=ataq;
		this.bloqueosEfectivos= bloqueosEfectivos;
		this.bloqueoFalli2= bloqueoFalli2;

	}

	public int getataq() {
		return ataq;
	}

	public int getbloqueosEfectivos() {
		return bloqueosEfectivos;
	}

	public int getbloqueoFalli2() {
		return bloqueoFalli2;
	}

	public void setataq(int ataq) {
		ataq = ataq;
	}

	public void setbloqueosEfectivos(int bloqueosEfectivos) {
		bloqueosEfectivos = bloqueosEfectivos;
	}

	public void setbloqueoFalli2(int bloqueoFalli2) {
		bloqueoFalli2 = bloqueoFalli2;
	}

}
