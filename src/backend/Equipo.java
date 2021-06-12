package backend;
import java.io.Serializable;
import java.util.ArrayList;

public class Equipo implements Serializable{


	private static final long serialVersionUID = -6798555891375663146L;
	private String nombre;
	private Pais pais;
	private int ranking;
	private ArrayList<Jugador> Jugadores = new ArrayList(17);
	private Dt entrenador;
	
	public Equipo (String n, Pais p, int r, ArrayList<Jugador> j, Dt e){
		nombre = n;
		pais = p;
		ranking = r;
		Jugadores = j;
		entrenador = e;
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
	

}
