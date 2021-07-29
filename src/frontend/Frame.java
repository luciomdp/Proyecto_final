package frontend;

import javax.swing.border.*;
import javax.swing.table.*;
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
		inicio = new Inicio();
		zona = new Zonas();
		cuartos = new Cuartos();
		semis = new Semifinales();
		fin = new Final();
		info = new Informacion();
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Inicio", null, inicio, null);
		tabbedPane.addTab("Zona", null, zona, null);
		tabbedPane.addTab("Cuartos", null, cuartos, null);
		tabbedPane.addTab("Semifinales", null, semis, null);
		tabbedPane.addTab("Final", null, fin, null);
		tabbedPane.addTab("Informacion", null, info, null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(tabbedPane);
		setContentPane(contentPane);
	}
}