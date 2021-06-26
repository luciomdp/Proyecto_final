package backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
	
	public static final String COMA=",";
	static ArrayList <Equipo> listaEquipos = new ArrayList <Equipo>();
	//listaEquipos.trialToSize(16);
		
	public static void main(String[] args)throws IOException {	
		BufferedReader br = null;
		
		try {
			br =new BufferedReader(new FileReader("Equipos.txt"));
			String line = br.readLine();
			while (null!=line) {
				String[] nombreEquipo = line.split(COMA);
				System.out.println(Arrays.toString(nombreEquipo));
				String[] paisEquipo = line.split(COMA);
				System.out.println(Arrays.toString(paisEquipo));
				String[] rankingEquipo = line.split(COMA);
				System.out.println(Arrays.toString(rankingEquipo));
				
				listaEquipos.add(new Equipo(nombreEquipo, paisEquipo, rankingEquipo, listaJugadores, dt));
				
				//crear array listaJugadores, antes d leer el arch equipos?, dt tmb esta en el arch jugadores.
				
            
				//fields = removeTrailingQuotes(fields);
				//System.out.println(Arrays.toString(fields));
            
				line = br.readLine();
			}
         
      } catch (Exception e) {
    	  System.out.println("Hubo un problema al abrir el archivo.");
         
      } finally {
    	  if (null!=br) {
            br.close();		
    	  }

        }
	}
}

