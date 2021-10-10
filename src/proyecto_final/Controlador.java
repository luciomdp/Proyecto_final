package proyecto_final;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.*;
import backend.Campeonato;
import backend.Posicion;
import frontend.Frame;
import backend.Serializacion;

/**
 * Clase que conecta back y front
 */
public class Controlador implements Serializable {
	
	/** Serial*/
	private static final long serialVersionUID = 1L;
	/*transient => no se serializa*/
	/** Cantidad de partidos por zona*/
	final transient int CANT_PZ = 6;
	/** Cantidad de zonas*/
	final transient int CANTZ = 4;
	/** Cantidad de fechas*/
	final transient int CANT_FECHAS = 3;
	/** Cantidad de partidos en cuartos*/
	final transient int CANT_PARTIDOS_CUARTOS = 8;
	/** Cantidad de partidos en semis*/
	final transient int CANT_PARTIDOS_SEMIS = 4;
	/** Cantidad de partidos en la final*/
	final transient int CANT_PARTIDOS_FINAL = 1;
	/** Objeto del campeonato actual*/
	private Campeonato campeonatoActual;
	/** Front-end*/
	private Frame frameActual;
	
	
	/**
	 * Constructor del controlador
	 * @param c Campeonato a controlar
	 * @param f Frame del programa
	 */
	public Controlador (Campeonato c, Frame f) {
		campeonatoActual = c;
		frameActual = f;
	}
	
	/**
	 * Setea el front
	 */
	public void setFrame(Frame _frame) {
		this.frameActual = _frame;
	}
	
	
	/**
	 * Inicia un torneo desde cero
	 */
	public void IniciaTorneo() {
		//inicia torneo con todos datos neutros (no paso nada)
		String Zonas[] = new String[4];
		campeonatoActual.IniciaTorneo();
		for(int i = 0; i<4; i++) 
			Zonas[i] = campeonatoActual.getZona(i).getValoresTabla();
		//pasarle por parametro al inicia torneo del frame, los strings de las 4 zonas.
		frameActual.IniciaTorneo(Zonas);
	}
	
	/**
	 * Reanuda un torneo previamente guardado
	 * @see Serializacion
	 */
	public void ContinuaTorneo() {
		//inicia torneo con todos datos serializados (se pasan por parametro de IniciaTorneo())
		try {
			
			Object[] _objetos = Serializacion.leeProgreso();
			this.setCampeonato((Campeonato) _objetos[0]);
			this.setFrame((Frame) _objetos[1]);
			
		} catch (FileNotFoundException e) {
			//si no se encuentra el archivo a leer
			JOptionPane.showMessageDialog(null, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		
		} catch (IOException e) {
			//si existe el archivo pero no se puede leer
			JOptionPane.showMessageDialog(null, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		
		} catch (ClassNotFoundException e) {
			//si la clase a reconstruir no existe
			JOptionPane.showMessageDialog(null, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
	}
	
	/**
	 * Guarda un torneo en un archivo 'Progreso'
	 * @see Serializacion
	 */
	public void SerializaProgreso() {
		//acá hay que guardar el torneo actual
		try {

			Serializacion.guardaProgreso(campeonatoActual, frameActual);
	
		} catch (FileNotFoundException e) {
			//si no se encuentra el archivo a leer
			JOptionPane.showMessageDialog(null, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		
		} catch (IOException e) {
			//si existe el archivo pero no se puede leer
			JOptionPane.showMessageDialog(null, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		
		}
	}
	
	/**
	 * Devuelve un listado de jugadores segun la posicion
	 * @param pos La posicion a consultar
	 * @return String con los jugadores
	 */
	public String getListadoJugadores(Posicion pos) {
		return campeonatoActual.listaJugadores(pos);
	}
	
	/**
	 * Devuelve un listado de equipos
	 * @return String con los equipos
	 */
	public String getListadoEquipos() {
		return campeonatoActual.listaEquipos();
	}

	/**
	 * Devuelve un listado de arbitros
	 * @return String con los arbitros
	 */
	public String getListadoArbitros() {
		return campeonatoActual.listaArbitros();
	}
	
	/**
	 * Setter para el campeonato del controlador
	 * @param _campeonato Un objeto Campeonato
	 */
	public void setCampeonato (Campeonato _campeonato) {
		this.campeonatoActual = _campeonato;
	}
	
	//-------------------------------------------------<<SIMULADORES ZONA>>-------------------------------------------------
	
	/**
	 * Simula un partido de zona
	 * @param zona Integer representando la zona
	 */
	public void SimulaPartidoZ (int zona) { //recibe la zona de la que se simula un partido 
		if(campeonatoActual.getZona(zona).getPartidoAct() + 1 == CANT_PZ) {
			campeonatoActual.getZona(zona).SimulaPartido();
			frameActual.ZonaSimulada(zona);
			ZonaSimulada();
		} else
			campeonatoActual.getZona(zona).SimulaPartido();
		//evaluar si se puede simular otro partido, sino, llamar al metodo ZtodoSimulado(zona) del Frame
	}
	
	/**
	 * Simula una fecha de la zona
	 * @param zona Integer representando la zona
	 */
	public void SimulaFechaZ (int zona) { //recibe la zona de la que se simula una fecha
		
		if(campeonatoActual.getZona(zona).getFechaAct() == CANT_FECHAS) {
			campeonatoActual.getZona(zona).SimulaFecha();
			frameActual.ZonaSimulada(zona);
			ZonaSimulada();
		} else {
			campeonatoActual.getZona(zona).SimulaFecha();	
		}
		//evaluar si se puede simular otro partido, sino, llamar al metodo ZtodoSimulado(zona) del Frame
	}
	
	/**
	 * Simula una zona entera
	 * @param zona Integer representando la zona
	 */
	public void SimulaZonaZ (int zona) { //recibe la zona que se simula toda 
		
		campeonatoActual.getZona(zona).SimulaZona();
		frameActual.ZonaSimulada(zona);
		ZonaSimulada();
		
	}
	
	/**
	 * Simula todas las zonas
	 */
	public void SimulaZonas() { //simula todas las zonas
		for (int i = 0; i < CANTZ; i++) {
			campeonatoActual.getZona(i).SimulaZona();
			frameActual.ZonaSimulada(i);
		}
		ZonaSimulada();

	}
	
	/**
	 * Inicia los cuartos de final (todas las zonas simuladas)
	 */
	public void ZonaSimulada() {
		if(campeonatoActual.TodasZonasSimuladas()) {
			campeonatoActual.IniciaCuartos();
			frameActual.ZtodoSimulado();
		}
	}
	
	/**
	 * Devuelve los resultados de una zona especifica
	 * @param zona Integer representando la zona
	 * @return Los resultados de la zona
	 */
	public String getZona (int zona) { //recibe la zona de la que quiere que se devuelva el String
		return campeonatoActual.getZona(zona).getValoresTabla();
	}
	
	//-------------------------------------------------<<SIMULADORES CUARTOS>>-------------------------------------------------
	
	/**
	 * Devuelve los resultados de un equipo de cuartos
	 * @param equipo Integer representando el equipo
	 * @return String con los resultados
	 */
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
	
	/**
	 * Simula un partido de cuartos de final
	 * @return Integer representando el partido que se jugo
	 */
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
			else {
				frameActual.CtodoSimulado(0);
				return campeonatoActual.getCuartosDeFinal().getPartidoActual() - 5 ;
			}	
		}
	}
	
	/**
	 * Simula los partidos de ida de los cuartos de final
	 * @return Integer representando el partido que se jugo
	 */
	public int simulaPartidosIdaC() {//Devuelve a partir de que partido  se simulo (1,2,3 o 4)
		int partidoComienzo = campeonatoActual.getCuartosDeFinal().getPartidoActual();
		if (partidoComienzo < CANT_PARTIDOS_CUARTOS/2) {
			campeonatoActual.getCuartosDeFinal().SimulaIda();
		}
		frameActual.CtodoSimulado(0); //saca del frame la posibilidad de jugar mas partidos ida
		return 0;
	}
	
	/**
	 * Simula algo de los cuartos -> TODO (el TODO para que marque la línea)
	 * @return Integer representando el partido que se jugo
	 */
	public int simulaPartidosCuartos() {//Devuelve a partir de que partido  se simulo (1,2,3 o 4)
		//int partidoInicio = campeonatoActual.getCuartosDeFinal().getPartidoActual();
		if (!campeonatoActual.getCuartosDeFinal().isCuartosSimulado())
			campeonatoActual.getCuartosDeFinal().SimulaCuartos();
		CuartosSimulado();
		return 0;
	}
	
	/**
	 * Setea todos los cuartos de final simulados
	 */
	public void CuartosSimulado() {
		if(campeonatoActual.getCuartosDeFinal().isCuartosSimulado()) {
			campeonatoActual.IniciaSemis();
			frameActual.CtodoSimulado(1);
		}
	}
	//-------------------------------------------------<<SIMULADORES SEMIS>>-------------------------------------------------
	
	/**
	 * Devuelve los resultados del equipos
	 * @param equipo Integer representando el equipo
	 * @return String con los resultados
	 */
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
	
	/**
	 * Simula partido de semifinal
	 * @return Integer representando el partido que se jugo
	 */
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
			else {
				frameActual.StodoSimulado(0);
				return campeonatoActual.getSemiFinal().getPartidoAct() - 3 ;
			}
		}
	}
	
	/**
	 * Simula los partidos de ida de la semifinal
	 * @return Integer representando el partido que se jugo
	 */
	public int simulaPartidosIdaS() {//Devuelve a partir de que partido  se simulo (1,2,3 o 4)
		int partidoComienzo = campeonatoActual.getSemiFinal().getPartidoAct();
		if (partidoComienzo < CANT_PARTIDOS_SEMIS/2) {
			campeonatoActual.getSemiFinal().SimulaIda();
		}
		frameActual.StodoSimulado(0); //saca del frame la posibilidad de jugar mas partidos ida
		return 0;
	}
	
	/**
	 * Simula los partidos de la semifinal
	 * @return Integer representando el partido que se jugo
	 */
	public int simulaPartidosSemis() {//Devuelve a partir de que partido  se simulo (1,2,3 o 4)
		//int partidoInicio = campeonatoActual.getSemiFinal().getPartidoAct();
		if (!campeonatoActual.getSemiFinal().SemiFinalSimulada())
			campeonatoActual.getSemiFinal().SimulaSemis();
		SemiFinalesSimuladas();
		return 0;
	}
	
	/**
	 * Setea la semifinal simulada
	 */
	public void SemiFinalesSimuladas() {
		if(campeonatoActual.getSemiFinal().SemiFinalSimulada()) {
			campeonatoActual.IniciaFinal();
			frameActual.StodoSimulado(1);
		}
	}
	
	//-------------------------------------------------<< SIMULADORES FINAL >>--------------------------------------------------------------------
	
	/**
	 * Devuelve resultados del equipo
	 * @param equipo Integer representando el equipo
	 * @return String con los resultados del equipo
	 */
	public String getEFinal(int equipo) {//DEBERIA RETORNAR EL STRING DEL EQUIPO, CON LA ACTUALIZACION EN GOLES IDA, VUELTA, ETC
		return campeonatoActual.getFinal().getEquipo(equipo).getNombre();
	}
	
	/**
	 * Devuelve los goles de la final de un equipo
	 * @param equipo Integer representando el equipo
	 * @return Integer representando la cantidad de goles TODO -> imagino que a favor
	 */
	public String getGFinal(int equipo) {
		return campeonatoActual.getFinal().getEquipo(equipo).getEstadisticasFinal();
	}

	/**
	 * Simula la final del campeonato
	 */
	public void SimulaFinal() { 
		if (!campeonatoActual.getFinal().isFinalSimulada()) {
			campeonatoActual.getFinal().juegaFinal();
			frameActual.FtodoSimulado();
			JOptionPane.showMessageDialog(null,campeonatoActual.getFinal().getCampeon() + " es el nuevo campeon de la copa!");
		}
		//NOSE SI HAY QUE DEFINIR ALGO ACA CUANDO SE JUEGA LA FINAL (BLOQUEAR EL BOTÓN POR EJ)
	}

	public int CantPJZona(int zona) {
		return campeonatoActual.getZona(zona).getPartidoAct();
	}

	public String[] getE1Zona(int zona) {
		// TODO Auto-generated method stub
		String a[] = new String[6];
		int j = 1;
		for (int i = 0;i<5;i++) {
			a[i] = "Equipo " + j;
			j+=2;
		}
		return a;
	}
	
	public String[] getE2Zona(int zona) {
		// TODO Auto-generated method stub
		String a[] = new String[6];
		int j = 2;
		for (int i = 0;i<5;i++) {
			a[i] = "Equipo " + j;
			j+=2;
		}
		return a;
	}
	
}
