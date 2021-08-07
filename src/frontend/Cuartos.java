package frontend;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import proyecto_final.Controlador;


public class Cuartos extends General{
		
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
	
	public Cuartos (Controlador c){
		
		setControl(c);
		
		//-------------------------------------------------<<SETEO LAYOUT>>-------------------------------------------------
				
		setLayout(new BorderLayout());

		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
		
		CpanelN = new JPanel();
		CpanelC = new panelC(); 
		CcomboBox = new JComboBox<String>();
		CEquipo1 = new JLabel();
		CEquipo2 = new JLabel();
		CEquipo3 = new JLabel();
		CEquipo4 = new JLabel();
		CEquipo5 = new JLabel();
		CEquipo6 = new JLabel();
		CEquipo7 = new JLabel();
		CEquipo8 = new JLabel();
		
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
		CcomboBox.addItem("Simula todos los partidos");
		
		CcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int partido_simulado = 0;
				if((String)CcomboBox.getSelectedItem() != "Cuartos") {
					if((String)CcomboBox.getSelectedItem() == "Simula partido") {
						partido_simulado = getControlador().SimulaPartidoC(); 
						  switch(partido_simulado) {
						  		case 1:
						  			 CEquipo1.setText(getControlador().getECuartos(1));
						  			 CEquipo2.setText(getControlador().getECuartos(2));
						  		break;
						  		case 2:
						            CEquipo3.setText(getControlador().getECuartos(3));
						  			 CEquipo4.setText(getControlador().getECuartos(4));
						  		break;
						  		case 3:
						  			 CEquipo5.setText(getControlador().getECuartos(5));
						  			 CEquipo6.setText(getControlador().getECuartos(6));
						  		break;
						  		case 4:
						  			 CEquipo7.setText(getControlador().getECuartos(7));
						  			 CEquipo8.setText(getControlador().getECuartos(8));
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
						  		case 1:
						  			 CEquipo1.setText(getControlador().getECuartos(1));
						  			 CEquipo2.setText(getControlador().getECuartos(2));
						  		case 2:
						            CEquipo3.setText(getControlador().getECuartos(3));
						  			 CEquipo4.setText(getControlador().getECuartos(4));
						  		case 3:
						  			 CEquipo5.setText(getControlador().getECuartos(5));
						  			 CEquipo6.setText(getControlador().getECuartos(6));
						  		case 4:
						  			 CEquipo7.setText(getControlador().getECuartos(7));
						  			 CEquipo8.setText(getControlador().getECuartos(8));
						  }
						//le saco el break asi dependiendo el que sea, ejecuta tambien las sentencias del de abajo
					}
				}
			}	
		});
		
		//-------------------------------------------------<<AÑADO TODO A LOS CUARTOS>>-------------------------------------------------
		
		CpanelN.add(CcomboBox);
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
	
	//-------------------------------------------------<<METODOS DE CLASE>>-------------------------------------------------
	
	public void CuartosSimuladoIda() {
		CcomboBox.removeItem("Simula todos los partidos de ida"); 
	}
	public void CuartosSimulado() {
		CcomboBox.setEnabled(false);
	}
	
	public void InicializaVariables() {
		CEquipo1.setText(getControlador().getECuartos(1));
		CEquipo2.setText(getControlador().getECuartos(2));
		CEquipo3.setText(getControlador().getECuartos(3));
		CEquipo4.setText(getControlador().getECuartos(4));
		CEquipo5.setText(getControlador().getECuartos(5));
		CEquipo6.setText(getControlador().getECuartos(6));
		CEquipo7.setText(getControlador().getECuartos(7));
		CEquipo8.setText(getControlador().getECuartos(8));
	}

	//-------------------------------------------------<<CLASES INTERNAS>>-------------------------------------------------
	
	private class panelC extends General {
		panelC () {
			super.paint(getGraphics());
		}
	}
	
	//-------------------------------------------------<<GETTERS Y SETTERS>>-------------------------------------------------
	
	public void setCEquipo1(String cEquipo1) {
		CEquipo1.setText(cEquipo1);
	}

	public void setCEquipo2(String cEquipo2) {
		CEquipo2.setText(cEquipo2);
	}

	public void setCEquipo3(String cEquipo3) {
		CEquipo3.setText(cEquipo3);
	}

	public void setCEquipo4(String cEquipo4) {
		CEquipo4.setText(cEquipo4);
	}

	public void setCEquipo5(String cEquipo5) {
		CEquipo5.setText(cEquipo5);
	}

	public void setCEquipo6(String cEquipo6) {
		CEquipo6.setText(cEquipo6);
	}

	public void setCEquipo7(String cEquipo7) {
		CEquipo7.setText(cEquipo7);
	}

	public void setCEquipo8(String cEquipo8) {
		CEquipo8.setText(cEquipo8);
	}

}
