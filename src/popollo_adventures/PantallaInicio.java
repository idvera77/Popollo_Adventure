package popollo_adventures;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import componentes.Botones;
import componentes.Paneles;

public class PantallaInicio extends Paneles {
	private Ventana ventana;
	public PantallaInicio(Ventana ventanaInicio) {
		Paneles panelInicio=this;
		this.ventana=ventanaInicio;
		
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
						//Connection connect = iniciarPartida();
						Mapa panelMapa=new Mapa(ventana);
						ventana.setContentPane(panelMapa);
						panelInicio.setVisible(false);
					}
				});
				
				botonCargar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//Connection connect = cargarPartida();
						Mapa panelMapa=new Mapa(ventanaInicio);
						ventanaInicio.setContentPane(panelMapa);
						panelInicio.setVisible(false);
					}
				});
				
				botonGaleria.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Galeria panelGaleria=new Galeria(ventanaInicio);
						ventanaInicio.setContentPane(panelGaleria);
						panelInicio.setVisible(false);
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
