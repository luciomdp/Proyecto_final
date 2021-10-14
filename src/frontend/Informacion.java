package frontend;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

import backend.Posicion;
import proyecto_final.Controlador;


public class Informacion extends General{
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private final Dimension DIMENSION_PANELES_INFO = new Dimension(15,75);
		
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
		
	private Box IFbox;
	private Box IFboxPPAL;
	private JButtonIF Listado_equipos;
	private JButtonIF Ranking_referis;
	private JButtonIF Listado_jugadores;
	private IFpanel_E PanelE;
	private IFpanel_J PanelJ;
	private IFpanel_R PanelR;
	private JPanel IFpanelBotonera;
	
	public Informacion (Controlador c){
		
		setControl(c);
				
		//-------------------------------------------------<<SETEO BACK Y LAYOUT>>-------------------------------------------------
		
		setBackground(COLOR_INFORMACION);	

		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
		
		IFpanelBotonera = new JPanel();
		IFbox = Box.createVerticalBox();
		IFboxPPAL = Box.createVerticalBox();
		PanelE = new IFpanel_E();
		PanelJ = new IFpanel_J();
		PanelR = new IFpanel_R();
		
		Listado_equipos = new JButtonIF("Listado de equipos",new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				PanelR.Desactiva();
				PanelE.Activa();
				PanelJ.Desactiva();
			}
			
		});
		Ranking_referis = new JButtonIF("Ranking de referis",new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				PanelR.Activa();
				PanelE.Desactiva();
				PanelJ.Desactiva();
			}
			
		});
		Listado_jugadores = new JButtonIF("Listado de jugadores",new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				PanelR.Desactiva();
				PanelE.Desactiva();
				PanelJ.Activa();
			}
			
		});
		
		//-------------------------------------------------<<AÑADO A LA INFORMACION>>-------------------------------------------------
		
		IFbox.add(Listado_equipos);
		IFbox.add(Box.createVerticalStrut(TAM_BTTN.height/4));
		IFbox.add(Ranking_referis);
		IFbox.add(Box.createVerticalStrut(TAM_BTTN.height/4));
		IFbox.add(Listado_jugadores);
		IFpanelBotonera.add(IFbox);
		IFpanelBotonera.setBackground(COLOR_INFORMACION);
		IFboxPPAL.add(Box.createVerticalStrut(HEIGHT/4-CANT_BTN*TAM_BTTN.height));
		IFboxPPAL.add(IFpanelBotonera,BorderLayout.NORTH);
		PanelE.Activa();
		IFboxPPAL.add(PanelE,BorderLayout.CENTER);
		IFboxPPAL.add(PanelJ,BorderLayout.CENTER);
		IFboxPPAL.add(PanelR,BorderLayout.CENTER);
		add(IFboxPPAL);
			
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(COLOR_LETRA);
			g2.draw(new Line2D.Double(getWidth()/16,getHeight(),getWidth()/16,0));
			g2.draw(new Line2D.Double(getWidth()-getWidth()/16,getHeight(),getWidth()-getWidth()/16,0));
	}
	
	private abstract class IFpanel extends JPanel { 
		private JTextArea area;
		private JScrollPane panel_area;
		private JButton boton_muestra;
		IFpanel() {
			setLayout(new BorderLayout());
			setBackground(Color.GRAY);
			area = new JTextArea(DIMENSION_PANELES_INFO.width,DIMENSION_PANELES_INFO.height);
			area.setEditable(false);
			panel_area = new JScrollPane(area);
			boton_muestra = new JButton();
			boton_muestra.setForeground(COLOR_LETRA);
			boton_muestra.setBackground(COLOR_BOTONES_2);
			add(panel_area,BorderLayout.CENTER);
			setVisible(false);
		}
	
		public void Desactiva () {
			setVisible(false);
		}
		public void Activa () {
			setVisible(true);
		}
		public JButton getBoton_muestra() {
			return boton_muestra;
		}
		public JTextArea getArea() {
			return area;
		}

	}
	private class IFpanel_E extends IFpanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5076033681079441032L;
		//panel que se muestra si se pide un listado de equipos
		IFpanel_E() {
			super();
			getBoton_muestra().setText("Mostrar equipos");
			add(getBoton_muestra(),BorderLayout.NORTH);
			setBorder(BorderFactory.createTitledBorder("Listado de equipos"));
			getBoton_muestra().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getArea().setText(getControlador().getListadoEquipos());
				}		
			});
		}
	}
	
	private class IFpanel_J extends IFpanel {
		private JComboBox <Posicion> IFpos;
		private JPanel panel_botonera;
		/**
		 * 
		 */
		private static final long serialVersionUID = -5076033681079441032L;
		//panel que se muestra si se pide un listado de equipos
		
		IFpanel_J() {
			super();
			IFpos = new JComboBox<Posicion>();
			getBoton_muestra().setText("Mostrar jugadores");
			panel_botonera = new JPanel();
			panel_botonera.setLayout(new BorderLayout());
			IFpos.addItem(Posicion.arquero);
			IFpos.addItem(Posicion.defensor);
			IFpos.addItem(Posicion.mediocampista);
			IFpos.addItem(Posicion.delantero);
			panel_botonera.add(IFpos,BorderLayout.WEST);
			panel_botonera.add(getBoton_muestra(),BorderLayout.CENTER);
			add(panel_botonera,BorderLayout.NORTH);
			setBorder(BorderFactory.createTitledBorder("Listado de jugadores"));
			getBoton_muestra().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getArea().setText(getControlador().getListadoJugadores((Posicion)IFpos.getSelectedItem()));
				}
			});
		}
		
	}
	private class IFpanel_R extends IFpanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5076033681079441032L;
		//panel que se muestra si se pide un listado de equipos
		IFpanel_R() {
			super();
			getBoton_muestra().setText("Listar referis");
			add(getBoton_muestra(),BorderLayout.NORTH);
			setBorder(BorderFactory.createTitledBorder("Ranking de referis"));
			getBoton_muestra().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getArea().setText(getControlador().getListadoArbitros());
				}
			});
		}
		
	}
	private class JButtonIF extends JButton {
		
		JButtonIF(String s,ActionListener L) {
			super(s);
			setMinimumSize(TAM_BTTN);
			setPreferredSize(TAM_BTTN);
			setMaximumSize(TAM_BTTN);
			setBackground(COLOR_BOTONES);
			setForeground(COLOR_LETRA);
			setFont(new Font(FONT_TYPE,0,FONT_SIZE));
			addActionListener(L);
		}
	}
}
