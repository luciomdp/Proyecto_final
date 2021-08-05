package proyecto_final;

import backend.Campeonato;
import backend.Posicion;
import frontend.Frame;

public class Controlador {

	private Campeonato campeonatoActual = null;
	private Frame frameActual = null;
	
	/*Inicia torneo*/
	public void iniciaTorneo() {
		//acá hay que leer todos los datos e iniciar uno nuevo
	}
	
	/*Reanuda torneo*/
	public void continuaTorneo() {
		//acá hay que continuar el torneo
	}
	
	/*Guarda torneo*/
	public void serializaTorneo() {
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
	
	/* Constructor de controlador de campeonato*/
	public Controlador (Campeonato c, Frame f) {
		this.campeonatoActual = c;
		this.frameActual = f;
	}
}
