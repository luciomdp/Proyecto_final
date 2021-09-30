package backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import frontend.Frame;

/**
 * Clase encargada de serializar progreso
 */
public abstract class Serializacion implements Serializable{

	/** Serial*/
	private static final long serialVersionUID = 1L;

	/**
	 * Guarda el progreso del campeonato
	 * @param _campeonato El campeonato a serializar
	 * @param _frame El frame a serializar
	 * @throws FileNotFoundException Si no puede crear el archivo
	 * @throws IOException Si no puede escribir en el archivo
	 */
	public static void guardaProgreso(Campeonato _campeonato, Frame _frame) throws FileNotFoundException, IOException {
		
		FileOutputStream fs = new FileOutputStream ("Progreso");
		ObjectOutputStream os = new ObjectOutputStream (fs);
			
		os.writeObject(_campeonato);
		os.writeObject(_frame);
		
		os.close();
			
	}
	
	/**
	 * Lee el progreso desde un archivo
	 * @return Una instancia de Campeonato
	 * @throws FileNotFoundException Si el archivo no existe
	 * @throws IOException Si no puede leer el archivo
	 * @throws ClassNotFoundException Si no se encuentra la clase Campeonato
	 */
	public static Object[] leeProgreso() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		Object[] ob = new Object[2];
		FileInputStream fs = new FileInputStream("Progreso");
		ObjectInputStream os = new ObjectInputStream(fs);
			
		Campeonato _campeonato = (Campeonato)os.readObject();
		Frame _frame = (Frame) os.readObject();
		
		ob[0] = _campeonato;
		ob[1] = _frame;
		
		os.close();
		return ob;
			
	}
	  
}
