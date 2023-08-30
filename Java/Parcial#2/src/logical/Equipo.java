package logical;

public class Equipo {

	private String paisParticpante;
	private String nombreEquipo;
	private String entrenadorEquipo;
	private int ranking;
	private Jugadores MiJugador;

	public Equipo(String paisParticpante, String nombreEquipo, String entrenadorEquipo, int ranking, Jugadores miJugador) {
		super();
		paisParticpante = paisParticpante;
		nombreEquipo = nombreEquipo;
		entrenadorEquipo = entrenadorEquipo;
		ranking = ranking;
		MiJugador = miJugador;
	}

	public String getpaisParticpante() {
		return paisParticpante;
	}

	public void setpaisParticpante(String paisParticpante) {
		paisParticpante = paisParticpante;
	}

	public String getnombreEquipo() {
		return nombreEquipo;
	}

	public int getranking() {
		return ranking;
	}

	public String getentrenadorEquipo() {
		return entrenadorEquipo;
	}

	public void setnombreEquipo(String nombreEquipo) {
		nombreEquipo = nombreEquipo;
	}

	public void setentrenadorEquipo(String entrenadorEquipo) {
		entrenadorEquipo = entrenadorEquipo;
	}

	public void setranking(int ranking) {
		ranking = ranking;
	}

	public Jugadores getMiJugador() {
		return MiJugador;
	}

	public void setMiJugador(Jugadores miJugador) {
		MiJugador = miJugador;
	}



}
