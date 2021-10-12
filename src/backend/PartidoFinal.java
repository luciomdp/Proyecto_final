package backend;

/*Mejorar un poco si hay tiempo la simulacion de penales
 * falta implementar: Si la final finaliza en empate en los 90 minutos, también se define con tiros penales.
 * 
*/

public class PartidoFinal extends BackPartido{
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = 7173242858989911828L;
	private int golesP1,golesP2;
	
	//-------------------------------------------------<<COSNTRUCTOR>>-------------------------------------------------
	
	public PartidoFinal(Equipo a, Equipo b, Referi referi) {
		super(a, b, referi);	
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	/**
	 * Simula los tiros penales de la final. 
	 * @param a equipo
	 * @param b equipo
	 * 
	 */
	public void simulacionPen(Equipo a,Equipo b) {
		int probab1,probab2;
		golesP1 = 0;
		golesP2 = 0;
		if(getMedia_totE1()>getMedia_totE2()) {
			probab1 = 55;
			probab2 = 45;
		}else {
			probab1 = 45;
			probab2 = 55;
		}
		int i;
		for(i = 0;i<5;i++) {
			if(Math.random()*100<probab1)
				golesP1++;
		}
		for(i = 0;i<5;i++) {
			if(Math.random()*100<probab2)
				golesP2++;
		}
		while (golesP1 == golesP2) {
			if(Math.random()*100<probab1)
				golesP1++;
			if(Math.random()*100<probab2)
				golesP2++;
		}	
	}

}
