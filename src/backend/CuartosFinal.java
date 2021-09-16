package backend;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
55 y 92- En el back no se usa el showMessageDialog, salvo que
sea para mostrar errores. Si se jugaron todos los partidos,
tendrías que avisar al front mediante el controlador.

102- ¿Qué es ese metodo comentado, es necesario? resolver
*/

public class CuartosFinal extends SemiFinal{
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private final int CANT_P = 8;
	private final int CANTE = 8;
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private PartidoIdaVuelta partidos [];
	private Resultados resultados [];
	private Equipo pasanASemis [];
	private int i, k;
	
	//-------------------------------------------------<<CONSTRUCTOR>>-------------------------------------------------
	
	public CuartosFinal(ArrayList <Equipo> equipos) {
		super (equipos);
		this.partidos = new PartidoIdaVuelta [CANT_P] ;
		int k= 0;
		for (int i = 0; i < CANT_P/2; i+=2) { //El EQUIPO A DEL PARTIDO SIEMPRE ES EL LOCAL, EL B EL VISITANTE
			partidos[k] = new PartidoIdaVuelta (equipos.get(i),equipos.get(i++));
			k++;
		}
		for (int i = 0; i < CANT_P/2; i+=2) {
			partidos[k] = new PartidoIdaVuelta (equipos.get(i++),equipos.get(i));
			k++;
		}
		this.resultados = new Resultados [CANT_P];
		this.i = 0;
		this.k = 0;
	}
	//-------------------------------------------------<<MÉTODOS DE LA CLASE>>-------------------------------------------------
	
	public void SimulaIda () {
		if (i < CANT_P/2){
			partidos[i].simulacionNM();
			partidos[i].getEquipo1().setGolesIdaCuartos(partidos[i].getGolesE1());
			partidos[i].getEquipo2().setGolesIdaCuartos(partidos[i].getGolesE2());
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
			partidos[i].getEquipo1().setGolesVueltaCuartos(partidos[i].getGolesE1());
			partidos[i].getEquipo2().setGolesVueltaCuartos(partidos[i].getGolesE2());
			resultados[i].setE1(partidos[i].getEquipo1());
			resultados[i].setE2(partidos[i].getEquipo2());
			resultados[i].setGolesE1(partidos[i].getGolesE1());
			resultados[i].setGolesE2(partidos[i].getGolesE2());
			if (resultados[i].getGolesE1() + resultados [i-(CANT_P/2)].getGolesE2() == resultados[i].getGolesE2() + resultados [i-(CANT_P/2)].getGolesE1()) { //SI LA SUMA DE LOS GOLES DE CADA EQUIPO EN AMBOS PARTIDOS ES IGUAL
				if (resultados[i].getGolesE2() > resultados [i-(CANT_P/2)].getGolesE2()) { //SI LOS GOLES DEL EQUIPO 2 EN LA IDA SON MAYORES QUE LOS DEL EQUIPO 2 EN LA VUELTA
					this.setGanador(partidos[i].getEquipo2());
				}
				else if (resultados[i].getGolesE2() < resultados [i-(CANT_P/2)].getGolesE2()) { // SI LOS GOLES DE EQUIPO 2 EN LA VUELTA SON MAYORES QUE LOS DEL EQUIPO 2 EN LA IDA
					this.setGanador(partidos[i-(CANT_P/2)].getEquipo2());
				}
				else { // HAY PENALES
					partidos[i].simulacionPen();
					if (partidos[i].getGolesP1() > partidos[i].getGolesP2()) { // SI LOS GOLES DE PENAL DEL EQUIPO 1 SON MAYORES QUE LOS DEL EQUIPO 2
						this.setGanador(partidos[i].getEquipo1());
					}
					else { // SI LOS GOLES DE PENAL DEL EQUIPO 2 SON MAYORES QUE LOS DEL EQUIPO 1
						this.setGanador(partidos[i].getEquipo2());
					}
				}
			}
			else if (resultados[i].getGolesE1() + resultados [i-(CANT_P/2)].getGolesE2() > resultados[i].getGolesE2() + resultados [i-(CANT_P/2)].getGolesE1())  //SI GANA EN EL TOTAL EL EQUIPO 1
				this.setGanador(partidos[i].getEquipo1());
			else
				this.setGanador(partidos[i].getEquipo2()); //SI GANA EN EL TOTAL EL EQUIPO 2
			
			i++;
		}
		else
			JOptionPane.showMessageDialog(null, "Ya se jugaron todos los partidos de vuelta de cuartos de final");
			
		
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------

	 /* SE SUPONE QUE HEREDA DE SEMIFINAL
	public String getResultado (int partido) { 
		return resultados[partido].getE1() + " " + resultados[partido].getGolesE1()+"\n"+resultados[partido].getE2() + " " + resultados[partido].getGolesE2();
	}*/
	



}
