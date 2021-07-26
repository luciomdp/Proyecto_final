package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PartidoZona extends Partido{
	private int GolE1, GolE2;
	
	private static final long serialVersionUID = 1584061224750984258L;

	public PartidoZona(Equipo a, Equipo b) {
		super(a, b);
		this.GolE1 = 0;
        this.GolE2 = 0;
		// TODO Auto-generated constructor stub
	}
	public void simulacion() {

    }

    public int getGolE1() {
        return GolE1;
    }

    public void setGolE1(int golE1) {
        GolE1 = golE1;
    }

    public int getGolE2() {
        return GolE2;
    }

    public void setGolE2(int golE2) {
        GolE2 = golE2;
    }
    
    public static int factorial (int numero) {
        if (numero == 0)
            return 1;
        else
            return numero * factorial(numero - 1);
    }

    public static void creaFechas (String[] equipos) {

        /*  Calculo primero todas las fórmulas que necesito y numeros que me sirven para hacer el algoritmo
        partidosSimultaneos = cantEquipos/2;
        partidosPosibles = (variacion entre cantEquipos y 2 (cantEquipos por partido)) / partidosSimultaneos;
        cantFechas = partidosPosibles / partidosSimultaneos;
        -----------------------------------------------------
        partidosSimultaneos = 4/2 = 2;
        partidosPosibles = ((4)!/(2)!) / 2 = (24/2) / 2 = 6;
        cantFechas = 6 / 2 = 3;
        */

        ArrayList<String> fechas = new ArrayList<>();
        int partidosSimultaneos = (equipos.length / 2);
        int partidosPosibles = ((factorial(equipos.length))/2) / partidosSimultaneos;
        int cantFechas = partidosPosibles / partidosSimultaneos;
        int i = 0; //indice de fechas

        //paso a minuscula
        for (int k = 0; k < equipos.length; k++) {
            equipos[k] = equipos[k].toLowerCase();
        }

        String[] equiposQueRotan = Arrays.copyOfRange(equipos, 1, equipos.length);
        //mientras que no llegue a completar todas las fechas
        while (i < cantFechas) {
            String posibleFecha = equipos[0] + " "; //agrego el primero ya que queda fijo en todas las fechas;
            //la primera fecha se agregan los equipos como están, es decir, 1vs2 3vs4 5vs6 7vs8 .....
            if (i == 0) {
                for (int k = 1; k < equipos.length; k++) {
                    posibleFecha += equipos[k] + " ";
                }
            } else {
                //aca viene el quilombo, tengo que ir rotando todos los equipos, 2 en 3-3 en 4-4 en 5-5 en 6...
                Collections.rotate(Arrays.asList(equiposQueRotan), equiposQueRotan.length - 1);
                //aca esta el array rotado asique ya puedo meter los equipos que faltan
                for (int k = 0; k < equiposQueRotan.length; k++) {
                    posibleFecha += equiposQueRotan[k] + " ";
                }
            }
            fechas.add(posibleFecha);
            i++;
        }
    }

}
