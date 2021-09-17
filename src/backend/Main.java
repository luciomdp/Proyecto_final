package backend;
//modificar esto (importar solo lo necesario)
import java.io.File;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
		ArrayList<Jugador> jugadoresEquipo = new ArrayList <Jugador>(18); 

		//EQUIPO
		String _nombreE = "";
		Pais _paisE = null;
		int _ranking = 0;
		Equipo e;
		
		//plantel
		Jugador _jugador;
		Dt _dt = null;
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
		
		Node equiposArbitros;
		NodeList listaEquiposArbitros;
		Node equipo;
		NodeList plantel;
		NodeList _jugadores;
		Node player;
		NamedNodeMap playerAtributos;
		NodeList persona;
		NodeList dt;
		
		final NodeList children = _raiz.getChildNodes(); //aca sacamos equipos y arbitros

			equiposArbitros = children.item(1); 	//sacamos equipos o arbitros
			listaEquiposArbitros = equiposArbitros.getChildNodes(); //lista de equipo's
			for (int j = 1; j < listaEquiposArbitros.getLength(); j += 2) { //esto itera 16 veces
					
					jugadoresEquipo.clear(); //esta bien aca?

					equipo = listaEquiposArbitros.item(j); //agarramos un equipo 
					
					_nombreE = equipo.getChildNodes().item(1).getTextContent();
					_paisE = Pais.valueOf(equipo.getChildNodes().item(3).getTextContent());
					_ranking = Byte.parseByte(equipo.getChildNodes().item(5).getTextContent());
					plantel = equipo.getChildNodes().item(7).getChildNodes(); //agarramos plantel
					
					e = new Equipo(_nombreE, _paisE, _ranking, jugadoresEquipo, _dt);

					_jugadores = plantel.item(1).getChildNodes(); //entro a jugadores
					for (int l = 1; l < _jugadores.getLength(); l += 2) { //iteramos 18 veces

						player = _jugadores.item(l);		//agarramos un jugador
						//Agarramos los atributos del jugador
						playerAtributos = player.getAttributes();
						_posicion = Posicion.valueOf(playerAtributos.getNamedItem("posicion").getNodeValue()); 
						_puntuacion = Byte.parseByte(playerAtributos.getNamedItem("puntuacion").getNodeValue());

						persona = player.getChildNodes().item(1).getChildNodes();
						_tipoDocumento = persona.item(1).getTextContent(); 
						_nroDocumento = Integer.parseInt(persona.item(3).getTextContent());
						_nombreApellido = persona.item(5).getTextContent();
						_apellido = _nombreApellido.substring(0, _nombreApellido.indexOf(" "));
						_nombre = _nombreApellido.substring(_nombreApellido.indexOf(" ")+1);
						_fecha = LocalDate.parse(persona.item(7).getTextContent(), formato);

						//aca creamos el jugador;
						_jugador = new Jugador(_apellido, _nombre, _fecha, _tipoDocumento, _nroDocumento, _posicion, _puntuacion);
						jugadoresEquipo.add(_jugador);
						jugadores.add(_jugador);
					
					}
					
					e.setJugadores(jugadoresEquipo);

					//entras a hijos de DT	
					dt = plantel.item(3).getChildNodes();	

					_tipoDocumento = dt.item(1).getChildNodes().item(1).getTextContent();
					_nroDocumento = Integer.parseInt(dt.item(1).getChildNodes().item(3).getTextContent());
					_nombreApellido = dt.item(1).getChildNodes().item(5).getTextContent();
					_apellido = _nombreApellido.substring(0, _nombreApellido.indexOf(" "));
					_nombre = _nombreApellido.substring(_nombreApellido.indexOf(" ")+1);
					_fecha = LocalDate.parse(dt.item(1).getChildNodes().item(7).getTextContent(), formato);

					_pais = Pais.valueOf(dt.item(3).getTextContent());			
					_titulos = Byte.parseByte(dt.item(5).getTextContent());

					_dt = new Dt (_apellido, _nombre, _fecha, _nroDocumento, _tipoDocumento, _pais, _titulos);
					e.setEntrenador(_dt);
					
					//aca falla
					
					equipos.add(e);
					for (Jugador o: jugadoresEquipo) {
						System.out.println(o.getApellido());
					}
					for (int z = 0; z < equipos.size(); z++) {
						System.out.println(equipos.get(z).getJugadores().get(0).getApellido());
					}
					
				} //for de equipos
				
				equiposArbitros = children.item(3);
				listaEquiposArbitros = equiposArbitros.getChildNodes();
				for (int n = 1; n < listaEquiposArbitros.getLength(); n += 2) { //pasamos por todos los arbitros

					NodeList children7 = listaEquiposArbitros.item(n).getChildNodes(); //persona -> este itera
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
			 //if de arbitros o equipos
		//for de torneo
	}//metodo
}//clase
