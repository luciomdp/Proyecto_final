package frontend;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import proyecto_final.Controlador;


public class FrontCuartos extends General{
		
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
		
	private JPanel CpanelN;
	private panelC CpanelC;
	private JComboBox<String> CcomboBox;
	private FrontPartido Partido1;
	private FrontPartido Partido2;
	private FrontPartido Partido3;
	private FrontPartido Partido4;
	private Box VBox;
	private Box HBox1;
	private Box HBox2;
	
	public FrontCuartos (Controlador c){
		
		setControl(c);
		
		//-------------------------------------------------<<SETEO LAYOUT>>-------------------------------------------------
				
		setLayout(new BorderLayout());

		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
		
		CpanelN = new JPanel();
		CpanelC = new panelC(); 
		CcomboBox = new JComboBox<String>();
		Partido1 = new FrontPartido(c,4);
		Partido2 = new FrontPartido(c,4);
		Partido3 = new FrontPartido(c,4);
		Partido4 = new FrontPartido(c,4);
		VBox = Box.createVerticalBox();
		HBox1 = Box.createHorizontalBox();
		HBox2 = Box.createHorizontalBox();
		
		//-------------------------------------------------<<SETEO VARIABLES>>-------------------------------------------------
		
		CpanelN.setBackground(COLOR_PANEL_N);
		CpanelC.setBackground(COLOR_PANEL_C);
		
		CcomboBox.setEditable(false);
		CcomboBox.addItem("Cuartos");
		CcomboBox.addItem("Simula partido");
		CcomboBox.addItem("Simula todos los partidos de ida");
		CcomboBox.addItem("Simula todos los partidos");
		
		CcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int partido_simulado = 0;
				if((String)CcomboBox.getSelectedItem() != "Cuartos") {
					if((String)CcomboBox.getSelectedItem() == "Simula partido") {
						partido_simulado = getControlador().SimulaPartidoC(); 
						  switch(partido_simulado) {
						  		case 0:
						  			Partido1.setText(getControlador().getECuartos(0),getControlador().getECuartos(1));
						  		break;
						  		case 1:
						  			Partido2.setText(getControlador().getECuartos(2),getControlador().getECuartos(3));
						  		break;
						  		case 2:
						  			Partido3.setText(getControlador().getECuartos(4),getControlador().getECuartos(5));
						  		break;
						  		case 3:
						  			Partido4.setText(getControlador().getECuartos(6),getControlador().getECuartos(7));
						  		break;
						  }			  
						//se simula el partido que sea
					}else {
						if((String)CcomboBox.getSelectedItem() == "Simula todos los partidos de ida") {
							partido_simulado = getControlador().simulaPartidosIdaC();
						}else {
							if((String)CcomboBox.getSelectedItem() == "Simula todos los partidos")
								partido_simulado = getControlador().simulaPartidosCuartos(); 
						}
						//cambio el string de los partidos de cuartos a partir del partido "partido_simulado", ya que el resto de opciones
						//simula todo, por lo que si se simula un anterior, se simulara el posterior (siempre se simulan los partidos en orden)
						switch(partido_simulado) {
						  		case 0:
						  			Partido1.setText(getControlador().getECuartos(0),getControlador().getECuartos(1));
						  		case 1:
						  			Partido2.setText(getControlador().getECuartos(2),getControlador().getECuartos(3));
						  		case 2:
						  			Partido3.setText(getControlador().getECuartos(4),getControlador().getECuartos(5));
						  		case 3:
						  			Partido4.setText(getControlador().getECuartos(6),getControlador().getECuartos(7));
						  }
						//le saco el break asi dependiendo el que sea, ejecuta tambien las sentencias del de abajo
					}
				}
			}	
		});
		
		//-------------------------------------------------<<AÑADO A LOS CUARTOS>>-------------------------------------------------
		
		CpanelN.add(CcomboBox);
		HBox1.add(Partido1);
		HBox1.add(Box.createHorizontalStrut(WIDTH/4));
		HBox1.add(Partido2);
		HBox2.add(Partido3);
		HBox2.add(Box.createHorizontalStrut(WIDTH/4));
		HBox2.add(Partido4);
		VBox.add(Box.createVerticalStrut(HEIGHT/8));
		VBox.add(HBox1);
		VBox.add(Box.createVerticalStrut(HEIGHT/3));
		VBox.add(HBox2);
		CpanelC.add(VBox);
		
		add(CpanelN,BorderLayout.NORTH);
		add(CpanelC,BorderLayout.CENTER);
		
	}
	
	//-------------------------------------------------<<METODOS DE CLASE>>-------------------------------------------------
	
	public void CuartosSimuladoIda() {
		CcomboBox.removeItem("Simula todos los partidos de ida"); 
	}
	
	public void CuartosSimulado(int G1,int G2,int G3,int G4) {
		Partido1.SetGanador(G1);
		Partido2.SetGanador(G2);
		Partido3.SetGanador(G3);
		Partido4.SetGanador(G4);
		CcomboBox.setSelectedIndex(0);
		CcomboBox.setEnabled(false);
	}
	
	public void InicializaVariables() {
		Partido1.setText(getControlador().getECuartos(0),getControlador().getECuartos(1));
		Partido2.setText(getControlador().getECuartos(2),getControlador().getECuartos(3));
		Partido3.setText(getControlador().getECuartos(4),getControlador().getECuartos(5));
		Partido4.setText(getControlador().getECuartos(6),getControlador().getECuartos(7));
	}

	//-------------------------------------------------<<CLASES INTERNAS>>-------------------------------------------------
	
	
	private class panelC extends General {
		panelC () {
			super.paint(getGraphics());
		}
	}	

}
