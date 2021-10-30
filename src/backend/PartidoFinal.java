package backend;

import java.time.LocalDate;

public class PartidoFinal extends BackPartido{
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = 7173242858989911828L;
	private int golesP1,golesP2;
	
	//-------------------------------------------------<<COSNTRUCTOR>>-------------------------------------------------
	
	public PartidoFinal(Equipo a, Equipo b, Referi referi, LocalDate fecha) {
		super(a, b, referi, fecha);	
	}
	
	//-------------------------------------------------<<M�TODOS>>-------------------------------------------------
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
