package backend;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


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

	private int pJ;
    private int pG;
	
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

	public String getEstadisticas() {
        return " Nombre: "+ nombre+"\n Puntos : "+ puntos +"\n Goles: "+ goles +"\n Goles en contra: "+ golesContra;
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
    
    public double edadMediaJugadores() {  
		int edadMedia = 0; 
		for (Jugador e: Jugadores) {
			
	        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
	        int edadJ = Integer.parseInt(getYearFormat.format(e.getNacimiento()));
			Calendar fechaAct = Calendar.getInstance();
			int actual = fechaAct.get(Calendar.YEAR);
			edadMedia += actual-edadJ;
			
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

	/*public void setPais(Pais pais) {
		this.pais = pais;
	}*/

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", pais=" + pais + ", ranking=" + ranking + ", Jugadores=" + Jugadores
				+ ", entrenador=" + entrenador + ", puntos=" + puntos + ", goles=" + goles + ", golesContra="
				+ golesContra + ", getEntrenador()=" + getEntrenador() + "]";
	}
	
}
