package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import proyecto_final.Controlador;

public class FrontPartido extends JPanel{
	
	//-------------------------------------------------<<CONSTANTES>>-------------------------------------------------
	
	private final Color COLOR_BORDE = Color.GRAY;
	
	//-------------------------------------------------<<VARIABLES>>-------------------------------------------------
	
	private JPanel PanelN;
	private Label Equipo1;
	private Label Equipo2;
	private JButton Credenciales;
	
	public FrontPartido(String E1,String E2,Controlador c) {
		
		setBorder(BorderFactory.createLineBorder(COLOR_BORDE));
		setLayout(new BorderLayout());
		
		//-------------------------------------------------<<INICIALIZO VARIABLES>>-------------------------------------------------
		
		Equipo1 = new Label(E1);
		Equipo2 = new Label(E2);
		Credenciales = new JButton("Emitir credenciales");
		PanelN = new JPanel();
		
		//-------------------------------------------------<<SETEO VARIABLES>>-------------------------------------------------
		
		Credenciales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}	
		});
		
		//-------------------------------------------------<<AÑADO VARIABLES>>-------------------------------------------------
		
		PanelN.setLayout(new BorderLayout());
		PanelN.add(Equipo1,BorderLayout.NORTH);
		PanelN.add(Equipo2,BorderLayout.SOUTH);
		add(PanelN,BorderLayout.CENTER);
		add(Credenciales,BorderLayout.SOUTH);
		
	}
	
	private class Label extends JLabel{
		Label(String s) {
			setText(s);
			setFont(new Font(General.FONT_TYPE,0,General.FONT_SIZE));
			setOpaque(true);
			setBackground(General.COLOR_PANEL_N);
			setForeground(General.COLOR_LETRA);
		}
	}
}
