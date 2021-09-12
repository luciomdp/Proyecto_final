package backend;

import java.io.Serializable;
import java.time.LocalDate;
/*16-public abstract String DatosIdent(); //estos procedimientos están vacíos... qué debería ir acá? (ver referi o jugador por ejemplo)
Resolver esa cuestión

20-public Persona (String a, String no, LocalDate n, int dni, String ti)
Se podría ser un poco mas especifico con el nombre de las variables que se pasan por parametro.

65-public String toString() {
	return "Persona [apellido=" + apellido + ", nombre=" + nombre + ", nacimiento=" + nacimiento + ", dni=" + dni
			+ "]";
}
¿Está bien el toString()?sino modificarlo.

¿Son necesarios todos esos getters y setters? Sino borrar los que no lo sean*/
public abstract class Persona implements Serializable {

	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = -6085890580210945177L;

	private String apellido, nombre;
	private LocalDate nacimiento;
	private int dni;
	String tipoDni;
	public abstract String DatosIdent(); //estos procedimientos están vacíos... qué debería ir acá? (ver referi o jugador por ejemplo)
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public Persona (String a, String no, LocalDate n, int dni, String ti){
		apellido = a;
		nombre = no;
		nacimiento = n;
		this.dni = dni;	
		tipoDni = ti;
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
	
	@Override
	public String toString() {
		return "Persona [apellido=" + apellido + ", nombre=" + nombre + ", nacimiento=" + nacimiento + ", dni=" + dni
				+ "]";
	}
}
