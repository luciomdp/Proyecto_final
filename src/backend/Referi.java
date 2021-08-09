package backend;

import java.time.LocalDate;

/* Ranking de refer�s por cantidad de partidos dirigidos en el campeonato. Indicar para cada 
uno la cantidad de a�os en el referato, y al final del listado el promedio de los mismos.*/

public class Referi extends Persona{

	private static final long serialVersionUID = 4414849362119102514L;
	private Pais nacionalidad;
	private int a�os_referato;

	public Referi(String a, String no, LocalDate n, int dni, String ti, Pais na, int an) {
		super(a, no, n, dni, ti);
		nacionalidad = na;
		a�os_referato = an;
	}
	
	public String ListaReferi () {
		return "Nombre: "+ this.getNombre()+ "\nAnios en el referato: "+ this.getA�os_referato(); 
	}
	
	@Override
	public String toString() { //este procedimiento se podr�a borrar m�s adelante, es para revisar la lectura
		return "Referi [nacionalidad=" + nacionalidad + ", a�os_referato=" + a�os_referato + ", tipoDni=" + tipoDni
				+ ", getApellido()=" + getApellido() + ", getNombre()=" + getNombre() + ", getNacimiento()="
				+ getNacimiento() + ", getDni()=" + getDni() + "]";
	}

	@Override
	public String DatosIdent() {
		// TODO Auto-generated method stub
		return null;
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
}
