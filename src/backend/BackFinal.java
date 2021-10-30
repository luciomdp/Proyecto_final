package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class BackFinal implements Serializable{
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = 1L;
	private PartidoIdaVuelta partidoFinal;
	private Resultados resultado;
	private ArrayList <Equipo> equipos;
	private String campeon;
	private int campeonNum;
	private boolean finalSimulada;
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------

	public BackFinal(ArrayList <Equipo> equipos, ArrayList <Referi> referis) {
		LocalDate fechaActual = LocalDate.now().plusDays(8);
		this.equipos = equipos;
		Random aleratorio = new Random ();
	    Referi referi = referis.get(aleratorio.nextInt(referis.size()));
    	while (referi.getNacionalidad() != this.equipos.get(0).getPais() && referi.getNacionalidad() != this.equipos.get(1).getPais()) {
    		referi = referis.get(aleratorio.nextInt(referis.size()));
    	}
		partidoFinal = new PartidoIdaVuelta (equipos.get(0), equipos.get(1), referi, fechaActual);
		finalSimulada = false;
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	/**
	 * Simula la final.<p>
	 *  Setea los goles a favor y en contra de cada equipo, asigna los resultados, en caso de empate simula los penales. Asigna el equipo campeon.
	 */
	public void juegaFinal () {
		if (!finalSimulada) {
			partidoFinal.simulacionNM();
			partidoFinal.getEquipo1().setGolVisitante(false);
			partidoFinal.getEquipo1().setGolesPenalesC(-1);
			partidoFinal.getEquipo2().setGolVisitante(false);
			partidoFinal.getEquipo2().setGolesPenalesC(-1);
			partidoFinal.getEquipo1().setGolesIda(partidoFinal.getGolesE1());
			partidoFinal.getEquipo2().setGolesIda(partidoFinal.getGolesE2());
			partidoFinal.getEquipo1().setGolesContra(partidoFinal.getGolesE2());
			partidoFinal.getEquipo2().setGolesContra(partidoFinal.getGolesE1());
			partidoFinal.getArbitro().dirigePartido();
			resultado = new Resultados (partidoFinal.getEquipo1(), partidoFinal.getEquipo2(), partidoFinal.getGolesE1(), partidoFinal.getGolesE2(), partidoFinal.getFecha());
			if (resultado.getGolesE1() == resultado.getGolesE2()) {
				partidoFinal.simulacionPen();
				partidoFinal.getEquipo1().setGolesPenalesC(partidoFinal.getGolesP1());
				partidoFinal.getEquipo2().setGolesPenalesC(partidoFinal.getGolesP2());
				if (partidoFinal.getGolesP1() > partidoFinal.getGolesP2()) {
					campeon = partidoFinal.getEquipo1().getNombre();
					campeonNum = 0;
				}
				else {
					campeon = partidoFinal.getEquipo2().getNombre();
					campeonNum = 1;
				}
			}
			else {
				if (partidoFinal.getGolesE1() > partidoFinal.getGolesE2()) {
					campeon = partidoFinal.getEquipo1().getNombre();
					campeonNum = 0;
				}
				else {
					campeon = partidoFinal.getEquipo2().getNombre();
					campeonNum = 1;
				}
			}
			finalSimulada = true;
		}
		
	}
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	public String getCampeon () {
		@SuppressWarnings("unused")
		String s = ""; 
		for (int i = 0; i < campeon.length(); i++) {
			if (campeon.charAt(i) != ' ')
				s += campeon.charAt(i);
		}
		return campeon;
	}
	
	public int getCampeonNum () {
		return campeonNum;
	}
	
	public PartidoIdaVuelta getPartidoFinal () {
		return partidoFinal;
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
