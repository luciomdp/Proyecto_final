package backend;
import java.io.Serializable;
import java.util.Date;

/*

19- Revisar algoritmo de resolución de partidos (si hay tiempo) y hacerlo un poco mas piola

*/

public class Partido implements Serializable{
	
	private static final long serialVersionUID = -1658384256163433401L;
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private Equipo equipo1,equipo2;
	private double Media_totE1,Media_totE2;
	private Date fecha_juego;
	private int golesE1,golesE2;
	private Referi referi;
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public Partido(Equipo a, Equipo b, Referi referi) {
		equipo1 = a;
		equipo2 = b;
		this.referi = referi;
		Media_totE1 = (equipo1.MediaJugadores())*0.25 + (equipo1.getRanking()*6.25)*0.4 + (equipo1.getEntrenador().getTitulos()*10)*0.15;
		Media_totE2 = (equipo2.MediaJugadores())*0.25 + (equipo2.getRanking()*6.25)*0.4 + (equipo2.getEntrenador().getTitulos()*10)*0.15;
		if(Math.random()*100<50) //moral del equipo el dia del partido, que puede hacerlos mejor o peor equipo
			Media_totE1 += Math.random()*20;
		else
			Media_totE2 += Math.random()*20;
		this.referi = referi;
		golesE1 = 0;
		golesE2 = 0;
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	
	/**
	 * Simulación que tiene en cuenta las posiciones en el ranking de ambos equipos, el promedio de las valoraciones de los jugadores, 
	 * y los títulos conseguidos por los DT (Media_totE). Además utiliza un componente aleatorio para definir
	 * el resultado (OportunidadesGol).
	 * Asigna valores a golesE1 y golesE2.
	 */
	public void simulacionNM() { 
		int OportunidadesGolA = (int) Math.round(Math.random()*1);//Cada equipo tiene como maximo 10 oportunidades de gol
		int OportunidadesGolB = (int) Math.round(Math.random()*1);
		int i;
		if(Media_totE1 > Media_totE2) 
			OportunidadesGolA ++;
		else
			OportunidadesGolB ++;
		for(i = 0;i<OportunidadesGolA; i++) {
			if(Math.random()*100<Media_totE1)//aumentar el *100 si se hacen muchos goles
				golesE1++; // NO DEBERÍA SER 
		}
		for(i = 0;i<=OportunidadesGolB; i++) {
			if(Math.random()*100<Media_totE2)
				golesE2++;
		}
		
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	public int getGolesE1() {
		return golesE1;
	}

	public int getGolesE2() {
		return golesE2;
	}

	public double getMedia_totE1() {
		return Media_totE1;
	}
	
	public double getMedia_totE2() {
		return Media_totE2;
	}
	
	public Referi getArbitro() {
		return referi;
	}
	
	public Equipo getEquipo1() {
		return equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

}
