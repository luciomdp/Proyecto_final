package proyecto_final;

import java.util.Date;

//hacer enum de nacionalidad

public class Dt extends Persona{
	public Dt(String a, String no, Date n, int dni) {
		super(a, no, n, dni);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3580960837841978040L;
	private String nacionalidad;
	private byte titulos;
	
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
