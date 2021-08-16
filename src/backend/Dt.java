package backend;

import java.time.LocalDate;
import java.time.Period;

public class Dt extends Persona{
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = -3580960837841978040L;
	private Pais nacionalidad;
	private byte titulos;
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public Dt(String a, String no, LocalDate n, int dni, String ti, Pais na, byte titulos) {
		super(a, no, n, dni, ti);
		this.titulos = titulos;
		this.nacionalidad = na;
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	public int getEdad() { 
		
		LocalDate fechaAct = null ;
		Period edad = Period.between(getNacimiento(), fechaAct.now()); 
		
		return edad.getYears();
		
	} 

	public byte getTitulos() {
		return titulos;
	}

	public void setTitulos(byte titulos) {
		this.titulos = titulos;
	}

	public Pais getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Pais nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	@Override
	public String toString() {
		return "Dt [nacionalidad=" + nacionalidad + ", titulos=" + titulos + ", tipoDni=" + tipoDni + ", getApellido()="
				+ getApellido() + ", getNombre()=" + getNombre() + ", getNacimiento()=" + getNacimiento()
				+ ", getDni()=" + getDni() + "]";
	}
	
	public String DatosIdent() {
		return null;
	}
}
