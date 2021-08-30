package backend;

import java.time.LocalDate;

/*Listado de jugadores de determinada posición seleccionada por el operador (arquero, 
defensor, mediocampista, delantero) mostrando toda la información disponible del mismo.
En el caso de los arqueros, mostrar la cantidad de Goles en Contra que recibió su equipo y 
el promedio de gol recibido por partido.*/

public class Jugador extends Persona{
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = 5889112804468930644L;
	private Posicion posicion;
	private byte puntaje; //0 - 100
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public Jugador(String a, String no, LocalDate n, String ti, int dni, Posicion po, byte pu) {
		super(a, no, n, dni, ti);
		posicion = po;
		puntaje = pu;
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------

	public byte getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(byte puntaje) {
		this.puntaje = puntaje;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}	
	
	@Override
	public String toString() {
		return "Jugador [apellido= " +super.getApellido()+ ", nombre= " +super.getNombre()+ ", fecha= "+ 
				super.getNacimiento()+", dni= " +super.getDni()+ ", posicion= " +posicion+ ", puntaje= " +
				puntaje+ ", tipoDni= " +tipoDni+ "]";
	}

	public String DatosIdent() { 
		return null;
	}
}
