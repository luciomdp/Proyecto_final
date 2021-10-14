package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import proyecto_final.Controlador;

public class FrontPartido extends JPanel{
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private final Color COLOR_BORDE = Color.GRAY;
	private final Color COLOR_GANADOR = new Color(38, 190, 35);
	private final Color COLOR_PERDEDOR = new Color(255, 75, 75);
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private JPanel PanelN;
	private Label Equipo1;
	private Label Equipo2;
	private JButton Credenciales;
	
	public FrontPartido(Controlador c,int Etapa) {
		
		setLayout(new BorderLayout());
		
		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
		
		Equipo1 = new Label();
		Equipo2 = new Label();
		Credenciales = new JButton("Emitir credenciales");
		PanelN = new JPanel();		
		
		//-------------------------------------------------<<SETEO VARIABLES>>-------------------------------------------------
		
		Credenciales.setBackground(General.COLOR_PANEL_N);
		Credenciales.setForeground(General.COLOR_LETRA);
		PanelN.setLayout(new BorderLayout());
		PanelN.setBorder(BorderFactory.createLineBorder(COLOR_BORDE));
		Credenciales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credencial C = new Credencial(c.EmitirCredenciales(Equipo1.getText(),Equipo2.getText(),Etapa));
			}	
		});
		
		//-------------------------------------------------<<AÑADO VARIABLES>>-------------------------------------------------
		
		
		PanelN.add(Equipo1,BorderLayout.NORTH);
		PanelN.add(Equipo2,BorderLayout.SOUTH);
		add(PanelN,BorderLayout.CENTER);
		add(Credenciales,BorderLayout.SOUTH);
		
	}
	
	private class Label extends JLabel{
		Label() {
			setFont(new Font(General.FONT_TYPE,0,General.FONT_SIZE));
			setOpaque(true);
			setBackground(General.COLOR_PANEL_N);
			setForeground(General.COLOR_LETRA);
		}
	}
	
	public void setText(String E1,String E2) {
		Equipo1.setText(E1);
		Equipo2.setText(E2);
	}
	
	public void SetFontSizeIncr(int x) {
		Equipo1.setFont(new Font(General.FONT_TYPE,0,General.FONT_SIZE + x));
		Equipo2.setFont(new Font(General.FONT_TYPE,0,General.FONT_SIZE + x));
	}
	
	public void SetGanador(int ganador) {
		if(ganador == 1) {
			Equipo2.setBackground(COLOR_GANADOR);
			Equipo1.setBackground(COLOR_PERDEDOR);
		}else {
			Equipo1.setBackground(COLOR_GANADOR);
			Equipo2.setBackground(COLOR_PERDEDOR);
		}
	}
}
