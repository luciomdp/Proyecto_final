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
 * La clase SemiFinal deber�a ser Semifinal
 * 
 * No deber�a haber una clase abstracta partido?, de la que hereden los 3 tipos de partidos que existen. (sino lo dejamos como est�
 * donde Partido act�a como una clase abstracta pero implementa la funcionalidad de ser un partido normal)
 * 
 * Estar�a bueno separar dentro del backend, en paquetes, Las clases relacionadas con partidos, las relacionadas con Personas, 
 * las relacionadas con etapas del torneo (cuartos,semis...) y los enums
 * 
 * El main no deber�a estar en proyecto_final?
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
			/*for (int i=0; i<referis.size(); i++) {
				System.out.println(referis.get(i).toString());
			}*/
			Frame vista = new Frame ();
			Controlador control = new Controlador (torneo, vista);
			vista.setControlador(control);
			torneo.setControlador(control);
			
		} catch (Exception e) {
			e.printStackTrace();
			//e.getMessage(); interesante por si quieren ver el tipo de mensaje que lanzar�a por consola
			//JOptionPane.showMessageDialog(null, "Se produjo un error en la lectura de archivos, por lo que es imposible iniciar el programa correctamente.","Error de lectura",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void leeArchivo(Element _raiz) {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		ArrayList<Jugador> jugadoresEquipo = new ArrayList <Jugador>(); 

        final NodeList children = _raiz.getChildNodes(); //aca sacamos equipos y arbitros
        
        for (int i=0; i<children.getLength(); i++) { //aca iteramos dos veces
        	
        	final Node nodo = children.item(i); //sacamos equipos o arbitros
        	
        		if (nodo.getNodeName() == "equipos") { //agarramos equipos
         			
         			NodeList listaChildren = nodo.getChildNodes(); //lista de equipo's
         			
         			for (int j=0; j<listaChildren.getLength(); j++) { 
         				
         				Node children2 = listaChildren.item(j); //agarramos un equipo
         
         					if (children2.getNodeName() == "equipo") { 
         						
         						String _nombreE = children2.getChildNodes().item(1).getTextContent();
         						Pais _paisE = Pais.valueOf(children2.getChildNodes().item(3).getTextContent());
         						int _ranking = Byte.parseByte(children2.getChildNodes().item(5).getTextContent());
         						
         						Dt dt = null;
         						jugadoresEquipo.clear(); 
         						
         						NodeList listaChildren2 = children2.getChildNodes().item(7).getChildNodes(); 
         						//entramos a plantel: jugadores y dt
         						for (int k=1; k<listaChildren2.getLength(); k+=2) {
         							
         							Node children3 = listaChildren2.item(k); //jugadores o dt
         							
         							if (children3.getNodeName() == "jugadores") {
         								
         								NodeList listaChildren3 = children3.getChildNodes(); //entro a jugador
         								
         								for (int l=1; l<listaChildren3.getLength(); l+=2) {
         									
         										
         										Node children4 = listaChildren3.item(l); 
         										
         										Posicion _posicion = null;
     											Byte _puntuacion = 0;
     											String _tipoDocumento = "";
     											int _nroDocumento = 0;
     											String _nombreApellido = "";
     											String _nombre = "";
     											String _apellido = "";
     											LocalDate _fecha = null;
     											
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
     											Jugador jugador = new Jugador(_apellido, _nombre, _fecha, _tipoDocumento, _nroDocumento, _posicion, _puntuacion);
 												
     											jugadoresEquipo.add(jugador);
 												jugadores.add(jugador);
         									
         								}
         							} else if (children3.getNodeName() == "dt") {
         								
         								NodeList listaChildren3 = children3.getChildNodes(); //entras al dt
										NodeList children4 = listaChildren3.item(1).getChildNodes(); //entras a persona
										
										String _tipoDocumento = children4.item(1).getTextContent(); //tipo doc
										int _nroDocumento = Integer.parseInt(children4.item(3).getTextContent());
										String _nombreApellido = children4.item(5).getTextContent();
										String _apellido = _nombreApellido.substring(0, _nombreApellido.indexOf(" "));
										String _nombre = _nombreApellido.substring(_nombreApellido.indexOf(" ")+1);
										LocalDate _fecha = LocalDate.parse(children4.item(7).getTextContent(), formato);
										
										Pais _pais = null; Byte _titulos = 0;
										
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
         						//Equipo e = new Equipo(_nombreE, _paisE, _ranking, jugadoresEquipo, dt);
             					equipos.add(new Equipo(_nombreE, _paisE, _ranking, jugadoresEquipo, dt));
         						
         					}
         			}
         			
         		         		
         		} else if (nodo.getNodeName() == "arbitros") {
         			
         			NodeList _arbitro = nodo.getChildNodes();
         			for (int n= 1; n<_arbitro.getLength(); n=n+2) { //pasamos por todos los arbitros
         				
         				NodeList children7 = _arbitro.item(n).getChildNodes(); //persona
         				NodeList children8 = children7.item(1).getChildNodes();
         				
         				String _tipoDoc = children8.item(1).getTextContent();
         				int _nroDoc = Integer.parseInt(children8.item(3).getTextContent());
         				String _nombreApellido = children8.item(5).getTextContent();
         				String _apellido = _nombreApellido.substring(0, _nombreApellido.indexOf(" "));
						String _nombre = _nombreApellido.substring(_nombreApellido.indexOf(" ")+1);
						LocalDate _fecha = LocalDate.parse(children8.item(7).getTextContent(), formato);
						
						Pais _pais = Pais.valueOf(children7.item(3).getTextContent());
						int _anios = Integer.parseInt(children7.item(5).getTextContent());
						
						Referi referi = new Referi (_apellido, _nombre, _fecha, _nroDoc, _tipoDoc, _pais, _anios);
						referis.add(referi);
         			}     			
         		}
        }
	}
}
