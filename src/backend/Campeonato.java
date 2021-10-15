package backend;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Clase encargada de crear el campeonato que se jugará
 */

public class Campeonato implements Serializable {
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	/** Serial*/
	private static final long serialVersionUID = 1L;
	/** Cantidad de zonas*/
	private final int CANTZ = 4;
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	/** Lista de equipos*/
	private static ArrayList <Equipo> equipos;
	/** Lista de referis*/
	private ArrayList <Referi> referis;
	/** Lista de zonas*/
	private BackZonas zonas[];
	/** Instancia de Cuartos de final*/
	private BackCuartos cuartosDeFinal;
	/** Instancia de Semifinal*/
	private BackSemis semiFinal;
	/** Instancia de Final*/
	private BackFinal final_Campeonato;
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	/**
	 * Constructor de la clase
	 * @param equipos Lista de equipos con sus respectivo jugadores y DT
	 * @param referis Lista de referis
	 */
	public Campeonato (ArrayList <Equipo> equipos, ArrayList <Referi> referis) {
		Campeonato.equipos = equipos; //accedo de forma estática porque ´equipos´ es static
		this.referis = referis;	
		zonas = new BackZonas [CANTZ];
		
	}

	//-------------------------------------------------<<MÉTODOS DE LA CLASE>>-------------------------------------------------
	
	/**
	 * Inicia el torneo, mezclando los equipos para que cada vez que se inicie un nuevo torneo, las zonas sean distintas
	 */
	public void IniciaTorneo() {
		
		int j = 0;
        Collections.shuffle(equipos); //MEZCLA EL ARRAYLIST PARA QUE CADA VEZ QUE SE QUIERA CREAR UN CAMPEONATO, LAS ZONAS SEAN DISTINTAS
        for (int z = 0; z < CANTZ; z++) {
            Equipo equiposZona[] = {equipos.get(j), equipos.get(j+1), equipos.get(j+2), equipos.get(j+3)}; 
            //0 1 2 3 /+4/ 4 5 6 7 /+4/ 8 9 10 11 /+4/ 12 13 14 15
            zonas[z] = new BackZonas(equiposZona, z +1, referis);
            j += 4;
        }
		this.cuartosDeFinal = null;
		this.semiFinal = null;
		this.final_Campeonato = null;
		
	}
	
	/**
	 * Se fija si todas las zonas fueron simuladas
	 * @return true si todas simuladas, false si faltan simular
	 */
	public boolean TodasZonasSimuladas() {
		int i = 0;
		while( i < CANTZ && zonas[i].isZonaSimulada())
			i++;
		return i == CANTZ;
	}
	
	/**
	 * Devuelve la tabla de la zona
	 * @param zona Numero de zona
	 * @return La tabla
	 */
	public String getTablaZona (int zona) {
		return zonas[zona].getValoresTabla();
	}
	
	public String GeneraCredenciales (String equipo1, String equipo2, int etapa) {
		
		int i;
		String s = "", E1 = equipo1.substring(0, 25), E2 = equipo2.substring(0, 25);
		i = 0;
		s += "<<=========================================================================>>\n";
		switch(etapa){//Se piden las credenciales de los equipos 1 y 2 que jugaron...
		case 0://zona 1
			while ((!zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre().equals(E1) && !zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre().equals(E2)) && (!zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre().equals(E1) && !zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre().equals(E2))) 
				i++;
			s +="\n<<===============================EQUIPO 1===============================>>\n\n" + E1.trim() + "\n\n";
			s += zonas[etapa].getPartidosZona()[i].getEquipo1().getCredenciales();
			s += "\n_______________________________________________________________________________\n";
			s +="\n<<===============================EQUIPO 2===============================>>\n\n" + E2.trim() + "\n\n";
			s += zonas[etapa].getPartidosZona()[i].getEquipo2().getCredenciales();
			s += zonas[etapa].getPartidosZona()[i].getArbitro().getCredencial();
		break;
		case 1://zona 2
			while ((!zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre().equals(E1) && !zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre().equals(E2)) && (!zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre().equals(E1) && !zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre().equals(E2)))
				i++;
			s +="\n<<===============================EQUIPO 1===============================>>\n\n" + E1.trim() + "\n\n";
			s += zonas[etapa].getPartidosZona()[i].getEquipo1().getCredenciales();
			s += "\n_______________________________________________________________________________\n";
			s +="\n<<===============================EQUIPO 2===============================>>\n\n" + E2.trim() + "\n\n";
			s += zonas[etapa].getPartidosZona()[i].getEquipo2().getCredenciales();
			s += zonas[etapa].getPartidosZona()[i].getArbitro().getCredencial();
		break;
		case 2://zona 3
			while ((!zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre().equals(E1) && !zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre().equals(E2)) && (!zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre().equals(E1) && !zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre().equals(E2)))
				i++;
			s +="\n<<===============================EQUIPO 1===============================>>\n\n" + E1.trim() + "\n\n";
			s += zonas[etapa].getPartidosZona()[i].getEquipo1().getCredenciales();
			s += "\n_______________________________________________________________________________\n";
			s +="\n<<===============================EQUIPO 2===============================>>\n\n" + E2.trim() + "\n\n";
			s += zonas[etapa].getPartidosZona()[i].getEquipo2().getCredenciales();
			s += zonas[etapa].getPartidosZona()[i].getArbitro().getCredencial();
		break;
		case 3://zona 4
			while ((!zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre().equals(E1) && !zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre().equals(E2)) && (!zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre().equals(E1) && !zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre().equals(E2)))
				i++;
			s +="\n<<===============================EQUIPO 1===============================>>\n\n" + E1.trim() + "\n\n";
			s += zonas[etapa].getPartidosZona()[i].getEquipo1().getCredenciales();
			s += "\n_______________________________________________________________________________\n";
			s +="\n<<===============================EQUIPO 2===============================>>\n\n" + E2.trim() + "\n\n";
			s += zonas[etapa].getPartidosZona()[i].getEquipo2().getCredenciales();
			s += zonas[etapa].getPartidosZona()[i].getArbitro().getCredencial();
		break;
		case 4://cuartos
			while (!(cuartosDeFinal.getPartidoCuartos()[i].getEquipo1().getNombre().equals(E1) && !cuartosDeFinal.getPartidoCuartos()[i].getEquipo2().getNombre().equals(E2)) && (!cuartosDeFinal.getPartidoCuartos()[i].getEquipo2().getNombre().equals(E1) && !cuartosDeFinal.getPartidoCuartos()[i].getEquipo1().getNombre().equals(E2))) 
				i++;
			s +="\n<<===============================EQUIPO 1===============================>>\n\n" + E1.trim() + "\n\n";
			s += cuartosDeFinal.getPartidoCuartos()[i].getEquipo1().getCredenciales();
			s += "\n_______________________________________________________________________________\n";
			s +="\n<<===============================EQUIPO 2===============================>>\n\n" + E2.trim() + "\n\n";
			s += cuartosDeFinal.getPartidoCuartos()[i].getEquipo2().getCredenciales();
			if (cuartosDeFinal.getPartidoActual() > cuartosDeFinal.getCANT_P()/2) { //si está en los partidos de vuelta
				s += "\n----------------------------------------------<<REFERI partido IDA>>---------------------------------------------- \n\n";
				s += cuartosDeFinal.getPartidoCuartos()[i-1].getArbitro().toString(); //árbitro del partido de ida
				s += "\n\n---------------------------------------------<<REFERI partido VUELTA>>---------------------------------------------- \n\n";
				} 
			else
				s += "\n----------------------------------------------------<<REFERI>>---------------------------------------------------- \n\n";
			s += cuartosDeFinal.getPartidoCuartos()[i].getArbitro().toString(); //árbitro del partido de vuelta (o de ida si no entra al if)
			break;
		case 5://semis TODO aca matii help
			while (!(semiFinal.getPartidoSemis()[i].getEquipo1().getNombre().equals(E1) && !semiFinal.getPartidoSemis()[i].getEquipo2().getNombre().equals(E2)) && (!semiFinal.getPartidoSemis()[i].getEquipo2().getNombre().equals(E1) && !semiFinal.getPartidoSemis()[i].getEquipo1().getNombre().equals(E2))) 
				i++;
			s +="\n<<===============================EQUIPO 1===============================>>\n\n" + E1.trim() + "\n\n";
			s += semiFinal.getPartidoSemis()[i].getEquipo1().getCredenciales();
			s += "\n_______________________________________________________________________________\n";
			s +="\n<<===============================EQUIPO 2===============================>>\n\n" + E2.trim() + "\n\n";
			s += semiFinal.getPartidoSemis()[i].getEquipo2().getCredenciales();

			System.out.println(i+ " " + semiFinal.getPartidoAct() + " " + semiFinal.getCANT_P()/2);
			if (semiFinal.getPartidoAct() >= semiFinal.getCANT_P()/2) {
				s += "\n----------------------------------------------<<REFERI partido IDA>>---------------------------------------------- \n\n";
				s += semiFinal.getPartidoSemis()[i-1].getArbitro().toString(); //i es 0)?
				System.out.println(i+ " " + semiFinal.getPartidoAct() + " " + semiFinal.getCANT_P()/2);
				s += "\n\n---------------------------------------------<<REFERI partido VUELTA>>---------------------------------------------- \n\n";
				} 
			else
				s += "\n----------------------------------------------------<<REFERI>>---------------------------------------------------- \n\n";
			s += semiFinal.getPartidoSemis()[i].getArbitro().toString();
			break;
		case 6://final
			s +="\n<<===============================EQUIPO 1===============================>>\n\n" + E1.trim() + "\n\n";
			s += final_Campeonato.getPartidoFinal().getEquipo1().getCredenciales();
			s += "\n_______________________________________________________________________________\n";
			s +="\n<<===============================EQUIPO 2===============================>>\n\n" + E2.trim() + "\n\n";
			s += final_Campeonato.getPartidoFinal().getEquipo2().getCredenciales();
			s += final_Campeonato.getPartidoFinal().getArbitro().getCredencial();
			break;
		}
		s += "\n\n<<=========================================================================>>\n";
		return s;
	
	}
	
	/**
	 * Listado de jugadores de determinada posición seleccionada por el operador (arquero, defensor, mediocampista, delantero) 
	mostrando toda la información disponible del mismo. En el caso de los arqueros, muestra la cantidad de Goles en Contra 
	que recibió su equipo y el promedio de gol recibido por partido.
	 * @param pos La posicion a listar
	 * @return String con la lista
	 */
	public String listaJugadores(Posicion pos) { 
		String s = "--------------------------------------JUGADORES--------------------------------------------\n\n";
		
	
		
		ArrayList <Jugador> jugadoresEquipo;
		float promedio;
		for (Equipo e: equipos) {//equipo
			//agarramos todos los jugadores del equipo
			jugadoresEquipo = e.getJugadores();
			
			for (Jugador player: jugadoresEquipo) {
				if (player.getPosicion() == pos) {
					s+= player.toString();
					if (pos == Posicion.arquero) {
						s+= "Goles en contra: " + e.getGolesContra() + "\n";
						if (e.getpJ() > 0) {
							promedio = (float)e.getGolesContra() / (float)e.getpJ();
							s+= "Promedio de goles recibido: " + promedio + "\n";
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
	
	/**
	 * Lista equipos 
	 * @return String con la lista
	 */
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
	
	/**
	 * Lista los árbitros del torneo
	 * @return String con la lista
	 */
	public String listaArbitros() { 
		int prom = 0; 
		Collections.sort(referis, new Comparator<Referi>() {
			public int compare(Referi r1, Referi r2) {
				return Integer.compare(r2.getPartidosDirigidos(), r1.getPartidosDirigidos());
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
	
	/**
	 * Devuelve un equipo de cuartos de final
	 * @param equipo Integer representando el equipo
	 * @return El equipo
	 */
	public Equipo getECuartosFinal(int equipo) {
		return cuartosDeFinal.getEquipo(equipo);
	}
	
	/**
	 * Devuelve un equipo de semifinal
	 * @param equipo Integer representando el equipo
	 * @return El equipo
	 */
	public Equipo getESemiFinal(int equipo) {
		return semiFinal.getEquipoSemis(equipo);
	}
	
	/**
	 * Devuelve una instancia de Zona
	 * @param zona Integer representando la zona
	 * @return La zona
	 */
	public BackZonas getZona(int zona) {
		return zonas[zona];
	}
	
	/**
	 * Devuelve una instancia de CuartosFinal
	 * @return Los cuartos de final
	 */
	public BackCuartos getCuartosDeFinal() {
		return cuartosDeFinal;
	}

	/**
	 * Devuelve una instancia de SemiFinal
	 * @return Una semifinal
	 */
	public BackSemis getSemiFinal() {
		return semiFinal;
	}
	
	/**
	 * Devuelve una instancia de Final
	 * @return Una final
	 */
	public BackFinal getFinal() {
		return final_Campeonato;	
	}

	/**
	 * Inicia los cuartos de final
	 */
	public void IniciaCuartos() {
		ArrayList <Equipo> equiposCuartos = new ArrayList <Equipo>();
		for (int i = 0; i < CANTZ; i ++) {
			equiposCuartos.add(zonas[i].getEquipo(0));
			equiposCuartos.add(zonas[i].getEquipo(1));
		}
		cuartosDeFinal = new BackCuartos(equiposCuartos, referis);
	}
	
	/**
	 * Inicia las semifinales
	 */
	public void IniciaSemis () {
		semiFinal = new BackSemis (cuartosDeFinal.getGanadores(), referis);
	}
	
	/**
	 * Inicia la final
	 */
	public void IniciaFinal () {
		final_Campeonato = new BackFinal (semiFinal.getGanadores(), referis);
	}
	/**
	 * Devuelve la mayor cantidad de títulos, entre todos los entrenadores del campeonato.
	 */
	
	 public static final byte getTitulos () {
		 
		byte t = 0;
		
		for (Equipo e : equipos){ 
			if (t < e.getEntrenador().getTitulos())
				t = e.getEntrenador().getTitulos();
			}

		return t;
	}
}
