package frontend;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;


public class Frame extends JFrame {
	//-----------------------------------CONSTANTES-----------------------------
	
	//-----------------------------------ALTO Y LARGO FRAME-----------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1903446880091767162L;

	//-----------------------------------INFO_BACKEND-----------------------------
	
	final int CANT_EQUIPOS = 16;
	final int CANT_ZONAS = 4;
	final int EQUIPOS_X_ZONA = (int) CANT_EQUIPOS/CANT_ZONAS;
	
	//-----------------------------------CANCHA-----------------------------
	
	final int CANCHA_TAMANO_CIRCULO_C = 10;
	final int CANCHA_TAMANO_CIRCULO_G = 100;
	final int CANCHA_TAMANO_RECT_C = 100;
	final int CANCHA_TAMANO_RECT_G = 200;
	final Color COLOR_LINEAS_CANCHA = Color.GRAY;
	//-----------------------------------BOTONES-----------------------------
	
	final int CANT_BTN = 3;
	final int TAM_HOR_BTTN = 300,TAM_VER_BTTN = 40,TAMX_HOR_BTTN = 500,TAMX_VER_BTTN = 70;
	final Color COLOR_BOTONES = new Color(38, 190, 35);
	final Color COLOR_BOTONES_IF = Color.DARK_GRAY;
	final Color COLOR_BOTONES_IFP =new Color (168, 168, 168);
	final Color COLOR_LETRA_IF = Color.WHITE;
	final Dimension TAMX_BTTN = new Dimension(TAMX_HOR_BTTN,TAMX_VER_BTTN),TAM_BTTN = new Dimension(TAM_HOR_BTTN,TAM_VER_BTTN);
	final Dimension TAM_BTTN_IFP = new Dimension(TAMX_HOR_BTTN,TAMX_VER_BTTN/3);
	//-----------------------------------TAMAÑO Y COLOR LETRA-----------------------------
	
	final int FONT_SIZE = 28;
	final Color COLOR_LETRA = Color.WHITE;
	//-----------------------------------COLORES FONDO-----------------------------
	
	final Color COLOR_INICIO = Color.GREEN;
	final Color COLOR_PANEL_N = new Color(38, 190, 35);
	final Color COLOR_PANEL_C = Color.GREEN;
	final Color COLOR_FINAL = new Color(38, 190, 35);
	final Color COLOR_INFORMACION = Color.GRAY;
	//-----------------------------------PANEL-----------------------------
	final Dimension DIMENSION_PANELES_INFO = new Dimension(15,75);
	private JPanel contentPane;

	
	
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
		Toolkit MiPantalla = Toolkit.getDefaultToolkit();
		Image imagen = MiPantalla.getImage("Src/frontend/icono.png");
		Dimension d = MiPantalla.getScreenSize();
		final int WIDTH = (int) (d.width*0.8),HEIGHT = (int) (d.height*0.8);
		setTitle("Proyecto final en Java: Torneo de futbol");
		setIconImage(imagen);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100,WIDTH,HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		//----------------------------------------PESTAÑAS----------------------------------------
		
		JPanel Inicio = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = -3935213560652636223L;

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
		Inicio.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Inicio.setBackground(COLOR_INICIO);
		JPanel Zona = new JPanel();
		Zona.setLayout(new BorderLayout(0, 0));
		JPanel Cuartos = new JPanel();
		Cuartos.setLayout(new BorderLayout());
		JPanel Semifinales = new JPanel();
		Semifinales.setLayout(new BorderLayout(0, 0));
		JPanel Final = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 8184469625700639718L;

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
		JPanel Informacion = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 8184469625700639718L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
					Graphics2D g2 = (Graphics2D) g;
					g2.setPaint(COLOR_LETRA_IF);
					g2.draw(new Line2D.Double(getWidth()/16,getHeight(),getWidth()/16,0));
					g2.draw(new Line2D.Double(getWidth()-getWidth()/16,getHeight(),getWidth()-getWidth()/16,0));
					g2.draw(new Line2D.Double(getWidth(),getHeight()-getHeight()/16,0,getHeight()-getHeight()/16));
			}
		};
		
			
		//----------------------------------------INICIO----------------------------------------
		Box Ibox = Box.createVerticalBox();
		JButton Inicia_torneo = new JButton("Inicia torneo");
		JButton Continua = new JButton("Continua desde donde lo dejaste");
		JButton Guarda_progreso = new JButton("Guarda tu progreso");
		
		Inicia_torneo.setMinimumSize(Inicia_torneo.getSize());
		Inicia_torneo.setPreferredSize(TAM_BTTN);
		Inicia_torneo.setMaximumSize(TAMX_BTTN);
		Inicia_torneo.setBackground(COLOR_BOTONES);
		
		Continua.setMinimumSize(Continua.getSize());
		Continua.setPreferredSize(TAM_BTTN);
		Continua.setMaximumSize(TAMX_BTTN);
		Continua.setBackground(COLOR_BOTONES);
		
		Guarda_progreso.setMinimumSize(Guarda_progreso.getSize());
		Guarda_progreso.setPreferredSize(TAM_BTTN);
		Guarda_progreso.setMaximumSize(TAMX_BTTN);
		Guarda_progreso.setBackground(COLOR_BOTONES);
		
		Ibox.add(Box.createVerticalStrut((getHeight()/2)-CANT_BTN*TAM_BTTN.height));
		Ibox.add(Inicia_torneo);
		Ibox.add(Box.createVerticalStrut(TAM_BTTN.height/2));
		Ibox.add(Continua);
		Ibox.add(Box.createVerticalStrut(TAM_BTTN.height/2));
		Ibox.add(Guarda_progreso);
		Ibox.add(Box.createVerticalStrut((getHeight()/2)-CANT_BTN*TAM_BTTN.height));
		Inicio.add(Ibox);
		
		//----------------------------------------ZONA----------------------------------------
		
		JButton Simula_todo = new JButton("Simular todas las zonas");
		JPanel ZpanelN = new JPanel();
		Box Zbox = Box.createHorizontalBox();
		JPanel ZpanelesZonas [] = new JPanel[CANT_ZONAS];
		JPanel ZpanelC = new JPanel();
		JComboBox<String> ZcomboBox1 = new JComboBox<String>();
		JComboBox<String> ZcomboBox2 = new JComboBox<String>();
		JComboBox<String> ZcomboBox3 = new JComboBox<String>();
		JComboBox<String> ZcomboBox4 = new JComboBox<String>();
		
		for (int i = 0; i<CANT_ZONAS;i++) {
			ZpanelesZonas[i] = new JPanel();
			ZpanelesZonas[i].setBackground(COLOR_PANEL_C);
			
			Zbox.add(ZpanelesZonas[i]);
		}
		ZpanelC.add(Zbox);
		ZpanelN.setBackground(COLOR_PANEL_N);
		
		
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
		ZpanelC.add(Zbox);
		Zona.add(ZpanelN, BorderLayout.NORTH);
		Zona.add(ZpanelC, BorderLayout.CENTER);
		
		//----------------------------------------CUARTOS----------------------------------------
		
		//---------------Variables
		JPanel CpanelN = new JPanel();
		JPanel CpanelC = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

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
		JComboBox<String> CcomboBox = new JComboBox<String>();
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
		
		CboxH1.add(CboxV1);
		CboxH1.add(Box.createHorizontalGlue());
		CboxH1.add(CboxV2);
		CboxH2.add(CboxV3);
		CboxH2.add(Box.createHorizontalGlue());
		CboxH2.add(CboxV4);
		
		CpanelC.add(CboxH1,BorderLayout.NORTH);
		CpanelC.add(CboxH2,BorderLayout.SOUTH);
		Cuartos.add(CpanelN,BorderLayout.NORTH);
		Cuartos.add(CpanelC,BorderLayout.CENTER);
		
		
		//----------------------------------------SEMIFINALES----------------------------------------
		
		//----------------Variables
		
		JPanel SpanelN = new JPanel();
		JPanel SpanelC = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

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
		JComboBox<String> ScomboBox = new JComboBox<String>();
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
		Box IFbox = Box.createVerticalBox();
		Box IFboxPPAL = Box.createVerticalBox();
		JButton Listado_equipos = new JButton("Listado de equipos");
		JButton Ranking_referis = new JButton("Ranking de referis");
		JButton Listado_jugadores = new JButton("Listado de jugadores");
		IFpanel_E PanelE = new IFpanel_E();
		IFpanel_J PanelJ = new IFpanel_J();
		IFpanel_R PanelR = new IFpanel_R();
		JPanel IFpanelBotonera = new JPanel();
 
		Listado_equipos.setMinimumSize(Listado_equipos.getSize());
		Listado_equipos.setPreferredSize(TAM_BTTN);
		Listado_equipos.setMaximumSize(TAMX_BTTN);
		Listado_equipos.setBackground(COLOR_BOTONES_IF);
		Listado_equipos.setForeground(COLOR_LETRA_IF);
		Listado_equipos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				PanelR.Desactiva();
				PanelE.Activa();
				PanelJ.Desactiva();
			}
			
		});
		
		Ranking_referis.setMinimumSize(Ranking_referis.getSize());
		Ranking_referis.setPreferredSize(TAM_BTTN);
		Ranking_referis.setMaximumSize(TAMX_BTTN);
		Ranking_referis.setBackground(COLOR_BOTONES_IF);
		Ranking_referis.setForeground(COLOR_LETRA_IF);
		Ranking_referis.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				PanelR.Activa();
				PanelE.Desactiva();
				PanelJ.Desactiva();
			}
			
		});
		
		Listado_jugadores.setMinimumSize(Listado_jugadores.getSize());
		Listado_jugadores.setPreferredSize(TAM_BTTN);
		Listado_jugadores.setMaximumSize(TAMX_BTTN);
		Listado_jugadores.setBackground(COLOR_BOTONES_IF);
		Listado_jugadores.setForeground(COLOR_LETRA_IF);
		Listado_jugadores.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				PanelR.Desactiva();
				PanelE.Desactiva();
				PanelJ.Activa();
			}
			
		});
		
		IFbox.add(Listado_equipos);
		IFbox.add(Box.createVerticalStrut(TAM_BTTN.height/4));
		IFbox.add(Ranking_referis);
		IFbox.add(Box.createVerticalStrut(TAM_BTTN.height/4));
		IFbox.add(Listado_jugadores);

		//------------------------------PANELES
		
		IFpanelBotonera.add(IFbox);
		IFpanelBotonera.setBackground(COLOR_INFORMACION);
		IFboxPPAL.add(Box.createVerticalStrut((getHeight()/4)-CANT_BTN*TAM_BTTN.height));
		IFboxPPAL.add(IFpanelBotonera,BorderLayout.NORTH);
		PanelE.Activa();
		IFboxPPAL.add(PanelE,BorderLayout.CENTER);
		IFboxPPAL.add(PanelJ,BorderLayout.CENTER);
		IFboxPPAL.add(PanelR,BorderLayout.CENTER);
		Informacion.add(IFboxPPAL);
		
		//-----------------------------------------------------------------------------------------
		
		tabbedPane.addTab("Inicio", null, Inicio, null);
		tabbedPane.addTab("Zona", null, Zona, null);
		tabbedPane.addTab("Cuartos", null, Cuartos, null);
		tabbedPane.addTab("Semifinales", null, Semifinales, null);
		tabbedPane.addTab("Final", null, Final, null);
		tabbedPane.addTab("Informacion", null, Informacion, null);
		
		
	}
	
	private class IFpanel_E extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5076033681079441032L;
		//panel que se muestra si se pide un listado de equipos
		IFpanel_E() {
			setLayout(new BorderLayout());
			setBackground(Color.GRAY);
			JTextArea area = new JTextArea(DIMENSION_PANELES_INFO.width,DIMENSION_PANELES_INFO.height);
			area.setEditable(false);
			JScrollPane panel_area = new JScrollPane(area);
			JButton boton_equipos = new JButton("Mostrar equipos");
			boton_equipos.setMinimumSize(boton_equipos.getSize());
			boton_equipos.setPreferredSize(TAM_BTTN_IFP);
			boton_equipos.setMaximumSize(TAM_BTTN);
			boton_equipos.setForeground(COLOR_LETRA_IF);
			boton_equipos.setBackground(COLOR_BOTONES_IFP);
			add(boton_equipos,BorderLayout.NORTH);
			add(panel_area,BorderLayout.CENTER);
			setBorder(BorderFactory.createTitledBorder("Listado de equipos"));
			setVisible(false);
		}
		public void Desactiva () {
			setVisible(false);
		}
		public void Activa () {
			setVisible(true);
		}
	}
	
	private class IFpanel_J extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5076033681079441032L;
		//panel que se muestra si se pide un listado de equipos
		IFpanel_J() {
			setLayout(new BorderLayout());
			setBackground(Color.GRAY);
			JTextArea area = new JTextArea(DIMENSION_PANELES_INFO.width,DIMENSION_PANELES_INFO.height);
			area.setEditable(false);
			JScrollPane panel_area = new JScrollPane(area);
			JComboBox<String> IFpos = new JComboBox<String>();
			JButton boton_muestra = new JButton("Mostrar jugadores");
			JPanel panel_botonera = new JPanel();
			boton_muestra.setMinimumSize(boton_muestra.getSize());
			boton_muestra.setPreferredSize(TAM_BTTN_IFP);
			boton_muestra.setMaximumSize(TAM_BTTN);
			boton_muestra.setForeground(COLOR_LETRA_IF);
			boton_muestra.setBackground(COLOR_BOTONES_IFP);
			IFpos.addItem("Seleccione posicion");
			IFpos.addItem("Arquero");
			IFpos.addItem("Defensor");
			IFpos.addItem("Mediocampista");
			IFpos.addItem("Delantero");
			panel_botonera.add(IFpos,BorderLayout.WEST);
			panel_botonera.add(boton_muestra,BorderLayout.EAST);
			add(panel_botonera,BorderLayout.NORTH);
			add(panel_area,BorderLayout.CENTER);
			setBorder(BorderFactory.createTitledBorder("Listado de jugadores"));
			setVisible(false);
		}
		public void Desactiva () {
			setVisible(false);
		}
		public void Activa () {
			setVisible(true);
		}
	}
	
	private class IFpanel_R extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5076033681079441032L;
		//panel que se muestra si se pide un listado de equipos
		IFpanel_R() {
			setLayout(new BorderLayout());
			setBackground(Color.GRAY);
			JTextArea area = new JTextArea(DIMENSION_PANELES_INFO.width,DIMENSION_PANELES_INFO.height);
			area.setEditable(false);
			JScrollPane panel_area = new JScrollPane(area);
			JButton boton_equipos = new JButton("Listar referis");
			boton_equipos.setMinimumSize(boton_equipos.getSize());
			boton_equipos.setPreferredSize(TAM_BTTN_IFP);
			boton_equipos.setMaximumSize(TAM_BTTN);
			boton_equipos.setForeground(COLOR_LETRA_IF);
			boton_equipos.setBackground(COLOR_BOTONES_IFP);
			add(boton_equipos,BorderLayout.NORTH);
			add(panel_area,BorderLayout.CENTER);
			setBorder(BorderFactory.createTitledBorder("Ranking de referis"));
			setVisible(false);
		}
		public void Desactiva () {
			setVisible(false);
		}
		public void Activa () {
			setVisible(true);
		}
	}

}
