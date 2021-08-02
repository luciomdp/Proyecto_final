package backend;

import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;  

public class Main {	
	
	static ArrayList <Jugador> jugadores;
	static ArrayList <Equipo> equipos;
	static ArrayList <Referi> referis; //falta
	
	public static void main (String[] args) throws NumberFormatException, ParseException {
		
		String Jugadores = "Jugadores.txt"; String Equipos = "Equipos.txt";
		BufferedReader br = null;
		BufferedReader br2 = null;
		String line = "";
		String coma = ",";
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		List <Jugador> totJugadores = new ArrayList<>();  //creo un arraylist con toooodos los jugadores
		((ArrayList<Jugador>) totJugadores).ensureCapacity(288);
		/*ArrayList <Jugador> jugadores;
		ArrayList <Equipo> equipos;
		ArrayList <Referi> referis; //falta*/
		                         
		int j=0,  i= 0;
		
		try {
		    br = new BufferedReader(new FileReader(Jugadores));
		    while ((line = br.readLine()) != null) {                
		        String[] datos = line.split(coma);      
		        /*Jugador jugador = new Jugador (datos[2], datos[3], formato.parse(datos[4]), datos[5], Integer.parseInt(datos[6]), 
		        								Posicion.Mediocampista, Byte.parseByte(datos[7])); //posicion?????
		        totJugadores.add(jugador);*/
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (br != null) {
		        try {
		            br.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
		totJugadores.forEach(System.out::println);
		
		
		
		System.out.println("---------------------------------------------------------------------------------------------------\n\n");
		
		
		equipos = new ArrayList<>(); //array de todos los equipos
		(equipos).ensureCapacity(16);
		//for (int i=0;i<totJugadores.size();i=i+18) { 	
		
				try {
				    br2 = new BufferedReader(new FileReader(Equipos));
				    line = br2.readLine();
			    	
				    while (line!= null) { //16 lineas + referis 
				    	jugadores = new ArrayList<>(); //array cada 18 jugadores
				    	((ArrayList<Jugador>) jugadores).ensureCapacity(18);
					    
				    	for (j=0; j<18; j++) {
							jugadores.add(totJugadores.get(i+j)); //guardo los 18 jugadores de totjugadores
						}
					    i=i+18;
					    //jugadores.forEach(System.out::println);
						String[] datos = line.split(coma);
				        //Imprime datos como los lee:
				        //System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] + ", " + datos[5] + ", " + datos[6] + ", " + datos[7]+ ", " + datos[8] + ", " + datos[9]);
				       /* Dt dt = new Dt (datos[3], datos[4], formato.parse(datos[5]), Integer.parseInt(datos[7]), datos[6], Pais.Alemania, 
				        		Byte.parseByte(datos[9])); //pais?????*/
				        //System.out.println(dt);
				    	
				        /*Equipo equipo = new Equipo(datos[0], Pais.Argentina, Integer.parseInt(datos[2]), jugadores, dt); //pais????????
				    	//System.out.println(equipo + "--------------------------------------------------------------------\\n");
				        equipos.add(equipo);*/
				        
				        line = br2.readLine();
				    }
				} catch (FileNotFoundException e) {
				    e.printStackTrace();
				} catch (IOException e) {
				    e.printStackTrace();
				} finally {
				    if (br2 != null) {
				        try {
				            br2.close();
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
				    }
				    System.out.println(("Equipos:\n"));
					equipos.forEach(System.out::println); 
			      }
				
	
		Campeonato torneo = new Campeonato (equipos, jugadores, referis);
				

	}
	
		
}
