package backend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main (String[] args) {
		
		//leo el archivo jugadores y creo un arraylist con tooodos los jugadores
		String filePath1 = "Jugadores.txt";
		List <Jugador> totJugadores = new ArrayList<>();
		try (Stream <String> streamfile = Files.lines(Paths.get(filePath1))){
			totJugadores = streamfile.map(linea -> linea.split (",")).map(arreglo->{ //linea.split separa el string en las comas y hace un arreglo x linea
				Jugador jugador = new Jugador (arreglo[2], arreglo[3], (Date)arreglo[4], arreglo[5], Integer.parseInt(arreglo[6]), (Posicion)arreglo[1], Byte.valueOf(arreglo[7]));
				return jugador;
			}).collect(Collectors.toList());
			
			totJugadores.forEach(System.out::println);
		
			
		} catch (IOException io) {
			System.err.println("Error en lectura de archivo" + io.getMessage());
			
		}
		//recorro totJugadores y voy creando una lista d jugadores x equipo
		
		for (int i=0;i<totJugadores.size();i++) { 
			
			List <Jugador> jugadores = new ArrayList<>();
			
			for (int j=0; j<18; j++) { 
		    
				jugadores.add(totJugadores.get(j));
		    	
				//recorrer el equipos.txt y guardo en cada equipo su arraylist de jugadores
		    	
				String filePath = "Equipos.txt";
		    	
				List <Equipo> equipos = new ArrayList<>();
		    	
				try (Stream <String> streamfile = Files.lines(Paths.get(filePath))){
		    		  equipos = streamfile.map(linea -> linea.split (",")).map(arreglo->{ 
		    			  Dt dt = new Dt (arreglo[3], arreglo[4], (Date)arreglo[5], Integer.parseInt(arreglo[7]), arreglo[8], Byte.valueOf(arreglo[9]));
		    			  Equipo equipo = new Equipo (arreglo[0], arreglo[1], Integer.parseInt(arreglo[2]),
		    					  jugadores, dt);
		    			  return equipo;
		    		  }).collect(Collectors.toList());
			
		    		  equipos.forEach(System.out::println);
		
			
		    	  } catch (IOException io) {
		    		  System.err.println("Error en lectura de archivo" + io.getMessage());
			
		    	  }
		      }
		      System.out.println(totJugadores.get(i));
		    }
		
	
	}
}

