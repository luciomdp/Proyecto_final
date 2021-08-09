package backend;

import java.time.LocalDate;

//Implementar enum para posicion
/*Listado de jugadores de determinada posici�n seleccionada por el operador (arquero, 
defensor, mediocampista, delantero) mostrando toda la informaci�n disponible del mismo.
En el caso de los arqueros, mostrar la cantidad de Goles en Contra que recibi� su equipo y 
el promedio de gol recibido por partido.*/
public class Jugador extends Persona{
	
	private static final long serialVersionUID = 5889112804468930644L;
	private Posicion posicion;
	private byte puntaje; //0 - 100
	
	public Jugador(String a, String no, LocalDate n, String ti, int dni, Posicion po, byte pu) {
		super(a, no, n, dni, ti);
		posicion = po;
		puntaje = pu;
	}
	
	@Override
	public String toString() {
		return "Jugador [apellido= "+super.getApellido()+", nombre= "+super.getNombre() + ", fecha= "+super.getNacimiento()+
				", dni= "+super.getDni()+", posicion= "+posicion+", puntaje= "+puntaje+", tipoDni= "+tipoDni+"]";
	}

	public String DatosIdent() { 
		return null;
	}

	public byte getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(byte puntaje) {
		this.puntaje = puntaje;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}	
}
