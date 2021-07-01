package backend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

public class Main {
	public static void main (String[] args) throws NumberFormatException, ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		List <Jugador> totJugadores = new ArrayList<>();  //creo un arraylist con toooodos los jugadores
		String Jugadores = "Jugadores.txt"; String Equipos = "Equipos.txt";
		BufferedReader br = null;
		BufferedReader br2 = null;
		String line = "";
		String coma = ",";
		
		try {
		    br = new BufferedReader(new FileReader(Jugadores));
		    while ((line = br.readLine()) != null) {                
		        String[] datos = line.split(coma);      
		        Jugador jugador = new Jugador (datos[2], datos[3], formato.parse(datos[4]), datos[5], Integer.parseInt(datos[6]), Posicion.Mediocampista, Byte.parseByte(datos[7])); //posicion?????
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
		
		
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		
		ArrayList <Equipo> equipos = new ArrayList<>(); //array de todos los equipos
		for (int i=0;i<totJugadores.size();i++) { 			
				try {
				    br2 = new BufferedReader(new FileReader(Equipos));
				    while ((line = br2.readLine()) != null) {   
				    	ArrayList <Jugador> jugadores = new ArrayList<>(); //array cada 18 jugadores
						for (int j=0; j<18; j++) {
							jugadores.add(totJugadores.get(j)); //guardo los 18 jugadores de totjugadores
						}
						//jugadores.forEach(System.out::println);
				    	String[] datos = line.split(coma);
				        //Imprime datos como los lee:
				        //System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] + ", " + datos[5] + ", " + datos[6] + ", " + datos[7]+ ", " + datos[8] + ", " + datos[9]);
				        Dt dt = new Dt (datos[3], datos[4], formato.parse(datos[5]), Integer.parseInt(datos[7]), datos[6], Pais.Alemania, Byte.parseByte(datos[9]));
				        //System.out.println(dt);
				    	Equipo equipo = new Equipo(datos[0], Pais.Argentina, Integer.parseInt(datos[2]), jugadores, dt);
				    	System.out.println(equipo + "--------------------------------------------------------------------");
				        equipos.add(equipo);
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
			    }
		}
		equipos.forEach(System.out::println); //no funcaa
	}
}
