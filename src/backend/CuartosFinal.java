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
			equipos[i].setGoles(0);
		}
		this.partidos = new PartidoIdaVuelta [CANT_P] ;
		int k= 0;
		for (int i = 0; i < CANT_P; i++) {
			for (int j = 1; i < CANT_P && i < j; i++) {
				partidos[k].setEquipo1(equipos[i]);
				partidos[k].setEquipo2(equipos[j]);
			}
		}
		this.resultados = new Resultados [CANT_P];
		this.i = 0;
	}
	
	public void SimulaIda () {
		if (i < CANT_P/2){
			partidos[i].simulacionNM();
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
