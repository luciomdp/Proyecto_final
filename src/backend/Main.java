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
	
	static ArrayList <Jugador> jugadores;
	static ArrayList <Equipo> equipos;
	static ArrayList <Referi> referis; 
	
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
         						System.out.println(children2.getChildNodes().item(1).getTextContent());
         						//1-nombre; 3-pais; 5-ranking
         						
         						NodeList listaChildren2 = children2.getChildNodes().item(7).getChildNodes(); 
         						//entramos a plantel: jugadores y dt
         						for (int k=0; k<listaChildren2.getLength(); k++) {
         							
         							Node children3 = listaChildren2.item(k); //jugador
         							
         							if (children3.getNodeName() == "jugador") {
         								
         								//instanciar jugador
         								
         							} else if (children3.getNodeName() == "dt") {
         								
         								
         								
         							}
         							
         						}
         						
         						
         						
         						
         						
         						
         						
         						
         						//aca creamos el equipo con jugadores y dt
         						//Equipo e = new Equipo();
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




