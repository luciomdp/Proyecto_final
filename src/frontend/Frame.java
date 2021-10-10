package frontend;

import javax.swing.border.*;
import javax.swing.table.*;

import proyecto_final.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.Serializable;
/*
 * Poner que informacion sea el ultimo panel siempre
 * Cambiar el width de general para que siempre sea aprox el mismo
 * Aplicar herencia entre cuartos, semis y final
 * Poner en rojo los equipos que no hayan pasado
 * doble click inicia torneo
 * tiene que implementar serializable?*/

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
		
		//-------------------------------------------------<<AGREGO LAS PESTA�AS INFORMACION Y ZONA>>-------------------------------------------------
		
		tabbedPane.addTab("Zona", null, zona, null);
		tabbedPane.addTab("Informacion", null, info, null);
	}
	
	//-------------------------------------------------<<METODOS DE SIMULACION FINALIZADA>>-------------------------------------------------
	
	public void ZtodoSimulado() {
		
		cuartos.InicializaVariables();
		zona.getSimula_todo().setEnabled(false);
		//JOptionPane.showMessageDialog(this, "Terminaron las fases de grupos");
		tabbedPane.remove(tabbedPane.indexOfTab("Informacion"));
		tabbedPane.addTab("Cuartos", null, cuartos, null);
		tabbedPane.addTab("Informacion", null, info, null);
		
	}
	public void ZonaSimulada(int nrozona) {
		zona.ZonaSimulada(nrozona);
	}
	public void CtodoSimulado(int i) {
		if(i == 0)
			cuartos.CuartosSimuladoIda();
		else {
			cuartos.CuartosSimulado();
			semis.InicializaVariables();
			//JOptionPane.showMessageDialog(this, "Terminaron los cuartos de final");
			tabbedPane.remove(tabbedPane.indexOfTab("Informacion"));
			tabbedPane.addTab("Semifinales", null, semis, null);
			tabbedPane.addTab("Informacion", null, info, null);
		}
			
	}
	public void StodoSimulado(int i) {
		if(i == 0)
			semis.SemisSimuladaIda();
		else {
			semis.SemisSimulada();
			fin.InicializaVariables();
			//JOptionPane.showMessageDialog(this, "Terminaron las semifinales");
			tabbedPane.remove(tabbedPane.indexOfTab("Informacion"));
			tabbedPane.addTab("Final", null, fin, null);
			tabbedPane.addTab("Informacion", null, info, null);

		}
			
	}
	public void FtodoSimulado() {
		fin.FinalSimulada();
	}
}