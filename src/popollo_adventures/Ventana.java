package popollo_adventures;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	PantallaInicio panelPrincipal;	
	public Ventana() {
		setTitle("Popollo Adventure");
		this.setSize(1024,576);
		panelPrincipal=new PantallaInicio(this);
		setContentPane(panelPrincipal);
	}
}
