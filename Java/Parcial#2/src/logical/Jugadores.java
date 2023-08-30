package logical;

public abstract class Jugadores {

	private String nombreJugador;
	private int erroresCometidos;
	private int aces;
	private int totalServicios;

	public Jugadores(String nombreJugador, int erroresCometidos, int aces, int totalServicios) {
		super();
		nombreJugador = nombreJugador;
		erroresCometidos = erroresCometidos;
		aces = aces;
		totalServicios = totalServicios;
	}

	public String getnombreJugador() {
		return nombreJugador;
	}

	public void setnombreJugador(String nombreJugador) {
		nombreJugador = nombreJugador;
	}

	public int getaces() {
		return aces;
	}

	public int geterroresCometidos() {
		return erroresCometidos;
	}

	public int gettotalServicios() {
		return totalServicios;
	}

	public void seterroresCometidos(int erroresCometidos) {
		erroresCometidos = erroresCometidos;
	}

	public void setaces(int aces) {
		aces = aces;
	}

	public void settotalServicios(int totalServicios) {
		totalServicios = totalServicios;
	}



}
