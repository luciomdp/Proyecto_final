package backend;

import java.io.Serializable;

public class Zona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2934756314623471362L;
	//Implementar tabla de posiciones
	
	//-------------------------VALORES DE PUNTOS--------------------------
	final int PV = 3;
	final int PE = 1;
	final int PD = 0;
	//-------------------------CANTIDAD DE PARTIDOS--------------------------
	final int CANT_PZ = 6;
	final int CANT_PF = 2;
	
	private int i,f;//f es fecha actual e i es partido actual
	/*Cada partido va a tener asignado un valor "i", cada fecha son 2 partidos de i (teniendo en cuenta el valor
	actual de i,tenes una variable fecha "f", que dice en que fecha se encuentra, y simular toda la zona, es iterar desde el i
	actual hasta el final)*/
	
	//HACER ARREGLO DE EQUIPOS 
    private Equipo e1;
    private Equipo e2;
    private Equipo e3;
    private Equipo e4;
    private Tabla tabla; 
    
    public Zona (Equipo equipo1, Equipo equipo2, Equipo equipo3, Equipo equipo4, Tabla tabla) {
        this.e1 = equipo1;
        this.e2 = equipo2;
        this.e3 = equipo3;
        this.e4 = equipo4;
        this.tabla = tabla;
        this.i = 0;
    }
    
    public void Prueba () {
        tabla.getValoresTabla();
    }
    
    public void SimulaPartido (Equipo e1, Equipo e2) {
        
        tabla.getValoresTabla();
        PartidoZona partido = new PartidoZona(e1, e2);
        partido.simulacion();
        tabla.setResultados(new Resultados (partido.getEquipo1(), partido.getEquipo2(), partido.getGolE1(), partido.getGolE2())); 
        e1.setGoles(partido.getGolE1());
        e2.setGoles(partido.getGolE2()); 
        e1.setGolesContra(partido.getGolE2());
        e2.setGolesContra(partido.getGolE1());
        tabla.ActualizaTabla();
        tabla.getValoresTabla();
        
    }

    public void SimulaFecha (Equipo e1, Equipo e2, Equipo e3, Equipo e4) {
        tabla.getValoresTabla();
        PartidoZona partido1 = new PartidoZona(e1, e2);
        partido1.simulacion();
        tabla.setResultados(new Resultados (partido1.getEquipo1(), partido1.getEquipo2(), partido1.getGolE1(), partido1.getGolE2()));
        i++;
        e1.setGoles(partido1.getGolE1());
        e2.setGoles(partido1.getGolE2());
        e1.setGolesContra(partido1.getGolE2());
        e2.setGolesContra(partido1.getGolE1());
        if (partido1.getGolE1()>partido1.getGolE2()) 
            e1.setPuntos(3);
        else if (partido1.getGolE1()<partido1.getGolE2())
            e2.setPuntos(3);
        else {
            e1.setPuntos(1);
            e2.setPuntos(1);
        }
        
        
        PartidoZona partido2 = new PartidoZona(e3, e4);    
        partido2.simulacion();
        tabla.setResultados(new Resultados (partido2.getEquipo1(), partido2.getEquipo2(), partido2.getGolE1(), partido2.getGolE2())); 
        e3.setGoles(partido1.getGolE1());
        e4.setGoles(partido1.getGolE2());
        e3.setGolesContra(partido1.getGolE2());
        e4.setGolesContra(partido1.getGolE1());
        if (partido1.getGolE1()>partido1.getGolE2()) 
            e3.setPuntos(3);
        else if (partido1.getGolE1()<partido1.getGolE2())
            e4.setPuntos(3);
        else {
            e3.setPuntos(1);
            e4.setPuntos(1);
        }
        
        tabla.ActualizaTabla();
        tabla.getValoresTabla();

    }

    public void SimulaZona (Equipo e1, Equipo e2, Equipo e3, Equipo e4) {

        this.SimulaFecha(e1, e2, e3, e4);
        this.SimulaFecha(e1, e3, e2, e4);
        this.SimulaFecha(e1, e4, e2, e3);
        
    }
}

