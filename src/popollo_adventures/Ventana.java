package popollo_adventures;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	Portada panelPrincipal;	
	public Ventana() {
		setTitle("Popollo Adventure");
		this.setSize(1024,576);
		panelPrincipal=new Portada(this);
		setContentPane(panelPrincipal);
	}
}
