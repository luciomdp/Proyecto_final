package proyecto_final;

import backend.Campeonato;
import backend.Posicion;
import frontend.Frame;

public class Controlador {
	
	final int CANT_PZ = 6;
	final int CANTZ = 4;
	private Campeonato campeonatoActual;
	private Frame frameActual;
	
	
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
	}
	
	/*Guarda torneo*/
	public void SerializaProgreso() {
		//acá hay que guardar el torneo actual
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
	
	//-------------------------------------------------<<SIMULADORES ZONA>>-------------------------------------------------
	
	public void SimulaPartidoZ (int zona) { //recibe la zona de la que se simula un partido 
		if (campeonatoActual.getZona(zona).getPartidoAct() < CANT_PZ) // SI NO SE JUGARON TODOS LOS PARTIDOS DE LA ZONA
			campeonatoActual.getZona(zona).SimulaPartido();
		else
			frameActual.ZtodoSimulado(zona);
			
		//evaluar si se puede simular otro partido, sino, llamar al metodo ZtodoSimulado(zona) del Frame
	}
	public void SimulaFechaZ (int zona) { //recibe la zona de la que se simula una fecha
		if (campeonatoActual.getZona(zona).getPartidoAct() < CANT_PZ)
			campeonatoActual.getZona(zona).SimulaFecha();
		else 
			frameActual.ZtodoSimulado(zona);
		
		//evaluar si se puede simular otro partido, sino, llamar al metodo ZtodoSimulado(zona) del Frame
	}
	public void SimulaZonaZ (int zona) { //recibe la zona que se simula toda 
		campeonatoActual.getZona(zona).SimulaZona();
		frameActual.ZtodoSimulado(zona);
	}
	public void SimulaZonas() { //simula todas las zonas
		for (int i = 0; i < CANTZ; i++) {
			campeonatoActual.getZona(i).SimulaZona();
			frameActual.ZtodoSimulado(i);
		}
		
	}
	public String getZona (int zona) { //recibe la zona de la que quiere que se devuelva el String
		return campeonatoActual.getZona(zona).getValoresTabla();
	}
	
	//-------------------------------------------------<<SIMULADORES CUARTOS>>-------------------------------------------------
	
	public String getECuartos(int equipo) {//DEBERIA RETORNAR EL STRING DEL EQUIPO, CON LA ACTUALIZACION EN GOLES IDA, VUELTA, ETC
		/*switch (equipo) {
		case 1:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		case 2:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		case 3:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		case 4:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		case 5:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		case 6:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		
		case 7:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		} 
		return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas(); */
		
		return campeonatoActual.getECuartosFinal(equipo).getEstadisticasCuartosIda(); // NO ES LO MISMO QUE HACER ESTE RETURN ?
	}
	
	public String getECuartosVuelta(int equipo) {//DEBERIA RETORNAR EL STRING DEL EQUIPO, CON LA ACTUALIZACION EN GOLES IDA, VUELTA, ETC
		/*switch (equipo) {
		case 1:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		case 2:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		case 3:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		case 4:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		case 5:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		case 6:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		
		case 7:
			return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas();
		} 
		return "Equipo " + campeonatoActual.getCuartosFinal().getEquipoCuartos(equipo).getEstadisticas(); */
		
		return campeonatoActual.getECuartosFinal(equipo).getEstadisticasCuartosVuelta(); // NO ES LO MISMO QUE HACER ESTE RETURN ?
	}
	
	public int SimulaPartidoC() { //Devuelve el partido que se jugo (1,2,3 o 4)
		//evaluar si se puede simular otro partido de ida, sino, llamar al metodo CtodoSimulado(0) del Frame
		//evaluar si se puede simular otro partido , sino, llamar al metodo CtodoSimulado(1) del Frame
		return 1; 
	}

	public int simulaPartidosIdaC() {//Devuelve a partir de que partido  se simulo (1,2,3 o 4)
		frameActual.CtodoSimulado(0); //saca del frame la posibilidad de jugar mas partidos ida
		return 0;
	}
	public int simulaPartidosCuartos() {//Devuelve a partir de que partido  se simulo (1,2,3 o 4)

		frameActual.CtodoSimulado(1); //saca del frame la posibilidad de jugar mas partidos cuartos
		return 0;
	}
	
	//-------------------------------------------------<<SIMULADORES SEMIS>>-------------------------------------------------
	
		public String getESemis(int equipo) {//DEBERIA RETORNAR EL STRING DEL EQUIPO, CON LA ACTUALIZACION EN GOLES IDA, VUELTA, ETC
			/*switch (equipo) {
			case 1:
				return "Equipo " + equipo;
			case 2:
				return "Equipo " + equipo;
			case 3:
				return "Equipo " + equipo;
			} 
			return "Equipo " + equipo; */
			
			return campeonatoActual.getSemiFinal().getEquipoSemis(equipo).getEstadisticas(); // DEVUELVE LAS ESTADÍSTICAS DEL EQUIPO equipo DE LAS SEMIS (adentro de smis hay un arreglo con todos los equipos que juegan)
		}
		public int SimulaPartidoS() { //Devuelve el partido que se jugo (1,2,3 o 4)
			//evaluar si se puede simular otro partido de ida, sino, llamar al metodo StodoSimulado(0) del Frame
			//evaluar si se puede simular otro partido , sino, llamar al metodo StodoSimulado(1) del Frame
			return 1; 
		}

		public int simulaPartidosIdaS() {//Devuelve a partir de que partido  se simulo (1,2,3 o 4)
			frameActual.StodoSimulado(0); //saca del frame la posibilidad de jugar mas partidos ida
			return 0;
		}
		public int simulaPartidosSemis() {//Devuelve a partir de que partido  se simulo (1,2,3 o 4)

			frameActual.StodoSimulado(1); //saca del frame la posibilidad de jugar mas partidos semis
			return 0;
		}
	
}
