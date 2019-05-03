package interfaces;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import componentes.Botones;
import componentes.Paneles;

public class Lucha extends Paneles{
	private Ventana ventana;
	
	public Lucha(Ventana v) {
		super();
		this.ventana=v;
		
		Botones botonAtras = new Botones("Volver al mapa");
		botonAtras.setBounds(709, 428, 215, 23);
		add(botonAtras);
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.volverPantallaPrincipal("Batalla");
			}
		});
	}
}
