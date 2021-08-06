package frontend;

import javax.swing.border.*;
import javax.swing.table.*;

import proyecto_final.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


public class Frame extends JFrame {
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private Inicio inicio;
	private Zonas zona;
	private Cuartos cuartos;
	private Semifinales semis;
	private Final fin;
	private Informacion info;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
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
	}
	public void setControlador (Controlador c) {
		inicio.AccionaBotones(c);
		zona = new Zonas(c);
		cuartos = new Cuartos(c);
		semis = new Semifinales(c);
		fin = new Final(c);
		info = new Informacion(c);
	}
	public void IniciaTorneo() { //SE PASA POR PARAMETRO LO QUE SEA NECESARIO PARA DARLE STRINGS A LAS ETIQUETAS DEL VISUAL 
		//SE USA PARA TODO (CONTINUA Y GUARDA)
		zona.setZona1("ZONA 1\nEquipo    PG PE PP DG \nEquipo 1 | 2 | 1 | 0 | 4 \nEquipo 2 | 1 | 2 | 0 | 2\nEquipo 3 | 1 | 1 | 1 | 1\nEquipo 4 | 0 | 1 | 2 | -2");
		zona.setZona2("ZONA 2\nEquipo    PG PE PP DG \nEquipo 1 | 2 | 1 | 0 | 4 \nEquipo 2 | 1 | 2 | 0 | 2\nEquipo 3 | 1 | 1 | 1 | 1\nEquipo 4 | 0 | 1 | 2 | -2");
		zona.setZona3("ZONA 3\nEquipo    PG PE PP DG \nEquipo 1 | 2 | 1 | 0 | 4 \nEquipo 2 | 1 | 2 | 0 | 2\nEquipo 3 | 1 | 1 | 1 | 1\nEquipo 4 | 0 | 1 | 2 | -2");
		zona.setZona4("ZONA 3\nEquipo    PG PE PP DG \nEquipo 1 | 2 | 1 | 0 | 4 \nEquipo 2 | 1 | 2 | 0 | 2\nEquipo 3 | 1 | 1 | 1 | 1\nEquipo 4 | 0 | 1 | 2 | -2");
		
		//-------------------------------------------------<<AGREGO LAS PESTAÑAS>>-------------------------------------------------
		
		tabbedPane.addTab("Zona", null, zona, null);
		tabbedPane.addTab("Cuartos", null, cuartos, null);
		tabbedPane.addTab("Semifinales", null, semis, null);
		tabbedPane.addTab("Final", null, fin, null);
		tabbedPane.addTab("Informacion", null, info, null);
	}
	
	//-------------------------------------------------<<METODOS DE SIMULACION FINALIZADA>>-------------------------------------------------
	
	public void ZtodoSimulado(int nrozona) {
		zona.ZonaSimulada(nrozona);
	}
	public void CtodoSimulado(int i) {
		if(i == 0)
			cuartos.CuartosSimuladoIda();
		else
			cuartos.CuartosSimulado();
	}
	public void StodoSimulado(int i) {
		if(i == 0)
			semis.SemisSimuladaIda();
		else
			semis.SemisSimulada();
	}
	public void FtodoSimulado() { //falta implementar cuando se cree la final
		fin.FinalSimulada();
	}
}