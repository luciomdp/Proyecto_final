package backend;

import java.io.Serializable;
import java.util.ArrayList;

/*59- ¿Qué pasa si todavía no se jugó la final cuando se invoca el metodo?

¿Qué sucede cuando se termina de jugar la final? hay que avisar al controlador
*/

public class Final implements Serializable{
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = 1L;
	private PartidoIdaVuelta partidoFinal;
	private Resultados resultado;
	private ArrayList <Equipo> equipos;
	private String campeon;
	private boolean finalSimulada;
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------

	public Final(ArrayList <Equipo> equipos) {
		partidoFinal = new PartidoIdaVuelta (equipos.get(0), equipos.get(1));
		this.equipos = equipos;
		finalSimulada = false;
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	
	public void juegaFinal () {
		if (!finalSimulada) {
			partidoFinal.simulacionNM();
			partidoFinal.getEquipo1().setGolesFinal(partidoFinal.getGolesE1());
			partidoFinal.getEquipo2().setGolesFinal(partidoFinal.getGolesE2());
			resultado = new Resultados (partidoFinal.getEquipo1(), partidoFinal.getEquipo2(), partidoFinal.getGolesE1(), partidoFinal.getGolesE2());
			if (resultado.getGolesE1() == resultado.getGolesE2()) {
				partidoFinal.simulacionPen();
				if (partidoFinal.getGolesP1() > partidoFinal.getGolesP2()) {
					campeon = partidoFinal.getEquipo1().getNombre();
				}
				else
					campeon = partidoFinal.getEquipo2().getNombre();
			}
			else {
				if (partidoFinal.getGolesE1() > partidoFinal.getGolesE2())
					campeon = partidoFinal.getEquipo1().getNombre();
				else
					campeon = partidoFinal.getEquipo2().getNombre();
			}
			finalSimulada = true;
		}
		
	}
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	public String getCampeon () {
		return campeon;
	}
	
	public Equipo getEquipo (int equipo) {
		return equipos.get(equipo);
	}
	public String getResultadoFinal () {
		return partidoFinal.getEquipo1().getNombre() +" "+ partidoFinal.getGolesE1()+"\n"+partidoFinal.getEquipo2().getNombre() +" "+ partidoFinal.getGolesE2();
	}
	
	public boolean isFinalSimulada() {
		return finalSimulada;
	}
}
