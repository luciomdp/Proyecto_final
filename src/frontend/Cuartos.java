package frontend;
import java.awt.*;
import java.awt.event.*;
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
	
	public Cuartos (){
				
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
		
		CcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int partido_simulado = 0;
				if((String)CcomboBox.getSelectedItem() != "Cuartos") {
					if((String)CcomboBox.getSelectedItem() == "Simula partido") {
						/*partido_simulado = getControl().SimulaPartidoCuartos(); // 0 si no se pueden jugar mas partidos
						  switch(partido_simulado) {
						  		case 1:
						  			 CEquipo1.setText(getControl().getE1Cuartos());
						  			 CEquipo2.setText(getControl().getE2Cuartos());
						  		break;
						  		case 2:
						            CEquipo3.setText(getControl().getE3Cuartos());
						  			 CEquipo4.setText(getControl().getE4Cuartos());
						  		break;
						  		case 3:
						  			 CEquipo5.setText(getControl().getE5Cuartos());
						  			 CEquipo6.setText(getControl().getE6Cuartos());
						  		break;
						  		case 4:
						  			 CEquipo7.setText(getControl().getE7Cuartos());
						  			 CEquipo8.setText(getControl().getE8Cuartos());
						  		break;
						  }
						  */ 
						//se simula el partido que sea
					}else {
						if((String)CcomboBox.getSelectedItem() == "Simula todos los partidos de ida") {
							//partido_simulado = getControl().simulaPartidosIdaC();
						}else {
							if((String)CcomboBox.getSelectedItem() == "Simula todos los partidos de vuelta") {
								//partido_simulado = getControl().simulaPartidosVueltaC();
							}else {
								//partido_simulado = getControl().simulaPartidosCuartos(); 
							}
						}
						//cambio el string de los partidos de cuartos a partir del partido "partido_simulado", ya que el resto de opciones
						//simula todo, por lo que si se simula un anterior, se simulara el posterior (siempre se simulan los partidos en orden)
						/*switch(partido_simulado) {
						  		case 1:
						  			 CEquipo1.setText(getControl().getE1Cuartos());
						  			 CEquipo2.setText(getControl().getE2Cuartos());
						  		case 2:
						            CEquipo3.setText(getControl().getE3Cuartos());
						  			 CEquipo4.setText(getControl().getE4Cuartos());
						  		case 3:
						  			 CEquipo5.setText(getControl().getE5Cuartos());
						  			 CEquipo6.setText(getControl().getE6Cuartos());
						  		case 4:
						  			 CEquipo7.setText(getControl().getE7Cuartos());
						  			 CEquipo8.setText(getControl().getE8Cuartos());
						  }*///le saco el break asi dependiendo el que sea, ejecuta tambien las sentencias del de abajo
					}
				}
			}	
		});
		
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
