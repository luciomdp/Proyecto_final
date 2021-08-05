package frontend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Semifinales extends General{
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private int AUMENTO_FUENTE = 10;
			
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
			
	private JPanel SpanelN;
	private panelS SpanelC;
	private JComboBox<String> ScomboBox;
	private JLabel SEquipo1;
	private JLabel SEquipo2;
	private JLabel SEquipo3;
	private JLabel SEquipo4;
		
	//private Controlador control;
	public Semifinales (){//Semifinales(Controlador c)
		//control = c;
					
		//-------------------------------------------------<<SETEO BACK Y LAYOUT>>-------------------------------------------------
					
		setLayout(new BorderLayout(0, 0));

		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
			
		SpanelN = new JPanel();
		SpanelC = new panelS(); 
		ScomboBox = new JComboBox<String>();
		SEquipo1 = new JLabel("Equipo 1");
		SEquipo2 = new JLabel("Equipo 2");
		SEquipo3 = new JLabel("Equipo 3");
		SEquipo4 = new JLabel("Equipo 4");
		
			
		//-------------------------------------------------<<SETEO VARIABLES>>-------------------------------------------------
			
		SpanelN.setBackground(COLOR_PANEL_N);
		SpanelC.setBackground(COLOR_PANEL_C);
		SpanelC.setLayout(null);
			
		SEquipo1.setFont(new Font(FONT_TYPE,0,FONT_SIZE+AUMENTO_FUENTE));
		SEquipo1.setBounds(CANCHA_TAMANO_RECT_G/2,CANCHA_TAMANO_RECT_G/2,TAM_LABEL.width,TAM_LABEL.height);
		SEquipo1.setForeground(COLOR_LETRA);
		
		SEquipo2.setFont(new Font(FONT_TYPE,0,FONT_SIZE+AUMENTO_FUENTE));
		SEquipo2.setBounds(CANCHA_TAMANO_RECT_G/2,CANCHA_TAMANO_RECT_G + TAM_LABEL.height + AUM_Y_BTTN, TAM_LABEL.width,TAM_LABEL.height);
		SEquipo2.setForeground(COLOR_LETRA);
		
		SEquipo3.setFont(new Font(FONT_TYPE,0,FONT_SIZE+AUMENTO_FUENTE));
		SEquipo3.setBounds(WIDTH-CANCHA_TAMANO_RECT_G/2-TAM_LABEL.width/2+75,CANCHA_TAMANO_RECT_G/2,TAM_LABEL.width,TAM_LABEL.height);
		SEquipo3.setForeground(COLOR_LETRA);
		
		SEquipo4.setFont(new Font(FONT_TYPE,0,FONT_SIZE+AUMENTO_FUENTE));
		SEquipo4.setBounds(WIDTH-CANCHA_TAMANO_RECT_G/2-TAM_LABEL.width/2+75,CANCHA_TAMANO_RECT_G + TAM_LABEL.height + AUM_Y_BTTN,TAM_LABEL.width,TAM_LABEL.height);
		SEquipo4.setForeground(COLOR_LETRA);
			
		ScomboBox.setEditable(false);
		ScomboBox.addItem("Semifinales");
		ScomboBox.addItem("Simula partido");
		ScomboBox.addItem("Simula todos los partidos de ida");
		ScomboBox.addItem("Simula todos los partidos de vuelta");
		ScomboBox.addItem("Simula todos los partidos");
		
		ScomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int partido_simulado = 0;
				if((String)ScomboBox.getSelectedItem() != "Semifinales") {
					if((String)ScomboBox.getSelectedItem() == "Simula partido") {
						/*partido_simulado = control.SimulaPartidoSemis(); // 0 si no se pueden jugar mas partidos
						 * switch(partido_simulado) {
						 * 		case 1:
						 * 			 SEquipo1.setText(control.getE1Semis());
						 * 			 SEquipo2.setText(control.getE2Semis());
						 * 		break;
						 * 		case 2:
						 *           SEquipo3.setText(control.getE3Semis());
						 * 			 SEquipo4.setText(control.getE4Semis());
						 * 		break;
						 * }
						 * */ 
						//se simula el partido que sea
					}else {
						if((String)ScomboBox.getSelectedItem() == "Simula todos los partidos de ida") {
							//partido_simulado = control.simulaPartidosIdaS();
						}else {
							if((String)ScomboBox.getSelectedItem() == "Simula todos los partidos de vuelta") {
								//partido_simulado = control.simulaPartidosVueltaS(); 
							}else {
								//partido_simulado = control.simulaPartidosSemis();
							}
						}
						/*partido_simulado = control.SimulaPartidoSemis(); // 0 si no se pueden jugar mas partidos
						  switch(partido_simulado) {
						  		case 1:
						  			 SEquipo1.setText(control.getE1Semis());
						 			 SEquipo2.setText(control.getE2Semis());
						  		case 2:
						            SEquipo3.setText(control.getE3Semis());
						 			 SEquipo4.setText(control.getE4Semis());
						  }
						  */
					}
				}
			}	
		});
		//-------------------------------------------------<<A�ADO TODO A LAS SEMIS>>-------------------------------------------------
			
		SpanelC.add(SEquipo1);
		SpanelC.add(SEquipo2);
		SpanelC.add(SEquipo3);
		SpanelC.add(SEquipo4);
		SpanelN.add(ScomboBox);
		add(SpanelN, BorderLayout.NORTH);
		add(SpanelC, BorderLayout.CENTER); 
			
	}
	//generar action listeners para los combo box y metodos para actualizar los equipos
	private class panelS extends General {
		panelS () {
			super.paint(getGraphics());
		}
	}
}