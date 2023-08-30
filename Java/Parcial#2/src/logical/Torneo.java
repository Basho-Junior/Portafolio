package logical;

import java.util.ArrayList;

public class Torneo {

	private ArrayList<Equipo> misEquiposList;
	private ArrayList<Jugadores>misJugadoresList;
	private ArrayList<Libero>missLiberoList;
	private ArrayList<Pasador>missPasadorList;
	private ArrayList<Auxiliar>missAuxiliarList;
	private ArrayList<Opuesto>missOpuestosList;
	private static Torneo torneo=null;

	private Torneo() {
		super();
		misEquiposList = new ArrayList<>();
		misJugadoresList= new ArrayList<>();
		missLiberoList=new ArrayList<>();
		missPasadorList=new ArrayList<>();
		missAuxiliarList=new ArrayList<>();

	}

	public static Torneo getInstance() {
		if(torneo==null) {
			torneo =new Torneo();
		}
		return torneo;
	}

	public ArrayList<Equipo> getmisEquiposList() {
		return misEquiposList;
	}

	public void setmisEquiposList(ArrayList<Equipo> misEquiposList) {
		this.misEquiposList = misEquiposList;
	}

	public ArrayList<Jugadores> getmisJugadoresList() {
		return misJugadoresList;
	}

	public void setmisJugadoresList(ArrayList<Jugadores> misJugadoresList) {
		this.misJugadoresList = misJugadoresList;
	}

	public String JugadorVal(Libero aux,Jugadores auxJugad) {

		String JugValioso;
		if((((aux.getRecibosEfec()-aux.getErrores())*100/aux.getRecibosEfec()+aux.getErrores())+(auxJugad.getPuntosDirec()*100)/auxJugad.getTotalServicio())) {
			JugValioso==auxJugad.getNombre();
		}
		return JugValioso;
	}

	public void Efectividad (Libero aux) {
	}

	public int LiberosErrores(Libero aux1) {

		misJugadoresList.add(aux1);
		int liberoserror=0;

		if(aux1.getErrores()>1) {
			//liberoserror += 1;
			liberoserror ++;
		}else{}
		return liberoserror;
	}

	public String pasadorfinta (Pasador aux2) {
		misJugadoresList.add(aux2);
		String MasFintas=null;
		int MassFintas=0;
		int cont=0;

		if(aux2.getFintas()>MassFintas) {
			MasFintas=aux2.getNombre();
		}
		return MasFintas;
	}

	public String bloqueosefectivos(Opuesto aux) {
		missOpuestosList.add(aux);
		String nombre=null;
		if(aux.getBloqueosEfec()>1) {
			nombre=aux.getNombre();
		}else{}
		return nombre;

	}
}
