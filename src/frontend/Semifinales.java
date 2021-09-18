package frontend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import proyecto_final.Controlador;

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
		
	public Semifinales (Controlador c){
		
		setControl(c);
		
		//-------------------------------------------------<<SETEO BACK Y LAYOUT>>-------------------------------------------------
					
		setLayout(new BorderLayout(0, 0));

		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
			
		SpanelN = new JPanel();
		SpanelC = new panelS(); 
		ScomboBox = new JComboBox<String>();
		SEquipo1 = new JLabel();
		SEquipo2 = new JLabel();
		SEquipo3 = new JLabel();
		SEquipo4 = new JLabel();
		
			
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
		ScomboBox.addItem("Simula todos los partidos");
		
		ScomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int partido_simulado = 0;
				if((String)ScomboBox.getSelectedItem() != "Semifinales") {
					if((String)ScomboBox.getSelectedItem() == "Simula partido") {
						partido_simulado = getControlador().SimulaPartidoS(); 
						  switch(partido_simulado) {
						  		case 0:
						  			 SEquipo1.setText(getControlador().getESemis(0));
						  			 SEquipo2.setText(getControlador().getESemis(1));
						  		break;
						  		case 1:
						            SEquipo3.setText(getControlador().getESemis(2));
						 			 SEquipo4.setText(getControlador().getESemis(3));
						  		break;
						  }
						 
						//se simula el partido que sea
					}else {
						if((String)ScomboBox.getSelectedItem() == "Simula todos los partidos de ida") {
							partido_simulado = getControlador().simulaPartidosIdaS();
						}else {
							if((String)ScomboBox.getSelectedItem() == "Simula todos los partidos")
								partido_simulado = getControlador().simulaPartidosSemis();
						}
						//partido_simulado = getControlador().simulaPartidosSemis();
						  switch(partido_simulado) {
						  		case 0:
						  			 SEquipo1.setText(getControlador().getESemis(0));
						 			 SEquipo2.setText(getControlador().getESemis(1));
						  		case 1:
						             SEquipo3.setText(getControlador().getESemis(2));
						 			 SEquipo4.setText(getControlador().getESemis(3));
						  }
					}
				}
			}	
		});
		//-------------------------------------------------<<AÑADO TODO A LAS SEMIS>>-------------------------------------------------
			
		SpanelC.add(SEquipo1);
		SpanelC.add(SEquipo2);
		SpanelC.add(SEquipo3);
		SpanelC.add(SEquipo4);
		SpanelN.add(ScomboBox);
		add(SpanelN, BorderLayout.NORTH);
		add(SpanelC, BorderLayout.CENTER); 
			
	}
	
	//-------------------------------------------------<<METODOS DE CLASE>>-------------------------------------------------
	
	public void SemisSimuladaIda() {
		ScomboBox.removeItem("Simula todos los partidos de ida");
	}
	
	public void SemisSimulada() {
		ScomboBox.setEnabled(false);
	}
	
	public void InicializaVariables() {
		SEquipo1.setText(getControlador().getESemis(0));
		SEquipo2.setText(getControlador().getESemis(1));
		SEquipo3.setText(getControlador().getESemis(2));
		SEquipo4.setText(getControlador().getESemis(3));
	}
	
	//-------------------------------------------------<<CLASES INTERNAS>>-------------------------------------------------
	
	private class panelS extends General {
		panelS () {
			super.paint(getGraphics());
		}
	}

}