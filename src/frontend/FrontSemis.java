package frontend;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import proyecto_final.Controlador;

public class FrontSemis extends General{
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1660981834575268289L;

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
		Partido1 = new FrontPartido(c,5, 0);
		Partido2 = new FrontPartido(c,5, 1);
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
				int partido_simulado = getControlador().getEtapaSemis();
				Controlador _control = getControlador();
				if((String)ScomboBox.getSelectedItem() != "Semifinales") {
					if((String)ScomboBox.getSelectedItem() == "Simula partido") {
						switch (partido_simulado) {	
						case 0:
							_control.SimulaPartidoS();
							Partido1.setText(_control.getESemis(0), _control.getESemis(1));
							break;
							
						case 1:
							_control.SimulaPartidoS();
							SemisSimuladaIda();
							Partido2.setText(_control.getESemis(2), _control.getESemis(3));
							break;
							
						case 2:
							_control.SimulaPartidoS();
							SemisSimuladaIda();
							Partido1.setText(_control.getESemis(0), _control.getESemis(1));
							break;
							
						case 3:
							_control.SimulaPartidoS();
							SemisSimuladaIda();
							Partido2.setText(_control.getESemis(2), _control.getESemis(3));
							break;
						}
						
						
					}else {
						if((String)ScomboBox.getSelectedItem() == "Simula todos los partidos de ida") {
							_control.simulaPartidosIdaS();
						}else {
							if((String)ScomboBox.getSelectedItem() == "Simula todos los partidos")
								_control.simulaPartidosSemis();
						}
						//partido_simulado = getControlador().simulaPartidosSemis();
						  switch(partido_simulado) {
						  		case 0:
						  			Partido1.setText(_control.getESemis(0),_control.getESemis(1));
						  		case 1:
						  			Partido2.setText(_control.getESemis(2),_control.getESemis(3));
						  }
					}
				}
			}	
		});
		//-------------------------------------------------<<AÑADO A LAS SEMIS>>-------------------------------------------------
			
		HBox.add(Partido1);
		HBox.add(Box.createHorizontalStrut(WIDTH/12));
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
		Partido2.SetGanador(G2);
		ScomboBox.setSelectedIndex(0);
		ScomboBox.setEnabled(false);
	}
	
	public void InicializaVariables() {
		Partido1.setText(getControlador().getESemis(0),getControlador().getESemis(1));
		Partido2.setText(getControlador().getESemis(2),getControlador().getESemis(3));
	}
	
	//-------------------------------------------------<<CLASES INTERNAS>>-------------------------------------------------
	
	
	private class panelS extends General {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6170406982552920046L;

		panelS () {
			super.paint(getGraphics());
		}
	}

}