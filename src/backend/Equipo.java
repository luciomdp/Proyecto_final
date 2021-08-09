package backend;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Equipo implements Serializable{
	
	private static final long serialVersionUID = -6798555891375663146L;
	private String nombre;
	private Pais pais;
	private int ranking; 
	private ArrayList<Jugador> Jugadores = new ArrayList<Jugador>(17);
	private Dt entrenador;
	
    private int puntos;
    private int goles;
    private int golesContra;
    private int golesCuartos;
    private int golesSemis;
    private int golesContraCuartos;
    private int golesContraSemis;
    private int pJ;
    private int pG;
    private int pP;
    
    public Equipo (String n, Pais p, int r, ArrayList<Jugador> j, Dt e){ 
		nombre = n;
		pais = p;
		ranking = r;
		Jugadores = j;
		entrenador = e;
		this.goles = 0;
        this.golesContra = 0;
        this.puntos = 0;
        this.pG = 0;
        this.pJ = 0;
        this.pP = 0;
	}
    
    public int getpP() {
		return pP;
	}

	public void setpP(int pP) {
		this.pP = pP;
	}

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
	
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", pais=" + pais + ", ranking=" + ranking + ", Jugadores=" + Jugadores
				+ ", entrenador=" + entrenador + ", puntos=" + puntos + ", goles=" + goles + ", golesContra="
				+ golesContra + ", getEntrenador()=" + getEntrenador() + "]";
	}
	
	public String getEstadisticas() {
        return " Nombre: "+ nombre+"\n Puntos : "+ puntos +"\n Goles: "+ goles +"\n Goles en contra: "+ golesContra;
    }
	
    public int getGolesCuartos() {
		return golesCuartos;
	}

	public void setGolesCuartos(int golesCuartos) {
		this.golesCuartos = golesCuartos;
	}

	public int getGolesSemis() {
		return golesSemis;
	}

	public void setGolesSemis(int golesSemis) {
		this.golesSemis = golesSemis;
	}

	public int getGolesContraCuartos() {
		return golesContraCuartos;
	}

	public void setGolesContraCuartos(int golesContraCuartos) {
		this.golesContraCuartos = golesContraCuartos;
	}

	public int getGolesContraSemis() {
		return golesContraSemis;
	}

	public void setGolesContraSemis(int golesContraSemis) {
		this.golesContraSemis = golesContraSemis;
	}
	
	public int getpJ() {
		return pJ;
	}

	public void setpJ(int pJ) {
		this.pJ = pJ;
	}

	public int getpG() {
		return pG;
	}

	public void setpG(int pG) {
		this.pG = pG;
	}

    public int getGoles () {
        return goles;
    }
    public int getGolesContra() {
        return golesContra;
    }

    public int getPuntos() {
        return puntos;
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

	public void setEntrenador(Dt entrenador) {
		this.entrenador = entrenador;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Jugador> getJugadores() {
		return Jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		Jugadores = jugadores;
	}
}
