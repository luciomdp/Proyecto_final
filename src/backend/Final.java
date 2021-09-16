package backend;

import java.util.ArrayList;

/*59- ¿Qué pasa si todavía no se jugó la final cuando se invoca el metodo?

¿Qué sucede cuando se termina de jugar la final? hay que avisar al controlador
*/

public class Final {
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private PartidoIdaVuelta partidoFinal;
	private Resultados resultado;
	private ArrayList <Equipo> equipos;
	private Equipo campeon;
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------

	public Final(ArrayList <Equipo> equipos) {
		this.partidoFinal = new PartidoIdaVuelta (equipos.get(0), equipos.get(1));
		this.equipos = equipos;
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
				campeon = partidoFinal.getEquipo1();
			}
			else
				campeon = partidoFinal.getEquipo2();
				
		}
		else {
			if (partidoFinal.getGolesE1() > partidoFinal.getGolesE2())
				campeon = partidoFinal.getEquipo1();
			else
				campeon = partidoFinal.getEquipo2();
		}
		
	}
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	public String getCampeon () {
		return campeon.getNombre();
	}
	public String getResultadoFinal () {
		return partidoFinal.getEquipo1().getNombre() +" "+ partidoFinal.getGolesE1()+"\n"+partidoFinal.getEquipo2().getNombre() +" "+ partidoFinal.getGolesE2();
	}
}
