package frontend;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
		
		//----------------------------------------PANEL PRINCIPAL----------------------------------------
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		//----------------------------------------PESTAÑAS----------------------------------------
		
		JPanel Inicio = new JPanel();
		tabbedPane.addTab("Inicio", null, Inicio, null);
		
		JPanel Zona = new JPanel();
		tabbedPane.addTab("Zona", null, Zona, null);
		Zona.setLayout(new BorderLayout(0, 0));
		
		JPanel Cuartos = new JPanel();
		tabbedPane.addTab("Cuartos", null, Cuartos, null);
		
		JPanel Semifinales = new JPanel();
		tabbedPane.addTab("Semifinales", null, Semifinales, null);
		
		JPanel Final = new JPanel();
		tabbedPane.addTab("Final", null, Final, null);
		
		JPanel Informacion = new JPanel();
		tabbedPane.addTab("Informacion", null, Informacion, null);
		Inicio.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//----------------------------------------INICIO----------------------------------------
		
		Box Ibox = Box.createVerticalBox();
		
		JButton Inicia_torneo = new JButton("Inicia torneo");
		Ibox.add(Inicia_torneo);
		
		JButton Continua = new JButton("Continua desde donde lo dejaste");
		Ibox.add(Continua);
		
		JButton Guarda_progreso = new JButton("Guarda tu progreso");
		Ibox.add(Guarda_progreso);
		Inicio.add(Ibox);
		
		//----------------------------------------ZONA----------------------------------------
		
		JPanel panel_sup = new JPanel();
		Zona.add(panel_sup, BorderLayout.NORTH);
		JPanel panel_central = new JPanel();
		Zona.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new GridLayout(1, 0, 0, 0));
		
		JComboBox<String> ZcomboBox1 = new JComboBox();
		ZcomboBox1.setEditable(false);
		ZcomboBox1.addItem("Zona 1");
		ZcomboBox1.addItem("Simula un partido");
		ZcomboBox1.addItem("Simula una fecha");
		ZcomboBox1.addItem("Simula una zona");
		panel_sup.add(ZcomboBox1);
		
		JComboBox<String> ZcomboBox2 = new JComboBox();
		ZcomboBox2.setEditable(false);
		ZcomboBox2.addItem("Zona 2");
		ZcomboBox2.addItem("Simula un partido");
		ZcomboBox2.addItem("Simula una fecha");
		ZcomboBox2.addItem("Simula una zona");
		panel_sup.add(ZcomboBox2);
		
		JComboBox<String> ZcomboBox3 = new JComboBox();
		ZcomboBox3.setEditable(false);
		ZcomboBox3.addItem("Zona 3");
		ZcomboBox3.addItem("Simula un partido");
		ZcomboBox3.addItem("Simula una fecha");
		ZcomboBox3.addItem("Simula una zona");
		panel_sup.add(ZcomboBox3);
		
		JComboBox<String> ZcomboBox4 = new JComboBox();
		ZcomboBox4.setEditable(false);
		ZcomboBox4.addItem("Zona 4");
		ZcomboBox4.addItem("Simula un partido");
		ZcomboBox4.addItem("Simula una fecha");
		ZcomboBox4.addItem("Simula una zona");
		panel_sup.add(ZcomboBox4);
		
		Box Zbox = Box.createHorizontalBox();
		
		panel_central.add(Zbox);
		
		JPanel panel_zona1 = new JPanel();
		Zbox.add(panel_zona1);
		
		JPanel panel_zona2 = new JPanel();
		Zbox.add(panel_zona2);
		
		JPanel panel_zona3 = new JPanel();
		Zbox.add(panel_zona3);
		
		JPanel panel_zona4 = new JPanel();
		Zbox.add(panel_zona4);
		
		//----------------------------------------CUARTOS----------------------------------------
		
		//---------------Paneles
		JPanel CpanelN = new JPanel();
		JPanel CpanelC = new JPanel();
		CpanelC.setLayout(new BorderLayout());
		//----------Cajas horizontales
		Box CboxH1 = Box.createHorizontalBox();
		Box CboxH2 = Box.createHorizontalBox();
		//----------Cajas verticales con equipos
		Box CboxV1 = Box.createHorizontalBox();
		Box CboxV2 = Box.createHorizontalBox();
		Box CboxV3 = Box.createHorizontalBox();
		Box CboxV4 = Box.createHorizontalBox();
		//---------------Equipos
		
		JLabel CEquipo1 = new JLabel("Equipo 1");
		CboxV1.add(CEquipo1);
		
		//CboxV1.add(Box.createVerticalStrut(40));
		CboxV1.add(Box.createVerticalGlue());
		
		JLabel CEquipo2 = new JLabel("Equipo 2");
		CboxV1.add(CEquipo2);
		
		JLabel CEquipo3 = new JLabel("Equipo 3");
		CboxV2.add(CEquipo3);
		
		CboxV2.add(Box.createVerticalGlue());
		
		JLabel CEquipo4 = new JLabel("Equipo 4");
		CboxV2.add(CEquipo4);
		
		JLabel CEquipo5 = new JLabel("Equipo 5");
		CboxV3.add(CEquipo5);
		
		CboxV3.add(Box.createVerticalGlue());
		
		JLabel CEquipo6 = new JLabel("Equipo 6");
		CboxV3.add(CEquipo6);
		
		JLabel CEquipo7 = new JLabel("Equipo 7");
		CboxV4.add(CEquipo7);
		
		CboxV4.add(Box.createVerticalGlue());
		
		JLabel CEquipo8 = new JLabel("Equipo 8");
		CboxV4.add(CEquipo8);
		//---------------Elecciones
		
		JComboBox<String> CcomboBox = new JComboBox();
		CcomboBox.setEditable(false);
		CcomboBox.addItem("Cuartos");
		CcomboBox.addItem("Simula un partido");
		CcomboBox.addItem("Simula una fecha");
		CcomboBox.addItem("Simula una zona");
		CpanelN.add(CcomboBox);
		
		//---------------Adds
		
		CboxH1.add(CboxV1);
		CboxH1.add(Box.createHorizontalGlue());
		CboxH1.add(CboxV2);
		CboxH2.add(CboxV3);
		CboxH2.add(Box.createHorizontalGlue());
		CboxH2.add(CboxV4);
		
		Cuartos.setLayout(new BorderLayout());
		CpanelC.add(CboxH1,BorderLayout.NORTH);
		CpanelC.add(CboxH2,BorderLayout.SOUTH);
		Cuartos.add(CpanelN,BorderLayout.NORTH);
		Cuartos.add(CpanelC,BorderLayout.CENTER);
		
		
		//----------------------------------------SEMIFINALES----------------------------------------
		
		//----------------------------------------FINAL----------------------------------------
		
		//----------------------------------------INFORMACION----------------------------------------
		
	}

}
