package backend;

import java.time.LocalDate;
import java.time.Period;

public class Dt extends Persona{
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = -3580960837841978040L;
	private Pais nacionalidad;
	private byte titulos;
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	/**
	 * Para los DT ser registra nacionalidad y cantidad de títulos obtenidos en todos los niveles (nacional o 
	internacional).
	 * @param apellido
	 * @param nombre
	 * @param nacimiento
	 * @param dni
	 * @param tipo
	 * @param nacionalidad
	 * @param titulos
	 */
	public Dt(String apellido, String nombre, LocalDate nacimiento, int dni, String tipo, Pais nacionalidad, byte titulos) {
		super(apellido, nombre, nacimiento, dni, tipo);
		this.titulos = titulos;
		this.nacionalidad = nacionalidad;
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	/**
	 * 
	 * @return Edad actual del DT. 
	 */
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
		return "Entrenador: " +super.getApellido()+ " " +super.getNombre()+ "\nFecha Nacimiento: "+ 
				super.getNacimiento() + "\nTipoDni: " + getTipoDni() +"\nDNI: " +super.getDni()+ "\n";
	}
	
}
