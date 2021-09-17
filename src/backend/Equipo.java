package backend;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
/*Equipo
* 57-Period edad = Period.between(e.getNacimiento(), fechaAct.now()); 
¿Por que haces fechaAct.now()? si now() es un metodo estatico
Debería ser LocalDate.now();
Borre tu variable de tipo LocalDate y utilice el metodo como deberia ser (de forma estatica)
LO CAMBIÉ, SI NO ESTA BIEN EL CAMBIO DECIME
* 209- ¿Está bien el toString asi?
public String toString() {
	return "Equipo [nombre=" + nombre + ", pais=" + pais + ", ranking=" + ranking + ", Jugadores=" + Jugadores
			+ ", entrenador=" + entrenador + ", puntos=" + puntos + ", goles=" + goles + ", golesContra="
			+ golesContra + "]";
}
Sino cambiarlo
* Estan absolutamente todos los getters y setters, son una bocha y medio al pedo
si no los vamos a usar todos, diría de centralizar en los que realmente podríamos 
necesitar por afuera de la clase.
 */
public class Equipo implements Serializable{
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = -6798555891375663146L;
	private String nombre;
	private Pais pais;
	private int ranking; 
	private ArrayList<Jugador> Jugadores = new ArrayList<Jugador>(18);
	private Dt entrenador;
	
    private int puntos;
    private int goles;
    private int golesContra;
    private int golesIdaCuartos;
    private int golesVueltaCuartos;
    private int golesIdaSemis;
    private int golesVueltaSemis;
    private int golesFinal;
    private int pJ;
    private int pG;
    private int pP;
    
  //-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
    
    public Equipo (String nombre, Pais nacionalidad, int ranking, ArrayList<Jugador> jugadores, Dt entrenador){ 
		this.nombre = nombre;
		pais = nacionalidad;
		this.ranking = ranking;
		Jugadores = jugadores;
		this.entrenador = entrenador;
		this.goles = 0;
        this.golesContra = 0;
        this.golesIdaCuartos = 0;
        this.golesVueltaCuartos = 0;
        this.golesIdaSemis = 0;
        this.golesVueltaSemis = 0;
        this.puntos = 0;
        this.pG = 0;
        this.pJ = 0;
        this.pP = 0;
	}
    
  //-------------------------------------------------<<MÉTODOS>>-------------------------------------------------

	public double edadMediaJugadores() { 
    	
    	int edadMedia = 0;
		for (Jugador j: Jugadores) {
			Period edad = Period.between(j.getNacimiento(), LocalDate.now()); 
			edadMedia += edad.getYears();
		}
		return edadMedia/18;
    }
	
	public double MediaJugadores() {
		int media = 0;
		for (Jugador j: Jugadores) {
			media += j.getPuntaje();
		}
		return media/18;
	}
	

	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	public String getEstadisticas() {
		for(int i = nombre.length();i < 25; i++) 
				nombre += " ";
        return nombre + " | " + puntos + " | " + pJ + " | " + pG + " | " + pP + " | " + (goles - golesContra) + " | ";//+ golesContra + (goles - golesContra);
    }
	
	public String getEstadisticasCuartosIda() { //DEVUELVE NOMBRE DEL EQUIPO Y GOLES EN LA IDA DE LOS CUARTOS
		return nombre + golesIdaCuartos;
    }
	
	public String getEstadisticasCuartosVuelta() { //DEVUELVE NOMBRE DEL EQUIPO Y GOLES EN LA IDA DE LOS CUARTOS
		return nombre + golesVueltaCuartos + golesIdaCuartos;
    }
	
	public String getEstadisticasSemisIda() { //DEVUELVE NOMBRE DEL EQUIPO Y GOLES EN LA IDA DE LOS CUARTOS
		return nombre + golesIdaSemis;
    }
	
	public String getEstadisticaSemis() { //DEVUELVE NOMBRE DEL EQUIPO Y GOLES EN LA IDA DE LOS CUARTOS
		return nombre + golesVueltaSemis + golesIdaSemis;
    }
	
	public String getEstadisticasFinal () {
		return nombre + golesFinal;
	}
	
	public int getpP() {
		return pP;
	}

	public void setpP() {
		this.pP++;
	}
	
	public int getpJ() {
		return pJ;
	}

	public int getpG() {
		return pG;
	}

    public int getGoles () {
        return goles;
    }
    public int getGolesContra() {
        return golesContra;
    }
    
    public void setpG() {
		this.pG ++;
	}
	
	public void setpJ() {
		this.pJ ++;;
	}
	


    public void setPuntos(int puntos) {
        this.puntos  += puntos;
    }

    public void setGoles(int goles) {
        this.goles += goles;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra += golesContra;
    }

    public int getPuntos() {
        return puntos;
    }
    
	public Pais getPais (){
		return pais ;
	}

	public int getRanking() {
		return ranking;
	}

	public Dt getEntrenador() {
		return entrenador;
	}
	
	public void setEntrenador(Dt _dt) {
		entrenador = _dt;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Jugador> getJugadores() {
		return Jugadores;
	}
	
	public void setJugadores(ArrayList<Jugador> jugadoresEquipo) {
		Jugadores = jugadoresEquipo;
		
	}
	
	public int getGolesIdaCuartos() {
		return golesIdaCuartos;
	}

	public void setGolesIdaCuartos(int golesIda) {
		this.golesIdaCuartos = golesIda;
	}

	public int getGolesVueltaCuartos() {
		return golesVueltaCuartos;
	}

	public void setGolesVueltaCuartos(int golesVuelta) {
		this.golesVueltaCuartos = golesVuelta;
	}
	public int getGolesIdaSemis() {
		return golesIdaSemis;
	}

	public void setGolesIdaSemis(int golesIda) {
		this.golesIdaSemis = golesIda;
	}

	public int getGolesVueltaSemis() {
		return golesVueltaSemis;
	}

	public void setGolesVueltaSemis(int golesVuelta) {
		this.golesVueltaSemis = golesVuelta;
	}
	public void setGolesFinal(int golesFinal) {
		this.golesFinal = golesFinal;
	}
	public int getGolesFinal () {
		return golesFinal;
	}

	
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", pais=" + pais + ", ranking=" + ranking + ", Jugadores=" + Jugadores
				+ ", entrenador=" + entrenador.getApellido() + ", puntos=" + puntos + ", goles=" + goles + ", golesContra="
				+ golesContra + "]";
	}

}