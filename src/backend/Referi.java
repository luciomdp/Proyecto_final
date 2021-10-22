package backend;

import java.time.LocalDate;

public class Referi extends Persona{

	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = 4414849362119102514L;
	private Pais nacionalidad;
	private int a�os_referato;
	private int partidosDirigidos;
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public Referi(String apellido, String nombre, LocalDate nacimiento, int dni, String tipo, Pais nacionalidad, int a�osReferato) {
		super(apellido, nombre, nacimiento, dni, tipo);
		this.nacionalidad = nacionalidad;
		this.a�os_referato = a�osReferato;
		this.partidosDirigidos = 0;
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
		
	
	public int getA�os_referato() {
		return a�os_referato;
	}
	
	public Pais getNacionalidad () {
		return nacionalidad;
	}

	
	public String getCredencial() {
		String s = "\n----------------------------------------------------<<REFERI>>---------------------------------------------------- \n\n";
		s += toString();
		return s;
	}

	/**
	 * Aumenta en uno (1) la cantidad de partidos dirigidos.
	 */
	public void dirigePartido () {
		this.partidosDirigidos ++;
	}
	
	public int getPartidosDirigidos() {
		return partidosDirigidos;
	}

	public String ListaReferi () {
		return "Nombre: "+ this.getNombre()+"\nApellido: "+ this.getApellido()+ "\nAnios en el referato: "+ this.getA�os_referato()+ "\nPartidos Dirigidos: " + partidosDirigidos + "\n"; 
	}
	
	public String toString() {
		return "Referi: " +super.getApellido()+ " " +super.getNombre()+ "\nFecha Nacimiento: "+ 
				super.getNacimiento()+"\nTipoDni: " + getTipoDni() +"\nDNI: " +super.getDni()+ "\nA�os referato: " + a�os_referato + "\nPartidos dirigidos: " +
				partidosDirigidos + "\nNacionalidad: " + nacionalidad;
	}

}
