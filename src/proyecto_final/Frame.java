package proyecto_final;

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
		
		Box caja_vert = Box.createVerticalBox();
		
		JButton Inicia_torneo = new JButton("Inicia torneo");
		caja_vert.add(Inicia_torneo);
		
		JButton Continua = new JButton("Continua desde donde lo dejaste");
		caja_vert.add(Continua);
		
		JButton Guarda_progreso = new JButton("Guarda tu progreso");
		caja_vert.add(Guarda_progreso);
		Inicio.add(caja_vert);
		
		//----------------------------------------ZONA----------------------------------------
		
		JPanel panel_sup = new JPanel();
		Zona.add(panel_sup, BorderLayout.NORTH);
		JPanel panel_central = new JPanel();
		Zona.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new GridLayout(1, 0, 0, 0));
		
		JComboBox<String> comboBox1 = new JComboBox();
		comboBox1.setEditable(false);
		comboBox1.addItem("Zona 1");
		comboBox1.addItem("Simula un partido");
		comboBox1.addItem("Simula una fecha");
		comboBox1.addItem("Simula una zona");
		panel_sup.add(comboBox1);
		
		JComboBox<String> comboBox2 = new JComboBox();
		comboBox2.setEditable(false);
		comboBox2.addItem("Zona 2");
		comboBox2.addItem("Simula un partido");
		comboBox2.addItem("Simula una fecha");
		comboBox2.addItem("Simula una zona");
		panel_sup.add(comboBox2);
		
		JComboBox<String> comboBox3 = new JComboBox();
		comboBox3.setEditable(false);
		comboBox3.addItem("Zona 3");
		comboBox3.addItem("Simula un partido");
		comboBox3.addItem("Simula una fecha");
		comboBox3.addItem("Simula una zona");
		panel_sup.add(comboBox3);
		
		JComboBox<String> comboBox4 = new JComboBox();
		comboBox4.setEditable(false);
		comboBox4.addItem("Zona 4");
		comboBox4.addItem("Simula un partido");
		comboBox4.addItem("Simula una fecha");
		comboBox4.addItem("Simula una zona");
		panel_sup.add(comboBox4);
		
		Box caja_horiz = Box.createHorizontalBox();
		
		panel_central.add(caja_horiz);
		
		JPanel panel_zona1 = new JPanel();
		caja_horiz.add(panel_zona1);
		
		JPanel panel_zona2 = new JPanel();
		caja_horiz.add(panel_zona2);
		
		JPanel panel_zona3 = new JPanel();
		caja_horiz.add(panel_zona3);
		
		JPanel panel_zona4 = new JPanel();
		caja_horiz.add(panel_zona4);
		
		//----------------------------------------CUARTOS----------------------------------------
		
		//----------------------------------------SEMIFINALES----------------------------------------
		
		//----------------------------------------FINAL----------------------------------------
		
		//----------------------------------------INFORMACION----------------------------------------
		
	}

}
