package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Clase encargada de serializar progreso.
 */
public abstract class Serializacion implements Serializable{

	/** Serial*/
	private static final long serialVersionUID = 1L;

	/**
	 * Guarda el progreso del campeonato.
	 * @param _campeonato El campeonato a serializar
	 * @param _frame El frame a serializar
	 * @throws FileNotFoundException Si no puede crear el archivo
	 * @throws IOException Si no puede escribir en el archivo
	 */
	public static void guardaProgreso(Campeonato _campeonato) throws FileNotFoundException, IOException {
		
		FileOutputStream fs = new FileOutputStream ("Progreso");
		ObjectOutputStream os = new ObjectOutputStream (fs);
			
		os.writeObject(_campeonato);
		
		os.close();
			
	}
	
	/**
	 * Lee el progreso desde un archivo.
	 * @return Una instancia de Campeonato
	 * @throws FileNotFoundException Si el archivo no existe
	 * @throws IOException Si no puede leer el archivo
	 * @throws ClassNotFoundException Si no se encuentra la clase Campeonato
	 */
	public static Campeonato leeProgreso() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		FileInputStream fs = new FileInputStream("Progreso");
		ObjectInputStream os = new ObjectInputStream(fs);
			
		Campeonato _campeonato = (Campeonato) os.readObject();

		os.close();
		return _campeonato;
			
	}


	/**
	 * Lee el documento pasado
	 * @param _doc Documento a leer
	 * @param equipos Lista de equipos (a rellenar)
	 * @param referis Lista de referis (a rellenar)
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */  
	public static void leeArchivo(ArrayList<Equipo> equipos, ArrayList<Referi> referis) throws ParserConfigurationException, SAXException, IOException {
		
		//abrimos el archivo
		File archivo = new File ("torneo.xml");
		
		//hacemos creamos una Factory de documentos y .setValidating para usar el dtd
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);
		
		//creamos el documento basandonos en el archivo
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(archivo);
		doc.getDocumentElement().normalize();
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		ArrayList<Jugador> jugadores;
		
		Equipo _equipo;
		Jugador _jugador;
		Dt _dt;
		Referi _referi; 
		
		String _nombreEquipo;
		Pais _pais, _paisEquipo;
		int _ranking, _aniosRef;
		byte _puntuacion;
		Posicion _posicion;
		String _tipoDocumento = "";
		int _nroDocumento = 0;
		String _nombreApellido = "";
		String _nombre = "";
		String _apellido = "";
		LocalDate _fecha;	
		
		NodeList listaEquipos, _jugadores, _director;
		
		//da los 16 equipos
		listaEquipos = doc.getElementsByTagName("equipo");
		
		for (int i = 0; i<listaEquipos.getLength(); i++) { //itera 16 veces
			
			jugadores = new ArrayList<Jugador>();         
			
			_nombreEquipo = listaEquipos.item(i).getChildNodes().item(1).getTextContent();
			_paisEquipo = Pais.valueOf(listaEquipos.item(i).getChildNodes().item(3).getTextContent());
			_ranking = Integer.parseInt(listaEquipos.item(i).getChildNodes().item(5).getTextContent());
			
			_jugadores = listaEquipos.item(i).getChildNodes().item(7).getChildNodes().item(1).getChildNodes(); //devuelve jugadores
			_director = listaEquipos.item(i).getChildNodes().item(7).getChildNodes().item(3).getChildNodes();
			
			for (int k = 1; k < _jugadores.getLength(); k += 2) { //jugador. 18 veces
				
				_posicion = Posicion.valueOf(_jugadores.item(k).getAttributes().getNamedItem("posicion").getNodeValue());
				_puntuacion = Byte.parseByte(_jugadores.item(k).getAttributes().getNamedItem("puntuacion").getNodeValue());
				
				_tipoDocumento = _jugadores.item(k).getChildNodes().item(1).getChildNodes().item(1).getTextContent();
				_nroDocumento = Integer.parseInt(_jugadores.item(k).getChildNodes().item(1).getChildNodes().item(3).getTextContent());
				_nombreApellido = _jugadores.item(k).getChildNodes().item(1).getChildNodes().item(5).getTextContent();
				_apellido = _nombreApellido.substring(0, _nombreApellido.indexOf(" "));
				_nombre = _nombreApellido.substring(_nombreApellido.indexOf(" ") +1);
				_fecha = LocalDate.parse(_jugadores.item(k).getChildNodes().item(1).getChildNodes().item(7).getTextContent(), formato);
				
				_jugador = new Jugador(_apellido, _nombre, _fecha, _tipoDocumento, _nroDocumento, _posicion, _puntuacion); 
				jugadores.add(_jugador);

			}
			//dt
			_tipoDocumento = _director.item(1).getChildNodes().item(1).getTextContent();
			_nroDocumento = Integer.parseInt(_director.item(1).getChildNodes().item(3).getTextContent());
			_nombreApellido = _director.item(1).getChildNodes().item(5).getTextContent();
			_apellido = _nombreApellido.substring(0, _nombreApellido.indexOf(" "));
			_nombre = _nombreApellido.substring(_nombreApellido.indexOf(" ") +1);
			_fecha = LocalDate.parse(_director.item(1).getChildNodes().item(7).getTextContent(), formato);
			_pais = Pais.valueOf(_director.item(3).getTextContent());
			_puntuacion = Byte.parseByte(_director.item(5).getTextContent()); //reutilizamos puntuacion como titulos
			
			_dt = new Dt(_apellido, _nombre, _fecha, _nroDocumento, _tipoDocumento, _pais, _puntuacion);
			
			_equipo = new Equipo (_nombreEquipo, _paisEquipo, _ranking, jugadores, _dt);
			equipos.add(_equipo);
		}
		
		//devuelve los arbitros
		NodeList listaArbitros = doc.getElementsByTagName("arbitro");

		for (int i = 0; i < listaArbitros.getLength(); i++) {
			
			_tipoDocumento = listaArbitros.item(i).getChildNodes().item(1).getChildNodes().item(1).getTextContent();
			_nroDocumento = Integer.parseInt(listaArbitros.item(i).getChildNodes().item(1).getChildNodes().item(3).getTextContent());
			_nombreApellido = listaArbitros.item(i).getChildNodes().item(1).getChildNodes().item(5).getTextContent();
			_apellido = _nombreApellido.substring(0, _nombreApellido.indexOf(" "));
			_nombre = _nombreApellido.substring(_nombreApellido.indexOf(" ") +1);
			_fecha = LocalDate.parse(listaArbitros.item(i).getChildNodes().item(1).getChildNodes().item(7).getTextContent(), formato);
			_pais = Pais.valueOf(listaArbitros.item(i).getChildNodes().item(3).getTextContent());
			_aniosRef = Integer.parseInt(listaArbitros.item(i).getChildNodes().item(5).getTextContent());
			
			_referi = new Referi(_apellido, _nombre, _fecha, _nroDocumento, _tipoDocumento, _pais, _aniosRef);
			referis.add(_referi);
		}
		
	}

}
