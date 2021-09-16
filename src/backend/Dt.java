package backend;

import java.time.LocalDate;
import java.time.Period;

/*

28-Period edad = Period.between(e.getNacimiento(), fechaAct.now()); 
¿Por que haces fechaAct.now()? si now() es un metodo estatico
Debería ser LocalDate.now();
Borre tu variable de tipo LocalDate y utilice el metodo como deberia ser (de forma estatica)
LO CAMBIÉ, SI NO ESTA BIEN EL CAMBIO DECIME

*/

public class Dt extends Persona{
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = -3580960837841978040L;
	private Pais nacionalidad;
	private byte titulos;
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public Dt(String apellido, String nombre, LocalDate nacimiento, int dni, String tipo, Pais nacionalidad, byte titulos) {
		super(apellido, nombre, nacimiento, dni, tipo);
		this.titulos = titulos;
		this.nacionalidad = nacionalidad;
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
	
	
	public String DatosIdent() {
		return null;
	}

//	@Override
//	public String toString() {
//		return "Dt [tipoDni=" + tipoDni + ", Edad="	+ getEdad() + ", Titulos=" + getTitulos() 
//				+ ", Nacionalidad=" + getNacionalidad()+ ", Apellido=" + getApellido() + ", Nombre=" 
//				+ getNombre()+ ", Nacimiento=" + getNacimiento() + ", Dni=" + getDni() + "]";
//	}
	
	
}
