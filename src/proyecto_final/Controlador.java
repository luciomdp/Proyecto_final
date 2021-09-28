package proyecto_final;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.*;
import backend.Campeonato;
import backend.Posicion;
import frontend.Frame;
import backend.Serializacion;

public class Controlador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	final int CANT_PZ = 6;
	final int CANTZ = 4;
	final int CANT_FECHAS = 3;
	final int CANT_PARTIDOS_CUARTOS = 8;
	final int CANT_PARTIDOS_SEMIS = 4;
	final int CANT_PARTIDOS_FINAL = 1;
	private Campeonato campeonatoActual;
	private transient Frame frameActual; //transient= el objeto no se serializa
	Serializacion progreso = new Serializacion();
	
	/* Constructor de controlador de campeonato*/
	public Controlador (Campeonato c, Frame f) {
		campeonatoActual = c;
		frameActual = f;
	}
	
	/*Inicia torneo*/
	public void IniciaTorneo() {
		//inicia torneo con todos datos neutros (no paso nada)
		String Zonas[] = new String[4];
		campeonatoActual.IniciaTorneo();
		for(int i = 0; i<4; i++) 
			Zonas[i] = campeonatoActual.getZona(i).getValoresTabla();
		//pasarle por parametro al inicia torneo del frame, los strings de las 4 zonas.
		frameActual.IniciaTorneo(Zonas);
	}
	
	/*Reanuda torneo*/
	public void ContinuaTorneo() {
		//inicia torneo con todos datos serializados (se pasan por parametro de IniciaTorneo())
		try {
			
			this.setCampeonato(progreso.leeProgreso());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/*Guarda torneo*/
	public void SerializaProgreso() {
		//acá hay que guardar el torneo actual
		try {

			progreso.guardaProgreso(campeonatoActual);
	
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* Listado de jugadores de determinada posición seleccionada por el operador (arquero,
		defensor, mediocampista, delantero) mostrando toda la información disponible del mismo.
		En el caso de los arqueros, mostrar la cantidad de Goles en Contra que recibió su equipo y
		el promedio de gol recibido por partido. */
	public String getListadoJugadores(Posicion pos) {
		return campeonatoActual.listaJugadores(pos);
	}
	
	/*Listado alfabético de los equipos mostrando edad promedio de sus jugadores, edad y
		nacionalidad de su DT, efectividad (porcentaje de puntos obtenidos sobre puntos posibles).*/
	public String getListadoEquipos() {
		return campeonatoActual.listaEquipos();
	}

	/*Ranking de referís por cantidad de partidos dirigidos en el campeonato. Indicar para cada
		uno la cantidad de años en el referato, y al final del listado el promedio de los mismos.*/
	public String getListadoArbitros() {
		return campeonatoActual.listaArbitros();
	}
	
	public void setCampeonato (Campeonato _campeonato) {
		this.campeonatoActual = _campeonato;
	}
	
	//-------------------------------------------------<<SIMULADORES ZONA>>-------------------------------------------------
	
	public void SimulaPartidoZ (int zona) { //recibe la zona de la que se simula un partido 
		if(campeonatoActual.getZona(zona).getPartidoAct() + 1 == CANT_PZ) {
			campeonatoActual.getZona(zona).SimulaPartido();
			frameActual.ZonaSimulada(zona);
			ZonaSimulada();
		}else
			campeonatoActual.getZona(zona).SimulaPartido();
		//evaluar si se puede simular otro partido, sino, llamar al metodo ZtodoSimulado(zona) del Frame
	}
	public void SimulaFechaZ (int zona) { //recibe la zona de la que se simula una fecha
		
		if(campeonatoActual.getZona(zona).getFechaAct() == CANT_FECHAS) {
			campeonatoActual.getZona(zona).SimulaFecha();
			frameActual.ZonaSimulada(zona);
			ZonaSimulada();
		}else
			campeonatoActual.getZona(zona).SimulaFecha();	
		
		//evaluar si se puede simular otro partido, sino, llamar al metodo ZtodoSimulado(zona) del Frame
	}
	public void SimulaZonaZ (int zona) { //recibe la zona que se simula toda 
		
		campeonatoActual.getZona(zona).SimulaZona();
		frameActual.ZonaSimulada(zona);
		ZonaSimulada();
		
	}
	
	public void SimulaZonas() { //simula todas las zonas
		for (int i = 0; i < CANTZ; i++) {
			campeonatoActual.getZona(i).SimulaZona();
			frameActual.ZonaSimulada(i);
		}
		ZonaSimulada();

	}
	
	public void ZonaSimulada() {
		if(campeonatoActual.TodasZonasSimuladas()) {
			campeonatoActual.IniciaCuartos();
			frameActual.ZtodoSimulado();
		}
	}
	
	public String getZona (int zona) { //recibe la zona de la que quiere que se devuelva el String
		return campeonatoActual.getZona(zona).getValoresTabla();
	}
	
	//-------------------------------------------------<<SIMULADORES CUARTOS>>-------------------------------------------------
	
	public String getECuartos(int equipo) {//DEBERIA RETORNAR EL STRING DEL EQUIPO, CON LA ACTUALIZACION EN GOLES IDA, VUELTA, ETC
		if (campeonatoActual.getCuartosDeFinal().getPartidoActual() == 0)
			return campeonatoActual.getECuartosFinal(equipo).getNombre();
		else if (campeonatoActual.getCuartosDeFinal().getPartidoActual() <= 4) 
			return campeonatoActual.getECuartosFinal(equipo).getEstadisticasCuartosIda();
		else if (campeonatoActual.getCuartosDeFinal().getPartidoActual() < 8)
			return campeonatoActual.getECuartosFinal(equipo).getEstadisticasCuartosVuelta();
		else 
			return campeonatoActual.getECuartosFinal(equipo).getEstadisticasCuartosVuelta();
	}
	
	public int SimulaPartidoC() { //Devuelve el partido que se jugo (1,2,3 o 4)
		//evaluar si se puede simular otro partido de ida, sino, llamar al metodo CtodoSimulado(0) del Frame
		//evaluar si se puede simular otro partido , sino, llamar al metodo CtodoSimulado(1) del Frame
		if (campeonatoActual.getCuartosDeFinal().getPartidoActual() + 1  == CANT_PARTIDOS_CUARTOS) {
			campeonatoActual.getCuartosDeFinal().SimulaPartido();
			CuartosSimulado();
			return campeonatoActual.getCuartosDeFinal().getPartidoActual() - 5  ;
		}else {
			campeonatoActual.getCuartosDeFinal().SimulaPartido();
			if(campeonatoActual.getCuartosDeFinal().getPartidoActual () - 1 < CANT_PARTIDOS_CUARTOS/2)
				return campeonatoActual.getCuartosDeFinal().getPartidoActual() - 1;
			else
				return campeonatoActual.getCuartosDeFinal().getPartidoActual() - 5 ;
		}
	}
	public int simulaPartidosIdaC() {//Devuelve a partir de que partido  se simulo (1,2,3 o 4)
		int partidoComienzo = campeonatoActual.getCuartosDeFinal().getPartidoActual();
		if (partidoComienzo < CANT_PARTIDOS_CUARTOS/2) {
			campeonatoActual.getCuartosDeFinal().SimulaIda();
		}
		frameActual.CtodoSimulado(0); //saca del frame la posibilidad de jugar mas partidos ida
		return 0;
	}
	public int simulaPartidosCuartos() {//Devuelve a partir de que partido  se simulo (1,2,3 o 4)
		//int partidoInicio = campeonatoActual.getCuartosDeFinal().getPartidoActual();
		if (!campeonatoActual.getCuartosDeFinal().isCuartosSimulado())
			campeonatoActual.getCuartosDeFinal().SimulaCuartos();
		CuartosSimulado();
		return 0;
	}
	
	public void CuartosSimulado() {
		if(campeonatoActual.getCuartosDeFinal().isCuartosSimulado()) {
			campeonatoActual.IniciaSemis();
			frameActual.CtodoSimulado(1);
		}
	}
	//-------------------------------------------------<<SIMULADORES SEMIS>>-------------------------------------------------
		
	public String getESemis(int equipo) {//DEBERIA RETORNAR EL STRING DEL EQUIPO, CON LA ACTUALIZACION EN GOLES IDA, VUELTA, ETC
		if (campeonatoActual.getSemiFinal().getPartidoAct() == 0)
			return campeonatoActual.getESemiFinal(equipo).getNombre();
		else if (campeonatoActual.getSemiFinal().getPartidoAct() <= 2) 
			return campeonatoActual.getESemiFinal(equipo).getEstadisticasSemisIda();
		else if (campeonatoActual.getSemiFinal().getPartidoAct() < 4)
			return campeonatoActual.getESemiFinal(equipo).getEstadisticaSemis();
		else 
			return campeonatoActual.getESemiFinal(equipo).getEstadisticaSemis();
	}
	
	
	public int SimulaPartidoS() { //Devuelve el partido que se jugo (1,2,3 o 4)
		//evaluar si se puede simular otro partido de ida, sino, llamar al metodo CtodoSimulado(0) del Frame
		//evaluar si se puede simular otro partido , sino, llamar al metodo CtodoSimulado(1) del Frame
		if (campeonatoActual.getSemiFinal().getPartidoAct() + 1  == CANT_PARTIDOS_SEMIS) {
			campeonatoActual.getSemiFinal().SimulaPartido();
			SemiFinalesSimuladas();
			return campeonatoActual.getSemiFinal().getPartidoAct() - 3  ;
		}else {
			campeonatoActual.getSemiFinal().SimulaPartido();
			if(campeonatoActual.getSemiFinal().getPartidoAct() - 1 < CANT_PARTIDOS_SEMIS/2)
				return campeonatoActual.getSemiFinal().getPartidoAct() - 1;
			else
				return campeonatoActual.getSemiFinal().getPartidoAct() - 3 ;
		}
	}
	
	
	public int simulaPartidosIdaS() {//Devuelve a partir de que partido  se simulo (1,2,3 o 4)
		int partidoComienzo = campeonatoActual.getSemiFinal().getPartidoAct();
		if (partidoComienzo < CANT_PARTIDOS_SEMIS/2) {
			campeonatoActual.getSemiFinal().SimulaIda();
		}
		frameActual.StodoSimulado(0); //saca del frame la posibilidad de jugar mas partidos ida
		return 0;
	}
	
	public int simulaPartidosSemis() {//Devuelve a partir de que partido  se simulo (1,2,3 o 4)
		//int partidoInicio = campeonatoActual.getSemiFinal().getPartidoAct();
		if (!campeonatoActual.getSemiFinal().SemiFinalSimulada())
			campeonatoActual.getSemiFinal().SimulaSemis();
		SemiFinalesSimuladas();
		return 0;
	}
	public void SemiFinalesSimuladas() {
		if(campeonatoActual.getSemiFinal().SemiFinalSimulada()) {
			campeonatoActual.IniciaFinal();
			frameActual.StodoSimulado(1);
		}
	}
	
	//-------------------------------------------------<< SIMULADORES FINAL >>--------------------------------------------------------------------
		
		public String getEFinal(int equipo) {//DEBERIA RETORNAR EL STRING DEL EQUIPO, CON LA ACTUALIZACION EN GOLES IDA, VUELTA, ETC
			return campeonatoActual.getFinal().getEquipo(equipo).getNombre();
		}
		
		public int getGFinal(int equipo) {
			return campeonatoActual.getFinal().getEquipo(equipo).getGolesFinal();
		}
		
		public void SimulaFinal() { 
			if (!campeonatoActual.getFinal().isFinalSimulada()) {
				campeonatoActual.getFinal().juegaFinal();
				frameActual.FtodoSimulado();
				JOptionPane.showMessageDialog(null,campeonatoActual.getFinal().getCampeon() + " es el nuevo campeon de la copa!");
			}
			//NOSE SI HAY QUE DEFINIR ALGO ACA CUANDO SE JUEGA LA FINAL (BLOQUEAR EL BOTÓN POR EJ)
		}
	
}
