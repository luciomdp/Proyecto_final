package backend;

import java.time.LocalDate;

public class Jugador extends Persona{
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = 5889112804468930644L;
	private Posicion posicion;
	private byte puntaje; //0 - 100
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	/**
	 * Para los jugadores se registra su posición (arquero, defensor, mediocampista, delantero) y puntaje 
		de valoración.
	 * @param apellido
	 * @param nombre
	 * @param nacimiento
	 * @param tipo
	 * @param dni
	 * @param posicion
	 * @param puntaje
	 */
	public Jugador(String apellido, String nombre, LocalDate nacimiento, String tipo, int dni, Posicion posicion, byte puntaje) {
		super(apellido, nombre, nacimiento, dni, tipo);
		this.posicion = posicion;
		this.puntaje = puntaje;
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------

	public byte getPuntaje() {
		return puntaje;
	}

	public Posicion getPosicion() {
		return posicion;
	}
	
	@Override
	public String toString() {
		return "Jugador: " +super.getApellido()+ " " +super.getNombre()+ "\nFecha Nacimiento: "+ 
				super.getNacimiento()+"\nDNI: " +super.getDni()+ "\nPosicion: " + posicion+ "\nPuntaje: " +
				puntaje + "\nTipoDni: " + getTipoDni() + "\n";
	}

}
