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
	private ArrayList<Jugador> Jugadores = new ArrayList<Jugador>(17);
	private Dt entrenador;
	
    private int puntos;
    private int goles;
    private int golesContra;
    private int golesIda;
    private int golesVuelta;
    private int pJ;
    private int pG;
    private int pP;
    
  //-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
    
    public Equipo (String n, Pais p, int r, ArrayList<Jugador> j, Dt e){ 
		nombre = n;
		pais = p;
		ranking = r;
		Jugadores = j;
		entrenador = e;
		this.goles = 0;
        this.golesContra = 0;
        this.golesIda = 0;
        this.golesVuelta = 0;
        this.puntos = 0;
        this.pG = 0;
        this.pJ = 0;
        this.pP = 0;
	}
    
  //-------------------------------------------------<<M�TODOS>>-------------------------------------------------

	public double edadMediaJugadores() { 
    	
    	int edadMedia = 0;
		LocalDate fechaAct = null ; 

		for (Jugador e: Jugadores) {
			Period edad = Period.between(e.getNacimiento(), fechaAct.now()); 
			edadMedia += edad.getYears();
		}
		return edadMedia/18;
    }
	
	public double MediaJugadores() {
		int media = 0;
		for (Jugador e: Jugadores) {
			media += e.getPuntaje();
		}
		return media/18;
	}
	
	public String estadisticasCuartos () {
		return nombre + golesIda + golesVuelta;
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	public String getEstadisticas() {
        return nombre+ puntos + pJ + pG + pP + goles + golesContra + (goles - golesContra);
    }
	
	
	public int getpP() {
		return pP;
	}

	public void setpP(int pP) {
		this.pP = pP;
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
    
    public void setpG(int pG) {
		this.pG = pG;
	}
	
	public void setpJ(int pJ) {
		this.pJ = pJ;
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

	public void setRanking(int ranking) {
		this.ranking = ranking;
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

	public void setJugadores(ArrayList<Jugador> jugadores) {
		Jugadores = jugadores;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setEntrenador(Dt entrenador) {
		this.entrenador = entrenador;
	}
	public int getGolesIda() {
		return golesIda;
	}

	public void setGolesIda(int golesIda) {
		this.golesIda = golesIda;
	}

	public int getGolesVuelta() {
		return golesVuelta;
	}

	public void setGolesVuelta(int golesVuelta) {
		this.golesVuelta = golesVuelta;
	}

	
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", pais=" + pais + ", ranking=" + ranking + ", Jugadores=" + Jugadores
				+ ", entrenador=" + entrenador + ", puntos=" + puntos + ", goles=" + goles + ", golesContra="
				+ golesContra + ", getEntrenador()=" + getEntrenador() + "]";
	}
}