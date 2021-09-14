package frontend;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import proyecto_final.Controlador;

public class Zonas extends General{
	
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
	
	public Zonas(Controlador c){
				
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
		Zona1 = new Zona();
		Zona2 = new Zona();
		Zona3 = new Zona();
		Zona4 = new Zona();
				
		//-------------------------------------------------<<SETEO VARIABLES>>-------------------------------------------------
		
		Zpanel12.setLayout(new BorderLayout());
		Zpanel34.setLayout(new BorderLayout());
		ZpanelN.setBackground(COLOR_PANEL_N);
		
		Simula_todo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  getControlador().SimulaZonas();
				  Zona1.setText(getControlador().getZona(0));
				  Zona2.setText(getControlador().getZona(1));
				  Zona3.setText(getControlador().getZona(2));
				  Zona4.setText(getControlador().getZona(3));
			}
		});
		
		//-------------------------------------------------<<AÑADO TODO A LA ZONA>>-------------------------------------------------
		
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
		ZpanelC.add(Zpanel12);
		ZpanelC.add(Zpanel34);
		add(ZpanelN, BorderLayout.NORTH);
		add(ZpanelC, BorderLayout.CENTER);			
		
	}

	//-------------------------------------------------<<METODOS DE CLASE>>-------------------------------------------------
	
	public void ZonaSimulada(int zona) {
		getCombo(zona).setEnabled(false);
	}
	
	//-------------------------------------------------<<CLASES INTERNAS>>-------------------------------------------------
	
	private class panelZ extends General {
		panelZ () {
			super.paint(getGraphics());
			setBackground(COLOR_FONDO_ZONA);
		}
	}
	private class Zona extends JTextPane{
		Zona() {
			setFont(new Font(FONT_TYPE,0,FONT_SIZE));
			setForeground(COLOR_LETRA);
			setBackground(COLOR_ZONA);
			setEditable(false);
		}
	}
	private class ZComboBox extends JComboBox<String> {
		ZComboBox(int zona) {
			setEditable(false);
			addItem("Zona " + zona);
			addItem("Simula un partido");
			addItem("Simula una fecha");
			addItem("Simula una zona");
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if((String)getSelectedItem() == "Simula un partido") {
							getControlador().SimulaPartidoZ(zona);
							getZona(zona).setText(getControlador().getZona(zona));
					}else {
						if((String)ZcomboBox1.getSelectedItem() == "Simula una fecha") {
							getControlador().SimulaFechaZ(zona);
							getZona(zona).setText(getControlador().getZona(zona));
						}else 
							if((String)ZcomboBox1.getSelectedItem() == "Simula una zona") {
								getControlador().SimulaZonaZ(zona);
								getZona(zona).setText(getControlador().getZona(zona));
							}
					}
				}
			});
		}
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	public void setZona1(String texto) {
		Zona1.setText(texto);
	}
	public void setZona2(String texto) {
		Zona2.setText(texto);
	}
	public void setZona3(String texto) {
		Zona3.setText(texto);
	}
	public void setZona4(String texto) {
		Zona4.setText(texto);
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
	
}
