package frontend;
import java.awt.*;
import javax.swing.*;


public class Cuartos extends General{
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	
		
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
		
	private JPanel CpanelN;
	private panelC CpanelC;
	private JComboBox<String> CcomboBox;
	private JLabel CEquipo1;
	private JLabel CEquipo2;
	private JLabel CEquipo3;
	private JLabel CEquipo4;
	private JLabel CEquipo5;
	private JLabel CEquipo6;
	private JLabel CEquipo7;
	private JLabel CEquipo8;
	
	//private Controlador c;
	public Cuartos (){//Cuartos(Controlador c)
		//this.c = c;
				
		//-------------------------------------------------<<SETEO BACK Y LAYOUT>>-------------------------------------------------
				
		setLayout(new BorderLayout());

		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
		
		CpanelN = new JPanel();
		CpanelC = new panelC(); //arreglar para que se vean los arcos
		CcomboBox = new JComboBox<String>();
		CEquipo1 = new JLabel("Equipo 1");
		CEquipo2 = new JLabel("Equipo 2");
		CEquipo3 = new JLabel("Equipo 3");
		CEquipo4 = new JLabel("Equipo 4");
		CEquipo5 = new JLabel("Equipo 5");
		CEquipo6 = new JLabel("Equipo 6");
		CEquipo7 = new JLabel("Equipo 7");
		CEquipo8 = new JLabel("Equipo 8");
		
		//-------------------------------------------------<<SETEO VARIABLES>>-------------------------------------------------
		
		CpanelN.setBackground(COLOR_PANEL_N);
		CpanelC.setLayout(null);
		CpanelC.setBackground(COLOR_PANEL_C);
		
		CEquipo1.setFont(new Font(FONT_TYPE,0,FONT_SIZE));
		CEquipo1.setBounds(CANCHA_TAMANO_RECT_G/2,CANCHA_TAMANO_RECT_G/2,TAM_LABEL.width/2,TAM_LABEL.height/2);
		CEquipo1.setForeground(COLOR_LETRA);
		
		CEquipo2.setFont(new Font(FONT_TYPE,0,FONT_SIZE));
		CEquipo2.setBounds(CANCHA_TAMANO_RECT_G/2,CANCHA_TAMANO_RECT_G/2 + AUM_Y_BTTN/2,TAM_LABEL.width/2,TAM_LABEL.height/2);
		CEquipo2.setForeground(COLOR_LETRA);
		
		CEquipo3.setFont(new Font(FONT_TYPE,0,FONT_SIZE));
		CEquipo3.setBounds(CANCHA_TAMANO_RECT_G/2,(CANCHA_TAMANO_RECT_G/2)*2+AUM_Y_BTTN/2+2*(TAM_LABEL.height/2) + AUM_Y_BTTN/2,TAM_LABEL.width/2,TAM_LABEL.height/2);
		CEquipo3.setForeground(COLOR_LETRA);
		
		CEquipo4.setFont(new Font(FONT_TYPE,0,FONT_SIZE));
		CEquipo4.setBounds(CANCHA_TAMANO_RECT_G/2,(CANCHA_TAMANO_RECT_G/2)*2+ AUM_Y_BTTN +2*(TAM_LABEL.height/2) + AUM_Y_BTTN/2,TAM_LABEL.width/2,TAM_LABEL.height/2);
		CEquipo4.setForeground(COLOR_LETRA);
		
		CEquipo5.setFont(new Font(FONT_TYPE,0,FONT_SIZE));
		CEquipo5.setBounds(WIDTH-CANCHA_TAMANO_RECT_G/2-TAM_LABEL.width/2+75,CANCHA_TAMANO_RECT_G/2,TAM_LABEL.width/2,TAM_LABEL.height/2);
		CEquipo5.setForeground(COLOR_LETRA);
		
		CEquipo6.setFont(new Font(FONT_TYPE,0,FONT_SIZE));
		CEquipo6.setBounds(WIDTH-CANCHA_TAMANO_RECT_G/2-TAM_LABEL.width/2+75,CANCHA_TAMANO_RECT_G/2 + AUM_Y_BTTN/2,TAM_LABEL.width/2,TAM_LABEL.height/2);
		CEquipo6.setForeground(COLOR_LETRA);
		
		CEquipo7.setFont(new Font(FONT_TYPE,0,FONT_SIZE));
		CEquipo7.setBounds(WIDTH-CANCHA_TAMANO_RECT_G/2-TAM_LABEL.width/2+75,(CANCHA_TAMANO_RECT_G/2)*2+AUM_Y_BTTN/2+2*(TAM_LABEL.height/2) + AUM_Y_BTTN/2,TAM_LABEL.width/2,TAM_LABEL.height/2);
		CEquipo7.setForeground(COLOR_LETRA);
		
		CEquipo8.setFont(new Font(FONT_TYPE,0,FONT_SIZE));
		CEquipo8.setBounds(WIDTH-CANCHA_TAMANO_RECT_G/2-TAM_LABEL.width/2+75,(CANCHA_TAMANO_RECT_G/2)*2+ AUM_Y_BTTN +2*(TAM_LABEL.height/2) + AUM_Y_BTTN/2,TAM_LABEL.width/2,TAM_LABEL.height/2);
		CEquipo8.setForeground(COLOR_LETRA);
		
		CcomboBox.setEditable(false);
		CcomboBox.addItem("Cuartos");
		CcomboBox.addItem("Simula partido");
		CcomboBox.addItem("Simula todos los partidos de ida");
		CcomboBox.addItem("Simula todos los partidos de vuelta");
		CcomboBox.addItem("Simula todos los partidos");
		CpanelN.add(CcomboBox);
		
		//------------------------------Resolver panel central	
		
		//-------------------------------------------------<<AÑADO TODO A LOS CUARTOS>>-------------------------------------------------
		
		CpanelC.add(CEquipo1);
		CpanelC.add(CEquipo2);
		CpanelC.add(CEquipo3);
		CpanelC.add(CEquipo4);
		CpanelC.add(CEquipo5);
		CpanelC.add(CEquipo6);
		CpanelC.add(CEquipo7);
		CpanelC.add(CEquipo8);
		
		add(CpanelN,BorderLayout.NORTH);
		add(CpanelC,BorderLayout.CENTER);
		
	}
		//generar action listeners para los combo box y metodos para actualizar los equipos
	private class panelC extends General {
		panelC () {
			super.paint(getGraphics());
		}
	}
}
