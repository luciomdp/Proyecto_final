package backend;
import java.io.Serializable;
import java.util.ArrayList;

public class Equipo implements Serializable{


	private static final long serialVersionUID = -6798555891375663146L;
	private String[] nombre;
	private Pais pais;
	private int ranking;
	private ArrayList<Jugador> Jugadores = new ArrayList<Jugador>(17);
	private Dt entrenador;
	
    private int puntos;
    private int goles;
    private int golesContra;
	
	public Equipo (String[] n, Pais p, int r, ArrayList<Jugador> j, Dt e){
		nombre = n;
		pais = p;
		ranking = r;
		Jugadores = j;
		entrenador = e;
		this.goles = 0;
        this.golesContra = 0;
        this.puntos = 0;
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
        this.puntos  = this.puntos + puntos;
    }

    public void setGoles(int goles) {
        this.goles = this.goles + goles;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = this.puntos + golesContra;
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
	public String[] getNombre() {
		return nombre;
	}

	public void setNombre(String []nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Jugador> getJugadores() {
		return Jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		Jugadores = jugadores;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
