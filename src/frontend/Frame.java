package frontend;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class Frame extends JFrame {
	
	protected static final int CANCHA_TAMANO_RECTANGULO_C = 0;
	final int WIDTH = 900,HEIGHT = 500;
	final int CANCHA_TAMANO_CIRCULO_C = 10;
	final int CANCHA_TAMANO_CIRCULO_G = 100;
	final int CANCHA_TAMANO_RECT_C = 100;
	final int CANCHA_TAMANO_RECT_G = 200;
	final Color COLOR_LINEAS_CANCHA = Color.WHITE;
	
	final int FONT_SIZE = 30;
	final Color COLOR_LETRA = Color.WHITE;
	
	final Color COLOR_INICIO = Color.GREEN;
	final Color COLOR_PANEL_N = Color.GREEN;
	final Color COLOR_PANEL_C = new Color(38, 190, 35);
	final Color COLOR_FINAL = new Color(38, 190, 35);
	final Color COLOR_INFORMACION = Color.GRAY;

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
		setBounds(200, 100, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		//----------------------------------------PESTAÑAS----------------------------------------
		
		JPanel Inicio = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
					Graphics2D g2 = (Graphics2D) g;
					g2.setPaint(Color.GRAY);
					g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
					g2.fill(new Ellipse2D.Double((getWidth()/2)-(CANCHA_TAMANO_CIRCULO_C/2),(getHeight()/2)-(CANCHA_TAMANO_CIRCULO_C/2),CANCHA_TAMANO_CIRCULO_C,CANCHA_TAMANO_CIRCULO_C));
					g2.draw(new Ellipse2D.Double((getWidth()/2)-(CANCHA_TAMANO_CIRCULO_G/2),(getHeight()/2)-(CANCHA_TAMANO_CIRCULO_G/2),CANCHA_TAMANO_CIRCULO_G,CANCHA_TAMANO_CIRCULO_G));
					g2.draw(new Line2D.Double(getWidth()/2,0,getWidth()/2,getHeight()));
					g2.draw(new Rectangle2D.Double(0-(CANCHA_TAMANO_RECT_C/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_C/2),CANCHA_TAMANO_RECT_C,CANCHA_TAMANO_RECT_C));
					g2.draw(new Rectangle2D.Double(0-(CANCHA_TAMANO_RECT_G/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_G/2),CANCHA_TAMANO_RECT_G,CANCHA_TAMANO_RECT_G));
					g2.draw(new Rectangle2D.Double(getWidth()-(CANCHA_TAMANO_RECT_C/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_C/2),CANCHA_TAMANO_RECT_C,CANCHA_TAMANO_RECT_C));
					g2.draw(new Rectangle2D.Double(getWidth()-(CANCHA_TAMANO_RECT_G/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_G/2),CANCHA_TAMANO_RECT_G,CANCHA_TAMANO_RECT_G));
			}
		};
		tabbedPane.addTab("Inicio", null, Inicio, null);
		
		JPanel Zona = new JPanel();
		tabbedPane.addTab("Zona", null, Zona, null);
		Zona.setLayout(new BorderLayout(0, 0));
		
		JPanel Cuartos = new JPanel();
		tabbedPane.addTab("Cuartos", null, Cuartos, null);
		
		JPanel Semifinales = new JPanel();
		tabbedPane.addTab("Semifinales", null, Semifinales, null);
		Semifinales.setLayout(new BorderLayout(0, 0));
		
		JPanel Final = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
					Graphics2D g2 = (Graphics2D) g;
					g2.setPaint(COLOR_LINEAS_CANCHA);
					g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
					g2.fill(new Ellipse2D.Double((getWidth()/2)-(CANCHA_TAMANO_CIRCULO_C/2),(getHeight()/2)-(CANCHA_TAMANO_CIRCULO_C/2),CANCHA_TAMANO_CIRCULO_C,CANCHA_TAMANO_CIRCULO_C));
					g2.draw(new Ellipse2D.Double((getWidth()/2)-(CANCHA_TAMANO_CIRCULO_G/2),(getHeight()/2)-(CANCHA_TAMANO_CIRCULO_G/2),CANCHA_TAMANO_CIRCULO_G,CANCHA_TAMANO_CIRCULO_G));
					g2.draw(new Line2D.Double(getWidth()/2,0,getWidth()/2,getHeight()));
					g2.draw(new Rectangle2D.Double(0-(CANCHA_TAMANO_RECT_C/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_C/2),CANCHA_TAMANO_RECT_C,CANCHA_TAMANO_RECT_C));
					g2.draw(new Rectangle2D.Double(0-(CANCHA_TAMANO_RECT_G/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_G/2),CANCHA_TAMANO_RECT_G,CANCHA_TAMANO_RECT_G));
					g2.draw(new Rectangle2D.Double(getWidth()-(CANCHA_TAMANO_RECT_C/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_C/2),CANCHA_TAMANO_RECT_C,CANCHA_TAMANO_RECT_C));
					g2.draw(new Rectangle2D.Double(getWidth()-(CANCHA_TAMANO_RECT_G/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_G/2),CANCHA_TAMANO_RECT_G,CANCHA_TAMANO_RECT_G));
			}
		};
		tabbedPane.addTab("Final", null, Final, null);
		
		JPanel Informacion = new JPanel();
		tabbedPane.addTab("Informacion", null, Informacion, null);
		Inicio.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//----------------------------------------INICIO----------------------------------------
		Inicio.setBackground(COLOR_INICIO);
		Box Ibox = Box.createVerticalBox();
		
		JButton Inicia_torneo = new JButton("Inicia torneo");
		Ibox.add(Inicia_torneo);
		
		JButton Continua = new JButton("Continua desde donde lo dejaste");
		Ibox.add(Continua);
		
		JButton Guarda_progreso = new JButton("Guarda tu progreso");
		Ibox.add(Guarda_progreso);
		Inicio.add(Ibox);
		
		//----------------------------------------ZONA----------------------------------------
		
		JButton Simula_todo = new JButton("Simular todas las zonas");
		JPanel ZpanelN = new JPanel();
		Box Zbox = Box.createHorizontalBox();
		JPanel panel_zona1 = new JPanel();
		JPanel panel_zona2 = new JPanel();
		JPanel panel_zona3 = new JPanel();
		JPanel panel_zona4 = new JPanel();
		JPanel ZpanelC = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
					Graphics2D g2 = (Graphics2D) g;
					g2.setPaint(COLOR_LINEAS_CANCHA);
					g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
					g2.fill(new Ellipse2D.Double((getWidth()/2)-(CANCHA_TAMANO_CIRCULO_C/2),(getHeight()/2)-(CANCHA_TAMANO_CIRCULO_C/2),CANCHA_TAMANO_CIRCULO_C,CANCHA_TAMANO_CIRCULO_C));
					g2.draw(new Ellipse2D.Double((getWidth()/2)-(CANCHA_TAMANO_CIRCULO_G/2),(getHeight()/2)-(CANCHA_TAMANO_CIRCULO_G/2),CANCHA_TAMANO_CIRCULO_G,CANCHA_TAMANO_CIRCULO_G));
					g2.draw(new Line2D.Double(getWidth()/2,0,getWidth()/2,getHeight()));
					g2.draw(new Rectangle2D.Double(0-(CANCHA_TAMANO_RECT_C/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_C/2),CANCHA_TAMANO_RECT_C,CANCHA_TAMANO_RECT_C));
					g2.draw(new Rectangle2D.Double(0-(CANCHA_TAMANO_RECT_G/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_G/2),CANCHA_TAMANO_RECT_G,CANCHA_TAMANO_RECT_G));
					g2.draw(new Rectangle2D.Double(getWidth()-(CANCHA_TAMANO_RECT_C/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_C/2),CANCHA_TAMANO_RECT_C,CANCHA_TAMANO_RECT_C));
					g2.draw(new Rectangle2D.Double(getWidth()-(CANCHA_TAMANO_RECT_G/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_G/2),CANCHA_TAMANO_RECT_G,CANCHA_TAMANO_RECT_G));
			}
		};
		JComboBox<String> ZcomboBox1 = new JComboBox();
		JComboBox<String> ZcomboBox2 = new JComboBox();
		JComboBox<String> ZcomboBox3 = new JComboBox();
		JComboBox<String> ZcomboBox4 = new JComboBox();
		
		ZpanelN.setBackground(COLOR_PANEL_N);
		panel_zona1.setBackground(COLOR_PANEL_C);
		panel_zona2.setBackground(COLOR_PANEL_C);
		panel_zona3.setBackground(COLOR_PANEL_C);
		panel_zona4.setBackground(COLOR_PANEL_C);
		ZpanelC.setLayout(new GridLayout(1, 0, 0, 0));
		
		//------------------------------Elecciones
		
		
		
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
		
		
		
		//-------------------------Adds
		
		ZpanelN.add(ZcomboBox1);
		ZpanelN.add(ZcomboBox2);
		ZpanelN.add(ZcomboBox3);
		ZpanelN.add(ZcomboBox4);
		ZpanelN.add(Simula_todo);
		Zbox.add(panel_zona1);
		Zbox.add(panel_zona2);
		Zbox.add(panel_zona3);
		Zbox.add(panel_zona4);
		ZpanelC.add(Zbox);
		Zona.add(ZpanelN, BorderLayout.NORTH);
		Zona.add(ZpanelC, BorderLayout.CENTER);
		
		//----------------------------------------CUARTOS----------------------------------------
		
		//---------------Variables
		JPanel CpanelN = new JPanel();
		JPanel CpanelC = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
					Graphics2D g2 = (Graphics2D) g;
					g2.setPaint(COLOR_LINEAS_CANCHA);
					g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
					g2.fill(new Ellipse2D.Double((getWidth()/2)-(CANCHA_TAMANO_CIRCULO_C/2),(getHeight()/2)-(CANCHA_TAMANO_CIRCULO_C/2),CANCHA_TAMANO_CIRCULO_C,CANCHA_TAMANO_CIRCULO_C));
					g2.draw(new Ellipse2D.Double((getWidth()/2)-(CANCHA_TAMANO_CIRCULO_G/2),(getHeight()/2)-(CANCHA_TAMANO_CIRCULO_G/2),CANCHA_TAMANO_CIRCULO_G,CANCHA_TAMANO_CIRCULO_G));
					g2.draw(new Line2D.Double(getWidth()/2,0,getWidth()/2,getHeight()));
					g2.draw(new Rectangle2D.Double(0-(CANCHA_TAMANO_RECT_C/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_C/2),CANCHA_TAMANO_RECT_C,CANCHA_TAMANO_RECT_C));
					g2.draw(new Rectangle2D.Double(0-(CANCHA_TAMANO_RECT_G/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_G/2),CANCHA_TAMANO_RECT_G,CANCHA_TAMANO_RECT_G));
					g2.draw(new Rectangle2D.Double(getWidth()-(CANCHA_TAMANO_RECT_C/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_C/2),CANCHA_TAMANO_RECT_C,CANCHA_TAMANO_RECT_C));
					g2.draw(new Rectangle2D.Double(getWidth()-(CANCHA_TAMANO_RECT_G/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_G/2),CANCHA_TAMANO_RECT_G,CANCHA_TAMANO_RECT_G));
			}
		};
		JComboBox<String> CcomboBox = new JComboBox();
		Box CboxH1 = Box.createHorizontalBox();
		Box CboxH2 = Box.createHorizontalBox();
		Box CboxV1 = Box.createVerticalBox();
		Box CboxV2 = Box.createVerticalBox();
		Box CboxV3 = Box.createVerticalBox();
		Box CboxV4 = Box.createVerticalBox();
		JLabel CEquipo1 = new JLabel("Equipo 1");
		JLabel CEquipo2 = new JLabel("Equipo 2");
		JLabel CEquipo3 = new JLabel("Equipo 3");
		JLabel CEquipo4 = new JLabel("Equipo 4");
		JLabel CEquipo5 = new JLabel("Equipo 5");
		JLabel CEquipo6 = new JLabel("Equipo 6");
		JLabel CEquipo7 = new JLabel("Equipo 7");
		JLabel CEquipo8 = new JLabel("Equipo 8");
		
		//---------------Paneles
		
		CpanelN.setBackground(COLOR_PANEL_N);
		CpanelC.setLayout(new BorderLayout());
		CpanelC.setBackground(COLOR_PANEL_C);

		//---------------Equipos
	
		CEquipo1.setForeground(COLOR_LETRA);
		CEquipo1.setFont(new Font(null,0,FONT_SIZE));
		CEquipo2.setForeground(COLOR_LETRA);
		CEquipo2.setFont(new Font(null,0,FONT_SIZE));
		CEquipo3.setForeground(COLOR_LETRA);
		CEquipo3.setFont(new Font(null,0,FONT_SIZE));
		CEquipo4.setForeground(COLOR_LETRA);
		CEquipo4.setFont(new Font(null,0,FONT_SIZE));
		CEquipo5.setForeground(COLOR_LETRA);
		CEquipo5.setFont(new Font(null,0,FONT_SIZE));
		CEquipo6.setForeground(COLOR_LETRA);
		CEquipo6.setFont(new Font(null,0,FONT_SIZE));
		CEquipo7.setForeground(COLOR_LETRA);
		CEquipo7.setFont(new Font(null,0,FONT_SIZE));
		CEquipo8.setForeground(COLOR_LETRA);
		CEquipo8.setFont(new Font(null,0,FONT_SIZE));
				
		//---------------Elecciones
		
		CcomboBox.setEditable(false);
		CcomboBox.addItem("Cuartos");
		CcomboBox.addItem("Simula partido");
		CcomboBox.addItem("Simula todos los partidos de ida");
		CcomboBox.addItem("Simula todos los partidos de vuelta");
		CcomboBox.addItem("Simula todos los partidos");
		CpanelN.add(CcomboBox);
		
		//-------------------------Adds
		
		//----Equipos y cajas
		CboxV1.add(CEquipo1);
		CboxV1.add(Box.createVerticalGlue());
		CboxV1.add(CEquipo2);
		
		CboxV2.add(CEquipo3);
		CboxV2.add(Box.createVerticalGlue());
		CboxV2.add(CEquipo4);
		
		CboxV3.add(CEquipo5);
		CboxV3.add(Box.createVerticalGlue());
		CboxV3.add(CEquipo6);
		
		CboxV4.add(CEquipo7);
		CboxV4.add(Box.createVerticalGlue());
		CboxV4.add(CEquipo8);
		
		//----cajas verticales
		
		CboxH1.add(CboxV1);
		CboxH1.add(Box.createHorizontalGlue());
		CboxH1.add(CboxV2);
		CboxH2.add(CboxV3);
		CboxH2.add(Box.createHorizontalGlue());
		CboxH2.add(CboxV4);
		
		//----cajas horizontales y paneles
		Cuartos.setLayout(new BorderLayout());
		CpanelC.add(CboxH1,BorderLayout.NORTH);
		CpanelC.add(CboxH2,BorderLayout.SOUTH);
		Cuartos.add(CpanelN,BorderLayout.NORTH);
		Cuartos.add(CpanelC,BorderLayout.CENTER);
		
		
		//----------------------------------------SEMIFINALES----------------------------------------
		
		//----------------Variables
		
		JPanel SpanelN = new JPanel();
		JPanel SpanelC = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
					Graphics2D g2 = (Graphics2D) g;
					g2.setPaint(COLOR_LINEAS_CANCHA);
					g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
					g2.fill(new Ellipse2D.Double((getWidth()/2)-(CANCHA_TAMANO_CIRCULO_C/2),(getHeight()/2)-(CANCHA_TAMANO_CIRCULO_C/2),CANCHA_TAMANO_CIRCULO_C,CANCHA_TAMANO_CIRCULO_C));
					g2.draw(new Ellipse2D.Double((getWidth()/2)-(CANCHA_TAMANO_CIRCULO_G/2),(getHeight()/2)-(CANCHA_TAMANO_CIRCULO_G/2),CANCHA_TAMANO_CIRCULO_G,CANCHA_TAMANO_CIRCULO_G));
					g2.draw(new Line2D.Double(getWidth()/2,0,getWidth()/2,getHeight()));
					g2.draw(new Rectangle2D.Double(0-(CANCHA_TAMANO_RECT_C/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_C/2),CANCHA_TAMANO_RECT_C,CANCHA_TAMANO_RECT_C));
					g2.draw(new Rectangle2D.Double(0-(CANCHA_TAMANO_RECT_G/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_G/2),CANCHA_TAMANO_RECT_G,CANCHA_TAMANO_RECT_G));
					g2.draw(new Rectangle2D.Double(getWidth()-(CANCHA_TAMANO_RECT_C/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_C/2),CANCHA_TAMANO_RECT_C,CANCHA_TAMANO_RECT_C));
					g2.draw(new Rectangle2D.Double(getWidth()-(CANCHA_TAMANO_RECT_G/2),(getHeight()/2)-(CANCHA_TAMANO_RECT_G/2),CANCHA_TAMANO_RECT_G,CANCHA_TAMANO_RECT_G));
			}
		};
		Box SboxH = Box.createHorizontalBox();
		Box SboxV1 = Box.createVerticalBox();
		Box SboxV2 = Box.createVerticalBox();
		JComboBox<String> ScomboBox = new JComboBox();
		JLabel SEquipo1 = new JLabel("Equipo 1");
		JLabel SEquipo2 = new JLabel("Equipo 2");
		JLabel SEquipo3 = new JLabel("Equipo 3");
		JLabel SEquipo4 = new JLabel("Equipo 4");
		
		//----------------Paneles
		SpanelN.setBackground(COLOR_PANEL_N);
		SpanelC.setBackground(COLOR_PANEL_C);
		SpanelC.setLayout(new BorderLayout());
		
		//---------------Equipos
		
		
		SEquipo1.setForeground(COLOR_LETRA);
		SEquipo1.setFont(new Font(null,0,FONT_SIZE));
		SEquipo2.setForeground(COLOR_LETRA);
		SEquipo2.setFont(new Font(null,0,FONT_SIZE));
		SEquipo3.setForeground(COLOR_LETRA);
		SEquipo3.setFont(new Font(null,0,FONT_SIZE));
		SEquipo4.setForeground(COLOR_LETRA);
		SEquipo4.setFont(new Font(null,0,FONT_SIZE));
		
		//----------------Elecciones
		
		ScomboBox.setEditable(false);
		ScomboBox.addItem("Semifinales");
		ScomboBox.addItem("Simula partido");
		ScomboBox.addItem("Simula todos los partidos de ida");
		ScomboBox.addItem("Simula todos los partidos de vuelta");
		ScomboBox.addItem("Simula todos los partidos");
		
		//-----------------Adds
		
		SboxV1.add(SEquipo1);
		SboxV1.add(Box.createVerticalStrut(30));
		SboxV1.add(SEquipo2);
		
		SboxV2.add(SEquipo3);
		SboxV2.add(Box.createVerticalStrut(30));
		SboxV2.add(SEquipo4);
		
		SboxH.add(Box.createHorizontalStrut(20));
		SboxH.add(SboxV1);
		SboxH.add(Box.createHorizontalStrut(500));
		SboxH.add(Box.createHorizontalGlue());
		SboxH.add(SboxV2);
		
		SpanelC.add(SboxH,BorderLayout.CENTER);
		SpanelN.add(ScomboBox);
		Semifinales.add(SpanelN, BorderLayout.NORTH);
		Semifinales.add(SpanelC, BorderLayout.CENTER); 
		
		//----------------------------------------FINAL----------------------------------------
		Final.setBackground(COLOR_FINAL);
		
		//----------------------------------------INFORMACION----------------------------------------
		Informacion.setBackground(COLOR_INFORMACION);
		
	}

}
