package frontend;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Credencial extends JFrame {

	private static final long serialVersionUID = -4876789525460049473L;
	private JScrollPane PanelScroll;
	private JTextPane AreaTexto;
	
	Credencial (String c) {
		Toolkit MiPantalla = Toolkit.getDefaultToolkit();
		Image imagen = MiPantalla.getImage("Src/frontend/icono.png");
		AreaTexto = new JTextPane();
		PanelScroll = new JScrollPane(AreaTexto);
		
		StyledDocument doc = AreaTexto.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		PanelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		AreaTexto.setText(c);
		AreaTexto.setBackground(Color.GRAY);
		AreaTexto.setForeground(Color.WHITE);
		AreaTexto.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
		AreaTexto.setEditable(false);
		setTitle("Credenciales del partido");
		setIconImage(imagen);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		add(PanelScroll);
		
	}
}
