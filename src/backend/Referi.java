package backend;

import java.time.LocalDate;
/*
58-
public String DatosIdent() {
	// TODO Auto-generated method stub
	return null;
}
¿Función de esto? ¿Hace falta implementarlo el metodo o es 
un metodo innecesario?

/* */

public class Referi extends Persona{

	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = 4414849362119102514L;
	private Pais nacionalidad;
	private int años_referato;
	private int partidosDirigidos;
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public Referi(String apellido, String nombre, LocalDate nacimiento, int dni, String tipo, Pais nacionalidad, int añosReferato) {
		super(apellido, nombre, nacimiento, dni, tipo);
		this.nacionalidad = nacionalidad;
		this.años_referato = añosReferato;
		this.partidosDirigidos = 0;
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
		
	
	public int getAños_referato() {
		return años_referato;
	}
	
	public Pais getNacionalidad () {
		return nacionalidad;
	}
	
	public void dirigePartido () {
		this.partidosDirigidos ++;
	}
	
	public int getPartidosDirigidos() {
		return partidosDirigidos;
	}

	public String ListaReferi () {
		return "Nombre: "+ this.getNombre()+"\nApellido: "+ this.getApellido()+ "\nAnios en el referato: "+ this.getAños_referato()+ "\nPartidos Dirigidos: " + this.getPartidosDirigidos() + "\n"; 
	}
	
	
	@Override
	public String DatosIdent() {
		return null;
	}
}


