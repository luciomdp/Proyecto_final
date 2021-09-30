package frontend;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import proyecto_final.Controlador;

public class Inicio extends General {
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private static final long serialVersionUID = 1L;

	private final Color COLOR_INICIO = new Color(38, 190, 35);
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private Box Ibox;
	private JButtonI Inicia_torneo;
	private JButtonI Continua;
	private JButtonI Guarda_progreso;
	
	public Inicio() {

		//-------------------------------------------------<<SETEO BACK Y LAYOUT>>-------------------------------------------------
		
		setBackground(COLOR_INICIO);
		setLayout(new FlowLayout());
		
		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
		
		Ibox = Box.createVerticalBox();
		Inicia_torneo = new JButtonI("Inicia torneo");
		Continua = new JButtonI("Continua tu torneo");
		Guarda_progreso = new JButtonI("Guarda tu progreso");
		
		//-------------------------------------------------<<AGREGO BOTONES>>-------------------------------------------------
		
		Ibox.add(Box.createVerticalStrut((HEIGHT/2)-CANT_BTN*TAM_BTTN.height+20));
		Ibox.add(Inicia_torneo);
		Ibox.add(Box.createVerticalStrut(TAM_BTTN.height/2));
		Ibox.add(Continua);
		Ibox.add(Box.createVerticalStrut(TAM_BTTN.height/2));
		Ibox.add(Guarda_progreso);
		Ibox.add(Box.createVerticalStrut((HEIGHT/2)-CANT_BTN*TAM_BTTN.height));
		add(Ibox);
	}
	
	//-------------------------------------------------<<METODOS DE CLASE>>-------------------------------------------------
	
	public void AccionaBotones(Controlador c) {
		setControl(c);
		Inicia_torneo.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				getControlador().IniciaTorneo();
				Inicia_torneo.setEnabled(false);
				Continua.setEnabled(false);
			}	
		});
		
		Continua.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				getControlador().ContinuaTorneo();
			}	
		});
		
		Guarda_progreso.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				getControlador().SerializaProgreso();
			}	
		});
		
	}
	
	//-------------------------------------------------<<CLASES INTERNAS>>-------------------------------------------------
	
	private class JButtonI extends JButton {
		JButtonI (String s){
			super(s);
			setForeground(COLOR_LETRA);
			setPreferredSize(TAM_BTTN);
			setMaximumSize(TAM_BTTN);
			setBackground(COLOR_PANEL_N);
			setFont(new Font(FONT_TYPE,0,FONT_SIZE));
		}
	}
	

}
