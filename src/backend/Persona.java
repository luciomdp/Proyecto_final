package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public abstract class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6085890580210945177L;

	private String apellido, nombre;
	private LocalDate nacimiento;
	private int dni;
	String tipoDni;
	public abstract String DatosIdent();
	
	public Persona (String a, String no, LocalDate n, int dni, String ti){
		apellido = a;
		nombre = no;
		nacimiento = n;
		this.dni = dni;	
		tipoDni = ti;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [apellido=" + apellido + ", nombre=" + nombre + ", nacimiento=" + nacimiento + ", dni=" + dni
				+ "]";
	}
	
}
