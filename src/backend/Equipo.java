package backend;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
/*Equipo
* Estan absolutamente todos los getters y setters, son una bocha y medio al pedo
si no los vamos a usar todos, diría de centralizar en los que realmente podríamos 
necesitar por afuera de la clase.
* utilizar unicamente tres variables de goles para ida vuelta y penales. Cada vez que hay una instancia nueva, se setea en 0 cada una de ellas. 
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
    private int golesPenalesC;
    private boolean ganaGolVisitante;
    private int pJ;
    private int pG;
    private int pP;
    private int pE;
  //-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
    
    public Equipo (String nombre, Pais nacionalidad, int ranking, ArrayList<Jugador> jugadores, Dt entrenador){ 
		for(int i = nombre.length(); i < 25; i++) {
			nombre += " ";
		}
		this.nombre = nombre;
		pais = nacionalidad;
		this.ranking = ranking;
		Jugadores = jugadores;
		this.entrenador = entrenador;
		this.goles = 0;
		this.golesPenalesC = -1;
        this.golesContra = 0;
        this.golesIdaCuartos = 0;
        this.golesVueltaCuartos = 0;
        this.golesIdaSemis = 0;
        this.golesVueltaSemis = 0;
        this.golesFinal = 0;
        this.ganaGolVisitante = false;
        this.puntos = 0;
        this.pG = 0;
        this.pJ = 0;
        this.pP = 0;
        this.pE = 0;
	}
    
  //-------------------------------------------------<<MÉTODOS>>-------------------------------------------------

    /**
	 * @return Edad promedio de los jugadores de un equipo.
	 */
	public double edadMediaJugadores() { 
    	
    	int edadMedia = 0;
		for (Jugador j: Jugadores) {
			Period edad = Period.between(j.getNacimiento(), LocalDate.now()); 
			edadMedia += edad.getYears();
		}
		return edadMedia/18;
    }
	/**
	 * @return Promedio de las valoraciones de los jugadores de un equipo.
	 */
	public double MediaJugadores() {
		int media = 0;
		for (Jugador j: Jugadores) {
			media += j.getPuntaje();
		}
		return media/18;
	}
	

	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	/**
	 * @return String con nombre del equipo, puntos, partidos jugados, ganados, 
	 * empatados y perdidos, goles a favor y en contra, diferencia de gol.
	 */
	public String getEstadisticas() {
        return nombre + "| " + puntos + "| " + pJ + "| " + pG + "| " + pE + "| " + pP +  "| " +(goles - golesContra) + "|";//+ golesContra + (goles - golesContra);
    }
	
	/**
	 * @return String con nombre del equipo y goles en la ida de los cuartos de final.
	 */
	public String getEstadisticasCuartosIda() { //
		return nombre + "|" + golesIdaCuartos + "|";
    }
	/**
	 * @return String con nombre del equipo y goles en la ida y vuelta de los cuartos de final.
	 */
	public String getEstadisticasCuartosVuelta() {
		if (golesPenalesC == -1) {
			if (ganaGolVisitante)
				return nombre + "|" + golesIdaCuartos + "|"  + golesVueltaCuartos + "| R:" + (golesIdaCuartos + golesVueltaCuartos)+ "(Gv)";
			else
				return nombre + "|" + golesIdaCuartos + "|"  + golesVueltaCuartos + "| R:" + (golesIdaCuartos + golesVueltaCuartos);
		}
		else
			return nombre + "|" + golesIdaCuartos + "|"  + golesVueltaCuartos + "| R:" + (golesIdaCuartos + golesVueltaCuartos) + " P:" + (golesPenalesC + 1);
			
    }
	/**
	 * @return String con nombre del equipo y goles en la ida de las semifinales.
	 */
	public String getEstadisticasSemisIda() {
		return nombre + "|" + golesIdaSemis + "|";
    }
	/**
	 * @return String con nombre del equipo y goles en la ida y vuelta de las semifinales.
	 */
	public String getEstadisticaSemis() {
		if (golesPenalesC == -1) {
			if (ganaGolVisitante)	
				return nombre + "|" + golesIdaSemis + "|"  + golesVueltaSemis + "| R:" + (golesIdaSemis + golesVueltaSemis)+ "(Gv)";
			else
				return nombre + "|" + golesIdaSemis + "|"  + golesVueltaSemis + "| R:" + (golesIdaSemis + golesVueltaSemis);
		}
		else
			return nombre + "|" + golesIdaSemis + "|"  + golesVueltaSemis + "| R:" + (golesIdaSemis + golesVueltaSemis) + " P:" + (golesPenalesC + 1);
			
    }
	/**
	 * @return String con goles de la final y penales, en caso de que hubieran.
	 */
	public String getEstadisticasFinal () {
		if (golesPenalesC == -1) 
			return ""+golesFinal;
		else
			return golesFinal + " ("+ (golesPenalesC + 1) + ")";
			
	}
	
	public boolean isGolDeVisitante () {
		return ganaGolVisitante;
	}
	
	public void setGolVisitante (boolean condicion) {
		this.ganaGolVisitante = condicion;
	}
	
	public int getGolesPenalesC() {
		return golesPenalesC;
	}

	public void setGolesPenalesC(int golesPenalesC) {
		this.golesPenalesC = golesPenalesC;
	}
	public int getpP() {
		return pP;
	}

	public void setpP() {
		this.pP += 1;
	}
	
	public int getpJ() {
		return this.pJ;
	}

	public int getpG() {
		return this.pG;
	}

    public int getGoles () {
        return goles;
    }
    public int getGolesContra() {
        return golesContra;
    }
    
    public void setpG() {
		this.pG += 1;
	}
	
	public void setpJ() {
		this.pJ += 1 ;
	}
	
    public void setpE() {
		this.pE += 1;
	}
    public int getpE() {
		return this.pE;
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
	
	public void setGolesIdaCuartos(int golesIda) {
		this.golesIdaCuartos = golesIda;
	}
	
	public int getGolesIdaCuartos() {
		return golesIdaCuartos;
	}

	public void setGolesVueltaCuartos(int golesVuelta) {
		this.golesVueltaCuartos = golesVuelta;
	}
	
	public int getGolesVueltaCuartos() {
		return golesVueltaCuartos;
	}

	public void setGolesIdaSemis(int golesIda) {
		this.golesIdaSemis = golesIda;
	}
	
	public int getGolesIdaSemis() {
		return golesIdaSemis;
	}

	public void setGolesVueltaSemis(int golesVuelta) {
		this.golesVueltaSemis = golesVuelta;
	}
	
	public int getGolesVueltaSemis() {
		return golesVueltaSemis;
	}

	public void setGolesFinal(int golesFinal) {
		this.golesFinal = golesFinal;
	}
	public int getGolesFinal () {
		return golesFinal;
	}

	public String getCredenciales() {
		// TODO Auto-generated method stub
		String s = nombre;
		s = "----------------------------------------------------<<JUGADORES>>---------------------------------------------------- \n";
		for (Jugador e: Jugadores) 
			s += e.toString() + "\n" ;
		s += "---------------------------------------------------<<ENTRENADOR>>--------------------------------------------------- \n";
		s += entrenador.toString() + "\n";
		return s;
	}
	
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", pais=" + pais + ", ranking=" + ranking + ", Jugadores=" + Jugadores
				+ ", entrenador=" + entrenador.getApellido() + ", puntos=" + puntos + ", goles=" + goles + ", golesContra="
				+ golesContra + "]";
	}


}