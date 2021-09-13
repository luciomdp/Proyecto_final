package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JOptionPane;

/*17- Las constantes no deber�an ser privadas?

36- resultados no deberia ser privado?

53-Como funciona SimulaPartido() ? Onda que hace

90- En el back no se usa el showMessageDialog, salvo que
sea para mostrar errores. Si se jugaron todos los partidos,
tendr�as que avisar al front mediante el controlador.

Ver todos los otros metodos que puedan inferir en el front, para conectar
con el controlador*/

public class Zona implements Serializable{
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
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
	//-------------------------CANTIDAD DE EQUIPOS QUE PASAN A CUARTOS POR ZONA---------------------
	final int PASAN_CUARTOS = 2;
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private int i,f;//f es fecha actual e i es partido actual
	/*Cada partido va a tener asignado un valor "i", cada fecha son 2 partidos de i (teniendo en cuenta el valor
	actual de i,tenes una variable fecha "f", que dice en que fecha se encuentra, y simular toda la zona, es iterar desde el i
	actual hasta el final)*/
    private Equipo [] tabla = new Equipo [CANTE]; // TABLA DE LA ZONA 
    private Equipo ganadoresZona [] = new Equipo [PASAN_CUARTOS]; // SON LOS DOS EQUIPOS QUE GANAN LA ZONA
    private Partido partidosZona[]; 
    Resultados resultados [] = new Resultados [CANT_PZ];
   
    
  //-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
    
    public Zona (Equipo equipos[]) {
    	this.partidosZona = new Partido[CANT_PZ];
        for (int i = 0; i < CANTE; i++) {
        	this.tabla[i] = equipos[i];
        }
        this.i = 0;
        this.f = 1;
        this.partidosZona = creaFechas(equipos);
    }
      
  //---------------------------------------------------------- SIMULA UN SOLO PARTIDO A LA VEZ ---------------------------------------------------------------
	
  	public void SimulaPartido () { 
  		
  		if  (i < CANT_PZ) {

  					this.getValoresTabla();
  					partidosZona[i].simulacionNM(); //SIMULA PARTIDO 
  					partidosZona[i].getEquipo1().setGoles(partidosZona[i].getGolesE1()); //ASIGNA GOLES A FAVOR DE CADA EQUIPO
  					partidosZona[i].getEquipo2().setGoles(partidosZona[i].getGolesE2()); 
  					partidosZona[i].getEquipo1().setGolesContra(partidosZona[i].getGolesE2()); //ASIGNA GOLES EN CONTRA DE CADA EQUIPO
  					partidosZona[i].getEquipo2().setGolesContra(partidosZona[i].getGolesE1());
  					partidosZona[i].getEquipo1().setpJ(1); //INCREMENTA LOS PARTIDOS JUGADOS PARA CADA EQUIPO
  					partidosZona[i].getEquipo2().setpJ(1);
  					
  					if (partidosZona[i].getGolesE1() > partidosZona[i].getGolesE2()) { //DEPENDIENDO QUIEN HAYA METIDO MAS GOLES, SUMA 3 PUNTOS O 1 SI EMPATARON. TAMBIEN INCREMENTA PARTIDOS GANADOS
  						partidosZona[i].getEquipo1().setPuntos(PV);
  						partidosZona[i].getEquipo1().setpG(1);
  						partidosZona[i].getEquipo1().setpP(1);
  					}
  					else if (partidosZona[i].getGolesE2() > partidosZona[i].getGolesE1()) {
  						partidosZona[i].getEquipo2().setPuntos(PV);
  						partidosZona[i].getEquipo2().setpG(1);	
  						partidosZona[i].getEquipo1().setpP(1);
  					}
  					else {
  						partidosZona[i].getEquipo1().setPuntos(PE);
  						partidosZona[i].getEquipo2().setPuntos(PE);
  					}
  					
  					Resultados result = new Resultados (partidosZona[i].getEquipo1(), partidosZona[i].getEquipo2(), partidosZona[i].getGolesE1(), partidosZona[i].getGolesE2() );
  					this.setResultados(result);
  					this.ActualizaTabla();
  					this.getValoresTabla();
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
  
	//---------------------------------------------------------- CREA LAS FECHAS DE LA ZONA ----------------------------------------------------------------------
	
	public Partido[] creaFechas (Equipo[] equipos) {


        /*  
         * DEVUELVE = [Boca vs River] [Racing vs Indep] .....
        */
		
		Partido[] partidos = new Partido[CANT_PZ]; //cada dos partidos, una fecha

        Equipo[] equiposQueRotan = Arrays.copyOfRange(equipos, 1, equipos.length); //array de equipos que van a ir rotando {1, 2, 3}
        
        for (i = 0; i < CANT_PZ; i += 2) {
        	partidos[i] = new Partido(equipos[0], equiposQueRotan[0]);
        	partidos[i+1] = new Partido(equiposQueRotan[1], equiposQueRotan[2]);
        	Collections.rotate(Arrays.asList(equiposQueRotan), equiposQueRotan.length - 1);
        }
        
        return partidos;
    }

    public void ActualizaTabla(){ // HAY QUE PROBARLO, PRINCIPALMENTE POR LA ULTIMA INSTANCIA
    	
    	Equipo aux;
    	
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
                        	
                        	int posicion = buscaResultado (tabla[j].getNombre(), tabla[j + 1].getNombre()); // 	BUSCAMOS LA POSICION DONDE EST� EL PARTIDO ENTRE LOS EQUIPOS QUE ESTAN IGUALADOS EN PUNTOS, GOLES Y DIF DE GOLES
                        	if (posicion >= 0) { // SI ES >= 0 YA SE JUG� EL PARTIDO
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
    
    public int buscaResultado(String e1, String e2) {
    	int k = 0;
    	
    	while (k <= resultados.length) {
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
    	String s = "ZONA 1\nEquipo   PP PG PE PP DG \n"; //Equipo 1 | 2 | 1 | 0 | 4 \\nEquipo 2 | 1 | 2 | 0 | 2\\nEquipo 3 | 1 | 1 | 1 | 1\\nEquipo 4 | 0 | 1 | 2 | -2";
        for (int i = 0; i < CANTE; i++ )
            s +=tabla[i].getEstadisticas()+ "\n";
        
        return s;
    }
    
    public Equipo[] getGanadoresZona() {
		for (int i = 0; i < PASAN_CUARTOS; i++) 
			this.ganadoresZona[i] = tabla[i];
		
		return ganadoresZona;
	}
    
    public void setResultados(Resultados resultado) {
        this.resultados[i] = resultado ;
        i++;
    }
    
  	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}
	


