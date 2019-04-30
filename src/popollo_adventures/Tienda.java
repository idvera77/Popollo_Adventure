package popollo_adventures;

import javax.swing.JFrame;
import clases.Heroe;
import componentes.Botones;
import componentes.Paneles;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Tienda extends Paneles{
	
	public Tienda(JFrame ventana, Heroe heroe) {
		Paneles panelTienda=this;
		
		Botones btnNewButton = new Botones("New button");
		btnNewButton.setBounds(99, 211, 89, 23);
		add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(206, 36, 206, 45);
		textPane.setText(Integer.toString(heroe.getDinero()));
		add(textPane);	
	}
}	
