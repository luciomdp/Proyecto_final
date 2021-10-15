package frontend;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import proyecto_final.Controlador;


public class General extends JPanel{
	//-----------------------------------CONSTANTES-----------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3518373160364526784L;
	
	//-----------------------------------ALTO Y LARGO FRAME-----------------------------
	

	/**
	 * 
	 */
	public static final int WIDTH = 900;
	public static final int HEIGHT = 500;

	//-----------------------------------INFO_BACKEND-----------------------------
	
	public static final int CANT_EQUIPOS = 16;
	public static final int CANT_ZONAS = 4;
	public static final int CANT_BTN = 3;
	
	//-----------------------------------CANCHA-----------------------------
	
	public static final int CANCHA_TAMANO_CIRCULO_C = 10;
	public static final int CANCHA_TAMANO_CIRCULO_G = 100;
	public static final int CANCHA_TAMANO_RECT_C = 100;
	public static final int CANCHA_TAMANO_RECT_G = 200;
	public static final Color COLOR_LINEAS_CANCHA = Color.GRAY;
	//-----------------------------------BOTONES-----------------------------
	
	public static final int TAM_HOR_LABEL = 300,TAM_VER_LABEL = 46;
	public static final int TAM_HOR_BTTN = 350;
	public static final int TAM_VER_BTTN = 40;
	public static int AUM_Y_BTTN = WIDTH/16;
	public static final Color COLOR_BOTONES = Color.DARK_GRAY;
	public static final Color COLOR_BOTONES_2 =new Color (168, 168, 168);
	public static final Color COLOR_LETRA = Color.WHITE;
	public static final Dimension TAM_BTTN = new Dimension(TAM_HOR_BTTN,TAM_VER_BTTN);
	public static final Dimension TAM_LABEL = new Dimension(TAM_HOR_LABEL,TAM_VER_LABEL);
	
	//-----------------------------------TAMAÑO Y COLOR LETRA-----------------------------
	
	public static final int FONT_SIZE = 17;
	public static final String FONT_TYPE = "Consolas";
	
	//-----------------------------------COLORES FONDO-----------------------------
	public static final Color COLOR_PANEL_N = new Color(0, 135, 5);//Color.DARK_GRAY;//new Color(38, 190, 35);
	public static final Color COLOR_PANEL_C = new Color(38, 190, 35);//Color.GREEN;
	public static final Color COLOR_FINAL = new Color(38, 190, 35);
	public static final Color COLOR_INFORMACION = Color.GRAY;
	
	//-----------------------------------CONTROLADOR-----------------------------
	
	private Controlador control;
	
	//-----------------------------------PANEL-----------------------------
	
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

	public Controlador getControlador() {
		return control;
	}

	public void setControl(Controlador control) {
		this.control = control;
	}

}
