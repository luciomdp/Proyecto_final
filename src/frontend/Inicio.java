package frontend;
import java.awt.*;
import javax.swing.*;

public class Inicio extends General{
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private final Color COLOR_INICIO = new Color(38, 190, 35);
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private Box Ibox;
	private JButtonI Inicia_torneo;
	private JButtonI Continua;
	private JButtonI Guarda_progreso;
	//private Controlador c;
	public Inicio() {//Inicio(Controlador c)
		//this.c = c;
		
		//-------------------------------------------------<<SETEO BACK Y LAYOUT>>-------------------------------------------------
		
		setBackground(COLOR_INICIO);
		setLayout(new FlowLayout());
		
		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
		
		Ibox = Box.createVerticalBox();
		Inicia_torneo = new JButtonI("Inicia torneo");
		Continua = new JButtonI("Continua tu torneo");
		Guarda_progreso = new JButtonI("Guarda tu progreso");
		
		//-------------------------------------------------<<POSICIONO LOS BOTONES CENTRADOS>>-------------------------------------------------
		
		Ibox.add(Box.createVerticalStrut((HEIGHT/2)-CANT_BTN*TAM_BTTN.height+20));
		Ibox.add(Inicia_torneo);
		Ibox.add(Box.createVerticalStrut(TAM_BTTN.height/2));
		Ibox.add(Continua);
		Ibox.add(Box.createVerticalStrut(TAM_BTTN.height/2));
		Ibox.add(Guarda_progreso);
		Ibox.add(Box.createVerticalStrut((HEIGHT/2)-CANT_BTN*TAM_BTTN.height));
		add(Ibox);
	}
	private class JButtonI extends JButton { //faltan action listeners
		JButtonI (String s){
			super(s);
			setForeground(COLOR_LETRA);
			setPreferredSize(TAM_BTTN);
			setMaximumSize(TAM_BTTN);
			setBackground(COLOR_PANEL_N);
			setFont(new Font(FONT_TYPE,0,FONT_SIZE));
		}
	}
	//generar action listeners para los 3 botones (no van a haber cambios visuales)
}
