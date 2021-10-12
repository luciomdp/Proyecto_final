package backend;

/*Mejorar un poco si hay tiempo la simulacion de penales*/

public class PartidoIdaVuelta extends BackPartido{

	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private static final long serialVersionUID = -8847438604485174325L;
	private int golesP1,golesP2;
	
	//-------------------------------------------------<<COSNTRUCTOR>>-------------------------------------------------
	
	public PartidoIdaVuelta(Equipo a, Equipo b, Referi referi) {
		super(a, b, referi);
	}
	
	//-------------------------------------------------<<MÉTODOS>>-------------------------------------------------
	/**
	 * Simula la definicion por penales.
	 * 
	 */
	public void simulacionPen() {
		
		double probab1, probab2, i;
		golesP1 = 0;
		golesP2 = 0;
		
		probab1 = ((getEquipo1().getMediaPos(Posicion.delantero) + getEquipo1().getMediaPos(Posicion.mediocampista) + getEquipo1().getMediaPos(Posicion.defensor))/3*10) - getEquipo2().getMediaPos(Posicion.arquero)*10* 0.5;
		probab2= ((getEquipo2().getMediaPos(Posicion.delantero) + getEquipo2().getMediaPos(Posicion.mediocampista) + getEquipo2().getMediaPos(Posicion.defensor))/3*10) - getEquipo1().getMediaPos(Posicion.arquero)*10* 0.5;
		
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
