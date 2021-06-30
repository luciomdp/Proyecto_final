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
		String line = "";
		//Se define separador ","
		String coma = ",";
		try {
		    br = new BufferedReader(new FileReader(Jugadores));
		    while ((line = br.readLine()) != null) {                
		        String[] datos = line.split(coma);
		        //Imprime datos.
		       //System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] + ", " + datos[5] + ", " + datos[6] + ", " + datos[7]);
		      
		       
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
		totJugadores.forEach(System.out::println);
		
		
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		for (int i=0;i<totJugadores.size();i++) { //comentario
			
			
			List <Jugador> jugadores = new ArrayList<>();
			List <Equipo> equipos = new ArrayList<>();
			
			for (int j=0; j<18; j++) { 
		    
				jugadores.add(totJugadores.get(j));
				
				BufferedReader br2 = null;
				try {
				    br2 = new BufferedReader(new FileReader(Equipos));
				    while ((line = br2.readLine()) != null) {                
				        String[] datos = line.split(coma);
				        //Imprime datos.
				       //System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] + ", " + datos[5] + ", " + datos[6] + ", " + datos[7]+ ", " + datos[8] + ", " + datos[9]);
				    Equipo equipo = new Equipo();
				    //voy x aca
				    
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

		}
	}
}
