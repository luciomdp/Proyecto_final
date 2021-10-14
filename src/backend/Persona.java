package backend;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Persona implements Serializable {

	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = -6085890580210945177L;

	private String apellido, nombre;
	private LocalDate nacimiento;
	private int dni;
	String tipoDni;
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public Persona (String apellido, String nombre, LocalDate nacimiento, int dni, String tipo){
		this.apellido = apellido;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.dni = dni;	
		this.tipoDni = tipo;
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	public String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public int getDni() {
		return dni;
	}

}	