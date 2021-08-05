package proyecto_final;

import backend.Campeonato;
import backend.Posicion;
import frontend.Frame;

public class Controlador {

	private Campeonato campeonatoActual;
	private Frame frameActual;
	
	/* Constructor de controlador de campeonato*/
	public Controlador (Campeonato c, Frame f) {
		this.campeonatoActual = c;
		this.frameActual = f;
	}
	
	/*Inicia torneo*/
	public void iniciaTorneo() {
		//inicia torneo con todos datos neutros (no paso nada)
	}
	
	/*Reanuda torneo*/
	public void continuaTorneo() {
		//inicia torneo con todos datos serializados (se pasan por parametro de IniciaTorneo())
	}
	
	/*Guarda torneo*/
	public void serializaTorneo() {
		//ac� hay que guardar el torneo actual
	}
	
	/* Listado de jugadores de determinada posici�n seleccionada por el operador (arquero,
		defensor, mediocampista, delantero) mostrando toda la informaci�n disponible del mismo.
		En el caso de los arqueros, mostrar la cantidad de Goles en Contra que recibi� su equipo y
		el promedio de gol recibido por partido. */
	public String getListadoJugadores(Posicion pos) {
		return campeonatoActual.listaJugadores(pos);
	}
	
	/*Listado alfab�tico de los equipos mostrando edad promedio de sus jugadores, edad y
		nacionalidad de su DT, efectividad (porcentaje de puntos obtenidos sobre puntos posibles).*/
	public String getListadoEquipos() {
		return campeonatoActual.listaEquipos();
	}

	/*Ranking de refer�s por cantidad de partidos dirigidos en el campeonato. Indicar para cada
		uno la cantidad de a�os en el referato, y al final del listado el promedio de los mismos.*/
	public String getListadoArbitros() {
		return campeonatoActual.listaArbitros();
	}
	
	
}
