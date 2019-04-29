package popollo_adventures;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	Portada panelPrincipal;	
	public Ventana() {
		setTitle("Popollo Adventure");
		panelPrincipal=new Portada(this);
		this.setSize(1024,576);
		setContentPane(panelPrincipal);

	}
	
	public Ventana getThis() {
		return this;
	}
}
