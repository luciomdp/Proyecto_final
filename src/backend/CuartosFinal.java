package backend;

import javax.swing.JOptionPane;

public class CuartosFinal {
	
	private final int CANT_P = 8;
	private final int CANTE = 8;
	private Equipo e1, e2;
	private PartidoIdaVuelta partidos [];
	private Equipo equipos [];
	private Resultados resultados [];
	private int i;
	
	public CuartosFinal(Equipo equipos []) {
		this.equipos = equipos;
		for (int i = 0; i < CANTE; i++) {
			equipos[i].setGoles(0); //RESETEO LOS GOLES DE CADA EQUIPO A PARTIR DE ESTA INSTANCIA PARA PODER SABER LOS RESULTADOS DE LA IDA A COMPARACION DE LA VUELTA
		}
		this.partidos = new PartidoIdaVuelta [CANT_P] ;
		int k= 0;
		for (int i = 0; i < CANT_P/2; i+=2) {
			partidos[k].setEquipo1(equipos[i]);
			partidos[k].setEquipo2(equipos[i++]);
			k++;
		}
		for (int i = 0; i < CANT_P/2; i+=2) {
			partidos[k].setEquipo1(equipos[i++]);
			partidos[k].setEquipo2(equipos[i]);
			k++;
		}
		this.resultados = new Resultados [CANT_P];
		this.i = 0;
	}
	
	public void SimulaIda () {
		if (i < CANT_P/2){
			partidos[i].simulacionNM();
			partidos[i].getEquipo1().setGoles(partidos[i].getGolesE1());
			partidos[i].getEquipo2().setGoles(partidos[i].getGolesE2());
			partidos[i].getEquipo1().setGolesContra(partidos[i].getGolesE2());
			partidos[i].getEquipo2().setGolesContra(partidos[i].getGolesE1());
			resultados[i].setE1(partidos[i].getEquipo1());
			resultados[i].setE2(partidos[i].getEquipo2());
			i++;
		}
		else
			JOptionPane.showMessageDialog(null, "Ya se jugaron todos los partidos de ida de cuartos de final");
	}
	
	public void SimulaVuelta() {
		if (i < CANT_P) {
			partidos[i].simulacionNM();
			i++;
		}
		else
			JOptionPane.showMessageDialog(null, "Ya se jugaron todos los partidos de vuelta de cuartos de final");
			
		
	}
}
