package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/*55-95 En el back no se usa el showMessageDialog, salvo que
sea para mostrar errores. Si se jugaron todos los partidos,
tendrías que avisar al front mediante el controlador.*/

public class SemiFinal implements Serializable{
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private static final long serialVersionUID = 1L;

	private final int CANT_P = 4;
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private PartidoIdaVuelta partidos [];
	private ArrayList <Equipo> equipos;
	private Resultados resultados [];
	private ArrayList <Equipo> ganadores;
	private int partidoActual;
	private boolean semisTodaSimulada;

	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------

	public SemiFinal(ArrayList <Equipo> equipos) {
		int i = 0,k = 0;
		semisTodaSimulada = false;
		this.equipos = equipos;
		partidos = new PartidoIdaVuelta [CANT_P];
		ganadores = new ArrayList <Equipo> ();
		Collections.shuffle(equipos);
		for(;i<CANT_P/2;i++) {
			partidos[i] = new PartidoIdaVuelta (this.equipos.get(k),this.equipos.get(k+1));
			k+=2;
		}
		k= 0;
		for(;i<CANT_P;i++) {
			partidos[i] = new PartidoIdaVuelta (this.equipos.get(k+1),this.equipos.get(k));
			k += 2;
		}
		this.resultados = new Resultados [CANT_P];
		this.partidoActual = 0;
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	
	public void SimulaPartido () {
		if (!semisTodaSimulada) {
			if (partidoActual >= CANT_P/2) { //SI YA ESTA EN LOS PARTIDOS DE VUELTA
				partidos[partidoActual].simulacionNM();
				partidos[partidoActual].getEquipo1().setGolVisitante(false);
				partidos[partidoActual].getEquipo1().setGolVisitante(false);
				partidos[partidoActual].getEquipo1().setGolesVueltaSemis(partidos[partidoActual].getGolesE1());
				partidos[partidoActual].getEquipo2().setGolesVueltaSemis(partidos[partidoActual].getGolesE2());
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
				partidos[partidoActual].getEquipo1().setGolesIdaSemis(partidos[partidoActual].getGolesE1());
				partidos[partidoActual].getEquipo2().setGolesIdaSemis(partidos[partidoActual].getGolesE2());
				resultados[partidoActual] = new Resultados (partidos[partidoActual].getEquipo1(), partidos[partidoActual].getEquipo2(), partidos[partidoActual].getGolesE1(), partidos[partidoActual].getGolesE2());
			}
			partidoActual++;
			if (partidoActual == CANT_P)
				semisTodaSimulada = true;
		}
}
	public void SimulaIda () {
		while (partidoActual < CANT_P/2)
			SimulaPartido();
	}
	public void SimulaSemis() {
		while (partidoActual < CANT_P)
			SimulaPartido();
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	public Equipo getEquipoSemis (int equipo) {
		return equipos.get(equipo);
	}
	
	public int getPartidoAct() {
		return partidoActual;
	}
	
	public String getResultado (int partido) {
		return resultados[partido].getE1() + " " + resultados[partido].getGolesE1()+"\n"+resultados[partido].getE2() + " " + resultados[partido].getGolesE2();
	}
	public ArrayList <Equipo> getGanadores() { //DEVUELVE EL ARREGLO COMPLETO CON LOS DOS EQUIPOS FINALISTAS
		return ganadores;
	}
	
	public boolean SemiFinalSimulada() {
		return semisTodaSimulada;
	}
}