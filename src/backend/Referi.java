package backend;

import java.time.LocalDate;
import java.util.ArrayList;

/* Ranking de referís por cantidad de partidos dirigidos en el campeonato. Indicar para cada 
uno la cantidad de años en el referato, y al final del listado el promedio de los mismos.*/

public class Referi extends Persona{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4414849362119102514L;
	private Pais nacionalidad;
	private int años_referato;

	public Referi(String a, String no, LocalDate n, int dni, String ti, Pais na, int an) {
		super(a, no, n, dni, ti);
		nacionalidad = na;
		años_referato = an;
	}
	
	public String ListaReferi () {
		return "Nombre: "+ this.getNombre()+ "\nAnios en el referato: "+ this.getAños_referato(); 
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

	@Override
	public String toString() {
		return "Referi [nacionalidad=" + nacionalidad + ", años_referato=" + años_referato + ", tipoDni=" + tipoDni
				+ ", getApellido()=" + getApellido() + ", getNombre()=" + getNombre() + ", getNacimiento()="
				+ getNacimiento() + ", getDni()=" + getDni() + "]";
	}

}
