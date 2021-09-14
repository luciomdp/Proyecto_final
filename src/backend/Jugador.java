package backend;

import java.time.LocalDate;
/*


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
	
	public Jugador(String apellido, String nombre, LocalDate nacimiento, String tipo, int dni, Posicion posicion, byte puntaje) {
		super(apellido, nombre, nacimiento, dni, tipo);
		this.posicion = posicion;
		this.puntaje = puntaje;
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
		return "Jugador: " +super.getApellido()+ " " +super.getNombre()+ "\nFecha Nacimiento: "+ 
				super.getNacimiento()+"\nDNI: " +super.getDni()+ "\nPosicion: " + posicion+ "\nPuntaje: " +
				puntaje + "\nTipoDni: " + tipoDni;
	}

	public String DatosIdent() { 
		return null;
	}
}
