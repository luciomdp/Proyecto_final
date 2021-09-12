package backend;

import java.time.LocalDate;
import java.time.Period;

/*15-public Dt(String a, String no, LocalDate n, int dni, String ti, Pais na, byte titulos)
Se podría ser un poco mas especifico con el nombre de las variables que se pasan por parametro
y se hace super().

28-Period edad = Period.between(e.getNacimiento(), fechaAct.now()); 
¿Por que haces fechaAct.now()? si now() es un metodo estatico
Debería ser LocalDate.now();
Borre tu variable de tipo LocalDate y utilice el metodo como deberia ser (de forma estatica)
LO CAMBIÉ, SI NO ESTA BIEN EL CAMBIO DECIME

49-public String toString() {
		return "Dt [nacionalidad=" + nacionalidad + ", titulos=" + titulos + ", tipoDni=" + tipoDni + ", Apellido="
			+ getApellido() + ", Nombre=" + getNombre() + ", Nacimiento=" + getNacimiento()
			+ ", Dni=" + getDni() + "]";
}
¿Está bien el toString()? sino cambiarlo*/

public class Dt extends Persona{
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = -3580960837841978040L;
	private Pais nacionalidad;
	private byte titulos;
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public Dt(String a, String no, LocalDate n, int dni, String ti, Pais na, byte titulos) {
		super(a, no, n, dni, ti);
		this.titulos = titulos;
		this.nacionalidad = na;
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	public int getEdad() { 
	
		Period edad = Period.between(getNacimiento(), LocalDate.now()); 
		return edad.getYears();
		
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
		return "Dt [nacionalidad=" + nacionalidad + ", titulos=" + titulos + ", tipoDni=" + tipoDni + ", Apellido="
				+ getApellido() + ", Nombre=" + getNombre() + ", Nacimiento=" + getNacimiento()
				+ ", Dni=" + getDni() + "]";
	}
	
	public String DatosIdent() {
		return null;
	}
}
