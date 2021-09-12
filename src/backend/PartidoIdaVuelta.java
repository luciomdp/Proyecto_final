package backend;

/*Mejorar un poco si hay tiempo la simulacion de penales*/

public class PartidoIdaVuelta extends Partido{

	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = -8847438604485174325L;
	private int golesP1,golesP2;
	
	//-------------------------------------------------<<COSNTRUCTOR>>-------------------------------------------------
	
	public PartidoIdaVuelta(Equipo a, Equipo b) {
		super(a, b);
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	
	public void simulacionPen() {
		
		int probab1, probab2, i;
		golesP1 = 0;
		golesP2 = 0;
		
		if (getMedia_totE1()>getMedia_totE2()) {
			probab1 = 75;
			probab2 = 65;
		} else {
			probab1 = 65;
			probab2 = 75;
		}
				
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
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	public int getGolesP1() {
		return golesP1;
	}
	
	public void setGolesP1(int golesP1) {
		this.golesP1 = golesP1;
	}
	
	public int getGolesP2() {
		return golesP2;
	}
	
	public void setGolesP2(int golesP2) {
		this.golesP2 = golesP2;
	}
}
