package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JOptionPane;

/*

*/

public class BackCuartos implements Serializable{
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private static final long serialVersionUID = 1L;
	private final int CANT_P = 8;
	private final int CANTE = 8;
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	private PartidoIdaVuelta partidos [];
	private Resultados resultados [];
	private Equipo pasanASemis [];
	private int partidoActual;
	private ArrayList <Equipo> ganadores;
	private ArrayList <Equipo> equipos;
	private boolean cuartosTodoSimulado;
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public BackCuartos(ArrayList <Equipo> equipos, ArrayList <Referi> referis) {
		int i = 0,k = 0;
		cuartosTodoSimulado = false;
		this.equipos = equipos;
		ganadores = new ArrayList <Equipo> ();
		Collections.shuffle(this.equipos);
		partidos = new PartidoIdaVuelta [CANT_P] ;
		Random aleatorio = new Random ();
	    Referi referi1 = referis.get(aleatorio.nextInt(referis.size()));
		for(;i<CANT_P/2;i++) {
        	while (referi1.getNacionalidad() != this.equipos.get(k).getPais() && referi1.getNacionalidad() != this.equipos.get(k+1).getPais()) {
        		referi1 = referis.get(aleatorio.nextInt(referis.size()));
        	}
			partidos[i] = new PartidoIdaVuelta (this.equipos.get(k),this.equipos.get(k+1), referi1);
			k+=2;
		}
		k= 0;
		for(;i<CANT_P;i++) {
			while (referi1.getNacionalidad() != this.equipos.get(k).getPais() && referi1.getNacionalidad() != this.equipos.get(k+1).getPais()) {
        		referi1 = referis.get(aleatorio.nextInt(referis.size()));
        	}
			partidos[i] = new PartidoIdaVuelta (this.equipos.get(k+1),this.equipos.get(k), referi1);
			k += 2;
		}
		this.resultados = new Resultados [CANT_P];
		this.partidoActual = 0;
	}
	//-------------------------------------------------<<M�TODOS DE LA CLASE>>-------------------------------------------------
	
	public void SimulaPartido () {
			if (!cuartosTodoSimulado) {
				if (partidoActual >= CANT_P/2) { //SI YA ESTA EN LOS PARTIDOS DE VUELTA
					partidos[partidoActual].simulacionNM();
					partidos[partidoActual].getEquipo1().setGolesVueltaCuartos(partidos[partidoActual].getGolesE1());
					partidos[partidoActual].getEquipo2().setGolesVueltaCuartos(partidos[partidoActual].getGolesE2());
					partidos[partidoActual].getEquipo1().setGolesContra(partidos[partidoActual].getGolesE2()); //ASIGNA GOLES EN CONTRA DE CADA EQUIPO
					partidos[partidoActual].getEquipo2().setGolesContra(partidos[partidoActual].getGolesE1());
					partidos[partidoActual].getEquipo1().setpJ(); //INCREMENTA LOS PARTIDOS JUGADOS PARA CADA EQUIPO
					partidos[partidoActual].getEquipo2().setpJ();
					partidos[partidoActual].getArbitro().dirigePartido();
					resultados[partidoActual] = new Resultados (partidos[partidoActual].getEquipo1(), partidos[partidoActual].getEquipo2(), partidos[partidoActual].getGolesE1(), partidos[partidoActual].getGolesE2());
					if (resultados[partidoActual].getGolesE1() + resultados [partidoActual-(CANT_P/2)].getGolesE2() == resultados[partidoActual].getGolesE2() + resultados [partidoActual-(CANT_P/2)].getGolesE1()) { //SI LA SUMA DE LOS GOLES DE CADA EQUIPO EN AMBOS PARTIDOS ES IGUAL
						if (resultados[partidoActual].getGolesE2() > resultados [partidoActual-(CANT_P/2)].getGolesE2()) { //SI LOS GOLES DEL EQUIPO 2 EN LA IDA SON MAYORES QUE LOS DEL EQUIPO 2 EN LA VUELTA
							ganadores.add(partidos[partidoActual].getEquipo2());
							partidos[partidoActual].getEquipo2().setGolVisitante(true);
						}
						else if (resultados[partidoActual].getGolesE2() < resultados [partidoActual-(CANT_P/2)].getGolesE2()) { // SI LOS GOLES DE EQUIPO 2 EN LA VUELTA SON MAYORES QUE LOS DEL EQUIPO 2 EN LA IDA
							ganadores.add(partidos[partidoActual-(CANT_P/2)].getEquipo2());
							partidos[partidoActual-(CANT_P/2)].getEquipo2().setGolVisitante(true);
						}
						else { // HAY PENALES
							partidos[partidoActual].simulacionPen();
							partidos[partidoActual].getEquipo1().setGolesPenalesC(partidos[partidoActual].getGolesP1());
							partidos[partidoActual].getEquipo2().setGolesPenalesC(partidos[partidoActual].getGolesP2());
							if (partidos[partidoActual].getGolesP1() > partidos[partidoActual].getGolesP2()) { // SI LOS GOLES DE PENAL DEL EQUIPO 1 SON MAYORES QUE LOS DEL EQUIPO 2
								ganadores.add(partidos[partidoActual].getEquipo1());
							}
							else { // SI LOS GOLES DE PENAL DEL EQUIPO 2 SON MAYORES QUE LOS DEL EQUIPO 1
								ganadores.add(partidos[partidoActual].getEquipo2());
							}
						}
					}
					else if (resultados[partidoActual].getGolesE1() + resultados [partidoActual-(CANT_P/2)].getGolesE2() > resultados[partidoActual].getGolesE2() + resultados [partidoActual-(CANT_P/2)].getGolesE1())  //SI GANA EN EL TOTAL EL EQUIPO 1
						ganadores.add(partidos[partidoActual].getEquipo1());
					else
						ganadores.add(partidos[partidoActual].getEquipo2()); //SI GANA EN EL TOTAL EL EQUIPO 2
				}
				else {
					partidos[partidoActual].simulacionNM();
					partidos[partidoActual].getEquipo1().setGolesIdaCuartos(partidos[partidoActual].getGolesE1());
					partidos[partidoActual].getEquipo2().setGolesIdaCuartos(partidos[partidoActual].getGolesE2());
					partidos[partidoActual].getEquipo1().setGolesContra(partidos[partidoActual].getGolesE2()); //ASIGNA GOLES EN CONTRA DE CADA EQUIPO
					partidos[partidoActual].getEquipo2().setGolesContra(partidos[partidoActual].getGolesE1());
					partidos[partidoActual].getArbitro().dirigePartido();
					resultados[partidoActual] = new Resultados (partidos[partidoActual].getEquipo1(), partidos[partidoActual].getEquipo2(), partidos[partidoActual].getGolesE1(), partidos[partidoActual].getGolesE2());
				}
				partidoActual++;
				if (partidoActual == CANT_P)
					cuartosTodoSimulado = true;
			}
	}
	public void SimulaIda () {
		while (partidoActual < CANT_P/2)
			SimulaPartido();
	}
	public void SimulaCuartos() {
		while (partidoActual < CANT_P)
			SimulaPartido();
	}
	
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	public boolean isCuartosSimulado () {
		return cuartosTodoSimulado;
	}
	
	public Equipo getEquipo (int equipo) {
		return equipos.get(equipo);
	}
	
	public int getPartidoActual() {
		return partidoActual;
	}
	
	public ArrayList<Equipo> getGanadores() {
		return ganadores;
	}

}