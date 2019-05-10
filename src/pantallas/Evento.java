package pantallas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import clases.Heroe;
import componentes.BotonesDialogo;
import componentes.LabelTexto;
import componentes.Paneles;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Evento extends Paneles{
	private Ventana ventana;
	public LabelTexto eventoTexto, eventoInicio;
	public BotonesDialogo opcion1, opcion2, opcion3, botonAtras;
	private Heroe heroe;
	private int opcion;
	
	public Evento(Ventana v, int evento) {
		super();
		this.ventana=v;
		this.heroe=ventana.heroe;
		
		//Añadir Botones
		opcion1 = new BotonesDialogo("");
		opcion1.setBounds(244, 294, 520, 30);
		add(opcion1);
		
		opcion2 = new BotonesDialogo("");
		opcion2.setBounds(244, 333, 520, 30);
		add(opcion2);
		
		opcion3 = new BotonesDialogo("");
		opcion3.setBounds(244, 372, 520, 30);
		add(opcion3);
		
		botonAtras = new BotonesDialogo("Volver");
		botonAtras.setVisible(false);
		botonAtras.setBounds(709, 428, 215, 23);
		add(botonAtras);
	
		//Paneles Texto
		eventoTexto = new LabelTexto();
		eventoTexto.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		eventoTexto.setBounds(10, 132, 988, 151);
		add(eventoTexto);
		
		//Imagen de fondo
		JLabel imagenBatalla = new JLabel("");
		imagenBatalla.setBounds(0, 0, 1008, 536);
		imagenBatalla.setIcon(new ImageIcon("./recursos/imagenes/batalla.jpg"));
		add(imagenBatalla);	
		
		elegirEvento(evento, opcion);
		
		//Eventos Botones
		opcion1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				elegirEvento(evento, 1);
				//general.Eventos.vagabundo(ventana.heroe, eventoTexto, opcion1, opcion2, opcion3, 1);
				ocultarBotones();
			}
		});
		
		opcion2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				elegirEvento(evento, 2);
				//general.Eventos.vagabundo(ventana.heroe, eventoTexto, opcion1, opcion2, opcion3, 2);
				ocultarBotones();
			}
		});
		
		opcion3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				elegirEvento(evento, 3);
				//general.Eventos.vagabundo(ventana.heroe, eventoTexto, opcion1, opcion2, opcion3, 3);
				ocultarBotones();
			}
		});	
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.volverPantallaPrincipal("evento");
			}
		});
	}
	
	public void ocultarBotones () {
		opcion1.setVisible(false);
		opcion2.setVisible(false);
		opcion3.setVisible(false);
		botonAtras.setVisible(true);
	}
	
	public void elegirEvento(int evento, int opcion) {
		switch(evento) {
			case 1:
				general.Eventos.vagabundo(ventana.heroe, eventoTexto, opcion1, opcion2, opcion3, opcion);
				break;
			case 2:
				general.Eventos.rescateAldeanos(heroe, null, eventoTexto, opcion1, opcion2, opcion3, opcion);
				break;
		}
	}
}
