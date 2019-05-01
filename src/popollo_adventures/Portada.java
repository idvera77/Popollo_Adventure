package popollo_adventures;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import componentes.Botones;
import componentes.Paneles;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Portada extends Paneles {
	
	public Portada(JFrame ventana) {
		Paneles panelPortada=this;
				
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
		
		//Eventos de botones
		botonIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection connect = iniciarPartida();
				Mapa panelMapa=new Mapa(ventana, connect);
				ventana.setContentPane(panelMapa);
				panelPortada.setVisible(false);
			}
		});
		
		botonCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection connect = cargarPartida();
				Mapa panelMapa=new Mapa(ventana, connect);
				ventana.setContentPane(panelMapa);
				panelPortada.setVisible(false);
			}
		});
		
		botonGaleria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Galeria panelGaleria=new Galeria(ventana);
				ventana.setContentPane(panelGaleria);
				panelPortada.setVisible(false);
			}
		});
		
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		//Imagen de fondo
		JLabel imagenPortada = new JLabel("");
		imagenPortada.setBounds(0, 0, 1008, 536);
		imagenPortada.setIcon(new ImageIcon("./imagenes/pantallaInicio.png"));
		add(imagenPortada);	
		
	}
	
	//Funcion que conecta con la base de datos y nos devuelve una conexion si no ocurre ningun error.
	public Connection iniciarPartida() {
		try {
			 Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/popollo_adventure","root","admin");
			 System.out.println("Conexion establecida");
			 return connect;
			 
		} catch (SQLException ex) {
		    System.err.println("La conexion a bd ha fallado");
		    ex.printStackTrace();
		    return null;
		}
	}
	
	//Funcion que conecta con la base de base de datos para cargar partida y nos devuelve una conexion si no ocurre ningun error.
	public Connection cargarPartida() {
		try {
			 Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/popollo_adventure","root","admin");
			 System.out.println("Conexion establecida");
			 return connect;
			 
		} catch (SQLException ex) {
		    System.err.println("La conexion a bd ha fallado");
		    ex.printStackTrace();
		    return null;
		}
	}	
}