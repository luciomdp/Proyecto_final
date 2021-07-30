package backend;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
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
	
	public int getEdad() { 
		
		int edad;
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        int edadDt = Integer.parseInt(getYearFormat.format(this.getNacimiento()));
		Calendar fechaAct = Calendar.getInstance();
		int act = fechaAct.get(Calendar.YEAR);
		edad = act - edadDt;
		return edad;
		
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
	

}
