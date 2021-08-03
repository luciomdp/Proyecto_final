package backend;

import javax.swing.JOptionPane;

public class SemiFinal {
	private final int CANT_P = 4;
	private final int CANTE = 4;
	private Equipo e1, e2;
	private PartidoIdaVuelta partidos [];
	private Equipo equipos [];
	private Resultados resultados [];
	private Equipo pasaAFinal [];
	private int i, k;

	public SemiFinal(Equipo equipos []) {
		
		this.equipos = equipos;
		int k= 0;
		for (int i = 0; i < CANT_P; i += 2) { //El EQUIPO A DEL PARTIDO SIEMPRE ES EL LOCAL, EL B EL VISITANTE
			this.partidos [k] = new PartidoIdaVuelta (equipos[i], equipos[i++]);
			k++;
		}
		for (int i = 0; i < CANT_P; i+=2) {
			this.partidos [k] = new PartidoIdaVuelta (equipos[i++], equipos[i]);
			k++;
		}
		this.resultados = new Resultados [CANT_P];
		this.i = 0;
		this.k = 0;
	}
	
	public void SimulaIda () {
		if (i < CANT_P/2){
			partidos[i].simulacionNM();
			partidos[i].getEquipo1().setGolesCuartos(partidos[i].getGolesE1());
			partidos[i].getEquipo2().setGolesCuartos(partidos[i].getGolesE2());
			partidos[i].getEquipo1().setGolesContraCuartos(partidos[i].getGolesE2());
			partidos[i].getEquipo2().setGolesContraCuartos(partidos[i].getGolesE1());
			resultados[i].setE1(partidos[i].getEquipo1());
			resultados[i].setE2(partidos[i].getEquipo2());
			resultados[i].setGolesE1(partidos[i].getGolesE1());
			resultados[i].setGolesE2(partidos[i].getGolesE2());
			i++;
		}
		else
			JOptionPane.showMessageDialog(null, "Ya se jugaron todos los partidos de ida de cuartos de final");
	}
	
	public void SimulaVuelta() {
		if (i < CANT_P) {
			partidos[i].simulacionNM();
			partidos[i].getEquipo1().setGolesCuartos(partidos[i].getGolesE1());
			partidos[i].getEquipo2().setGolesCuartos(partidos[i].getGolesE2());
			partidos[i].getEquipo1().setGolesContraCuartos(partidos[i].getGolesE2());
			partidos[i].getEquipo2().setGolesContraCuartos(partidos[i].getGolesE1());
			resultados[i].setE1(partidos[i].getEquipo1());
			resultados[i].setE2(partidos[i].getEquipo2());
			resultados[i].setGolesE1(partidos[i].getGolesE1());
			resultados[i].setGolesE2(partidos[i].getGolesE2());
			if (resultados[i].getGolesE1() + resultados [i-(CANT_P/2)].getGolesE2() == resultados[i].getGolesE2() + resultados [i-(CANT_P/2)].getGolesE1()) { //SI LA SUMA DE LOS GOLES DE CADA EQUIPO EN AMBOS PARTIDOS ES IGUAL
				if (resultados[i].getGolesE2() > resultados [i-(CANT_P/2)].getGolesE2()) { //SI LOS GOLES DEL EQUIPO 2 EN LA IDA SON MAYORES QUE LOS DEL EQUIPO 2 EN LA VUELTA
					this.setPasanAFinal(partidos[i].getEquipo2());
				}
				else if (resultados[i].getGolesE2() < resultados [i-(CANT_P/2)].getGolesE2()) { // SI LOS GOLES DE EQUIPO 2 EN LA VUELTA SON MAYORES QUE LOS DEL EQUIPO 2 EN LA IDA
					this.setPasanAFinal(partidos[i-(CANT_P/2)].getEquipo2());
				}
				else { // HAY PENALES
					partidos[i].simulacionPen();
					if (partidos[i].getGolesP1() > partidos[i].getGolesP2()) { // SI LOS GOLES DE PENAL DEL EQUIPO 1 SON MAYORES QUE LOS DEL EQUIPO 2
						this.setPasanAFinal(partidos[i].getEquipo1());
					}
					else { // SI LOS GOLES DE PENAL DEL EQUIPO 2 SON MAYORES QUE LOS DEL EQUIPO 1
						this.setPasanAFinal(partidos[i].getEquipo2());
					}
				}
			}
			else if (resultados[i].getGolesE1() + resultados [i-(CANT_P/2)].getGolesE2() > resultados[i].getGolesE2() + resultados [i-(CANT_P/2)].getGolesE1()) { //SI GANA EL EQUIPO 1 EN EL TOTAL
				this.setPasanAFinal(partidos[i].getEquipo1());
			}
			else // SI GANA EL EQUIPO 2 EN EL TOTAL
				this.setPasanAFinal(partidos[i].getEquipo2());
			
			i++;
		}
		else
			JOptionPane.showMessageDialog(null, "Ya se jugaron todos los partidos de vuelta de cuartos de final");
			
		
	}
	
	public Equipo[] getPasanAFinal() {
		return pasaAFinal;
	}

	public void setPasanAFinal(Equipo pasaAFinal) {
		this.pasaAFinal[k] = pasaAFinal;
		k++;
	}

	
}


