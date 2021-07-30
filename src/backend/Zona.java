package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JOptionPane;


public class Zona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2934756314623471362L;
	//Implementar tabla de posiciones
	
	//-------------------------VALORES DE PUNTOS--------------------------
	final int PV = 3;
	final int PE = 1;
	final int PD = 0;
	//-------------------------CANTIDAD DE PARTIDOS--------------------------
	final int CANT_PZ = 6;
	final int CANT_PF = 2;
	final int CANTE = 4;
	private int i,f;//f es fecha actual e i es partido actual
	/*Cada partido va a tener asignado un valor "i", cada fecha son 2 partidos de i (teniendo en cuenta el valor
	actual de i,tenes una variable fecha "f", que dice en que fecha se encuentra, y simular toda la zona, es iterar desde el i
	actual hasta el final)*/
	
	//HACER ARREGLO DE EQUIPOS 
    private Equipo pasanACuartos [] = new Equipo [2];
    private Tabla tabla; 
    private PartidoZona partidos[];
    private Equipo equipos[] = new Equipo [CANTE];
    private int k;
    
    public Zona (Equipo equipos[]) {
    	this.equipos = equipos;
    	this.partidos = new PartidoZona[CANT_PZ];
    	
        this.tabla = new Tabla (equipos); 
        this.i = 0;
        this.f = 1;
        this.k = 0;
    }
    
	public void MuestraPartidos () {
		for (int i= 0; i <=CANT_PZ; i++) {
			System.out.println(partidos[i].getEquipo1().getNombre()+" vs "+partidos[i].getEquipo2().getNombre());
		}
	}

//---------------------------------------------------------- SIMULA UN SOLO PARTIDO A LA VEZ ---------------------------------------------------------------
	
	public void SimulaPartido () { 
		
		if  (i <= CANT_PZ) {

					tabla.getValoresTabla();
					partidos[i].simulacionNM(); //SIMULA PARTIDO 
					partidos[i].getEquipo1().setGoles(partidos[i].getGolE1()); //ASIGNA GOLES A FAVOR DE CADA EQUIPO
					partidos[i].getEquipo2().setGoles(partidos[i].getGolE2()); 
					partidos[i].getEquipo1().setGolesContra(partidos[i].getGolE2()); //ASIGNA GOLES EN CONTRA DE CADA EQUIPO
					partidos[i].getEquipo2().setGolesContra(partidos[i].getGolE1());
					partidos[i].getEquipo1().setpJ(1); //INCREMENTA LOS PARTIDOS JUGADOS PARA CADA EQUIPO
					partidos[i].getEquipo2().setpJ(1);
					
					if (partidos[i].getGolE1() > partidos[i].getGolE2()) { //DEPENDIENDO QUIEN HAYA METIDO MAS GOLES, SUMA 3 PUNTOS O 1 SI EMPATARON. TAMBIEN INCREMENTA PARTIDOS GANADOS
						partidos[i].getEquipo1().setPuntos(3);
						partidos[i].getEquipo1().setpG(1);						
					}
					else if (partidos[i].getGolE2() > partidos[i].getGolE1()) {
						partidos[i].getEquipo2().setPuntos(3);
						partidos[i].getEquipo2().setpG(1);					
					}
					else {
						partidos[i].getEquipo1().setPuntos(1);
						partidos[i].getEquipo2().setPuntos(1);
					}
					
					Resultados result = new Resultados (partidos[i].getEquipo1(), partidos[i].getEquipo2(), partidos[i].getGolE1(), partidos[i].getGolE2() );
					tabla.setResultados(result);
					tabla.ActualizaTabla();
					tabla.getValoresTabla();
					i++;
					if (i == f*CANT_PF) {
						f++;
					}
		}
		else{
			
			JOptionPane.showMessageDialog(null, "Ya se han jugado todos los partidos de la Zona ");
		}

	}
	
//---------------------------------------------------------- SIMULA UNA FECHA SOLA  ---------------------------------------------------------------------------
	
	public void SimulaFecha () {
		
			for (;i<=f*CANT_PF;) {
				this.SimulaPartido();
			}
	}
	
//---------------------------------------------------------- SIMULA TODOS LOS PARTIDOS DE LA ZONA ---------------------------------------------------------------
	
	public void SimulaZona () {

		this.SimulaFecha();
		this.SimulaFecha();
		this.SimulaFecha();
	
		
	}

	public Equipo[] getPasanACuartos() {
		this.tabla.GanadoresZona();
		this.pasanACuartos = this.tabla.getGanadoresZona();
		return pasanACuartos;
	}
	
    public static int factorial (int numero) {
        if (numero == 0)
            return 1;
        else
            return numero * factorial(numero - 1);
    }

    public static void creaFechas (Equipo[] equipos) {

        /*  Calculo primero todas las fórmulas que necesito y numeros que me sirven para hacer el algoritmo
        partidosSimultaneos = cantEquipos/2;
        partidosPosibles = (variacion entre cantEquipos y 2 (cantEquipos por partido)) / partidosSimultaneos;
        cantFechas = partidosPosibles / partidosSimultaneos;
        -----------------------------------------------------
        partidosSimultaneos = 4/2 = 2;
        partidosPosibles = ((4)!/(2)!) / 2 = (24/2) / 2 = 6;
        cantFechas = 6 / 2 = 3;
        */

        ArrayList<String> fechas = new ArrayList<>();
        int partidosSimultaneos = (equipos.length / 2);
        int partidosPosibles = ((factorial(equipos.length))/2) / partidosSimultaneos;
        int cantFechas = partidosPosibles / partidosSimultaneos;
        int i = 0; //indice de fechas

        //paso a minuscula
        for (int k = 0; k < equipos.length; k++) {
            equipos[k] = equipos[k].toLowerCase(); //MODIFICAR
        }

        String[] equiposQueRotan = Arrays.copyOfRange(equipos, 1, equipos.length); //MODIFICAR
        //mientras que no llegue a completar todas las fechas
        while (i < cantFechas) {
            String posibleFecha = equipos[0] + " "; //agrego el primero ya que queda fijo en todas las fechas;
            //la primera fecha se agregan los equipos como están, es decir, 1vs2 3vs4 5vs6 7vs8 .....
            if (i == 0) {
                for (int k = 1; k < equipos.length; k++) {
                    posibleFecha += equipos[k] + " ";
                }
            } else {
                //aca viene el quilombo, tengo que ir rotando todos los equipos, 2 en 3-3 en 4-4 en 5-5 en 6...
                Collections.rotate(Arrays.asList(equiposQueRotan), equiposQueRotan.length - 1);
                //aca esta el array rotado asique ya puedo meter los equipos que faltan
                for (int k = 0; k < equiposQueRotan.length; k++) {
                    posibleFecha += equiposQueRotan[k] + " ";
                }
            }
            fechas.add(posibleFecha);
            i++;
        }
    }

}


