package backend;

import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  

public class Main {	
	
	static ArrayList <Jugador> jugadores;
	static ArrayList <Equipo> equipos;
	static ArrayList <Referi> referis; //falta
	
	public static void main (String[] args) throws NumberFormatException, ParseException {
		
		String Jugadores = "Jugadores.txt"; String Equipos = "Equipos.txt"; String Referis = "Referis.txt";
		BufferedReader br = null; BufferedReader br1 = null; BufferedReader br2 = null;
		String line = ""; String coma = ",";
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha;
				
		Pais pais; Posicion pos;
		
		List <Jugador> totJugadores = new ArrayList<>(); 
		((ArrayList<Jugador>) totJugadores).ensureCapacity(288);
		                         
		int j=0,  i= 0;
		
		try {
		    br = new BufferedReader(new FileReader(Jugadores));
		    while ((line = br.readLine()) != null) {  
		    	
		        String[] datos = line.split(coma);  
		        fecha = LocalDate.parse(datos[4], formato);
		        pos = Posicion.valueOf(datos[1]);
		        
		        Jugador jugador = new Jugador (datos[2], datos[3], fecha, datos[5], Integer.parseInt(datos[6]), 
		        								pos , Byte.parseByte(datos[7]));
		        totJugadores.add(jugador);
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
		//totJugadores.forEach(System.out::println);
		
		
		System.out.println("---------------------------------------------------------------------------------------------------\n\n");
		
		
		equipos = new ArrayList<>(); 
		(equipos).ensureCapacity(16);
				
				try {
				    br1 = new BufferedReader(new FileReader(Equipos));
				    line = br1.readLine();
			    	
				    while (line!= null) {
				    		jugadores = new ArrayList<>(); //array cada 18 jugadores
				    		((ArrayList<Jugador>) jugadores).ensureCapacity(18);
					    
				    		for (j=0; j<18; j++) {
				    			jugadores.add(totJugadores.get(i+j)); //guardo los 18 jugadores de totjugadores
				    		}
				    		i=i+18;
				    		//jugadores.forEach(System.out::println);
					    
				    		String[] datos = line.split(coma);
				    		fecha = LocalDate.parse(datos[5], formato);
				    		pais = Pais.valueOf(datos[8]);
						
				    		Dt dt = new Dt (datos[3], datos[4], fecha, Integer.parseInt(datos[7]), datos[6], pais, 
				    						Byte.parseByte(datos[9]));
				    		//System.out.println(dt);
				        
				    		pais = Pais.valueOf(datos[1]);
				    		Equipo equipo = new Equipo(datos[0], pais, Integer.parseInt(datos[2]), jugadores, dt); 
				    		equipos.add(equipo);
				    		
				    		line = br1.readLine();				    	
				   }
				} catch (FileNotFoundException e) {
				    e.printStackTrace();
				} catch (IOException e) {
				    e.printStackTrace();
				} finally {
				    if (br1 != null) {
				        try {
				            br1.close();
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
				    }
				    /*System.out.println(("Equipos:\n"));
					equipos.forEach(System.out::println); */
			      }
		
		System.out.println("---------------------------------------------------------------------------------------------------\n\n");
		referis = new ArrayList <>();
				try {
				    br2 = new BufferedReader(new FileReader(Referis));
				    line = br2.readLine();
			    	
				    while (line!= null) {
				    		
				    	String[] datos = line.split(coma);
			    		fecha = LocalDate.parse(datos[2], formato);
			    		pais = Pais.valueOf(datos[5]);
				
			    		Referi referi = new Referi (datos[0], datos[1], fecha, Integer.parseInt(datos[4]), datos[3], pais, 
		    										Byte.parseByte(datos[6]));
			    		referis.add(referi);
			    		System.out.println(referis.size());
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
				    referis.forEach(System.out::println);
			      }
							    	
				
		Campeonato torneo = new Campeonato (equipos, jugadores, referis);
		//formulario?		

	}
	
		
}
