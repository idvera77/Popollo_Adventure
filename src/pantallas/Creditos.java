package pantallas;

import clases.Heroe;
import componentes.Botones;
import componentes.Paneles;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Creditos extends Paneles{
	private Ventana ventana;
	private Heroe heroe;
	
	public Creditos (Ventana ventana) {
		super();
		setBackground(Color.BLACK);
		this.ventana=ventana;
		
		Botones botonSalir = new Botones("Salir del Juego");
		botonSalir.setBounds(767, 487, 215, 23);
		add(botonSalir);
		
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "¿Estas seguro?" , " Cerrar Programa", 
						JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (exit == JOptionPane.YES_OPTION){
					if(ventana.getConnect()!=null) {
						try {
							ventana.getConnect().close();
						} catch (SQLException e1) {
						//No importa el error que pueda transmitir en este caso.
						}
					}	
				    System.exit(0);
				}	
			}
		});
	}	
}
