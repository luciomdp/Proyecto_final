package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import proyecto_final.Controlador;

public class FrontFinal extends General{
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private final int AUMENTO_FUENTE = 10;
	private final Color COLOR_CAMPEON_CLARO = new Color(239, 220, 0);
	private final Color COLOR_CAMPEON_OSCURO = new Color(190,140,20);
		
	//-------------------------------------------------<<VARIABLES>>------------------------------------------------
	
	private JPanel FpanelN;
	private panelF FpanelC;
	private FLabel FEquipo1;
	private FLabel FEquipo2;
	private Marcador marcador;
	private JButton SimulaFinal;
	private Box VertBox;
	private Box HorBox;
	
	public FrontFinal (Controlador c){
		
		setControl(c);
				
		//-------------------------------------------------<<SETEO BACK Y LAYOUT>>-------------------------------------------------
		
		setLayout(new BorderLayout(0, 0));	
		setBackground(COLOR_FINAL);

		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
		
		FpanelN = new JPanel();
		FpanelC = new panelF(); 
		FEquipo1 = new FLabel ();
		FEquipo2 = new FLabel ();
		marcador = new Marcador();
		SimulaFinal = new JButton("Simula la final");
		VertBox = Box.createVerticalBox();
		HorBox = Box.createHorizontalBox();
		
		//-------------------------------------------------<<SETEO VARIABLES>>-------------------------------------------------
		
		FpanelN.setBackground(COLOR_PANEL_N);
		FpanelC.setBackground(COLOR_PANEL_C);
		FpanelC.setLayout(new FlowLayout(FlowLayout.CENTER));
		SimulaFinal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				getControlador().SimulaFinal();
				marcador.ActualizaMarcador(getControlador().getGFinal(0), getControlador().getGFinal(1));
			}
			
		});
		
		//-------------------------------------------------<<AÑADO TODO A LA ZONA>>------------------------------------------------- 
		
		FpanelN.add(SimulaFinal);
		
		HorBox.add(FEquipo1);
		HorBox.add(Box.createHorizontalStrut(100));
		HorBox.add(FEquipo2);
		
		VertBox.add(Box.createVerticalStrut(HEIGHT/10));
		VertBox.add(Box.createVerticalStrut(HEIGHT/4));
		VertBox.add(HorBox);
		//FpanelC.add(FEquipo1,BorderLayout.EAST);
		//FpanelC.add(FEquipo2,BorderLayout.WEST);
		//FpanelC.add(marcador,BorderLayout.NORTH);
		FpanelC.add(marcador);
		FpanelC.add(VertBox);

		add(FpanelN,BorderLayout.NORTH);
		add(FpanelC,BorderLayout.CENTER);
		
	}
	
	//-------------------------------------------------<<METODOS DE CLASE>>-------------------------------------------------
	
		public void FinalSimulada() {
			SimulaFinal.setEnabled(false);
			FpanelC.setBackground(COLOR_CAMPEON_CLARO);
			FpanelN.setBackground(COLOR_CAMPEON_OSCURO);
			FEquipo1.setBackground(COLOR_CAMPEON_OSCURO);
			FEquipo2.setBackground(COLOR_CAMPEON_OSCURO);
			marcador.setBackground(COLOR_CAMPEON_OSCURO);
		}

		public void InicializaVariables() {
			FEquipo1.setText(getControlador().getEFinal(0));
			FEquipo2.setText(getControlador().getEFinal(1));
		}
		
		//-------------------------------------------------<<CLASES INTERNAS>>-------------------------------------------------
		
		private class Marcador extends JLabel {
			
			public Marcador () {
				setFont(new Font("Consolas",Font.PLAIN,60));
				setText(" 0 | 0 ");
				setOpaque(true);
				setBackground(COLOR_PANEL_N);
				setForeground(COLOR_LETRA);
			}
			
			public void ActualizaMarcador(String G1, String G2) {
				setText( " " + G1 + " | " + G2 + " ");
			}
		
		}
		
		private class FLabel extends JLabel{
			FLabel () {
				setFont(new Font(FONT_TYPE,0,FONT_SIZE+AUMENTO_FUENTE));
				setOpaque(true);
				setBackground(COLOR_PANEL_N);
				setForeground(COLOR_LETRA);
				setSize(TAM_LABEL.width*5,TAM_LABEL.height);
			}
		}
		
		private class panelF extends General {
			panelF () {
				super.paint(getGraphics());
				setBackground(COLOR_BOTONES_2);
			}
		}
		
}