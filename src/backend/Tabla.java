package backend;

public class Tabla {
	private final int PASAN_CUARTOS = 2;
	private int i;
    private Equipo tabla [] = new Equipo[4];
    private Equipo aux;
    private Equipo ganadoresZona [] = new Equipo [2];
    Resultados resultados [] = new Resultados [6];
 
	public Tabla (Equipo equipos[]){
    	this.tabla = equipos;
        this.i = 0;
    }

    public void getValoresTabla(){
        for (int i = 0; i<4; i++ )
            System.out.println(tabla[i].getEstadisticas());
    }

    public void ActualizaTabla(){ // HAY QUE PROBARLO, PRINCIPALMENTE POR LA ULTIMA INSTANCIA
                
        for (int i = 0; i < tabla.length-1; i++){ 
            
            for (int j = 0; j < tabla.length-i -1; j++){ 
                
                	if (tabla[j + 1].getPuntos() < tabla[j].getPuntos()){
                		aux = tabla[j + 1];
                		tabla[j + 1] = tabla[j];
                		tabla[j] = aux;    
                	}
                	
                	else if (tabla[j + 1].getPuntos() == tabla[j].getPuntos()){
                        if (tabla[j + 1].getGoles() < tabla[j].getGoles()){
                        	aux = tabla[j + 1];
                    		tabla[j + 1] = tabla[j];
                    		tabla[j] = aux;
                        }
                        else if (tabla[j + 1].getGoles() == tabla[j].getGoles()){
                        	if ((tabla[j + 1].getGoles() - tabla[j + 1].getGolesContra()) < (tabla[j].getGoles()-tabla[j].getGolesContra())){
                        		aux = tabla[j + 1];
                        		tabla[j + 1] = tabla[j];
                        		tabla[j] = aux;                            
                        	}
                        	else if((tabla[j + 1].getGoles() - tabla[j + 1].getGolesContra()) == (tabla[j].getGoles()-tabla[j].getGolesContra())){
                        		int pos = this.buscaResultado(tabla[i].getNombre(), tabla[j].getNombre());
                        		if (resultados[pos].getE1() == tabla[i].getNombre()) {
                        			if (resultados[pos].getGolesE1() < resultados[pos].getGolesE2()) {
                        				aux = tabla[j + 1];
                                		tabla[j + 1] = tabla[j];
                                		tabla[j] = aux;
                        			}
                        		}
                        		else if (resultados[pos].getE1() == tabla[j].getNombre()){
                        			if (resultados[pos].getGolesE1() > resultados[pos].getGolesE2()) {
                        				aux = tabla[j + 1];
                                		tabla[j + 1] = tabla[j];
                                		tabla[j] = aux;
                        			}
                        		}
                        	}
                        }
                	}
                }
          }
       }
    
    
    public void setResultados(Resultados resultado) {
        this.resultados[i] = resultado ;
        i++;
    }
    public int buscaResultado(String e1, String e2) {
    	int k = 0;
    	
    	while (k <= resultados.length) {
    		if (resultados[k].getE1() == e1 && resultados[k].getE2() == e2) {
    			return k;
    		} 
    		else if (resultados[k].getE1() == e2 && resultados[k].getE2() == e1) {
    			return k;
    		} 
    		k++;
        }
    		return -1;
    }
    
    public Equipo[] getGanadoresZona() {
		return ganadoresZona;
	}

	public void GanadoresZona() {
		for (int i = 0; i < PASAN_CUARTOS; i++) {
			ganadoresZona[i] = tabla[i];
		}
		this.ganadoresZona = ganadoresZona;
	}
    
 
}
