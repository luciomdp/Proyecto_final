package backend;

import java.time.LocalDate;
/*18-public Referi(String a, String no, LocalDate n, int dni, String ti, Pais na, int an)
Se podría ser un poco mas especifico con el nombre de las variables que se pasan por parametro
y se hace super().

51-
public String toString() { //este procedimiento se podría borrar más adelante, es para revisar la lectura
	return "Referi [nacionalidad=" + nacionalidad + ", años_referato=" + años_referato + ", tipoDni=" + tipoDni
			+ ", getApellido: " + getApellido() + ", getNombre" + getNombre() + ", getNacimiento()="
			+ getNacimiento() + ", getDni" + getDni() + "]";
}
¿Está bien el toString()? sino cambiarlo.

58-
public String DatosIdent() {
	// TODO Auto-generated method stub
	return null;
}
¿Función de esto? ¿Hace falta implementarlo el metodo o es 
un metodo innecesario?

¿Son necesarios todos esos getters y setters? Sino borrar los que no lo sean*/

/* Ranking de referís por cantidad de partidos dirigidos en el campeonato. Indicar para cada 
uno la cantidad de años en el referato, y al final del listado el promedio de los mismos.*/

public class Referi extends Persona{

	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = 4414849362119102514L;
	private Pais nacionalidad;
	private int años_referato;

	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public Referi(String a, String no, LocalDate n, int dni, String ti, Pais na, int an) {
		super(a, no, n, dni, ti);
		nacionalidad = na;
		años_referato = an;
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
		
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
	
	public String ListaReferi () {
		return "Nombre: "+ this.getNombre()+ "\nAnios en el referato: "+ this.getAños_referato(); 
	}
	
	@Override
	public String toString() { //este procedimiento se podría borrar más adelante, es para revisar la lectura
		return "Referi [nacionalidad=" + nacionalidad + ", años_referato=" + años_referato + ", tipoDni=" + tipoDni
				+ ", getApellido: " + getApellido() + ", getNombre" + getNombre() + ", getNacimiento()="
				+ getNacimiento() + ", getDni" + getDni() + "]";
	}

	@Override
	public String DatosIdent() {
		// TODO Auto-generated method stub
		return null;
	}
}
