package frontend;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import proyecto_final.Controlador;

public class FrontFinal extends General{
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private final int AUMENTO_FUENTE = 10;
	private final Color COLOR_GANADOR = new Color(38, 190, 35);
	private final Color COLOR_PERDEDOR = new Color(255, 75, 75);
	private final Color COLOR_CAMPEON_CLARO = new Color(239, 220, 0);
	private final Color COLOR_CAMPEON_OSCURO = new Color(190,140,20);
	private final Color COLOR_CREDENCIAL_F = new Color(175,120,20);
		
	//-------------------------------------------------<<VARIABLES>>------------------------------------------------
	
	private JPanel FpanelN;
	private panelF FpanelC;
	private JButton SimulaFinal;
	private PartidoFinal Partido;
	
	
	public FrontFinal (Controlador c){
		
		setControl(c);
				
		//-------------------------------------------------<<SETEO BACK Y LAYOUT>>-------------------------------------------------
		
		setLayout(new BorderLayout(0, 0));	
		setBackground(COLOR_FINAL);

		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
		
		FpanelN = new JPanel();
		FpanelC = new panelF(); 
		SimulaFinal = new JButton("Simula la final");
		Partido = new PartidoFinal(c);
		
		//-------------------------------------------------<<SETEO VARIABLES>>-------------------------------------------------
		
		FpanelC.setLayout(new GridBagLayout());
		FpanelN.setBackground(COLOR_PANEL_N);
		FpanelC.setBackground(COLOR_PANEL_C);
		SimulaFinal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				getControlador().SimulaFinal();
				Partido.m.ActualizaMarcador(getControlador().getGFinal(0), getControlador().getGFinal(1));
			}
			
		});
		
		//-------------------------------------------------<<AÑADO A LA ZONA>>------------------------------------------------- 
		
		FpanelN.add(SimulaFinal);
		FpanelC.add(Partido);

		add(FpanelN,BorderLayout.NORTH);
		add(FpanelC,BorderLayout.CENTER);
		
	}
	
	//-------------------------------------------------<<METODOS DE CLASE>>-------------------------------------------------
	
		public void FinalSimulada(int G) {
			if(G == 1) {
				Partido.FEquipo2.setBackground(COLOR_GANADOR);
				Partido.FEquipo1.setBackground(COLOR_PERDEDOR);
			}else {
				Partido.FEquipo1.setBackground(COLOR_GANADOR);
				Partido.FEquipo2.setBackground(COLOR_PERDEDOR);
			}
			SimulaFinal.setEnabled(false);
			Partido.FEquipo1.setForeground(COLOR_CAMPEON_CLARO);
			Partido.FEquipo2.setForeground(COLOR_CAMPEON_CLARO);
			FpanelC.setBackground(COLOR_CAMPEON_CLARO);
			FpanelN.setBackground(COLOR_CAMPEON_OSCURO);
			Partido.Credenciales.setBackground(COLOR_CREDENCIAL_F);
			Partido.m.setBackground(COLOR_CAMPEON_OSCURO);
			
		}

		public void InicializaVariables() {
			Partido.FEquipo1.setText(getControlador().getEFinal(0));
			Partido.FEquipo2.setText(getControlador().getEFinal(1));
		}
		
		//-------------------------------------------------<<CLASES INTERNAS>>-------------------------------------------------
		
		private class PartidoFinal extends JPanel{
			Marcador m;
			FLabel FEquipo1;
			FLabel FEquipo2;
			JButton Credenciales;
			JPanel PanelC;
			JPanel PanelN;
			
			PartidoFinal(Controlador c) {
				setLayout(new BorderLayout());
				FEquipo1 = new FLabel();
				FEquipo2 = new FLabel();
				Credenciales = new JButton("Emitir credenciales");
				PanelC = new JPanel();
				PanelN = new JPanel();
				m = new Marcador();
				
				Credenciales.setBackground(COLOR_PANEL_N);
				Credenciales.setForeground(COLOR_LETRA);
				PanelN.setLayout(new BorderLayout());
				
				FEquipo1.setHorizontalAlignment(SwingConstants.LEFT);
				FEquipo2.setHorizontalAlignment(SwingConstants.RIGHT);
				
				Credenciales.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new Credencial(c.EmitirCredenciales(FEquipo1.getText(),FEquipo2.getText(),6));
					}	
				});
				
				//-------------------------------------------------<<AÑADO VARIABLES>>-------------------------------------------------
				PanelN.add(m,BorderLayout.CENTER);
				PanelC.add(FEquipo1);
				PanelC.add(FEquipo2);
				add(m,BorderLayout.NORTH);
				add(PanelC,BorderLayout.CENTER);
				add(Credenciales,BorderLayout.SOUTH);
				
			}	
			
		}
		
		private class Marcador extends JLabel {
			
			public Marcador () {
				setHorizontalAlignment(SwingConstants.CENTER);
				setFont(new Font("Consolas",Font.PLAIN,60));
				setText("| 0 | 0 |");
				setOpaque(true);
				setBackground(COLOR_PANEL_N);
				setForeground(COLOR_LETRA);
			}
			
			public void ActualizaMarcador(String G1, String G2) {
				setText( " | " + G1 + " | " + G2 + " | ");
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