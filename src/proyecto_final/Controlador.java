package proyecto_final;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JOptionPane;

import backend.Campeonato;
import backend.Posicion;
import backend.Serializacion;
import frontend.Frame;

/**
 * Clase que conecta back y front
 */
public class Controlador implements Serializable {
	
	/** Serial*/
	private static final long serialVersionUID = 1L;
	/*transient => no se serializa*/
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
		String Zonas[] = new String[campeonatoActual.getCANTZ()];
		campeonatoActual.IniciaTorneo();
		for(int i = 0; i<Zonas.length; i++) 
			Zonas[i] = campeonatoActual.getZona(i).getValoresTabla();
		//pasarle por parametro al inicia torneo del frame, los strings de las 4 zonas.
		
		frameActual.setControlador(this);
		frameActual.IniciaTorneo(Zonas);
	}
	
	/**
	 * Reanuda un torneo previamente guardado
	 * @see Serializacion
	 */
	public void ContinuaTorneo() {
		/** @nota: continuar el torneo NO es lo mismo que iniciar el torneo nuevamente, 
		 *         NO puedo usar los mismos métodos del controlador, eso me cambiaría la info del back!*/
		try {
			this.setCampeonato((Campeonato) Serializacion.leeProgreso());
			
			String[] zonas = new String[campeonatoActual.getCANTZ()];
			
			for (int i = 0; i < zonas.length; i++) {
				zonas[i] = campeonatoActual.getZona(i).getValoresTabla();
			}
			
			/** Si las zonas no están simuladas, arranco desde las zonas*/
			if (!campeonatoActual.TodasZonasSimuladas()) {
				frameActual.continuaTorneo(zonas, 0);
				
				/** Si hay cuartos y no hay semis, se reanudan los cuartos*/	
			} else if ((campeonatoActual.getECuartosFinal(0) != null) && (campeonatoActual.getSemiFinal() == null)) {
				frameActual.continuaTorneo(zonas, 1);
				
				/** Si hay semi, y no esta la final simulada, entonces, se reanuda la semi*/
			} else if ((campeonatoActual.getESemiFinal(0) != null) && (campeonatoActual.getFinal() == null)) {
				frameActual.continuaTorneo(zonas, 2);
				
				/** Si no hay final simulada pero se jugo la semi, sigo con la final*/
			} else if (!campeonatoActual.getFinal().isFinalSimulada()) {
				frameActual.continuaTorneo(zonas, 3);
				
				/** Todo simulado*/
			} else {
				frameActual.continuaTorneo(zonas, 4);
				
			}
			
		} catch (FileNotFoundException e) {
			//si no se encuentra el archivo a leer
			JOptionPane.showMessageDialog(frameActual, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		
		} catch (IOException e) {
			//si existe el archivo pero no se puede leer
			JOptionPane.showMessageDialog(frameActual, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		
		} catch (ClassNotFoundException e) {
			//si la clase a reconstruir no existe
			JOptionPane.showMessageDialog(frameActual, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
	}
	
	/**
	 * Guarda un torneo en un archivo 'Progreso'
	 * @see Serializacion
	 */
	public void SerializaProgreso() {
		//acá hay que guardar el torneo actual
		try {

			Serializacion.guardaProgreso(campeonatoActual);
	
		} catch (FileNotFoundException e) {
			//si no se encuentra el archivo a leer
			JOptionPane.showMessageDialog(frameActual, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		
		} catch (IOException e) {
			//si existe el archivo pero no se puede leer
			JOptionPane.showMessageDialog(frameActual, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		
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
	
	/**
	 * Getter para el campeonato del controlador
	 * @return campeonato El Campeonato
	 */
	public Campeonato getCampeonato () {
		return campeonatoActual;
	}
	
	/**
	 * Emite las credenciales de los equipos 
	 * @param equipo1
	 * @param equipo2
	 * @param etapa
	 * @return
	 */
	public String EmitirCredenciales(String equipo1, String equipo2, int etapa) {
		return campeonatoActual.GeneraCredenciales(equipo1, equipo2, etapa);
	}
	
	
	//-------------------------------------------------<<SIMULADORES ZONA>>-------------------------------------------------
	
	/**
	 * Simula un partido de zona
	 * @param zona Integer representando la zona
	 */
	public void SimulaPartidoZ (int zona) { //recibe la zona de la que se simula un partido 
		if(campeonatoActual.getZona(zona).getPartidoAct() + 1 == campeonatoActual.getCANTZ()) {
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
		
		if(campeonatoActual.getZona(zona).getFechaAct() == campeonatoActual.getZona(0).getCANT_PF()) {
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
		for (int i = 0; i < campeonatoActual.getCANTZ(); i++) {
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
	
	public int CantPJZona(int zona) {
		return campeonatoActual.getZona(zona).getPartidoAct();
	}

	public String[] getE1Zona(int zona) {
		String E1[] = new String[campeonatoActual.getZona(zona).getPartidoAct()];
		for (int i = 0; i < campeonatoActual.getZona(zona).getPartidoAct(); i++) {
			E1[i] =  campeonatoActual.getZona(zona).getPartidosZona()[i].getEquipo1().getNombre() + " " + campeonatoActual.getZona(zona).getPartidosZona()[i].getGolesE1() + " ";
		}
		return E1;
	}
	
	public String[] getE2Zona(int zona) {
		String E2[] = new String[campeonatoActual.getZona(zona).getPartidoAct()];
		for (int i = 0; i < campeonatoActual.getZona(zona).getPartidoAct(); i++) {
			E2[i] = campeonatoActual.getZona(zona).getPartidosZona()[i].getEquipo2().getNombre() + " " + campeonatoActual.getZona(zona).getPartidosZona()[i].getGolesE2() + " ";
		}
		return E2;
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
	public int SimulaPartidoC() { //Devuelve el partido que se jugo (0, 1, 2, 3)
		if (campeonatoActual.getCuartosDeFinal().getPartidoActual() + 1  == campeonatoActual.getSemiFinal().getCANT_P()) {
			campeonatoActual.getCuartosDeFinal().SimulaPartido();
			CuartosSimulado();
			return campeonatoActual.getCuartosDeFinal().getPartidoActual() - 5  ;
		}else {
			campeonatoActual.getCuartosDeFinal().SimulaPartido();
			if(campeonatoActual.getCuartosDeFinal().getPartidoActual () - 1 < campeonatoActual.getSemiFinal().getCANT_P()/2) 
				return campeonatoActual.getCuartosDeFinal().getPartidoActual() - 1;
			else {
				frameActual.CtodoSimulado(0, 0, 0, 0, 0);
				return campeonatoActual.getCuartosDeFinal().getPartidoActual() - 5 ;
			}	
		}
	}
	
	/**
	 * Simula los partidos de ida de los cuartos de final
	 * @return Integer representando el partido que se jugo
	 */
	public int simulaPartidosIdaC() {//Devuelve a partir de que partido  se simulo (0, 1, 2, 3)
		int partidoComienzo = campeonatoActual.getCuartosDeFinal().getPartidoActual();
		if (partidoComienzo < campeonatoActual.getCuartosDeFinal().getCANT_P()/2) {
			campeonatoActual.getCuartosDeFinal().SimulaIda();
		}
		frameActual.CtodoSimulado(0, 0, 0, 0, 0);  //saca del frame la posibilidad de jugar mas partidos ida
		return 0;
	}
	
	/**
     * Simula los partidos de cuartos de final.
	 * @return Integer representando el partido que se jugo
	 */
	public int simulaPartidosCuartos() {
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
		int g1, g2, g3, g4;
		if(campeonatoActual.getCuartosDeFinal().isCuartosSimulado()) {
			campeonatoActual.IniciaSemis();
			g1 = campeonatoActual.getCuartosDeFinal().getGanadoresNum().get(0);
			g2 = campeonatoActual.getCuartosDeFinal().getGanadoresNum().get(1);
			g3 = campeonatoActual.getCuartosDeFinal().getGanadoresNum().get(2);
			g4 = campeonatoActual.getCuartosDeFinal().getGanadoresNum().get(3);
			frameActual.CtodoSimulado(1, g1, g2, g3, g4);
		}
	}
	
	public int[] getGanadoresCuartos() {
		int[] ganadores = new int[4];
		for (int i = 0; i < 4; i++) {
			ganadores[i] = campeonatoActual.getCuartosDeFinal().getGanadoresNum().get(i);
		}
		
		return ganadores;
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
	public void SimulaPartidoS() { //Devuelve el partido que se jugo (1,2,3 o 4)
		if (campeonatoActual.getSemiFinal().getPartidoAct() + 1  == campeonatoActual.getSemiFinal().getCANT_P()) {
			campeonatoActual.getSemiFinal().SimulaPartido();
			SemiFinalesSimuladas(); //se fija si esta en el ultimo partido de la semi
			//return campeonatoActual.getSemiFinal().getPartidoAct() - 3  ; //devuelve 3
		}else {
			campeonatoActual.getSemiFinal().SimulaPartido();
			if(campeonatoActual.getSemiFinal().getPartidoAct() - 1 < campeonatoActual.getSemiFinal().getCANT_P()/2) { //0 o 1
				//return campeonatoActual.getSemiFinal().getPartidoAct() - 1; 
			}else {
				frameActual.StodoSimulado(0, 0, 0);
				//return campeonatoActual.getSemiFinal().getPartidoAct() - 3 ; // 2
			}
		}
	}
	
	/**
	 * Simula los partidos de ida de la semifinal
	 * @return Integer representando el partido que se jugo
	 */
	public int simulaPartidosIdaS() {//Devuelve a partir de que partido se simulo (1,2,3 o 4)
		int partidoComienzo = campeonatoActual.getSemiFinal().getPartidoAct();
		if (partidoComienzo < campeonatoActual.getSemiFinal().getCANT_P()/2) {
			campeonatoActual.getSemiFinal().SimulaIda();
		}
		frameActual.StodoSimulado(0, 0, 0); //saca del frame la posibilidad de jugar mas partidos ida
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
		int g1, g2;
		if(campeonatoActual.getSemiFinal().SemiFinalSimulada()) {
			campeonatoActual.IniciaFinal();
			g1 = campeonatoActual.getSemiFinal().getGanadoresNum().get(0);
			g2 = campeonatoActual.getSemiFinal().getGanadoresNum().get(1);
			frameActual.StodoSimulado(1, g1, g2);
		}
	}
	
	public int[] getGanadoresSemis() {
		
		int[] ganadores = new int[2];
		for (int i = 0; i < ganadores.length; i++) {
			ganadores[i] = campeonatoActual.getCuartosDeFinal().getGanadoresNum().get(i);
		}
		
		return ganadores;
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
	 * @return Integer representando la cantidad de goles a favor
	 */
	public String getGFinal(int equipo) {
		return campeonatoActual.getFinal().getEquipo(equipo).getEstadisticasFinal();
	}

	/**
	 * Simula la final del campeonato
	 */
	public void SimulaFinal() { 
		String campeonNomb = "";
		if (!campeonatoActual.getFinal().isFinalSimulada()) {
			campeonatoActual.getFinal().juegaFinal();
			frameActual.FtodoSimulado(campeonatoActual.getFinal().getCampeonNum());
			campeonNomb += campeonatoActual.getFinal().getCampeon().trim();
			
			JOptionPane.showMessageDialog(frameActual, campeonNomb + " es el nuevo campeon de la copa!");
		}
	}
	
	public int getGanador() {
		return campeonatoActual.getFinal().getCampeonNum();
	}

	public int getEtapaSemis() {
		return campeonatoActual.getSemiFinal().getPartidoAct();
	}
}
