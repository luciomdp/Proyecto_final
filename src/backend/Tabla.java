package backend;

public class Tabla {
	private int i;
    private Equipo tabla [] = new Equipo[4];
    private Equipo aux;
    Resultados resultados [] = new Resultados [3];
    
    public Tabla (Equipo e1, Equipo e2, Equipo e3, Equipo e4){
        tabla[0] = e1;
        tabla[1] = e2;
        tabla[2] = e3;
        tabla[3] = e4;
        this.i = 0;
    }

    public void getValoresTabla(){
        for (int i = 0; i<4; i++ )
            System.out.println(tabla[i].getEstadisticas());
    }

    public void ActualizaTabla(){
        int k=0;
        
        for (int i = 0; i < tabla.length; i++){
            
            for (int j = 0; j < tabla.length -1; j++){
                
                if (tabla[i].getPuntos() < tabla[j].getPuntos()){
                    aux = tabla[i];
                    tabla[i] = tabla[j];
                    tabla[j] = aux;
                        
                }    
                else if (tabla[i].getPuntos() == tabla[j].getPuntos()){
                    
                    if (tabla[i].getGoles() < tabla[j].getGoles()){
                        aux = tabla[i];
                        tabla[i] = tabla[j];
                        tabla[j] = aux;
                    }
                    else if (tabla[i].getGoles() == tabla[j].getGoles()){
                        
                        if ((tabla[i].getGoles()-tabla[i].getGolesContra()) < (tabla[j].getGoles()-tabla[j].getGolesContra())){
                            aux = tabla[i];
                            tabla[i] = tabla[j];
                            tabla[j] = aux;                            
                        }
                        else if((tabla[i].getGoles()-tabla[i].getGolesContra()) == (tabla[j].getGoles()-tabla[j].getGolesContra())){
                            
                            
                            
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
    
    
}
