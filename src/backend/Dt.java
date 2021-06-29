package backend;

import java.util.Date;

//hacer enum de nacionalidad

public class Dt extends Persona{
	
	private static final long serialVersionUID = -3580960837841978040L;
	private String nacionalidad;
	private byte titulos;
	
	public Dt(String a, String no, Date n, int dni, String na, byte ti) {
		super(a, no, n, dni);
		nacionalidad = na;
		titulos = ti;
	}
	
	public String DatosIdent() {
		
		return null;
	}

	public byte getTitulos() {
		return titulos;
	}

	public void setTitulos(byte titulos) {
		this.titulos = titulos;
	}
}
