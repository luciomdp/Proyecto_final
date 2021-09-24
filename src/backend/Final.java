package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/*59- �Qu� pasa si todav�a no se jug� la final cuando se invoca el metodo?

�Qu� sucede cuando se termina de jugar la final? hay que avisar al controlador
*/

public class Final implements Serializable{
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = 1L;
	private PartidoIdaVuelta partidoFinal;
	private Resultados resultado;
	private ArrayList <Equipo> equipos;
	static ArrayList <Referi> referis = new ArrayList <Referi>();
	private String campeon;
	private boolean finalSimulada;
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------

	public Final(ArrayList <Equipo> equipos, ArrayList <Referi> referis) {
		this.referis = referis;
		this.equipos = equipos;
		Random aleratorio = new Random ();
	    Referi referi = referis.get(aleratorio.nextInt(referis.size()));
    	while (referi.getNacionalidad() != this.equipos.get(0).getPais() && referi.getNacionalidad() != this.equipos.get(1).getPais()) {
    		referi = referis.get(aleratorio.nextInt(referis.size()));
    	}
		partidoFinal = new PartidoIdaVuelta (equipos.get(0), equipos.get(1), referi);
		finalSimulada = false;
	}
	
	//-------------------------------------------------<<M�TODOS>>-------------------------------------------------
	
	public void juegaFinal () {
		if (!finalSimulada) {
			partidoFinal.simulacionNM();
			partidoFinal.getEquipo1().setGolesFinal(partidoFinal.getGolesE1());
			partidoFinal.getEquipo2().setGolesFinal(partidoFinal.getGolesE2());
			partidoFinal.getArbitro().dirigePartido();
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
