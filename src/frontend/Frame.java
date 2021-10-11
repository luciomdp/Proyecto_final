package frontend;

import javax.swing.border.*;
import javax.swing.table.*;

import proyecto_final.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.Serializable;


public class Frame extends JFrame{
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private Inicio inicio;
	private FrontZonas zona;
	private FrontCuartos cuartos;
	private FrontSemis semis;
	private FrontFinal fin;
	private Informacion info;
	
	/**
	 * Crea e inicializa el frame.
	 */
	public Frame() {
		
		Toolkit MiPantalla = Toolkit.getDefaultToolkit();
		Image imagen = MiPantalla.getImage("Src/frontend/icono.png");
		setTitle("Proyecto final en Java: Torneo de futbol");
		setIconImage(imagen);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100,1003,567);
		setResizable(false);
		setLocationRelativeTo(null);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane = new JPanel();
		inicio = new Inicio();
		tabbedPane.addTab("Inicio", null, inicio, null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(tabbedPane);
		setContentPane(contentPane);
		setVisible(true);
	}
	/**
	 * Pasa el controlador a todos los paneles del frame.
	 * @param c, el controlador.
	 */
	public void setControlador (Controlador c) {
		inicio.AccionaBotones(c);
		zona = new FrontZonas(c);
		cuartos = new FrontCuartos(c);
		semis = new FrontSemis(c);
		fin = new FrontFinal(c);
		info = new Informacion(c);
	}
	public void IniciaTorneo(String Zonas[]) { //SE PASA POR PARAMETRO LO QUE SEA NECESARIO PARA DARLE STRINGS A LAS ETIQUETAS DEL VISUAL 
		
		zona.setZona1(Zonas[0]);
		zona.setZona2(Zonas[1]);
		zona.setZona3(Zonas[2]);
		zona.setZona4(Zonas[3]);
		
		//-------------------------------------------------<<AGREGO LAS PESTAÑAS INFORMACION Y ZONA>>-------------------------------------------------
		
		tabbedPane.addTab("Zona", null, zona, null);
		tabbedPane.addTab("Informacion", null, info, null);
	}
	
	//-------------------------------------------------<<METODOS DE SIMULACION FINALIZADA>>-------------------------------------------------
	
	public void ZtodoSimulado() {
		
		cuartos.InicializaVariables();
		zona.getSimula_todo().setEnabled(false);
		tabbedPane.remove(tabbedPane.indexOfTab("Informacion"));
		tabbedPane.addTab("Cuartos", null, cuartos, null);
		tabbedPane.addTab("Informacion", null, info, null);
		
	}
	public void ZonaSimulada(int nrozona) {
		zona.ZonaSimulada(nrozona);
	}
	public void CtodoSimulado(int i,int G1,int G2,int G3,int G4) {
		if(i == 0)
			cuartos.CuartosSimuladoIda();
		else {
			cuartos.CuartosSimulado(G1,G2,G3,G4);
			semis.InicializaVariables();
			tabbedPane.remove(tabbedPane.indexOfTab("Informacion"));
			tabbedPane.addTab("Semifinales", null, semis, null);
			tabbedPane.addTab("Informacion", null, info, null);
		}
			
	}
	public void StodoSimulado(int i,int G1,int G2) {
		if(i == 0)
			semis.SemisSimuladaIda();
		else {
			semis.SemisSimulada(G1,G2);
			fin.InicializaVariables();
			tabbedPane.remove(tabbedPane.indexOfTab("Informacion"));
			tabbedPane.addTab("Final", null, fin, null);
			tabbedPane.addTab("Informacion", null, info, null);

		}
			
	}
	public void FtodoSimulado(int G) {
		fin.FinalSimulada(G);
	}
}