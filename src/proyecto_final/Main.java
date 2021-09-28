package proyecto_final;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import backend.Campeonato;
import backend.Dt;
import backend.Equipo;
import backend.Jugador;
import backend.Pais;
import backend.Posicion;
import backend.Referi;
import frontend.Frame;
/* 
 * Cambiar nombre a las clases compartidas entre el back y front (como final,semifinal,cuartos,zona) para diferenciarlas
 * (sugerencia, las que son del back llamarlas BackFinal,BackSemifinal ... y las del Front, FrontFinal,FrontSemifinal ...)
 * 
 * No debería haber una clase abstracta partido?, de la que hereden los 3 tipos de partidos que existen. (sino lo dejamos como está
 * donde Partido actúa como una clase abstracta pero implementa la funcionalidad de ser un partido normal)
 * 
 * Estaría bueno separar dentro del backend, en paquetes, Las clases relacionadas con partidos, las relacionadas con Personas, 
 * las relacionadas con etapas del torneo (cuartos,semis...) y los enums
 * 
 * Verificar que todas las clases del back, tengan atributos private
 * 
 * Cual es la diferencia entre PartidoIdaVuelta y PartidoFinal ??
 * 
 * Resolver tareas en cada clase del back
 */
public class Main {	
	/*saco el throw => no tiene sentido tirar la excepción si también la vamos a catchear (además, si falla el main, qué le queda al resto?*/
	/**
	 * Entry point
	 * @param args Argument's array
	 */
	public static void main (String[] args) {
		
		ArrayList <Equipo> equipos = new ArrayList <Equipo>();
		ArrayList <Referi> referis = new ArrayList <Referi>();
		
		try {
			//abrimos el archivo
			File archivo = new File ("torneo.xml");
			
			//hacemos creamos una Factory de documentos y .setValidating para usar el dtd
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(true);
			
			//creamos el documento basandonos en el archivo
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(archivo);
			doc.getDocumentElement().normalize();
			
			//funcion principal de lectura
			leeArchivo(doc, equipos, referis);
			
			//creamos el torneo y la vista
			Campeonato torneo = new Campeonato (equipos, referis);
			Frame vista = new Frame ();
			
			//creamos el controlador y le pasamos el back y el front
			Controlador control = new Controlador (torneo, vista);
			vista.setControlador(control);
			torneo.setControlador(control);
			
		} catch (NumberFormatException e) {
			//esto si falla alguna string ->
			JOptionPane.showMessageDialog(null, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		
		} catch (ParserConfigurationException e) {
			//aca falla el parser -> el null del dialogo debe ser algun componente de la vista, para que el dialogo herede el icono
			JOptionPane.showMessageDialog(null, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		
		} catch (SAXException e) {
			//esto si falla algo del XML
			JOptionPane.showMessageDialog(null, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		
		} catch (IOException e) {
			//esto si pasa algo con el archivo (no deja abrirlo/no existe)
			JOptionPane.showMessageDialog(null, "Se produjo un error. \nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Lee el documento pasado
	 * @param _doc Documento a leer
	 * @param equipos Lista de equipos (a rellenar)
	 * @param referis Lista de referis (a rellenar)
	 */
	public static void leeArchivo(Document _doc, ArrayList<Equipo> equipos, ArrayList<Referi> referis) {//pasar x parametros equipos y referis
		
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
		listaEquipos = _doc.getElementsByTagName("equipo");
		
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
		NodeList listaArbitros = _doc.getElementsByTagName("arbitro");

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
}//clase
