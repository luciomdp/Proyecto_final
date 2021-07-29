package frontend;
import java.awt.*;
import javax.swing.*;

public class Semifinales extends General{
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
		
			
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
			
	private JPanel SpanelN;
	private panelS SpanelC;
	private JComboBox<String> ScomboBox;
	private JLabel SEquipo1;
	private JLabel SEquipo2;
	private JLabel SEquipo3;
	private JLabel SEquipo4;
		
	//private Controlador c;
	public Semifinales (){//Semifinales(Controlador c)
		//this.c = c;
					
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
			
		SEquipo1.setFont(new Font(FONT_TYPE,0,FONT_SIZE*2));
		SEquipo1.setBounds(CANCHA_TAMANO_RECT_G/2,CANCHA_TAMANO_RECT_G/2,TAM_LABEL.width,TAM_LABEL.height);
		SEquipo1.setBackground(COLOR_ETIQUETAS);
		
		SEquipo2.setFont(new Font(FONT_TYPE,0,FONT_SIZE*2));
		SEquipo2.setBounds(CANCHA_TAMANO_RECT_G/2,CANCHA_TAMANO_RECT_G + TAM_LABEL.height + AUM_Y_BTTN, TAM_LABEL.width,TAM_LABEL.height);
		SEquipo2.setBackground(COLOR_ETIQUETAS);
		
		SEquipo3.setFont(new Font(FONT_TYPE,0,FONT_SIZE*2));
		SEquipo3.setBounds(WIDTH-CANCHA_TAMANO_RECT_G/2-TAM_LABEL.width/2+75,CANCHA_TAMANO_RECT_G/2,TAM_LABEL.width,TAM_LABEL.height);
		SEquipo3.setBackground(COLOR_ETIQUETAS);
		
		SEquipo4.setFont(new Font(FONT_TYPE,0,FONT_SIZE*2));
		SEquipo4.setBounds(WIDTH-CANCHA_TAMANO_RECT_G/2-TAM_LABEL.width/2+75,CANCHA_TAMANO_RECT_G + TAM_LABEL.height + AUM_Y_BTTN,TAM_LABEL.width,TAM_LABEL.height);
		SEquipo4.setBackground(COLOR_ETIQUETAS);
			
		ScomboBox.setEditable(false);
		ScomboBox.addItem("Semifinales");
		ScomboBox.addItem("Simula partido");
		ScomboBox.addItem("Simula todos los partidos de ida");
		ScomboBox.addItem("Simula todos los partidos de vuelta");
		ScomboBox.addItem("Simula todos los partidos");
			
		//-------------------------------------------------<<AÑADO TODO A LAS SEMIS>>-------------------------------------------------
			
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