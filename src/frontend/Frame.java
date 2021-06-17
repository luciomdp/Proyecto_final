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
	
	final int WIDTH = 900,HEIGHT = 500;
	
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
	final Color COLOR_ETIQUETAS = Color.GREEN;//new Color(38, 190, 35);
	final Color COLOR_BOTONES = Color.DARK_GRAY;
	final Color COLOR_BOTONES_2 =new Color (168, 168, 168);
	final Color COLOR_LETRA = Color.WHITE;
	final Dimension TAMX_BTTN = new Dimension(TAMX_HOR_BTTN,TAMX_VER_BTTN),TAM_BTTN = new Dimension(TAM_HOR_BTTN,TAM_VER_BTTN);
	final Dimension TAM_BTTN_IFP = new Dimension(TAMX_HOR_BTTN,TAMX_VER_BTTN/3);
	//-----------------------------------TAMAÑO Y COLOR LETRA-----------------------------
	
	final int FONT_SIZE = 22;
	//-----------------------------------COLORES FONDO-----------------------------
	
	final Color COLOR_INICIO = new Color(38, 190, 35);//Color.GREEN;
	final Color COLOR_PANEL_N = new Color(0, 135, 5);//Color.DARK_GRAY;//new Color(38, 190, 35);
	final Color COLOR_PANEL_C = new Color(38, 190, 35);//Color.GREEN;
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
		setTitle("Proyecto final en Java: Torneo de futbol");
		setIconImage(imagen);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100,1003,567);
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
					g2.setPaint(COLOR_LETRA);
					g2.draw(new Line2D.Double(getWidth()/16,getHeight(),getWidth()/16,0));
					g2.draw(new Line2D.Double(getWidth()-getWidth()/16,getHeight(),getWidth()-getWidth()/16,0));
					//g2.draw(new Line2D.Double(getWidth(),getHeight()-getHeight()/16,0,getHeight()-getHeight()/16));
			}
		};
		
			
		//----------------------------------------INICIO----------------------------------------
		Box Ibox = Box.createVerticalBox();
		JButton Inicia_torneo = new JButton("Inicia torneo");
		JButton Continua = new JButton("Continua con el torneo");
		JButton Guarda_progreso = new JButton("Guarda tu progreso");
		
		Inicia_torneo.setMinimumSize(Inicia_torneo.getSize());
		Inicia_torneo.setForeground(COLOR_LETRA);
		Inicia_torneo.setPreferredSize(TAM_BTTN);
		Inicia_torneo.setMaximumSize(TAMX_BTTN);
		Inicia_torneo.setBackground(COLOR_PANEL_N);
		Inicia_torneo.setFont(new Font(null,0,FONT_SIZE));
		
		Continua.setMinimumSize(Continua.getSize());
		Continua.setForeground(COLOR_LETRA);
		Continua.setPreferredSize(TAM_BTTN);
		Continua.setMaximumSize(TAMX_BTTN);
		Continua.setBackground(COLOR_PANEL_N);
		Continua.setFont(new Font(null,0,FONT_SIZE));
		
		Guarda_progreso.setMinimumSize(Guarda_progreso.getSize());
		Guarda_progreso.setPreferredSize(TAM_BTTN);
		Guarda_progreso.setForeground(COLOR_LETRA);
		Guarda_progreso.setMaximumSize(TAMX_BTTN);
		Guarda_progreso.setBackground(COLOR_PANEL_N);
		Guarda_progreso.setFont(new Font(null,0,FONT_SIZE));
		
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
		
		final int AUM_Y_BTTN = getWidth()/16; //AUMENTO DE LOS BOTONES EN Y/2 PARA CUARTOS E Y SEMIS
		
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
		JButton CEquipo1 = new JButton("Equipo 1");
		JButton CEquipo2 = new JButton("Equipo 2");
		JButton CEquipo3 = new JButton("Equipo 3");
		JButton CEquipo4 = new JButton("Equipo 4");
		JButton CEquipo5 = new JButton("Equipo 5");
		JButton CEquipo6 = new JButton("Equipo 6");
		JButton CEquipo7 = new JButton("Equipo 7");
		JButton CEquipo8 = new JButton("Equipo 8");
		
		//---------------Paneles
		
		CpanelN.setBackground(COLOR_PANEL_N);
		CpanelC.setLayout(null);
		CpanelC.setBackground(COLOR_PANEL_C);

		//---------------Equipos
	
		
		CEquipo1.setFont(new Font(null,0,FONT_SIZE));
		CEquipo1.setEnabled(false);
		CEquipo1.setBounds(CANCHA_TAMANO_RECT_G/2,CANCHA_TAMANO_RECT_G/2,TAM_BTTN.width/2,TAM_BTTN.height/2);
		CEquipo1.setBackground(COLOR_ETIQUETAS);
		
		CEquipo2.setFont(new Font(null,0,FONT_SIZE));
		CEquipo2.setEnabled(false);
		CEquipo2.setBounds(CANCHA_TAMANO_RECT_G/2,CANCHA_TAMANO_RECT_G/2 + AUM_Y_BTTN/2,TAM_BTTN.width/2,TAM_BTTN.height/2);
		CEquipo2.setBackground(COLOR_ETIQUETAS);
		
		CEquipo3.setFont(new Font(null,0,FONT_SIZE));
		CEquipo3.setEnabled(false);
		CEquipo3.setBounds(CANCHA_TAMANO_RECT_G/2,(CANCHA_TAMANO_RECT_G/2)*2+AUM_Y_BTTN/2+2*(TAM_BTTN.height/2) + AUM_Y_BTTN/2,TAM_BTTN.width/2,TAM_BTTN.height/2);
		CEquipo3.setBackground(COLOR_ETIQUETAS);
		
		CEquipo4.setFont(new Font(null,0,FONT_SIZE));
		CEquipo4.setEnabled(false);
		CEquipo4.setBounds(CANCHA_TAMANO_RECT_G/2,(CANCHA_TAMANO_RECT_G/2)*2+ AUM_Y_BTTN +2*(TAM_BTTN.height/2) + AUM_Y_BTTN/2,TAM_BTTN.width/2,TAM_BTTN.height/2);
		CEquipo4.setBackground(COLOR_ETIQUETAS);
		
		CEquipo5.setFont(new Font(null,0,FONT_SIZE));
		CEquipo5.setEnabled(false);
		CEquipo5.setBounds(WIDTH-CANCHA_TAMANO_RECT_G/2-TAM_BTTN.width/2+75,CANCHA_TAMANO_RECT_G/2,TAM_BTTN.width/2,TAM_BTTN.height/2);
		CEquipo5.setBackground(COLOR_ETIQUETAS);
		
		CEquipo6.setFont(new Font(null,0,FONT_SIZE));
		CEquipo6.setEnabled(false);
		CEquipo6.setBounds(WIDTH-CANCHA_TAMANO_RECT_G/2-TAM_BTTN.width/2+75,CANCHA_TAMANO_RECT_G/2 + AUM_Y_BTTN/2,TAM_BTTN.width/2,TAM_BTTN.height/2);
		CEquipo6.setBackground(COLOR_ETIQUETAS);
		
		CEquipo7.setFont(new Font(null,0,FONT_SIZE));
		CEquipo7.setEnabled(false);
		CEquipo7.setBounds(WIDTH-CANCHA_TAMANO_RECT_G/2-TAM_BTTN.width/2+75,(CANCHA_TAMANO_RECT_G/2)*2+AUM_Y_BTTN/2+2*(TAM_BTTN.height/2) + AUM_Y_BTTN/2,TAM_BTTN.width/2,TAM_BTTN.height/2);
		CEquipo7.setBackground(COLOR_ETIQUETAS);
		
		CEquipo8.setFont(new Font(null,0,FONT_SIZE));
		CEquipo8.setEnabled(false);
		CEquipo8.setBounds(WIDTH-CANCHA_TAMANO_RECT_G/2-TAM_BTTN.width/2+75,(CANCHA_TAMANO_RECT_G/2)*2+ AUM_Y_BTTN +2*(TAM_BTTN.height/2) + AUM_Y_BTTN/2,TAM_BTTN.width/2,TAM_BTTN.height/2);
		CEquipo8.setBackground(COLOR_ETIQUETAS);
				
		//---------------Elecciones
		
		CcomboBox.setEditable(false);
		CcomboBox.addItem("Cuartos");
		CcomboBox.addItem("Simula partido");
		CcomboBox.addItem("Simula todos los partidos de ida");
		CcomboBox.addItem("Simula todos los partidos de vuelta");
		CcomboBox.addItem("Simula todos los partidos");
		CpanelN.add(CcomboBox);
		
		//-------------------------Adds
		CpanelC.add(CEquipo1);
		CpanelC.add(CEquipo2);
		CpanelC.add(CEquipo3);
		CpanelC.add(CEquipo4);
		CpanelC.add(CEquipo5);
		CpanelC.add(CEquipo6);
		CpanelC.add(CEquipo7);
		CpanelC.add(CEquipo8);
		
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
		JComboBox<String> ScomboBox = new JComboBox<String>();
		JButton SEquipo1 = new JButton("Equipo 1");
		JButton SEquipo2 = new JButton("Equipo 2");
		JButton SEquipo3 = new JButton("Equipo 3");
		JButton SEquipo4 = new JButton("Equipo 4");
		
		//----------------Paneles
		SpanelN.setBackground(COLOR_PANEL_N);
		SpanelC.setBackground(COLOR_PANEL_C);
		SpanelC.setLayout(null);
		
		//---------------Equipos
		
		SEquipo1.setFont(new Font(null,0,FONT_SIZE));
		SEquipo1.setEnabled(false);
		SEquipo1.setBounds(CANCHA_TAMANO_RECT_G/2,getHeight()/4,TAM_BTTN.width,TAM_BTTN.height);
		SEquipo1.setBackground(COLOR_ETIQUETAS);
		
		SEquipo2.setFont(new Font(null,0,FONT_SIZE));
		SEquipo2.setEnabled(false);
		SEquipo2.setBounds(CANCHA_TAMANO_RECT_G/2,getHeight()/4+TAM_BTTN.height+AUM_Y_BTTN,TAM_BTTN.width,TAM_BTTN.height);
		SEquipo2.setBackground(COLOR_ETIQUETAS);
		
		SEquipo3.setFont(new Font(null,0,FONT_SIZE));
		SEquipo3.setEnabled(false);
		SEquipo3.setBounds(WIDTH-TAM_BTTN.width-CANCHA_TAMANO_RECT_G/2+75,getHeight()/4,TAM_BTTN.width,TAM_BTTN.height);
		SEquipo3.setBackground(COLOR_ETIQUETAS);
		
		SEquipo4.setFont(new Font(null,0,FONT_SIZE));
		SEquipo4.setEnabled(false);
		SEquipo4.setBounds(WIDTH-TAM_BTTN.width-CANCHA_TAMANO_RECT_G/2+75,getHeight()/4+TAM_BTTN.height+AUM_Y_BTTN,TAM_BTTN.width,TAM_BTTN.height);
		SEquipo4.setBackground(COLOR_ETIQUETAS);
		
		//----------------Elecciones
		
		ScomboBox.setEditable(false);
		ScomboBox.addItem("Semifinales");
		ScomboBox.addItem("Simula partido");
		ScomboBox.addItem("Simula todos los partidos de ida");
		ScomboBox.addItem("Simula todos los partidos de vuelta");
		ScomboBox.addItem("Simula todos los partidos");
		
		//-----------------Adds
		
		SpanelC.add(SEquipo1);
		SpanelC.add(SEquipo2);
		SpanelC.add(SEquipo3);
		SpanelC.add(SEquipo4);
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
		Listado_equipos.setBackground(COLOR_BOTONES);
		Listado_equipos.setForeground(COLOR_LETRA);
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
		Ranking_referis.setBackground(COLOR_BOTONES);
		Ranking_referis.setForeground(COLOR_LETRA);
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
		Listado_jugadores.setBackground(COLOR_BOTONES);
		Listado_jugadores.setForeground(COLOR_LETRA);
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
			boton_equipos.setForeground(COLOR_LETRA);
			boton_equipos.setBackground(COLOR_BOTONES_2);
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
			boton_muestra.setForeground(COLOR_LETRA);
			boton_muestra.setBackground(COLOR_BOTONES_2);
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
			boton_equipos.setForeground(COLOR_LETRA);
			boton_equipos.setBackground(COLOR_BOTONES_2);
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