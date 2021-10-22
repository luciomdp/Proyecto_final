package backend;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

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
    private int golesIda;
    private int golesVuelta;
    private int golesPenalesC;
    private boolean ganaGolVisitante;
    private int pJ;
    private int pG;
    private int pP;
    private int pE;
    private double mediaEquipo;
    
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
        this.golesIda = 0;
        this.golesVuelta = 0;
        this.ganaGolVisitante = false;
        this.puntos = 0;
        this.pG = 0;
        this.pJ = 0;
        this.pP = 0;
        this.pE = 0;
        double suma = 0;
		for (Jugador e: jugadores) {
			suma += e.getPuntaje();
		}
		suma = suma/18;
		this.mediaEquipo = (suma* 0.6 * 10) + ((101 - ranking)*0.25 ) + ((entrenador.getTitulos() *100 / 30)* 0.15);
        
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
		return media/18 *10;
	}
	
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	/**
	 * @return String con nombre del equipo, puntos, partidos jugados, ganados, 
	 * empatados y perdidos, goles a favor y en contra, diferencia de gol.
	 */
	public String getEstadisticas() {
		if (goles-golesContra >= 0)
			return nombre + "| " + puntos + "| " + pJ + "| " + pG + "| " + pE + "| " + pP +  "|  " +(goles - golesContra) + "|";//+ golesContra + (goles - golesContra);
		else
			return nombre + "| " + puntos + "| " + pJ + "| " + pG + "| " + pE + "| " + pP +  "| " +(goles - golesContra) + "|";//+ golesContra + (goles - golesContra);
			
	}
	
	/**
	 * @return String con nombre del equipo y goles en la ida de los cuartos de final.
	 */
	public String getEstadisticasCuartosIda() { //
		return nombre + "|" + golesIda + "|";
    }
	/**
	 * @return String con nombre del equipo y goles en la ida y vuelta de los cuartos de final.
	 */
	public String getEstadisticasCuartosVuelta() {
		if (golesPenalesC == -1) {
			if (ganaGolVisitante)
				return nombre + "|" + golesIda + "|"  + golesVuelta + "| R:" + (golesIda + golesVuelta)+ "(Gv)";
			else
				return nombre + "|" + golesIda + "|"  + golesVuelta + "| R:" + (golesIda + golesVuelta);
		}
		else
			return nombre + "|" + golesIda + "|"  + golesVuelta + "| R:" + (golesIda + golesVuelta) + " P:" + (golesPenalesC + 1);
			
    }
	/**
	 * @return String con nombre del equipo y goles en la ida de las semifinales.
	 */
	public String getEstadisticasSemisIda() {
		return nombre + "|" + golesIda + "|";
    }
	/**
	 * @return String con nombre del equipo y goles en la ida y vuelta de las semifinales.
	 */
	public String getEstadisticaSemis() {
		if (golesPenalesC == -1) {
			if (ganaGolVisitante)	
				return nombre + "|" + golesIda + "|"  + golesVuelta + "| R:" + (golesIda + golesVuelta)+ "(Gv)";
			else
				return nombre + "|" + golesIda + "|"  + golesVuelta + "| R:" + (golesIda + golesVuelta);
		}
		else
			return nombre + "|" + golesIda + "|"  + golesVuelta + "| R:" + (golesIda + golesVuelta) + " P:" + (golesPenalesC + 1);
			
    }
	/**
	 * @return String con goles de la final y penales, en caso de que hubieran.
	 */
	public String getEstadisticasFinal () {
		if (golesPenalesC == -1) 
			return ""+golesIda;
		else
			return golesIda + " ("+ (golesPenalesC + 1) + ")";
			
	}
	
	public void setGolVisitante (boolean condicion) {
		this.ganaGolVisitante = condicion;
	}
	
	public void setGolesPenalesC(int golesPenalesC) {
		this.golesPenalesC = golesPenalesC;
	}
	
	public double getMediaEquipo () {
		return mediaEquipo;
	}
	
	public float getMediaPos(Posicion pos) {
		float suma = 0;
		int cantJ = 0;
		for (Jugador e: Jugadores) {
			if (e.getPosicion() == pos) {
				suma += e.getPuntaje();
				cantJ ++;
			}
		}
		suma = suma/cantJ;
		return suma;
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

	public Dt getEntrenador() {
		return entrenador;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Jugador> getJugadores() {
		return Jugadores;
	}
	
	public void setGolesIda(int golesIda) {
		this.golesIda = golesIda;
	}

	public void setGolesVuelta(int golesVuelta) {
		this.golesVuelta = golesVuelta;
	}

	public String getCredenciales() {
		String s = nombre;
		s = "__________________________<<JUGADORES>>__________________________ \n\n";
		for (Jugador e: Jugadores) 
			s += e.toString() + "\n" ;
		s += "__________________________<<ENTRENADOR>>__________________________ \n\n";
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