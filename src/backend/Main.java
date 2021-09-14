package backend;
//modificar esto (importar solo lo necesario)
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;
//////////
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import frontend.Frame;
import proyecto_final.Controlador;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  
/* public static void leeArchivo(Element _raiz) Agregarle los throw correspondientes de la funcion
 * 
 * catch (Exception e) Diversificar las excepciones para tratar cada una en particular, y mostrarlas con showmessagedialog
 * 
 * Cambiar nombre a las clases compartidas entre el back y front (como final,semifinal,cuartos,zona) para diferenciarlas
 * (sugerencia, las que son del back llamarlas BackFinal,BackSemifinal ... y las del Front, FrontFinal,FrontSemifinal ...)
 * 
 * La clase SemiFinal debería ser Semifinal
 * 
 * No debería haber una clase abstracta partido?, de la que hereden los 3 tipos de partidos que existen. (sino lo dejamos como está
 * donde Partido actúa como una clase abstracta pero implementa la funcionalidad de ser un partido normal)
 * 
 * Estaría bueno separar dentro del backend, en paquetes, Las clases relacionadas con partidos, las relacionadas con Personas, 
 * las relacionadas con etapas del torneo (cuartos,semis...) y los enums
 * 
 * El main no debería estar en proyecto_final?
 * 
 * Verificar que todas las clases del back, tengan atributos private
 * 
 * Cual es la diferencia entre PartidoIdaVuelta y PartidoFinal ??
 * 
 * Resolver tareas en cada clase del back
 */
public class Main {	
	
	
	static ArrayList <Jugador> jugadores = new ArrayList <Jugador>();
	static ArrayList <Equipo> equipos = new ArrayList <Equipo>();
	static ArrayList <Referi> referis = new ArrayList <Referi>();
	
	public static void main (String[] args) throws NumberFormatException, ParseException {
				
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
			//agarramos el nodo raiz (torneo)
			Element raiz = doc.getDocumentElement();
			//funcion principal de lectura
			leeArchivo(raiz);
		
			Campeonato torneo = new Campeonato (equipos, jugadores, referis);
			
			Frame vista = new Frame ();
			Controlador control = new Controlador (torneo, vista);
			vista.setControlador(control);
			torneo.setControlador(control);
			
		} catch (Exception e) {
			e.printStackTrace();
			//e.getMessage(); interesante por si quieren ver el tipo de mensaje que lanzaría por consola
			//JOptionPane.showMessageDialog(null, "Se produjo un error en la lectura de archivos, por lo que es imposible iniciar el programa correctamente.","Error de lectura",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void leeArchivo(Element _raiz) {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		ArrayList<Jugador> jugadoresEquipo = new ArrayList <Jugador>(); 

		//EQUIPO
		String _nombreE;
		Pais _paisE;
		int _ranking;
		Equipo e;
		
		//plantel
		Jugador jugador;
		Dt dt = null;
		Posicion _posicion = null;
		Byte _puntuacion = 0;
		String _tipoDocumento = "";
		int _nroDocumento = 0;
		String _nombreApellido = "";
		String _nombre = "";
		String _apellido = "";
		LocalDate _fecha = null;
		Byte _titulos = 0;
		
		//referi
		Referi referi;
		Pais _pais = null;
		int _anios;
		////
		
		
        final NodeList children = _raiz.getChildNodes(); //aca sacamos equipos y arbitros
        
        for (int i=0; i<children.getLength(); i++) { //aca iteramos dos veces
        	
        	final Node nodo = children.item(i); //sacamos equipos o arbitros
        	
        		if (nodo.getNodeName() == "equipos") { //agarramos equipos
         			
         			NodeList listaChildren = nodo.getChildNodes(); //lista de equipo's
         			
         			for (int j=1; j<listaChildren.getLength(); j+=2) { 
         				
         				Node children2 = listaChildren.item(j); //agarramos un equipo
         
         					if (children2.getNodeName() == "equipo") { 
         						
         						_nombreE = children2.getChildNodes().item(1).getTextContent();
         						_paisE = Pais.valueOf(children2.getChildNodes().item(3).getTextContent());
         						_ranking = Byte.parseByte(children2.getChildNodes().item(5).getTextContent());
         						
         						jugadoresEquipo.clear(); 
         						
         						NodeList listaChildren2 = children2.getChildNodes().item(7).getChildNodes(); 
         						//entramos a plantel: jugadores y dt
         						for (int k=1; k<listaChildren2.getLength(); k+=2) {
         							
         							Node children3 = listaChildren2.item(k); //jugadores o dt
         							
         							if (children3.getNodeName() == "jugadores") {
         								
         								NodeList listaChildren3 = children3.getChildNodes(); //entro a jugador
         								
         								for (int l=1; l<listaChildren3.getLength(); l+=2) {
         									
         										Node children4 = listaChildren3.item(l); 

         										for (int m=0; m<2; m++) {
         											
         											if (m == 0) {
         												NamedNodeMap att = listaChildren3.item(l).getAttributes();
             											_posicion = Posicion.valueOf(att.getNamedItem("posicion").getNodeValue()); 
         												_puntuacion = Byte.parseByte(att.getNamedItem("puntuacion").getNodeValue());
         												
         											} else { //persona
         												
         												NodeList listaChildren5 = children4.getChildNodes();
         												NodeList children5 = listaChildren5.item(1).getChildNodes();
         												         										
         												_tipoDocumento = children5.item(1).getTextContent(); 
         												_nroDocumento = Integer.parseInt(children5.item(3).getTextContent());
         												_nombreApellido = children5.item(5).getTextContent();
         												_apellido = _nombreApellido.substring(0, _nombreApellido.indexOf(" "));
         												_nombre = _nombreApellido.substring(_nombreApellido.indexOf(" ")+1);
         												_fecha = LocalDate.parse(children5.item(7).getTextContent(), formato);
         												
         											}
         											
         										}
         										//aca creamos el jugador;
     											jugador = new Jugador(_apellido, _nombre, _fecha, _tipoDocumento, _nroDocumento, _posicion, _puntuacion);
 												
     											jugadoresEquipo.add(jugador);
 												jugadores.add(jugador);
         									
         								}
         							} else if (children3.getNodeName() == "dt") {
         								
         								NodeList listaChildren3 = children3.getChildNodes(); //entras al dt
										NodeList children4 = listaChildren3.item(1).getChildNodes(); //entras a persona
										
										_tipoDocumento = children4.item(1).getTextContent(); //tipo doc
										_nroDocumento = Integer.parseInt(children4.item(3).getTextContent());
										_nombreApellido = children4.item(5).getTextContent();
										_apellido = _nombreApellido.substring(0, _nombreApellido.indexOf(" "));
										_nombre = _nombreApellido.substring(_nombreApellido.indexOf(" ")+1);
										_fecha = LocalDate.parse(children4.item(7).getTextContent(), formato);
										
										for (int n=3; n<=5; n+=2) {
											
											NodeList children5 = listaChildren3.item(n).getChildNodes();
											
											if (n == 3) {
											
												_pais = Pais.valueOf(children5.item(0).getTextContent());
												
											} else {
												
												_titulos = Byte.parseByte(children5.item(0).getTextContent());
												
											}
										}
										dt = new Dt (_apellido, _nombre, _fecha, _nroDocumento, _tipoDocumento, _pais, _titulos);
         							}
         							
         						}
         						e = new Equipo(_nombreE, _paisE, _ranking, jugadoresEquipo, dt);
             					//hasta aca tenemos los jugadores que corresponden
         						
         						equipos.add(e);
             					
         					}
         			}
         			     		
         		} else if (nodo.getNodeName() == "arbitros") {
         			
         			NodeList _arbitro = nodo.getChildNodes();
         			for (int n= 1; n<_arbitro.getLength(); n=n+2) { //pasamos por todos los arbitros
         				
         				NodeList children7 = _arbitro.item(n).getChildNodes(); //persona
         				NodeList children8 = children7.item(1).getChildNodes();
         				
         				_tipoDocumento = children8.item(1).getTextContent();
         				_nroDocumento = Integer.parseInt(children8.item(3).getTextContent());
         				_nombreApellido = children8.item(5).getTextContent();
         				_apellido = _nombreApellido.substring(0, _nombreApellido.indexOf(" "));
						_nombre = _nombreApellido.substring(_nombreApellido.indexOf(" ")+1);
						_fecha = LocalDate.parse(children8.item(7).getTextContent(), formato);
						
						_pais = Pais.valueOf(children7.item(3).getTextContent());
						_anios = Integer.parseInt(children7.item(5).getTextContent());
						
						referi = new Referi (_apellido, _nombre, _fecha, _nroDocumento, _tipoDocumento, _pais, _anios);
						referis.add(referi);
         			}     			
         		}
        }
	}
}
