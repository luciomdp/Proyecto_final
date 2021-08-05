package proyecto_final;

import backend.Campeonato;
import backend.Posicion;

public class Controlador {

	/* Listado de jugadores de determinada posici�n seleccionada por el operador (arquero,
		defensor, mediocampista, delantero) mostrando toda la informaci�n disponible del mismo.
		En el caso de los arqueros, mostrar la cantidad de Goles en Contra que recibi� su equipo y
		el promedio de gol recibido por partido. */
	public static String returnListaJugadores(Posicion pos) {
		return Campeonato.listaJugadores(pos);
	}
	
	/*Listado alfab�tico de los equipos mostrando edad promedio de sus jugadores, edad y
		nacionalidad de su DT, efectividad (porcentaje de puntos obtenidos sobre puntos posibles).*/
	public static String returnListaEquipos() {
		return Campeonato.listaEquipos();
	}

	/*Ranking de refer�s por cantidad de partidos dirigidos en el campeonato. Indicar para cada
		uno la cantidad de a�os en el referato, y al final del listado el promedio de los mismos.*/
	public static String returnListaArbitros() {
		return Campeonato.listaArbitros();
	}
	
}
