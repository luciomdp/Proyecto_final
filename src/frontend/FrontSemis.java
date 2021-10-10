package frontend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import proyecto_final.Controlador;

public class FrontSemis extends General{
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private int AUMENTO_FUENTE = 4;
			
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
			
	private JPanel SpanelN;
	private panelS SpanelC;
	private JComboBox<String> ScomboBox;
	private FrontPartido Partido1;
	private FrontPartido Partido2;
	private Box HBox;
		
	public FrontSemis (Controlador c){
		
		setControl(c);
		
		//-------------------------------------------------<<SETEO BACK Y LAYOUT>>-------------------------------------------------
					
		setLayout(new BorderLayout(0, 0));

		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
			
		SpanelN = new JPanel();
		SpanelC = new panelS(); 
		ScomboBox = new JComboBox<String>();
		Partido1 = new FrontPartido(c,5);
		Partido2 = new FrontPartido(c,5);
		HBox = Box.createHorizontalBox();
		
			
		//-------------------------------------------------<<SETEO VARIABLES>>-------------------------------------------------
			
		SpanelN.setBackground(COLOR_PANEL_N);
		SpanelC.setBackground(COLOR_PANEL_C);
		SpanelC.setLayout(new GridBagLayout());
		Partido1.SetFontSizeIncr(AUMENTO_FUENTE);
		Partido2.SetFontSizeIncr(AUMENTO_FUENTE);
		
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
						  			Partido1.setText(getControlador().getESemis(0),getControlador().getESemis(1));
						  		break;
						  		case 1:
						  			Partido2.setText(getControlador().getESemis(2),getControlador().getESemis(3));
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
						  			Partido1.setText(getControlador().getESemis(0),getControlador().getESemis(1));
						  		case 1:
						  			Partido2.setText(getControlador().getESemis(2),getControlador().getESemis(3));
						  }
					}
				}
			}	
		});
		//-------------------------------------------------<<AÑADO TODO A LAS SEMIS>>-------------------------------------------------
			
		HBox.add(Partido1);
		HBox.add(Box.createHorizontalStrut(WIDTH/10));
		HBox.add(Partido2);
		SpanelC.add(HBox);
		SpanelN.add(ScomboBox);
		add(SpanelN, BorderLayout.NORTH);
		add(SpanelC, BorderLayout.CENTER); 
			
	}
	
	//-------------------------------------------------<<METODOS DE CLASE>>-------------------------------------------------
	
	public void SemisSimuladaIda() {
		ScomboBox.removeItem("Simula todos los partidos de ida");
	}
	
	public void SemisSimulada(int G1,int G2) {
		Partido1.SetGanador(G1);
		Partido2.SetGanador(G1);
		ScomboBox.setSelectedIndex(0);
		ScomboBox.setEnabled(false);
	}
	
	public void InicializaVariables() {
		Partido1.setText(getControlador().getESemis(0),getControlador().getESemis(1));
		Partido2.setText(getControlador().getESemis(2),getControlador().getESemis(3));
	}
	
	//-------------------------------------------------<<CLASES INTERNAS>>-------------------------------------------------
	
	
	private class panelS extends General {
		panelS () {
			super.paint(getGraphics());
		}
	}

}