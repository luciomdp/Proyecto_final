package backend;

import java.util.Date;

//Implementar enum para posicion
public class Jugador extends Persona{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5889112804468930644L;
	private Posicion posicion;
	private byte puntaje; //0 - 100
	String tipoDni;
	
	public Jugador(String a, String no, Date n, String ti, int dni, Posicion po, byte pu) {
		super(a, no, n, dni);
		posicion = po;
		puntaje = pu;
		tipoDni = ti;
		
	}
	
	public String DatosIdent() {
		
		return null;
	}

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

	
	
}
