package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Campeonato implements Serializable{
	
	private static final long serialVersionUID = 9176305150524899919L;
	private final int CANTE = 16;
	private final int CANTJ = 18;
	private final int CANTR = 12;
	private final int CANTZ = 4;
	private final int EQUIPOS_ZONA = 4;
	
	private ArrayList <Equipo> equipos;
	private ArrayList <Jugador> jugadores;
	private ArrayList <Referi> referis;
	private Zona zonas [] = new Zona [CANTZ];
	private CuartosFinal cuartosDeFinal;
	private SemiFinal semiFinal;
	private Final final_Campeonato;
	
	public Campeonato (ArrayList <Equipo> equipos, ArrayList <Jugador> jugadores, ArrayList <Referi> referis) {
		
		this.cuartosDeFinal = null;
		this.semiFinal = null;
		this.equipos = equipos;
		this.jugadores = jugadores;
		this.referis = referis;
		//CREAR LAS ZONAS CON SUS RESPECTIVOS EQUIPOS
		
		
	}
	public String ListaJugadores(Posicion pos) { 
		String s = "--------------------------------------JUGADORES--------------------------------------------\n\n";
		Iterator < Jugador > it = jugadores.iterator();
		Jugador j = it.next();
		while (it.hasNext() && j.getPosicion() != pos) {
			j = it.next();
		}
	
		if (pos.name() == "Arquero" ) { //COMPLETAR GOLES EN CONTRA Y PROMEDIO POR PARTIDO DE GOLES EN CONTRA
			while (it.hasNext() && j.getPosicion() == pos) {
				s += j.toString()+"\n";
				j = it.next();
			}
		}
		else {
			while (it.hasNext() && j.getPosicion() == pos) {
				s += j.toString()+"\n";
				j = it.next();
			}
		}
		
		return s;
	}
	public String ListaEquipos() { // CORROBORAR PROCESO DE OBTENCIÓN DE EDADES edadMediaJugadres y getEdad de entrenador (se lo mande a claudio para estar seguro)
		String s = "----------------------------------------EQUIPOS--------------------------------------------\n\n";
		for (Equipo  e: equipos) {
			s+= e.getNombre() + "\nEdad media jugadores: ";
			s+= e.edadMediaJugadores() + "\nEdad DT:";
			s+= e.getEntrenador().getEdad() + ", Nacionalidad DT: ";
			s+= e.getEntrenador().getNacionalidad() + "\nEfectividad en el torneo" ;
			s+= (e.getpG()/e.getpJ())*100+ "\n\n";
		}
		return s;
	}
	public String ListaArbitros() { 
		int prom = 0; 
		String s = "----------------------------------------ARBITROS--------------------------------------------\n\n";
		for (Referi  e: referis) {
			s+= e.getNombre()+"\nAños en el referato; ";
			s+= e.getAños_referato()+ "\n\n";
			prom += e.getAños_referato();
			
		}
		s += "El promedio de años en el referato es: "+ prom/equipos.size();
		return s;
	}

	
}
