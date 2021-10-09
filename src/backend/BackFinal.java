package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/*59- ¿Qué pasa si todavía no se jugó la final cuando se invoca el metodo?
		Si la final no esta jugada se va a jugar y se va a poner como true el boolean que indica si se jugo o no el partido.
		Si ya está jugada, debería bloquearse el botón de jugar partido, pero desde el controlador.
	  ¿Qué sucede cuando se termina de jugar la final? hay que avisar al controlador
		El controlador sabe si se puede jugar o no, porque accede al valor del boolean. Si esta en true nunca va a jugarse el partido.
*/

public class BackFinal implements Serializable{
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = 1L;
	private PartidoIdaVuelta partidoFinal;
	private Resultados resultado;
	private ArrayList <Equipo> equipos;
	private String campeon;
	private boolean finalSimulada;
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------

	public BackFinal(ArrayList <Equipo> equipos, ArrayList <Referi> referis) {
		this.equipos = equipos;
		Random aleratorio = new Random ();
	    Referi referi = referis.get(aleratorio.nextInt(referis.size()));
    	while (referi.getNacionalidad() != this.equipos.get(0).getPais() && referi.getNacionalidad() != this.equipos.get(1).getPais()) {
    		referi = referis.get(aleratorio.nextInt(referis.size()));
    	}
		partidoFinal = new PartidoIdaVuelta (equipos.get(0), equipos.get(1), referi);
		finalSimulada = false;
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	/**
	 * Simula la final. Setea los goles a favor y en contra de cada equipo, asigna los resultados, en caso de empate simula los penales. Asigna el equipo campeon.
	 */
	public void juegaFinal () {
		if (!finalSimulada) {
			partidoFinal.simulacionNM();
			partidoFinal.getEquipo1().setGolVisitante(false);
			partidoFinal.getEquipo1().setGolesPenalesC(-1);
			partidoFinal.getEquipo2().setGolVisitante(false);
			partidoFinal.getEquipo2().setGolesPenalesC(-1);
			partidoFinal.getEquipo1().setGolesFinal(partidoFinal.getGolesE1());
			partidoFinal.getEquipo2().setGolesFinal(partidoFinal.getGolesE2());
			partidoFinal.getEquipo1().setGolesContra(partidoFinal.getGolesE2());
			partidoFinal.getEquipo2().setGolesContra(partidoFinal.getGolesE1());
			partidoFinal.getArbitro().dirigePartido();
			resultado = new Resultados (partidoFinal.getEquipo1(), partidoFinal.getEquipo2(), partidoFinal.getGolesE1(), partidoFinal.getGolesE2());
			if (resultado.getGolesE1() == resultado.getGolesE2()) {
				partidoFinal.simulacionPen();
				partidoFinal.getEquipo1().setGolesPenalesC(partidoFinal.getGolesP1());
				partidoFinal.getEquipo2().setGolesPenalesC(partidoFinal.getGolesP2());
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
