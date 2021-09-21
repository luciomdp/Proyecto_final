package backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializacion implements Serializable{

	private static final long serialVersionUID = 1L;

	public void guardaProgreso(Campeonato _campeonato) throws FileNotFoundException, IOException {
		
		FileOutputStream fs = new FileOutputStream ("Progreso");
		ObjectOutputStream os = new ObjectOutputStream (fs);
			
		os.writeObject(_campeonato);
			
		os.close();
			
	}
	
	public Campeonato leeProgreso() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		FileInputStream fs = new FileInputStream("Progreso");
		ObjectInputStream os = new ObjectInputStream(fs);
			
		Campeonato _campeonato = (Campeonato)os.readObject();
			
		os.close();
		return _campeonato;
			
	}
	
}
