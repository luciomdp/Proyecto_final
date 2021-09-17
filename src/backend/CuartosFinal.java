package backend;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/*
55 y 92- En el back no se usa el showMessageDialog, salvo que
sea para mostrar errores. Si se jugaron todos los partidos,
tendrías que avisar al front mediante el controlador.

102- ¿Qué es ese metodo comentado, es necesario? resolver
*/

public class CuartosFinal{
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private final int CANT_P = 8;
	private final int CANTE = 8;
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	private PartidoIdaVuelta partidos [];
	private Resultados resultados [];
	private Equipo pasanASemis [];
	private int partidoActual, k;
	private ArrayList <Equipo> ganador;
	private ArrayList <Equipo> equipos;
	private boolean cuartosTodoSimulado;
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public CuartosFinal(ArrayList <Equipo> equipos) {
		this.equipos = equipos;
		cuartosTodoSimulado = false;
		Collections.shuffle(this.equipos);
		this.partidos = new PartidoIdaVuelta [CANT_P] ;
		int k= 0;
		for (int i = 0; i < CANT_P; i+=2) { //El EQUIPO A DEL PARTIDO SIEMPRE ES EL LOCAL, EL B EL VISITANTE
			partidos[k] = new PartidoIdaVuelta (this.equipos.get(i),this.equipos.get(i++));
			k++;
		}
		for (int i = 0; i < CANT_P; i+=2) {
			partidos[k] = new PartidoIdaVuelta (this.equipos.get(i++),this.equipos.get(i));
			k++;
		}
		this.resultados = new Resultados [CANT_P];
		this.partidoActual = 0;
	}
	//-------------------------------------------------<<MÉTODOS DE LA CLASE>>-------------------------------------------------
	
	public void SimulaPartido () {
			if (!cuartosTodoSimulado) {
				partidos[partidoActual].simulacionNM();
				partidos[partidoActual].getEquipo1().setGolesIdaCuartos(partidos[partidoActual].getGolesE1());
				partidos[partidoActual].getEquipo2().setGolesIdaCuartos(partidos[partidoActual].getGolesE2());
				resultados[partidoActual] = new Resultados (partidos[partidoActual].getEquipo1(), partidos[partidoActual].getEquipo2(), partidos[partidoActual].getGolesE1(), partidos[partidoActual].getGolesE2());
				if (partidoActual >= CANT_P/2) {
					if (resultados[partidoActual].getGolesE1() + resultados [partidoActual-(CANT_P/2)].getGolesE2() == resultados[partidoActual].getGolesE2() + resultados [partidoActual-(CANT_P/2)].getGolesE1()) { //SI LA SUMA DE LOS GOLES DE CADA EQUIPO EN AMBOS PARTIDOS ES IGUAL
						if (resultados[partidoActual].getGolesE2() > resultados [partidoActual-(CANT_P/2)].getGolesE2()) { //SI LOS GOLES DEL EQUIPO 2 EN LA IDA SON MAYORES QUE LOS DEL EQUIPO 2 EN LA VUELTA
							this.setGanador(partidos[partidoActual].getEquipo2());
						}
						else if (resultados[partidoActual].getGolesE2() < resultados [partidoActual-(CANT_P/2)].getGolesE2()) { // SI LOS GOLES DE EQUIPO 2 EN LA VUELTA SON MAYORES QUE LOS DEL EQUIPO 2 EN LA IDA
							this.setGanador(partidos[partidoActual-(CANT_P/2)].getEquipo2());
						}
						else { // HAY PENALES
							partidos[partidoActual].simulacionPen();
							if (partidos[partidoActual].getGolesP1() > partidos[partidoActual].getGolesP2()) { // SI LOS GOLES DE PENAL DEL EQUIPO 1 SON MAYORES QUE LOS DEL EQUIPO 2
								this.setGanador(partidos[partidoActual].getEquipo1());
							}
							else { // SI LOS GOLES DE PENAL DEL EQUIPO 2 SON MAYORES QUE LOS DEL EQUIPO 1
								this.setGanador(partidos[partidoActual].getEquipo2());
							}
						}
					}
					else if (resultados[partidoActual].getGolesE1() + resultados [partidoActual-(CANT_P/2)].getGolesE2() > resultados[partidoActual].getGolesE2() + resultados [partidoActual-(CANT_P/2)].getGolesE1())  //SI GANA EN EL TOTAL EL EQUIPO 1
						this.setGanador(partidos[partidoActual].getEquipo1());
					else
						this.setGanador(partidos[partidoActual].getEquipo2()); //SI GANA EN EL TOTAL EL EQUIPO 2
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
	public void setGanador(Equipo pasaAFinal) { // INGRESA EQUIPO FINALISTA
		this.ganador.add(pasaAFinal);
	}
	public boolean isCuartosSimulado () {
		return cuartosTodoSimulado;
	}
	
	public Equipo getEquipo (int equipo) {
		return equipos.get(equipo);
	}
	
	public int getPartidoActual() {
		return partidoActual;
	}
	 /* SE SUPONE QUE HEREDA DE SEMIFINAL
	public String getResultado (int partido) { 
		return resultados[partido].getE1() + " " + resultados[partido].getGolesE1()+"\n"+resultados[partido].getE2() + " " + resultados[partido].getGolesE2();
	}*/
	



}
