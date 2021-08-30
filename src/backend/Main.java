package backend;

import java.io.*;
import java.util.*;

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

public class Main {	
	
	static ArrayList <Jugador> jugadores = new ArrayList <Jugador>();
	static ArrayList <Equipo> equipos = new ArrayList <Equipo>();
	static ArrayList <Referi> referis = new ArrayList <Referi>();
	
	public static void main (String[] args) throws NumberFormatException, ParseException {
				
		try {
			
			File archivo = new File ("torneo.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(archivo);
			doc.getDocumentElement().normalize();
			
			
			System.out.println(doc.getDocumentElement().getNodeName());
			Element raiz = doc.getDocumentElement();
			leeArchivo(raiz);
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		Campeonato torneo = new Campeonato (equipos, jugadores, referis);
		Frame vista = new Frame ();
		Controlador control = new Controlador (torneo, vista);
		vista.setControlador(control);
		torneo.setControlador(control);
		
	}	
	public static void leeArchivo(Element _raiz) {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        final NodeList children = _raiz.getChildNodes(); //aca sacamos equipos y arbitros
        
        for (int i=0; i<children.getLength(); i++) { //aca iteramos dos veces
        	
        	final Node nodo = children.item(i); //sacamos equipos o arbitros
        	
        	if (nodo.getNodeType() == Node.ELEMENT_NODE) { //nos fijamos si es un nodo

        		if (nodo.getNodeName() == "equipos") { //agarramos equipos
         			
         			NodeList listaChildren = nodo.getChildNodes(); //lista de equipo's
         			
         			for (int j = 0; j<listaChildren.getLength(); j++) { 
         				
         				Node children2 = listaChildren.item(j); //agarramos un equipo
         				
         				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
         					
         					if (children2.getNodeName() == "equipo") { 
         						
         						System.out.println(children2.getNodeName());
         						//1-nombre; 3-pais; 5-ranking
         						String _nombreE = children2.getChildNodes().item(1).getTextContent();
         						Pais _paisE = Pais.valueOf(children2.getChildNodes().item(3).getTextContent());
         						int _ranking = Byte.parseByte(children2.getChildNodes().item(5).getTextContent());
         						
         						Dt dt = null;
         						jugadores.clear(); 
         						
         						NodeList listaChildren2 = children2.getChildNodes().item(7).getChildNodes(); 
         						//entramos a plantel: jugadores y dt
         						for (int k=0; k<listaChildren2.getLength(); k++) {
         							
         							Node children3 = listaChildren2.item(k); //jugadores o dt
         							
         							if (children3.getNodeName() == "jugadores") {
         								
         								NodeList listaChildren3 = children3.getChildNodes(); //entro a jugador
         								for(int l = 0; l<listaChildren3.getLength(); l++) {
         									
         									if (l%2 !=0) { //tira dos valores por nodo. no sabemos porqué :)
         										
         										Node children4 = listaChildren3.item(l); 
         										for (int m=0; m<2; m++) {
         											
         											Posicion _posicion = null; Byte _puntuacion = 0;
         											
         											if (m == 0) {
         												NamedNodeMap att = listaChildren3.item(l).getAttributes();
             											_posicion = Posicion.valueOf(att.getNamedItem("posicion").getNodeValue()); 
         												_puntuacion = Byte.parseByte(att.getNamedItem("puntuacion").getNodeValue());
         												
         											} else {
         												
         												NodeList listaChildren5 = children4.getChildNodes();
         												NodeList children5 = listaChildren5.item(1).getChildNodes();
         												         										
         												String _tipoDocumento = children5.item(1).getTextContent(); //tipo doc
         												int _nroDocumento = Integer.parseInt(children5.item(3).getTextContent());
         												String _nombreApellido = children5.item(5).getTextContent();
         												String _nombre = _nombreApellido.substring(0, _nombreApellido.indexOf(" ")-1);
         												String _apellido = _nombreApellido.substring(_nombreApellido.indexOf(" ")+1);
         												LocalDate _fecha = LocalDate.parse(children5.item(7).getTextContent(), formato);
         												
         												Jugador jugador = new Jugador(_apellido, _nombre, _fecha, _tipoDocumento, _nroDocumento, _posicion, _puntuacion);
         												jugadores.add(jugador);
         											}
         										}
         									}
         								}
         							} else if (children3.getNodeName() == "dt") {
         								
         								NodeList listaChildren3 = children3.getChildNodes(); //entras al dt
										NodeList children4 = listaChildren3.item(1).getChildNodes(); //entras a persona
										
										String _tipoDocumento = children4.item(1).getTextContent(); //tipo doc
										int _nroDocumento = Integer.parseInt(children4.item(3).getTextContent());
										String _nombreApellido = children4.item(5).getTextContent();
										String _nombre = _nombreApellido.substring(0, _nombreApellido.indexOf(" ")-1);
										String _apellido = _nombreApellido.substring(_nombreApellido.indexOf(" ")+1);
										LocalDate _fecha = LocalDate.parse(children4.item(7).getTextContent(), formato);
										
										Pais _pais = null; Byte _titulos = 0;
										
										for (int n = 3; n<=5; n+=2) {
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
         						
         						
         						Equipo e = new Equipo(_nombreE, _paisE, _ranking, jugadores, dt);
         						System.out.println(e.toString());
         						//ArrayList equipos.push
         						
         					}
         				}
                  				
         			}
         			
         				
         			//System.out.println(nodo.getNodeName() + ": " + (!nodo.hasChildNodes() ? "" : nodo.getTextContent()));
         		
         		
         		} else if (nodo.getNodeName() == "arbitros") {
         			
         			
         			
         		}
		 	}
        	
        }
	}
}




