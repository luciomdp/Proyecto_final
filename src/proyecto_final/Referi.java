package proyecto_final;

import java.util.Date;

public class Referi extends Persona{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4414849362119102514L;
	private Pais nacionalidad;
	private int a�os_referato;
	

	public Referi(String a, String no, Date n, int dni, Pais na, int an) {
		super(a, no, n, dni);
		nacionalidad = na;
		a�os_referato = an;
	}
	
	public Pais getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(Pais nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getA�os_referato() {
		return a�os_referato;
	}
	public void setA�os_referato(int a�os_referato) {
		this.a�os_referato = a�os_referato;
	}
	public Pais getPais (){
		return nacionalidad;
	} 
	public String DatosIdent() {
		return null;
	}

}
