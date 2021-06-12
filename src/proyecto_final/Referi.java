package proyecto_final;

import java.util.Date;

public class Referi extends Persona{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4414849362119102514L;
	private Pais nacionalidad;
	private int años_referato;
	

	public Referi(String a, String no, Date n, int dni, Pais na, int an) {
		super(a, no, n, dni);
		nacionalidad = na;
		años_referato = an;
	}
	
	public Pais getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(Pais nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getAños_referato() {
		return años_referato;
	}
	public void setAños_referato(int años_referato) {
		this.años_referato = años_referato;
	}
	public Pais getPais (){
		return nacionalidad;
	} 
	public String DatosIdent() {
		return null;
	}

}
