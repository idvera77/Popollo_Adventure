package pantallas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import componentes.Botones;
import componentes.Paneles;

public class Inicio extends Paneles {
	private Ventana ventana;
	
	public Inicio(Ventana v) {
		super();
		this.ventana=v;
		
		//Sonido
		String rutaSonido = "./recursos/sonidos/Login.wav";
				
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
		imagenPortada.setIcon(new ImageIcon("./recursos/imagenes/pantallaInicio.png"));
		add(imagenPortada);	
		
		//Eventos de botones
		botonIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargarPantallaCarga();
				general.Musica.sonidosBoton(rutaSonido);
			}
		});
		
		botonCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargarPartida();
				ventana.cargarPantallaCarga();
				general.Musica.sonidosBoton(rutaSonido);
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
				if(ventana.getConnect()!=null) {
					try {
						ventana.getConnect().close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
					System.exit(0);
			}
		});
		
	}		
}
