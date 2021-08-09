package proyecto_final;

import backend.Campeonato;
import backend.Posicion;
import frontend.Frame;

public class Controlador {

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
		frameActual.IniciaTorneo();
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

		//evaluar si se puede simular otro partido, sino, llamar al metodo ZtodoSimulado(zona) del Frame
	}
	public void SimulaFechaZ (int zona) { //recibe la zona de la que se simula una fecha 

		//evaluar si se puede simular otro partido, sino, llamar al metodo ZtodoSimulado(zona) del Frame
	}
	public void SimulaZonaZ (int zona) { //recibe la zona que se simula toda 
		
		frameActual.ZtodoSimulado(zona);
	}
	public void SimulaZonas() { //simula todas las zonas
		
	}
	public String getZona (int zona) { //recibe la zona de la que quiere que se devuelva el String
		String s = "ZONA "+ zona;
		
		return s;
	}
	
	//-------------------------------------------------<<SIMULADORES CUARTOS>>-------------------------------------------------
	
	public String getECuartos(int equipo) {//DEBERIA RETORNAR EL STRING DEL EQUIPO, CON LA ACTUALIZACION EN GOLES IDA, VUELTA, ETC
		switch (equipo) {
		case 1:
			return "Equipo " + equipo;
		case 2:
			return "Equipo " + equipo;
		case 3:
			return "Equipo " + equipo;
		case 4:
			return "Equipo " + equipo;
		case 5:
			return "Equipo " + equipo;
		case 6:
			return "Equipo " + equipo;
		case 7:
			return "Equipo " + equipo;
		} 
		return "Equipo " + equipo;
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
			switch (equipo) {
			case 1:
				return "Equipo " + equipo;
			case 2:
				return "Equipo " + equipo;
			case 3:
				return "Equipo " + equipo;
			} 
			return "Equipo " + equipo;
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
