package frontend;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import proyecto_final.Controlador;

public class FrontZonas extends General{
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private final Color COLOR_FONDO_ZONA = new Color(38, 190, 35);
	private final Color COLOR_ZONA = COLOR_PANEL_N;
		
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
		
	private JButton Simula_todo;
	private JPanel ZpanelN;
	private panelZ ZpanelC;
	private JPanel Zpanel12;
	private JPanel Zpanel34;
	private ZComboBox ZcomboBox1;
	private ZComboBox ZcomboBox2;
	private ZComboBox ZcomboBox3;
	private ZComboBox ZcomboBox4;
	private Zona Zona1;
	private Zona Zona2;
	private Zona Zona3;
	private Zona Zona4;
	
	public FrontZonas(Controlador c){
				
		//-------------------------------------------------<<SETEO CONTROLADOR Y LAYOUT>>-------------------------------------------------
		
		setControl(c);		
		setLayout(new BorderLayout(0, 0));

		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
		
		Simula_todo = new JButton("Simular todas las zonas");
		ZpanelN = new JPanel();
		Zpanel12 = new JPanel();
		Zpanel34 = new JPanel();
		ZpanelC = new panelZ();
		ZcomboBox1 = new ZComboBox(0);
		ZcomboBox2 = new ZComboBox(1);
		ZcomboBox3 = new ZComboBox(2);
		ZcomboBox4 = new ZComboBox(3);
		Zona1 = new Zona(0,getControlador());
		Zona2 = new Zona(1,getControlador());
		Zona3 = new Zona(2,getControlador());
		Zona4 = new Zona(3,getControlador());
				
		//-------------------------------------------------<<SETEO VARIABLES>>-------------------------------------------------
		
		Zpanel12.setLayout(new BorderLayout());
		Zpanel34.setLayout(new BorderLayout());
		ZpanelN.setBackground(COLOR_PANEL_N);
		
		Simula_todo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  getControlador().SimulaZonas();
				  Zona1.getPanel_texto().setText(getControlador().getZona(0));
				  Zona2.getPanel_texto().setText(getControlador().getZona(1));
				  Zona3.getPanel_texto().setText(getControlador().getZona(2));
				  Zona4.getPanel_texto().setText(getControlador().getZona(3));
			}
		});
		
		//-------------------------------------------------<<AÑADO A LA ZONA>>-------------------------------------------------
		
		ZpanelN.add(ZcomboBox1);
		ZpanelN.add(ZcomboBox2);
		ZpanelN.add(ZcomboBox3);
		ZpanelN.add(ZcomboBox4);
		ZpanelN.add(Simula_todo);
		Zpanel12.add(Zona1,BorderLayout.WEST);
		Zpanel12.add(Box.createHorizontalStrut(CANCHA_TAMANO_CIRCULO_C));
		Zpanel12.add(Zona2,BorderLayout.EAST);
		Zpanel34.add(Zona3,BorderLayout.WEST);
		Zpanel34.add(Box.createHorizontalStrut(CANCHA_TAMANO_CIRCULO_C));
		Zpanel34.add(Zona4,BorderLayout.EAST);
		ZpanelC.add(Box.createVerticalStrut(CANCHA_TAMANO_RECT_G));
		ZpanelC.add(Zpanel12);
		ZpanelC.add(Zpanel34);
		add(ZpanelN, BorderLayout.NORTH);
		add(ZpanelC, BorderLayout.CENTER);			
		
	}

	//-------------------------------------------------<<METODOS DE CLASE>>-------------------------------------------------

	public void ZonaSimulada(int zona) {
		getCombo(zona).setSelectedIndex(0);
		getCombo(zona).setEnabled(false);
	}
	
	//-------------------------------------------------<<CLASES INTERNAS>>-------------------------------------------------
	
	private class panelZ extends General {
		panelZ () {
			super.paint(getGraphics());
			setBackground(COLOR_FONDO_ZONA);
		}
	}
	private class Zona extends JPanel{
		private JButton Partidos;
		private JTextPane Panel_texto;
		Zona(int NroZona,Controlador c) {
			setLayout(new BorderLayout());
			Panel_texto = new JTextPane();
			Panel_texto.setFont(new Font(FONT_TYPE,0,FONT_SIZE));
			Panel_texto.setForeground(COLOR_LETRA);
			Panel_texto.setBackground(COLOR_ZONA);
			Panel_texto.setEditable(false);
			Partidos = new JButton ("Ver partidos");
			Partidos.setBackground(COLOR_ZONA);
			Partidos.setForeground(COLOR_LETRA);
			Partidos.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					new FramePartidos(NroZona,c);
				}	
			});
			add(Panel_texto,BorderLayout.CENTER);
			add(Partidos,BorderLayout.SOUTH);
		}
		
		public JButton getPartidos() {
			return Partidos;
		}
		public JTextPane getPanel_texto() {
			return Panel_texto;
		}
	}
	private class ZComboBox extends JComboBox <String> {
		ZComboBox(int zona) {
			setEditable(false);
			addItem("Zona " + (zona + 1));
			addItem("Simula un partido");
			addItem("Simula una fecha");
			addItem("Simula una zona");
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if((String)getSelectedItem() == "Simula un partido") {
							getControlador().SimulaPartidoZ(zona);
							getZona(zona).getPanel_texto().setText(getControlador().getZona(zona));
					}else {
						if((String)getSelectedItem() == "Simula una fecha") {
							getControlador().SimulaFechaZ(zona);
							getZona(zona).getPanel_texto().setText(getControlador().getZona(zona));
						}else 
							if((String)getSelectedItem() == "Simula una zona") {
								getControlador().SimulaZonaZ(zona);
								getZona(zona).getPanel_texto().setText(getControlador().getZona(zona));
							}
					}
				}
			});
		}
	}
	
	private class FramePartidos extends JFrame {
		
		final int ESPACIO_VERTICAL = 30;
		
		JScrollPane PanelScroll;
		JPanel Panel;
		FrontPartido Partidos [];
		String E1[],E2[];
		int PJ;
		Box VBox;
		FramePartidos(int zona,Controlador c) {
			Toolkit MiPantalla = Toolkit.getDefaultToolkit();
			Image imagen = MiPantalla.getImage("Src/frontend/icono.png");
			PJ = c.CantPJZona(zona);
			E1 = c.getE1Zona(zona);
			E2 = c.getE2Zona(zona);
			Panel = new JPanel();
			PanelScroll = new JScrollPane();
			Partidos = new FrontPartido [PJ];
			VBox = Box.createVerticalBox();
			
			setTitle("Partidos de la zona " + (zona+1));
			setIconImage(imagen);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(450,600);
			setResizable(false);
			setLocationRelativeTo(null);
			Panel.setBackground(COLOR_PANEL_C);
			
			//Panel.setLayout(new FlowLayout(FlowLayout.LEFT)); ACTIVAR SI SE PREFIERE A LA IZQUIERDA LOS PARTIDOS
			
			PanelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			for(int i = 0; i < PJ; i++) {
				Partidos[i] = new FrontPartido(c,zona);
				Partidos[i].setText(E1[i], E2[i]);
				Partidos[i].SetFontSizeIncr(8);
				VBox.add(Box.createVerticalStrut(ESPACIO_VERTICAL));
				VBox.add(Partidos[i]);
			}
			Panel.add(VBox);
			PanelScroll.setViewportView(Panel);
			add(PanelScroll);
			
			setVisible(true);
		}
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	public void setZona1(String texto) {
		Zona1.getPanel_texto().setText(texto);
	}
	public void setZona2(String texto) {
		Zona2.getPanel_texto().setText(texto);
	}
	public void setZona3(String texto) {
		Zona3.getPanel_texto().setText(texto);
	}
	public void setZona4(String texto) {
		Zona4.getPanel_texto().setText(texto);
	}
	public Zona getZona(int zona) {
		if(zona == 0) {
			return Zona1;
		}else {
			if(zona == 1) {
				return Zona2;
			}else {
				if(zona == 2)
					return Zona3;
				else 
					return Zona4;
			}
		}
	}
	public ZComboBox getCombo(int combo) {
		if(combo == 0) {
			return ZcomboBox1;
		}else {
			if(combo == 1) {
				return ZcomboBox2;
			}else {
				if(combo == 2)
					return ZcomboBox3;
				else 
					return ZcomboBox4;
			}
		}
	}
	
	public JButton getSimula_todo() {
		return Simula_todo;
	}
	
}
