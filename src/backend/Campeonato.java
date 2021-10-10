package backend;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import proyecto_final.Controlador;

/*Campeonato

31- ¿No se utiliza el controlador para mandar información del back al front?
		??? utiliza un monton de metodos del back que son utilizados en el front llamando al controlador. 

 armar un formato mas estético de los lista()

122- ¿Qué son esos getters de cuartos semis y final? 
		TE DEVUELVEN LA INSTANCIA EN LOS MOMENTOS QUE EL CONTROLADOR NECESITA OBTENER DATOS DE LOS EQUIPOS PERTENECIENTES A ESAS INSTANCIAS

*/

/**
 * Clase encargada de crear el campeonato que se jugará
 */
public class Campeonato implements Serializable {
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	/** Serial*/
	private static final long serialVersionUID = 1L;
	/** Cantidad de zonas*/
	private final int CANTZ = 4;
	
	/** Acá dejo super prolijo, bien comentado todo lo que no se usa
	private final int CANT_EQUIPOS_CUARTOS = 8;
	private final int CANT_EQUIPOS_SEMIS = 4;
	private final int EQUIPOS_ZONA = 4;  
	private final int CANTE = 16; //CANTIDAD DE EQUIPOS
	private final int CANTJ = 18; // CANTIDAD DE JUGADORES POR EQUIPO
	private final int CANTR = 12; // CANTIDAD DE REFERIS
	*/
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	/** Lista de equipos*/
	private ArrayList <Equipo> equipos;
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
	/** Instancia de Controlador .-TODO- Sin usar*/
	
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	/**
	 * Constructor de la clase
	 * @param equipos Lista de equipos con sus respectivo jugadores y DT
	 * @param referis Lista de referis
	 */
	public Campeonato (ArrayList <Equipo> equipos, ArrayList <Referi> referis) {
		this.equipos = equipos;
		this.referis = referis;	
		zonas = new BackZonas [CANTZ];
		
	}

	//-------------------------------------------------<<MÉTODOS DE LA CLASE>>-------------------------------------------------
	
	/**
	 * Inicia el torneo, mezclando los equipos para que cada vez que se inicie un nuevo torneo, las zonas sean distintas
	 */
	public void IniciaTorneo() {//pasar parametros para iniciar UN SOLO INICIATORNEO ??????
		/*Se podrian poner como parametros, las distintas etapas del torneo, ya sea zona, cuartos, semis y final
		 * en caso de iniciar torneo de 0, todos los parametros serian null, en caso contrario, se pasarian los
		 * parametros que se hayan modificado (osea que se haya jugado) y el resto que no, podrian ser null tambien*/
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
		int i = 0;
		String s = "";
		equipo1 = equipo1.substring(0, 25);
		equipo2 = equipo2.substring(0, 25);
		switch(etapa){//Se piden las credenciales de los equipos 1 y 2 que jugaron...
		case 0://zona 1
			while ((zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre() != equipo1 && zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre() != equipo2) && (zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre() != equipo1 && zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre() != equipo2)) 
				i++;
			s += zonas[etapa].getPartidosZona()[i].getEquipo1().getCredenciales();
			s += zonas[etapa].getPartidosZona()[i].getEquipo2().getCredenciales();
			s += zonas[etapa].getPartidosZona()[i].getArbitro().getCredencial();
		break;
		case 1://zona 2
			while ((zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre() != equipo1 && zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre() != equipo2) && (zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre() != equipo1 && zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre() != equipo2)) 
				i++;
			s += zonas[etapa].getPartidosZona()[i].getEquipo1().getCredenciales();
			s += zonas[etapa].getPartidosZona()[i].getEquipo2().getCredenciales();
			s += zonas[etapa].getPartidosZona()[i].getArbitro().getCredencial();
		break;
		case 2://zona 3
			while ((zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre() != equipo1 && zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre() != equipo2) && (zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre() != equipo1 && zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre() != equipo2)) 
				i++;
			s += zonas[etapa].getPartidosZona()[i].getEquipo1().getCredenciales();
			s += zonas[etapa].getPartidosZona()[i].getEquipo2().getCredenciales();
			s += zonas[etapa].getPartidosZona()[i].getArbitro().getCredencial();
		break;
		case 3://zona 4
			while ((zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre() != equipo1 && zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre() != equipo2) && (zonas[etapa].getPartidosZona()[i].getEquipo2().getNombre() != equipo1 && zonas[etapa].getPartidosZona()[i].getEquipo1().getNombre() != equipo2)) 
				i++;
			s += zonas[etapa].getPartidosZona()[i].getEquipo1().getCredenciales();
			s += zonas[etapa].getPartidosZona()[i].getEquipo2().getCredenciales();
			s += zonas[etapa].getPartidosZona()[i].getArbitro().getCredencial();
		break;
		case 4://cuartos
			while ((cuartosDeFinal.getPartidoCuartos()[i].getEquipo1().getNombre() != equipo1 && cuartosDeFinal.getPartidoCuartos()[i].getEquipo2().getNombre() != equipo2) && (cuartosDeFinal.getPartidoCuartos()[i].getEquipo2().getNombre() != equipo1 && cuartosDeFinal.getPartidoCuartos()[i].getEquipo1().getNombre() != equipo2)) 
				i++;
			s += cuartosDeFinal.getPartidoCuartos()[i].getEquipo1().getCredenciales();
			s += cuartosDeFinal.getPartidoCuartos()[i].getEquipo2().getCredenciales();
			s += cuartosDeFinal.getPartidoCuartos()[i].getArbitro().getCredencial();
			break;
		case 5://semis
			while ((semiFinal.getPartidoSemis()[i].getEquipo1().getNombre() != equipo1 && semiFinal.getPartidoSemis()[i].getEquipo2().getNombre() != equipo2) && (semiFinal.getPartidoSemis()[i].getEquipo2().getNombre() != equipo1 && semiFinal.getPartidoSemis()[i].getEquipo1().getNombre() != equipo2)) 
				i++;
			s += semiFinal.getPartidoSemis()[i].getEquipo1().getCredenciales();
			s += semiFinal.getPartidoSemis()[i].getEquipo2().getCredenciales();
			s += semiFinal.getPartidoSemis()[i].getArbitro().getCredencial();
			break;
		case 6://final
			s += final_Campeonato.getPartidoFinal().getEquipo1().getCredenciales();
			s += final_Campeonato.getPartidoFinal().getEquipo2().getCredenciales();
			s += final_Campeonato.getPartidoFinal().getArbitro().getCredencial();
			break;
		}
		return s;
	
	}
	
	/**
	 * Lista jugadores segun posicion
	 * @param pos La posicion a listar
	 * @return String con la lista
	 */
	public String listaJugadores(Posicion pos) { 
		String s = "--------------------------------------JUGADORES--------------------------------------------\n\n";
		/*Listado de jugadores de determinada posición seleccionada por el operador (arquero, defensor, mediocampista, delantero) 
		 * mostrando toda la información disponible del mismo. En el caso de los arqueros, mostrar la cantidad de Goles en Contra 
		 * que recibió su equipo y el promedio de gol recibido por partido.*/
		
		ArrayList <Jugador> jugadoresEquipo;
		float promedio;
		for (Equipo e: equipos) {//equipo
			//agarramos todos los jugadores del equipo
			jugadoresEquipo = e.getJugadores();
			
			System.out.println(e); //revisar entrenador TODO-> Esto es nuevo o es viejo????
			
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
		Collections.sort(referis, new Comparator<Referi>() { //
			public int compare(Referi r1, Referi r2) {
				///TODO: acá abajo, que se hace? los métodos están deprecados => Claudio nos mata
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
	
	/**
	 * Setea el controlador
	 * @param control El controlador
	 */
	
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

}
