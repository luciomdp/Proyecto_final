package frontend;
import java.awt.*;
import javax.swing.*;

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
	private JComboBox<String> ZcomboBox1;
	private JComboBox<String> ZcomboBox2;
	private JComboBox<String> ZcomboBox3;
	private JComboBox<String> ZcomboBox4;
	private Zona Zona1;
	private Zona Zona2;
	private Zona Zona3;
	private Zona Zona4;
	
	//private Controlador c;
	public Zonas(){//Zona(Controlador c)
		//this.c = c;
				
		//-------------------------------------------------<<SETEO BACK Y LAYOUT>>-------------------------------------------------
				
		setLayout(new BorderLayout(0, 0));

		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
		
		Simula_todo = new JButton("Simular todas las zonas");
		ZpanelN = new JPanel();
		Zpanel12 = new JPanel();
		Zpanel34 = new JPanel();
		ZpanelC = new panelZ();
		ZcomboBox1 = new JComboBox<String>();
		ZcomboBox2 = new JComboBox<String>();
		ZcomboBox3 = new JComboBox<String>();
		ZcomboBox4 = new JComboBox<String>();
		Zona1 = new Zona();
		Zona2 = new Zona();
		Zona3 = new Zona();
		Zona4 = new Zona();
				
		//-------------------------------------------------<<SETEO VARIABLES>>-------------------------------------------------
		
		Zpanel12.setLayout(new BorderLayout());
		Zpanel34.setLayout(new BorderLayout());
		ZpanelN.setBackground(COLOR_PANEL_N);
		Zona1.setText("ZONA 1\nEquipo    PG PE PP DG \nEquipo 1 | 2 | 1 | 0 | 4 \nEquipo 2 | 1 | 2 | 0 | 2\nEquipo 3 | 1 | 1 | 1 | 1\nEquipo 4 | 0 | 1 | 2 | -2");
		Zona2.setText("ZONA 2\nEquipo    PG PE PP DG \nEquipo 1 | 2 | 1 | 0 | 4 \nEquipo 2 | 1 | 2 | 0 | 2\nEquipo 3 | 1 | 1 | 1 | 1\nEquipo 4 | 0 | 1 | 2 | -2");
		Zona3.setText("ZONA 3\nEquipo    PG PE PP DG \nEquipo 1 | 2 | 1 | 0 | 4 \nEquipo 2 | 1 | 2 | 0 | 2\nEquipo 3 | 1 | 1 | 1 | 1\nEquipo 4 | 0 | 1 | 2 | -2");
		Zona4.setText("ZONA 4\nEquipo    PG PE PP DG \nEquipo 1 | 2 | 1 | 0 | 4 \nEquipo 2 | 1 | 2 | 0 | 2\nEquipo 3 | 1 | 1 | 1 | 1\nEquipo 4 | 0 | 1 | 2 | -2");
		
		ZcomboBox1.setEditable(false);
		ZcomboBox1.addItem("Zona 1");
		ZcomboBox1.addItem("Simula un partido");
		ZcomboBox1.addItem("Simula una fecha");
		ZcomboBox1.addItem("Simula una zona");
				
		ZcomboBox2.setEditable(false);
		ZcomboBox2.addItem("Zona 2");
		ZcomboBox2.addItem("Simula un partido");
		ZcomboBox2.addItem("Simula una fecha");
		ZcomboBox2.addItem("Simula una zona");
				
		ZcomboBox3.setEditable(false);
		ZcomboBox3.addItem("Zona 3");
		ZcomboBox3.addItem("Simula un partido");
		ZcomboBox3.addItem("Simula una fecha");
		ZcomboBox3.addItem("Simula una zona");
				
		ZcomboBox4.setEditable(false);
		ZcomboBox4.addItem("Zona 4");
		ZcomboBox4.addItem("Simula un partido");
		ZcomboBox4.addItem("Simula una fecha");
		ZcomboBox4.addItem("Simula una zona");
		
		//------------------------------Resolver panel central	
		
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
		//generar action listeners para los combo box y metodos para actualizar las tablas
	private class panelZ extends General {
		panelZ () {
			super.paint(getGraphics());
			setBackground(COLOR_FONDO_ZONA);
		}
	}
	private class Zona extends JTextPane{
		Zona(String s) {
			setText(s);
			setFont(new Font(FONT_TYPE,0,FONT_SIZE));
			setBackground(COLOR_ZONA);
		}
		Zona() {
			setFont(new Font(FONT_TYPE,0,FONT_SIZE));
			setBackground(COLOR_ZONA);
		}
	}
}
