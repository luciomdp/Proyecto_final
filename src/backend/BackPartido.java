package backend;
import java.io.Serializable;
import java.util.Date;

/*

19- Revisar algoritmo de resolución de partidos (si hay tiempo) y hacerlo un poco mas piola

*/

public class BackPartido implements Serializable{
	
	private static final long serialVersionUID = -1658384256163433401L;
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private Equipo equipo1,equipo2;
	private double Media_totE1,Media_totE2;
	private Date fecha_juego;
	private int golesE1,golesE2;
	private Referi referi;
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public BackPartido(Equipo a, Equipo b, Referi referi) {
		equipo1 = a;
		equipo2 = b;
		this.referi = referi;
		this.referi = referi;
		golesE1 = 0;
		golesE2 = 0;
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	
	/**
	 * <B>Simula un partido.</b><p>
	 * Simulación que tiene en cuenta las posiciones en el ranking de ambos equipos, el promedio de las valoraciones de los jugadores, 
	 * y los títulos conseguidos por los DT (Media_totE). Además utiliza un componente aleatorio para definir
	 * el resultado (OportunidadesGol).
	 * Asigna valores a golesE1 y golesE2.
	 */
	public void simulacionNM() {
		int OportunidadesGolA = (int) (equipo1.getMediaEquipo()/5); //Cada equipo tiene como maximo 10 oportunidades de gol. Si hay pocas oportunidades, hacer mas chico el denominador
		int OportunidadesGolB = (int) (equipo2.getMediaEquipo()/5);
		double probabilidadesGolA = 0; // el 50% es random, el otro 50% depende de las características de los jugadores
		double probabilidadesGolB = 0;
		int i;
	
		probabilidadesGolA = (Math.random()*100 *0.2) + ((equipo1.getMediaPos (Posicion.delantero) * 0.75 + equipo1.getMediaPos (Posicion.mediocampista) * 0.25)*0.4 *10) - ((equipo2.getMediaPos (Posicion.defensor) * 0.6 + equipo2.getMediaPos (Posicion.arquero) * 0.4)*0.4 *10);
		if (probabilidadesGolA < 10)
			probabilidadesGolA = 5; // minimamente por partido el equipo tiene 5% probabilidades de que lo metan
		probabilidadesGolA = (Math.random()*100 *0.2) + ((equipo2.getMediaPos (Posicion.delantero) * 0.75 + equipo2.getMediaPos (Posicion.mediocampista) * 0.25)*0.4 *10) - ((equipo1.getMediaPos (Posicion.defensor) * 0.6 + equipo1.getMediaPos (Posicion.arquero) * 0.4)*0.4 *10);
		if (probabilidadesGolB < 10)
			probabilidadesGolB = 5;
		
		for(i = 0;i<OportunidadesGolA; i++) {
			if(Math.random()*100 < probabilidadesGolA)
				golesE1++; 
		}
		for(i = 0;i<=OportunidadesGolB; i++) {
			if(Math.random()*100 < probabilidadesGolB)
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

