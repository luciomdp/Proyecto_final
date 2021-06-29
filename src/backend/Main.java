package backend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main (String[] args) {
		
	
		
		String filePath1 = "Jugadores.txt";
		List <Jugador> jugadores = new ArrayList<>();
		try (Stream <String> streamfile = Files.lines(Paths.get(filePath1))){
			jugadores = streamfile.map(linea -> linea.split (",")).map(arreglo->{ //linea.split separa el string en las comas y hace un arreglo x linea
				Jugador jugador = new Jugador (arreglo[2], arreglo[3], arreglo[4], arreglo[5], Integer.parseInt(arreglo[6]), arreglo[1], Byte.valueOf(arreglo[7]));
				return jugador;
			}).collect(Collectors.toList());
			
			jugador.forEach(System.out::println);
		
			
		} catch (IOException io) {
			System.err.println("Error en lectura de archivo" + io.getMessage());
			
		}
		String filePath = "Equipos.txt";
		List <Equipo> equipos = new ArrayList<>();
		try (Stream <String> streamfile = Files.lines(Paths.get(filePath))){
			equipos = streamfile.map(linea -> linea.split (",")).map(arreglo->{ 
				Equipo equipo = new Equipo (arreglo[0], arreglo[1], Integer.parseInt(arreglo[2]), ArrayList<Jugador> j, Dt e);
			return equipo;
			}).collect(Collectors.toList());
			
			equipos.forEach(System.out::println);
		
			
		} catch (IOException io) {
			System.err.println("Error en lectura de archivo" + io.getMessage());
			
		}
	}
}

