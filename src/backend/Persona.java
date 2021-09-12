package backend;

import java.io.Serializable;
import java.time.LocalDate;
/*16-public abstract String DatosIdent(); //estos procedimientos están vacíos... qué debería ir acá? (ver referi o jugador por ejemplo)
Resolver esa cuestión
*/
public abstract class Persona implements Serializable {

	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = -6085890580210945177L;

	private String apellido, nombre;
	private LocalDate nacimiento;
	private int dni;
	String tipoDni;
	public abstract String DatosIdent(); //estos procedimientos están vacíos... qué debería ir acá? (ver referi o jugador por ejemplo)
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public Persona (String apeliido, String nombre, LocalDate nacimiento, int dni, String tipo){
		this.apellido = apellido;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.dni = dni;	
		this.tipoDni = tipo;
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
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
}	

