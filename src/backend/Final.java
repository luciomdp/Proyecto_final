package backend;

/*59- ¿Qué pasa si todavía no se jugó la final cuando se invoca el metodo?

¿Qué sucede cuando se termina de jugar la final? hay que avisar al controlador
*/

public class Final {
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private PartidoIdaVuelta partidoFinal;
	private Resultados resultado;
	private Equipo [] equipos;
	private Equipo campeon;
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------

	public Final(Equipo[] equipos) {
		this.partidoFinal = new PartidoIdaVuelta (equipos[0], equipos[1]);
		this.equipos[0].setGolesFinal(0);
		this.equipos[1].setGolesFinal(0);
		this.resultado = null;
		this.campeon = null;
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	
	public void juegaFinal () {
		partidoFinal.simulacionNM();
		resultado.setE1(partidoFinal.getEquipo1());
		resultado.setGolesE1(partidoFinal.getGolesE1());
		partidoFinal.getEquipo1().setGolesFinal(partidoFinal.getGolesE1());
		partidoFinal.getEquipo2().setGolesFinal(partidoFinal.getGolesE2());
		resultado.setE2(partidoFinal.getEquipo2());
		resultado.setGolesE2(partidoFinal.getGolesE2());
		if (resultado.getGolesE1() == resultado.getGolesE2()) {
			partidoFinal.simulacionPen();
			if (partidoFinal.getGolesP1() > partidoFinal.getGolesP2()) {
				setCampeon (partidoFinal.getEquipo1());
			}
			else
				setCampeon (partidoFinal.getEquipo2());
				
		}
		else {
			if (partidoFinal.getGolesE1() > partidoFinal.getGolesE2())
				setCampeon (partidoFinal.getEquipo1());
			else
				setCampeon (partidoFinal.getEquipo2());
		}
		
	}
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	public void setCampeon (Equipo equipo) {
		this.campeon = equipo;
	}
	public String getCampeon () {
		return campeon.getNombre();
	}
	public String getResultadoFinal () {
		return partidoFinal.getEquipo1().getNombre() +" "+ partidoFinal.getGolesE1()+"\n"+partidoFinal.getEquipo2().getNombre() +" "+ partidoFinal.getGolesE2();
	}
}
