package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.JOptionPane;

/*

53-Como funciona SimulaPartido() ? Onda que hace
	1- simula el partido correspondiente
	2- le suma a cada equipo los goles a favor y en contra, el partido jugado, si ganaron o perdieron y el puntaje que deben recibir
	3- se registra el resultado en un arreglo de resultados (por si en algun momento debemos acudir a alguno de ellos)
	4- actualiza la tabla de la zona dependiendo del resultado
	
*/

public class BackZonas implements Serializable{
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private static final long serialVersionUID = 2934756314623471362L;
	//-------------------------VALORES DE PUNTOS--------------------------
	final private int PV = 3;
	final private int PE = 1;
	//-------------------------CANTIDAD DE PARTIDOS--------------------------
	final private int CANT_PZ = 6;
	final private int CANT_PF = 2;
	final private int CANTE = 4;
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private int partidoAct,fechaAct;//f es fecha actual e i es partido actual
	/*Cada partido va a tener asignado un valor "i", cada fecha son 2 partidos de i (teniendo en cuenta el valor
	actual de i,tenes una variable fecha "f", que dice en que fecha se encuentra, y simular toda la zona, es iterar desde el i
	actual hasta el final)*/
    private Equipo [] tabla = new Equipo [CANTE]; // TABLA DE LA ZONA 
    private Partido partidosZona[];
    private Resultados resultados [];
    private int nroZona; 
    private boolean ZonaSimulada;
    
  //-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------

	public BackZonas (Equipo equipos[], int nroZona, ArrayList <Referi> referis) {
    	
    	ZonaSimulada = false;
    	this.nroZona = nroZona;
    	resultados = new Resultados [CANT_PZ];
    	this.partidosZona = new Partido [CANT_PZ];
    	this.partidosZona = creaFechas(equipos, referis);
        for (int i = 0; i < CANTE; i++) {
        	this.tabla[i] = equipos[i];
        }
        this.partidoAct = 0;
        this.fechaAct = 1;
        
    }
      
  //---------------------------------------------------------- SIMULA UN SOLO PARTIDO A LA VEZ ---------------------------------------------------------------
	/**
	 * Simula un partido. Asigna goles a favor y en contra de cada equipo. Incrementa los partidos jugados para cada equipo. Asigna los puntos, el 
		ganador obtiene 3 puntos, el perdedor 0, y en caso de empate ambos equipos obtienen 1 punto. Actualiza los valores de la tabla de posiciones y de resultados.
	 * 
	 */
  	public void SimulaPartido () { 
  	  	if  (!ZonaSimulada) {

				partidosZona[partidoAct].simulacionNM(); //SIMULA PARTIDO 
				partidosZona[partidoAct].getEquipo1().setGoles(partidosZona[partidoAct].getGolesE1()); //ASIGNA GOLES A FAVOR DE CADA EQUIPO
				partidosZona[partidoAct].getEquipo2().setGoles(partidosZona[partidoAct].getGolesE2()); 
				partidosZona[partidoAct].getEquipo1().setGolesContra(partidosZona[partidoAct].getGolesE2()); //ASIGNA GOLES EN CONTRA DE CADA EQUIPO
				partidosZona[partidoAct].getEquipo2().setGolesContra(partidosZona[partidoAct].getGolesE1());
				partidosZona[partidoAct].getEquipo1().setpJ(); //INCREMENTA LOS PARTIDOS JUGADOS PARA CADA EQUIPO
				partidosZona[partidoAct].getEquipo2().setpJ();
				partidosZona[partidoAct].getArbitro().dirigePartido();
					
				if (partidosZona[partidoAct].getGolesE1() > partidosZona[partidoAct].getGolesE2()) { //DEPENDIENDO QUIEN HAYA METIDO MAS GOLES, SUMA 3 PUNTOS O 1 SI EMPATARON. TAMBIEN INCREMENTA PARTIDOS GANADOS
					partidosZona[partidoAct].getEquipo1().setPuntos(PV);
					partidosZona[partidoAct].getEquipo1().setpG();
					partidosZona[partidoAct].getEquipo2().setpP();
				}
				else if (partidosZona[partidoAct].getGolesE2() > partidosZona[partidoAct].getGolesE1()) {
					partidosZona[partidoAct].getEquipo2().setPuntos(PV);
					partidosZona[partidoAct].getEquipo2().setpG();	
					partidosZona[partidoAct].getEquipo1().setpP();
				}
				else {
					partidosZona[partidoAct].getEquipo1().setPuntos(PE);
					partidosZona[partidoAct].getEquipo2().setPuntos(PE);
					partidosZona[partidoAct].getEquipo2().setpE();	
					partidosZona[partidoAct].getEquipo1().setpE();
				}
					
				resultados [partidoAct] = new Resultados (partidosZona[partidoAct].getEquipo1(), partidosZona[partidoAct].getEquipo2(), partidosZona[partidoAct].getGolesE1(), partidosZona[partidoAct].getGolesE2() );
				this.ActualizaTabla();
				this.getValoresTabla();
				partidoAct++;
			if (partidoAct < CANT_PZ  && (partidoAct) == fechaAct*CANT_PF) 
				fechaAct++;
			if(partidoAct == CANT_PZ)
				ZonaSimulada = true;
  	  	}			
  	}
  	
  //---------------------------------------------------------- SIMULA UNA FECHA SOLA  ---------------------------------------------------------------------------
  	
  	/**
  	 * Simula todos los partidos disponibles para simular, de una fecha.
  	 */
	public void SimulaFecha () {
		int fechaASimular = fechaAct;
		int partidosASimular = partidoAct;
		while (partidosASimular < fechaASimular *CANT_PF) {
			SimulaPartido();
			partidosASimular++;
		}
  	}
  	
  //---------------------------------------------------------- SIMULA TODOS LOS PARTIDOS DE LA ZONA ---------------------------------------------------------------
  	/**
  	 * Simula todos los partidos de la zona que estén disponibles para simular. 
  	 */
  	public void SimulaZona () {
		while (!ZonaSimulada) {
			SimulaPartido();
		}
		
  	}
  
	//---------------------------------------------------------- CREA LAS FECHAS DE LA ZONA ----------------------------------------------------------------------
	/**
	 * 
	 * @param equipos
	 * @param referis
	 * @return partidos, un array que guarda los oponentes por cada partido de la zona. 
	 */
	public Partido[] creaFechas (Equipo[] equipos, ArrayList <Referi> referis) {


        /*  
         * DEVUELVE = [Boca vs River] [Racing vs Indep] .....
        */
		
		Partido[] partidos = new Partido[CANT_PZ]; //cada dos partidos, una fecha

        Equipo[] equiposQueRotan = Arrays.copyOfRange(equipos, 1, equipos.length); //array de equipos que van a ir rotando {1, 2, 3}
        Random aleratorio = new Random ();
        Referi referi1 = referis.get(aleratorio.nextInt(referis.size())), referi2 =  referis.get(aleratorio.nextInt(referis.size()));
        for (int i = 0; i < CANT_PZ; i += 2) {
        	while (referi1.getNacionalidad() != equipos[0].getPais() && referi1.getNacionalidad() != equiposQueRotan[0].getPais()) {
        		referi1 = referis.get(aleratorio.nextInt(referis.size()));
        	}
        	while (referi2.getNacionalidad() != equiposQueRotan[1].getPais() && referi2.getNacionalidad() != equiposQueRotan[2].getPais()) {
        		referi2 = referis.get(aleratorio.nextInt(referis.size()));
        	}
        	partidos[i] = new Partido(equipos[0], equiposQueRotan[0], referi1);
        	partidos[i+1] = new Partido(equiposQueRotan[1], equiposQueRotan[2], referi2);
        	Collections.rotate(Arrays.asList(equiposQueRotan), equiposQueRotan.length - 1);
        }
        
        return partidos;
    }
	/**
	 * Actualiza los valores de la tabla de la zona.
	 */
    public void ActualizaTabla(){ // HAY QUE PROBARLO, PRINCIPALMENTE POR LA ULTIMA INSTANCIA
    	
    	Equipo aux;
    	int posicion = 0;
        for (int i = 0; i < tabla.length - 1; i++) {
        	for (int j = 0; j < tabla.length - i - 1; j++) {
            	
                if (tabla[j + 1].getPuntos() > tabla[j].getPuntos()) {
                    aux = tabla[j + 1];
                    tabla[j + 1] = tabla[j];
                    tabla[j] = aux;
                }
                else if (tabla[j + 1].getPuntos() == tabla[j].getPuntos()) {
                	
                    if (tabla[j + 1].getGoles() > tabla[j].getGoles()) {
                        aux = tabla[j + 1];
                        tabla[j + 1] = tabla[j];
                        tabla[j] = aux;
                    }
                    else if (tabla[j + 1].getGoles() == tabla[j].getGoles()) {
                    	
                        if (tabla[j + 1].getGoles() - tabla[j + 1].getGolesContra() > tabla[j].getGoles() - tabla[j].getGolesContra() ) {
                            aux = tabla[j + 1];
                            tabla[j + 1] = tabla[j];
                            tabla[j] = aux;
                        }
                        else if (tabla[j + 1].getGoles() - tabla[j + 1].getGolesContra() == tabla[j].getGoles() - tabla[j].getGolesContra() ) {
                        	
                        	posicion = buscaResultado (tabla[j].getNombre(), tabla[j + 1].getNombre()); // 	BUSCAMOS LA POSICION DONDE ESTÁ EL PARTIDO ENTRE LOS EQUIPOS QUE ESTAN IGUALADOS EN PUNTOS, GOLES Y DIF DE GOLES
                        	if (posicion >= 0) { // SI ES >= 0 YA SE JUGÓ EL PARTIDO
                        		if (resultados [posicion].getGolesE1() > resultados [posicion].getGolesE2()) {
                        			if (resultados [posicion].getE1() == tabla [j+1].getNombre()) {
                                        aux = tabla[j + 1];
                                        tabla[j + 1] = tabla[j];
                                        tabla[j] = aux;
                        			}
                        		}
                        		else if (resultados [posicion].getGolesE1() < resultados [posicion].getGolesE2()) {
                            			if (resultados [posicion].getE2() == tabla [j+1].getNombre()) {
                                            aux = tabla[j + 1];
                                            tabla[j + 1] = tabla[j];
                                            tabla[j] = aux;
                            			}
                            		
                        		}
                        	}
                        }
                    	
                    }
                }
            }
        }
    }
    /**
     * 
     * @param e1
     * @param e2
     * @return int k, la posición de los equipos en el array de resultados. Devuelve -1 si no se encontraron.
     */
    public int buscaResultado(String e1, String e2) {
    	int k = 0;
    	
    	while ( k <= partidoAct && k <= resultados.length) {
    		if (resultados[k].getE1() == e1 && resultados[k].getE2() == e2) {
    			return k;
    		} 
    		else if (resultados[k].getE1() == e2 && resultados[k].getE2() == e1) {
    			return k;
    		} 
    		k++;
        }
    		return -1;
    }
    
	public String MuestraPartidos () {
		
		String s = "PARTIDOS DE LA ZONA\n";
		for (int i= 0; i <=CANT_PZ; i++) {
			s +=partidosZona[i].getEquipo1().getNombre()+" vs "+partidosZona[i].getEquipo2().getNombre()+ "\n";
		}
		
		return s;
	}

	//-------------------------------------------------------------------- GETTERS Y SETTERS -----------------------------------------------------------------------

	
    public String getValoresTabla(){
    	String s = "ZONA " + nroZona + "\nEquipo                    PT PJ PG PP DG\n"; //Equipo 1 | 2 | 1 | 0 | 4 \\nEquipo 2 | 1 | 2 | 0 | 2\\nEquipo 3 | 1 | 1 | 1 | 1\\nEquipo 4 | 0 | 1 | 2 | -2";
        for (int i = 0; i < CANTE; i++ )
            s +=tabla[i].getEstadisticas()+ "\n";
        
        return s;
    }
    
    public Equipo getEquipo(int equipo) {
    	
		return tabla[equipo];
	}
    
   
  	public int getPartidoAct() {
		return partidoAct;
	}

	public void setPartidoAct(int i) {
		this.partidoAct = i;
	}

	public int getFechaAct() {
		// TODO Auto-generated method stub
		return fechaAct;
	}
	
	public boolean isZonaSimulada() {
		return ZonaSimulada;
	}
}
	

