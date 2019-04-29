package popollo_adventures;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import clases.*;
import general.*;


public class Portada extends JPanel {
	
	public Portada(JFrame ventana) {
		JPanel panelPortada=this;
		this.setSize(1008, 536);
		setLayout(null);
		
		JButton botonIniciar = new JButton("Comenzar Partida");
		botonIniciar.setBounds(397, 326, 215, 23);
		add(botonIniciar);
		
		JButton botonCargar = new JButton("Cargar Partida");
		botonCargar.setBounds(397, 360, 215, 23);
		add(botonCargar);
			
		JButton botonGaleria = new JButton("Galeria");
		botonGaleria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Galeria panelGaleria=new Galeria(ventana);
				ventana.setContentPane(panelGaleria);
				panelPortada.setVisible(false);
			}
		});
		botonGaleria.setBounds(397, 395, 215, 23);
		add(botonGaleria);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setBounds(397, 429, 215, 23);
		add(botonSalir);
	
		JLabel imagenPortada = new JLabel("");
		imagenPortada.setBounds(0, 0, 1008, 536);
		imagenPortada.setIcon(new ImageIcon(".\\imagenes\\pantallaInicio.png"));
		add(imagenPortada);
			
	}
}
