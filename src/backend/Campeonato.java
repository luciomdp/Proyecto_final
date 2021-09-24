package backend;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import proyecto_final.Controlador;

/*Campeonato

14- Hacia falta diferenciar entre variables y constantes, si esto sucede en otras
Clases tambien, hacerlo.

24-private static ArrayList <Equipo> equipos;
private static ArrayList <Jugador> jugadores;
private static ArrayList <Referi> referis;
¿Variables estaticas por algo en particular?

31- ¿No se utiliza el controlador para mandar información del back al front?

43- Terminar metodo IniciaTorneo() 

67- Arreglar metodo listaJugadores()
92- Arreglar metodo listaEquipos()

En los 3, terminar de verificar que no tengan errores, y armar un formato
un poco mas estético.

122- ¿Qué son esos getters de cuartos semis y final? por qué se crean esas instancias
en getters ?

153- revisar que hay un error si o si, porque una variable solo puede ser nula en ese punto

Los referis no dirigen partidos, implementar.
*/

public class Campeonato implements Serializable {
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int CANTE = 16; //CANTIDAD DE EQUIPOS
	private final int CANTJ = 18; // CANTIDAD DE JUGADORES POR EQUIPO
	private final int CANTR = 12; // CANTIDAD DE REFERIS
	private final int CANTZ = 4; // CANTIDAD DE ZONAS
	private final int CANT_EQUIPOS_CUARTOS = 8;
	private final int CANT_EQUIPOS_SEMIS = 4;
	private final int EQUIPOS_ZONA = 4; 
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private ArrayList <Equipo> equipos;
	private ArrayList <Referi> referis;
	private Zona zonas[];
	private CuartosFinal cuartosDeFinal;
	private SemiFinal semiFinal;
	private Final final_Campeonato;
	private Controlador control;
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public Campeonato (ArrayList <Equipo> equipos, ArrayList <Referi> referis) {
		this.equipos = equipos;
		this.referis = referis;	
		zonas = new Zona [CANTZ];
		
	}

	//-------------------------------------------------<<MÉTODOS DE LA CLASE>>-------------------------------------------------
	
	public void IniciaTorneo() {//pasar parametros para iniciar UN SOLO INICIATORNEO ??????
		/*Se podrian poner como parametros, las distintas etapas del torneo, ya sea zona, cuartos, semis y final
		 * en caso de iniciar torneo de 0, todos los parametros serian null, en caso contrario, se pasarian los
		 * parametros que se hayan modificado (osea que se haya jugado) y el resto que no, podrian ser null tambien*/
		int j = 0;
        Collections.shuffle(equipos); //MEZCLA EL ARRAYLIST PARA QUE CADA VEZ QUE SE QUIERA CREAR UN CAMPEONATO, LAS ZONAS SEAN DISTINTAS
        for (int z = 0; z < CANTZ; z++) {
            Equipo equiposZona[] = {equipos.get(j), equipos.get(j+1), equipos.get(j+2), equipos.get(j+3)};
            //0 1 2 3 /+4/ 4 5 6 7 /+4/ 8 9 10 11 /+4/ 12 13 14 15
            zonas[z] = new Zona(equiposZona, z +1, referis);
            j += 4;
        }
		this.cuartosDeFinal = null;
		this.semiFinal = null;
		this.final_Campeonato = null;
		
	}
	
	public boolean TodasZonasSimuladas() {
		int i = 0;
		while( i < CANTZ && zonas[i].isZonaSimulada())
			i++;
		return i == CANTZ;
	}
	
	public String getTablaZona (int zona) { //DEVUELVE LA TABLA DE LA ZONA
		
		return zonas[zona].getValoresTabla();
	}
	
	public String listaJugadores(Posicion pos) { 
		String s = "--------------------------------------JUGADORES--------------------------------------------\n\n";
		/*Listado de jugadores de determinada posición seleccionada por el operador (arquero, defensor, mediocampista, delantero) 
		 * mostrando toda la información disponible del mismo. En el caso de los arqueros, mostrar la cantidad de Goles en Contra 
		 * que recibió su equipo y el promedio de gol recibido por partido.*/
		
		ArrayList <Jugador> jugadoresEquipo;
		
		for (Equipo e: equipos) {//equipo
			//agarramos todos los jugadores del equipo
			jugadoresEquipo = e.getJugadores();
			
			System.out.println(e); //el equipo esta bien, los jugadores no. revisar entrenador
			
			//System.out.println(jugadoresEquipo); //aca imprime todos los del ultimo equipo. 
			
			for (Jugador player: jugadoresEquipo) {
				if (player.getPosicion() == pos) {
					s+= player.toString(); //en el toString de jugadores se podría sacar la posición, no?
					if (pos == Posicion.arquero) {
						s+= "Goles en contra: " + e.getGolesContra() + "\n";
						if (e.getpJ() > 0) {
							s+= "Promedio de goles recibido: " + (e.getGolesContra() / e.getpJ());
						} else {
							s+= "Promedio de goles recibido: 0";
						}
					}
					s+= "\n\n";
				}
			}
		}
		return s;
	}
	
	public String listaEquipos() { 
		String s = "----------------------------------------EQUIPOS--------------------------------------------\n\n";
		float promedio;
		DecimalFormat formato = new DecimalFormat ("#.00");
		for (Equipo  e: equipos) {
			s+= e.getNombre() + "\nEdad media jugadores: ";
			s+= e.edadMediaJugadores() + "\nEdad DT:";
			s+= e.getEntrenador().getEdad() + ", \nNacionalidad DT: ";
			s+= e.getEntrenador().getNacionalidad() + "\nEfectividad en el torneo: " ;
			if(e.getpJ() > 0 && e.getpG() > 0) {
				promedio = ((float)e.getpG()/(float)e.getpJ())*100;
				s+= formato.format(promedio)+ "\n\n";
			}
			else
				s+= 0 + "\n\n";
		}
		return s;
	}
	
	public String listaArbitros() { 
		int prom = 0; 
		Collections.sort(referis, new Comparator<Referi>() { //
			public int compare(Referi r1, Referi r2) {
				return new Integer(r2.getPartidosDirigidos()).compareTo(new Integer(r1.getPartidosDirigidos()));
			}
		});
		String s= "----------------------------------------ARBITROS--------------------------------------------\n\n";
		for (Referi  e: referis) {
			s += e.ListaReferi() + "\n";
			prom += e.getAños_referato();		
		}
		s += "El promedio de años en el referato es: "+ prom/referis.size();
		return s;
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	public Equipo getECuartosFinal(int equipo) {
		return cuartosDeFinal.getEquipo(equipo);
	}
	public Equipo getESemiFinal(int equipo) {
		return semiFinal.getEquipoSemis(equipo);
	}
	
	public CuartosFinal getCuartosDeFinal() {
		return cuartosDeFinal;
	}

	public SemiFinal getSemiFinal() {
		//semiFinal = new SemiFinal(this.cuartosDeFinal.getPasanASemis());
		return semiFinal;
	}
	
	public Final getFinal() {
		//this.final_Campeonato = new Final(this.semiFinal.getPasanAFinal());
		return final_Campeonato;	
	}
	
	public Zona getZona(int zona) {
		return zonas[zona];
	}
	
	public void setControlador(Controlador control) {
		this.control = control;
	}

	public void IniciaCuartos() {
		ArrayList <Equipo> equiposCuartos = new ArrayList <Equipo>();
		for (int i = 0; i < CANTZ; i ++) {
			equiposCuartos.add(zonas[i].getEquipo(0));
			equiposCuartos.add(zonas[i].getEquipo(1));
		}
		cuartosDeFinal = new CuartosFinal(equiposCuartos, referis);
	}
	
	public void IniciaSemis () {
		/*for (int i = 0; i< CANT_EQUIPOS_SEMIS; i++) {
			cuartosDeFinal.getGanadores().get(i).setGolesPenalesC(-1);
			cuartosDeFinal.getGanadores().get(i).setGolVisitante();
		}*/
		semiFinal = new SemiFinal (cuartosDeFinal.getGanadores(), referis);
	}
	public void IniciaFinal () {
		final_Campeonato = new Final (semiFinal.getGanadores(), referis);
	}

}
