package backend;

import java.util.Date;

//hacer enum de nacionalidad

public class Dt extends Persona{
	
	private static final long serialVersionUID = -3580960837841978040L;
	private String nacionalidad;
	private byte titulos;
	
	public Dt(String a, String no, Date n, int dni, String na, byte ti) {
		super(a, no, n, dni);
		setNacionalidad(na);
		titulos = ti;
	}
	
	/*public Dt(String a, String no, float f, String na, Byte ti) {
		super(a, no, f);
		nacionalidad = na;
		titulos = ti;	}
*/
	public String DatosIdent() {
		
		return null;
	}

	public byte getTitulos() {
		return titulos;
	}

	public void setTitulos(byte titulos) {
		this.titulos = titulos;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
}
