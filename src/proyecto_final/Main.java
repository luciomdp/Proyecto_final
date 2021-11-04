package proyecto_final;

import frontend.Frame;

/**
 * Clase principal
 */
public class Main {	
	/**
	 * Entry point del programa
	 * @param args Argument's array
	 */
	public static void main (String[] args) {
			
			//creamos la vista
			Frame vista = new Frame ();
			
			//creamos el controlador y le pasamos el front
			Controlador control = new Controlador (vista);
			
			//seteamos el controlador
			vista.setControlador(control);
	}		
	
}//clase
