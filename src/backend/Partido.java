package backend;
import java.io.Serializable;
import java.util.Date;

public class Partido implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1658384256163433401L;
	private Equipo equipo1,equipo2;
	private double Media_totE1,Media_totE2;
	private Date fecha_juego;
	private Referi arbitro;//no puede tener misma nacionalidad que equipos, a menos que los dos sean de la misma (IMPLEMENTAR)
	private int golesE1,golesE2;
	
	public Partido(Equipo a, Equipo b) {
		equipo1 = a;
		equipo2 = b;
		Media_totE1 = (equipo1.MediaJugadores())*0.25 + (equipo1.getRanking()*6.25)*0.4 + (equipo1.getEntrenador().getTitulos()*10)*0.15;
		Media_totE2 = (equipo2.MediaJugadores())*0.25 + (equipo2.getRanking()*6.25)*0.4 + (equipo2.getEntrenador().getTitulos()*10)*0.15;
		if(Math.random()*100<50) //moral del equipo el dia del partido, que puede hacerlos mejor o peor equipo
			Media_totE1 += Math.random()*20;
		else
			Media_totE2 += Math.random()*20;
		golesE1 = 0;
		golesE2 = 0;
	}
	
	public void simulacionNM() { 
		int OportunidadesGolA = (int) Math.round(Math.random()*10);//Cada equipo tiene como maximo 10 oportunidades de gol
		int OportunidadesGolB = (int) Math.round(Math.random()*10);
		int i;
		if(Media_totE1 > Media_totE2) 
			OportunidadesGolA ++;
		else
			OportunidadesGolB ++;
		for(i = 0;i<OportunidadesGolA; i++) {
			if(Math.random()*100<Media_totE1)//aumentar el *100 si se hacen muchos goles
				golesE1++;
		}
		for(i = 0;i<=OportunidadesGolB; i++) {
			if(Math.random()*100<Media_totE2)
				golesE2++;
		}		
	}
	
	public double getMedia_totE1() {
		return Media_totE1;
	}
	public void setMedia_totE1(double media_totE1) {
		Media_totE1 = media_totE1;
	}
	public double getMedia_totE2() {
		return Media_totE2;
	}
	public void setMedia_totE2(double media_totE2) {
		Media_totE2 = media_totE2;
	}
}
