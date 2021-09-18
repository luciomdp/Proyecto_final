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
	private CLabel CEquipo1;
	private CLabel CEquipo2;
	private CLabel CEquipo3;
	private CLabel CEquipo4;
	private CLabel CEquipo5;
	private CLabel CEquipo6;
	private CLabel CEquipo7;
	private CLabel CEquipo8;
	
	public Cuartos (Controlador c){
		
		setControl(c);
		
		//-------------------------------------------------<<SETEO LAYOUT>>-------------------------------------------------
				
		setLayout(new BorderLayout());

		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
		
		CpanelN = new JPanel();
		CpanelC = new panelC(); 
		CcomboBox = new JComboBox<String>();
		CEquipo1 = new CLabel();
		CEquipo2 = new CLabel();
		CEquipo3 = new CLabel();
		CEquipo4 = new CLabel();
		CEquipo5 = new CLabel();
		CEquipo6 = new CLabel();
		CEquipo7 = new CLabel();
		CEquipo8 = new CLabel();
		
		//-------------------------------------------------<<SETEO VARIABLES>>-------------------------------------------------
		
		CpanelN.setBackground(COLOR_PANEL_N);
		CpanelC.setLayout(null);
		CpanelC.setBackground(COLOR_PANEL_C);

		CEquipo1.setBounds(CANCHA_TAMANO_RECT_G/2,CANCHA_TAMANO_RECT_G/2,WIDTH/2 - CANCHA_TAMANO_RECT_C + 20,TAM_LABEL.height/2);
		
		CEquipo2.setBounds(CANCHA_TAMANO_RECT_G/2,CANCHA_TAMANO_RECT_G/2 + AUM_Y_BTTN/2,WIDTH/2 - CANCHA_TAMANO_RECT_C + 20,TAM_LABEL.height/2);
		
		CEquipo3.setBounds(CANCHA_TAMANO_RECT_G/2,(CANCHA_TAMANO_RECT_G/2)*2+AUM_Y_BTTN/2+2*(TAM_LABEL.height/2) + AUM_Y_BTTN/2,WIDTH/2 - CANCHA_TAMANO_RECT_C + 20,TAM_LABEL.height/2);
		
		CEquipo4.setBounds(CANCHA_TAMANO_RECT_G/2,(CANCHA_TAMANO_RECT_G/2)*2+ AUM_Y_BTTN +2*(TAM_LABEL.height/2) + AUM_Y_BTTN/2,WIDTH/2 - CANCHA_TAMANO_RECT_C + 20,TAM_LABEL.height/2);
		
		CEquipo5.setBounds(WIDTH-CANCHA_TAMANO_RECT_G-TAM_LABEL.width/2,CANCHA_TAMANO_RECT_G/2,WIDTH/2 - CANCHA_TAMANO_RECT_C + 20,TAM_LABEL.height/2);

		CEquipo6.setBounds(WIDTH-CANCHA_TAMANO_RECT_G-TAM_LABEL.width/2,CANCHA_TAMANO_RECT_G/2 + AUM_Y_BTTN/2,WIDTH/2 - CANCHA_TAMANO_RECT_C + 20,TAM_LABEL.height/2);
	
		CEquipo7.setBounds(WIDTH-CANCHA_TAMANO_RECT_G-TAM_LABEL.width/2,(CANCHA_TAMANO_RECT_G/2)*2+AUM_Y_BTTN/2+2*(TAM_LABEL.height/2) + AUM_Y_BTTN/2,WIDTH/2 - CANCHA_TAMANO_RECT_C + 20,TAM_LABEL.height/2);
		
		CEquipo8.setBounds(WIDTH-CANCHA_TAMANO_RECT_G-TAM_LABEL.width/2,(CANCHA_TAMANO_RECT_G/2)*2+ AUM_Y_BTTN +2*(TAM_LABEL.height/2) + AUM_Y_BTTN/2,WIDTH/2 - CANCHA_TAMANO_RECT_C + 20,TAM_LABEL.height/2);
		
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
						  			 CEquipo1.setText(getControlador().getECuartos(0));
						  			 CEquipo2.setText(getControlador().getECuartos(1));
						  		break;
						  		case 1:
						             CEquipo3.setText(getControlador().getECuartos(2));
						  			 CEquipo4.setText(getControlador().getECuartos(3));
						  		break;
						  		case 2:
						  			 CEquipo5.setText(getControlador().getECuartos(4));
						  			 CEquipo6.setText(getControlador().getECuartos(5));
						  		break;
						  		case 3:
						  			 CEquipo7.setText(getControlador().getECuartos(6));
						  			 CEquipo8.setText(getControlador().getECuartos(7));
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
						  			 CEquipo1.setText(getControlador().getECuartos(0));
						  			 CEquipo2.setText(getControlador().getECuartos(1));
		
						  		case 1:
						            CEquipo3.setText(getControlador().getECuartos(2));
						  			 CEquipo4.setText(getControlador().getECuartos(3));
						  		case 2:
						  			 CEquipo5.setText(getControlador().getECuartos(4));
						  			 CEquipo6.setText(getControlador().getECuartos(5));
						  		case 3:
						  			 CEquipo7.setText(getControlador().getECuartos(6));
						  			 CEquipo8.setText(getControlador().getECuartos(7));
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
		CcomboBox.setSelectedIndex(0);
		CcomboBox.setEnabled(false);
	}
	
	public void InicializaVariables() {
		CEquipo1.setText(getControlador().getECuartos(0));
		CEquipo2.setText(getControlador().getECuartos(1));
		CEquipo3.setText(getControlador().getECuartos(2));
		CEquipo4.setText(getControlador().getECuartos(3));
		CEquipo5.setText(getControlador().getECuartos(4));
		CEquipo6.setText(getControlador().getECuartos(5));
		CEquipo7.setText(getControlador().getECuartos(6));
		CEquipo8.setText(getControlador().getECuartos(7));
	}

	//-------------------------------------------------<<CLASES INTERNAS>>-------------------------------------------------
	
	private class CLabel extends JLabel{
		CLabel () {
			setFont(new Font(FONT_TYPE,0,FONT_SIZE));
			setOpaque(true);
			setBackground(COLOR_PANEL_N);
			setForeground(COLOR_LETRA);
		}
	}
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
