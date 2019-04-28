package popollo_adventures;

import javax.swing.JFrame;

import com.sun.java_cup.internal.runtime.Scanner;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Ventana_Inicio extends JFrame{
	public Ventana_Inicio() {
		setTitle("Popollo Adventures - Inicio");
		getContentPane().setBackground(new Color(127, 255, 212));
		setSize(new Dimension(1024, 576));
		getContentPane().setLayout(null);
		
		JButton botonNuevoJuego = new JButton("Nuevo Juego");
		botonNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		botonNuevoJuego.setBounds(397, 322, 215, 23);
		getContentPane().add(botonNuevoJuego);
		
		JButton botonCargarPartida = new JButton("Cargar Partida");
		botonCargarPartida.setBounds(397, 356, 215, 23);
		getContentPane().add(botonCargarPartida);
		
		JButton buttonGaleria = new JButton("Galeria");
		buttonGaleria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ventana_Galeria galeria = new Ventana_Galeria();
				galeria.setVisible(true);
			}
		});
		buttonGaleria.setBounds(397, 390, 215, 23);
		getContentPane().add(buttonGaleria);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.setBounds(397, 424, 215, 23);
		getContentPane().add(botonSalir);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1008, 536);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel imagenPortada = new JLabel("imagenPortada");
		imagenPortada.setIcon(new ImageIcon(".\\imagenes\\pantallaInicio.png"));
		imagenPortada.setBounds(0, 0, 1008, 536);
		panel.add(imagenPortada);
	}
}
