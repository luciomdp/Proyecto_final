package backend;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

//hacer enum de nacionalidad

public class Dt extends Persona{
	
	private static final long serialVersionUID = -3580960837841978040L;
	private Pais nacionalidad;
	private byte titulos;
	
	public Dt(String a, String no, Date n, int dni, String ti, Pais na, byte titulos) {
		super(a, no, n, dni, ti);
		this.titulos = titulos;
	}
	
	public String DatosIdent() {
		return null;
	}
	
	/*public int getEdad() {
		LocalDate fechaAct ; 
		Period edad = Period.between(this.getNacimiento(), fechaAct.now()); //NECESITO PASAR DE DATE A LOCAL DATE e.getNacimiento()
		return edad.getYears();
	} */

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
	

}
