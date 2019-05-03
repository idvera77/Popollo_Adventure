package interfaces;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import componentes.Botones;
import componentes.Paneles;

public class Inicio extends Paneles {
	private Ventana ventana;
	
	public Inicio(Ventana v) {
		super();
		this.ventana=v;
		
		//Añadiendo Botones
				Botones botonIniciar = new Botones("Comenzar Partida");
				botonIniciar.setBounds(397, 326, 215, 23);
				add(botonIniciar);
				
				Botones botonCargar = new Botones("Cargar Partida");
				botonCargar.setBounds(397, 360, 215, 23);
				add(botonCargar);
					
				Botones botonGaleria = new Botones("Galeria");
				botonGaleria.setBounds(397, 395, 215, 23);
				add(botonGaleria);
				
				Botones botonSalir = new Botones("Salir");
				botonSalir.setBounds(397, 429, 215, 23);
				add(botonSalir);
				
				//Imagen de fondo
				JLabel imagenPortada = new JLabel("");
				imagenPortada.setBounds(0, 0, 1008, 536);
				imagenPortada.setIcon(new ImageIcon("./imagenes/pantallaInicio.png"));
				add(imagenPortada);	
				
				//Eventos de botones
				botonIniciar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ventana.cargarPantallaPrincipal();
					}
				});
				
				botonCargar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ventana.cargarPantallaPrincipal();
					}
				});
				
				botonGaleria.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ventana.cargarPantallaGaleria();
					}
				});
				
				botonSalir.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
				});
				
			}
			
			
}
