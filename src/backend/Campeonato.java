package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import proyecto_final.Controlador;

public class Campeonato implements Serializable {
	
	private static final long serialVersionUID = 9176305150524899919L;
	private final int CANTE = 16;
	private final int CANTJ = 18;
	private final int CANTR = 12;
	private final int CANTZ = 4;
	private final int EQUIPOS_ZONA = 4;
	
	private static ArrayList <Equipo> equipos;
	private static ArrayList <Jugador> jugadores;
	private static ArrayList <Referi> referis;
	private Zona zonas [] = new Zona [CANTZ];
	private CuartosFinal cuartosDeFinal;
	private SemiFinal semiFinal;
	private Final final_Campeonato;
	private Controlador control;
	
	public Campeonato (ArrayList <Equipo> equipos, ArrayList <Jugador> jugadores, ArrayList <Referi> referis) {
		
		this.cuartosDeFinal = null;
		this.semiFinal = null;
		this.equipos = equipos;
		this.jugadores = jugadores;
		this.referis = referis;
		//CREAR LAS ZONAS CON SUS RESPECTIVOS EQUIPOS
		int j = 0;
        for (int z = 0; z < CANTZ; z++) {
            Equipo equiposZona[] = {equipos.get(j), equipos.get(j+1), equipos.get(j+2), equipos.get(j+3)};
            //0 1 2 3 /+4/ 4 5 6 7 /+4/ 8 9 10 11 /+4/ 12 13 14 15
            zonas[z] = new Zona(equiposZona);
            j += 4;
        }
		
	}
	
	public void IniciaTorneo() {//pasar parametros para iniciar UN SOLO INICIATORNEO
		/*Se podrian poner como parametros, las distintas etapas del torneo, ya sea zona, cuartos, semis y final
		 * en caso de iniciar torneo de 0, todos los parametros serian null, en caso contrario, se pasarian los
		 * parametros que se hayan modificado (osea que se haya jugado) y el resto que no, podrian ser null tambien*/
	}
	
	public String listaJugadores(Posicion pos) { 
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
	

	public String listaEquipos() { 
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
	
	public String listaArbitros() { 
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

	public CuartosFinal getCuartosFinal() {
		
		Equipo[] aux = null;
		Equipo[] aux2 = null;
		for (int i = 0; i < CANTZ; i += 2) {
			aux2 = this.zonas[i].getPasanACuartos();
			aux[i] = aux2[0];
			aux[i+1] = aux2[1];
		}
		this.cuartosDeFinal = new CuartosFinal(aux);
		
		return cuartosDeFinal;
	}
	
	public SemiFinal getSemiFinal() {
		
		semiFinal = new SemiFinal(this.cuartosDeFinal.getPasanASemis());
		return semiFinal;
	}
	
	public Final getFinal() {
		
		this.final_Campeonato = new Final(this.semiFinal.getPasanAFinal());
		return final_Campeonato;
	
	}

	public Controlador getControlador() {
		return control;
	}

	public void setControlador(Controlador control) {
		this.control = control;
	}
}
